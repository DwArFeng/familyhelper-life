package com.dwarfeng.familyhelper.life.impl.handler.atdriver;

import com.dwarfeng.familyhelper.life.impl.handler.ActivityTemplateDriverProvider;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.familyhelper.life.stack.exception.ActivityTemplateDriverException;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Cron 活动模板驱动提供器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
@Component
public class CronActivityTemplateDriverProvider implements ActivityTemplateDriverProvider {

    public static final String SUPPORT_TYPE = "cron_activity_template_driver";

    private final CronActivityTemplateDriver cronActivityTemplateDriver;

    public CronActivityTemplateDriverProvider(CronActivityTemplateDriver cronActivityTemplateDriver) {
        this.cronActivityTemplateDriver = cronActivityTemplateDriver;
    }

    @Override
    public boolean supportType(String type) {
        return Objects.equals(SUPPORT_TYPE, type);
    }

    @Override
    public ActivityTemplateDriver provide() {
        return cronActivityTemplateDriver;
    }

    @Component
    public static class CronActivityTemplateDriver extends AbstractActivityTemplateDriver {

        private final ThreadPoolTaskScheduler scheduler;

        private final Lock lock = new ReentrantLock();
        private final Set<ScheduledFuture<?>> scheduledFutures = new HashSet<>();
        private final Set<CronProcessor> cronProcessors = new HashSet<>();

        public CronActivityTemplateDriver(ThreadPoolTaskScheduler scheduler) {
            this.scheduler = scheduler;
        }

        @Override
        public void register(ActivityTemplateDriverInfo activityTemplateDriverInfo)
                throws ActivityTemplateDriverException {
            lock.lock();
            try {
                LongIdKey activityTemplateDriverInfoKey = activityTemplateDriverInfo.getKey();
                String cron = activityTemplateDriverInfo.getParam();
                CronProcessor cronProcessor = new CronProcessor(context, activityTemplateDriverInfoKey);
                CronTrigger cronTrigger = new CronTrigger(cron);
                ScheduledFuture<?> scheduledFuture = scheduler.schedule(cronProcessor, cronTrigger);
                cronProcessors.add(cronProcessor);
                scheduledFutures.add(scheduledFuture);
            } catch (Exception e) {
                throw new ActivityTemplateDriverException(e);
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void unregisterAll() {
            lock.lock();
            try {
                for (ScheduledFuture<?> scheduledFuture : scheduledFutures) {
                    scheduledFuture.cancel(true);
                }
                for (CronProcessor cronProcessor : cronProcessors) {
                    cronProcessor.shutdown();
                }
            } finally {
                lock.unlock();
            }
        }

        @Override
        public String toString() {
            return "CronActivityTemplateDriver{" +
                    "context=" + context +
                    '}';
        }
    }

    private static class CronProcessor implements Runnable {

        private static final Logger LOGGER = LoggerFactory.getLogger(CronProcessor.class);

        private final ActivityTemplateDriver.Context context;
        private final LongIdKey activityTemplateDriverInfoKey;

        private final Lock lock = new ReentrantLock();
        private boolean runningFlag = true;

        private CronProcessor(ActivityTemplateDriver.Context context, LongIdKey activityTemplateDriverInfoKey) {
            this.context = context;
            this.activityTemplateDriverInfoKey = activityTemplateDriverInfoKey;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                if (!runningFlag) {
                    return;
                }

                LOGGER.debug("计划时间已到达, cron 活动模板驱动器 {} 执行驱动动作...", activityTemplateDriverInfoKey);
                context.drive(activityTemplateDriverInfoKey);
            } catch (Exception e) {
                LOGGER.warn("记录 {} 时出现异常, 放弃本次记录", activityTemplateDriverInfoKey, e);
            } finally {
                lock.unlock();
            }
        }

        void shutdown() {
            lock.lock();
            try {
                runningFlag = false;
            } finally {
                lock.unlock();
            }
        }
    }
}
