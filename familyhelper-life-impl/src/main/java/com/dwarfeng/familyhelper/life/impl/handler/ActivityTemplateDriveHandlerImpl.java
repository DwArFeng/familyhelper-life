package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.familyhelper.life.stack.exception.ActivityTemplateDriverException;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriveHandler;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriveLocalCacheHandler;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
import com.dwarfeng.familyhelper.life.stack.struct.ActivityTemplateDriveInfo;
import com.dwarfeng.subgrade.impl.handler.CuratorDistributedLockHandler;
import com.dwarfeng.subgrade.impl.handler.Worker;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.BehaviorAnalyse;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ActivityTemplateDriveHandlerImpl implements ActivityTemplateDriveHandler {

    private final CuratorDistributedLockHandler handler;

    public ActivityTemplateDriveHandlerImpl(
            CuratorFramework curatorFramework,
            @Value("${curator.latch_path.activity_template_drive.leader_latch}") String leaserLatchPath,
            ActivityTemplateDriveWorker activityTemplateDriveWorker
    ) {
        handler = new CuratorDistributedLockHandler(curatorFramework, leaserLatchPath, activityTemplateDriveWorker);
    }

    @BehaviorAnalyse
    @Override
    public boolean isOnline() {
        return handler.isOnline();
    }

    @BehaviorAnalyse
    @Override
    public void online() throws HandlerException {
        handler.online();
    }

    @BehaviorAnalyse
    @Override
    public void offline() throws HandlerException {
        handler.offline();
    }

    @BehaviorAnalyse
    @Override
    public boolean isStarted() {
        return handler.isStarted();
    }

    @BehaviorAnalyse
    @Override
    public void start() throws HandlerException {
        handler.start();
    }

    @BehaviorAnalyse
    @Override
    public void stop() throws HandlerException {
        handler.stop();
    }

    @BehaviorAnalyse
    @Override
    public boolean isLockHolding() {
        return handler.isLockHolding();
    }

    @BehaviorAnalyse
    @Override
    public boolean isWorking() {
        return handler.isWorking();
    }

    @Component
    public static class ActivityTemplateDriveWorker implements Worker {

        private static final Logger LOGGER = LoggerFactory.getLogger(ActivityTemplateDriveWorker.class);

        private final ActivityTemplateMaintainService activityTemplateMaintainService;

        private final ActivityTemplateDriveLocalCacheHandler activityTemplateDriveLocalCacheHandler;

        private final Set<ActivityTemplateDriver> usedActivityTemplateDrivers = new HashSet<>();

        public ActivityTemplateDriveWorker(
                ActivityTemplateMaintainService activityTemplateMaintainService,
                ActivityTemplateDriveLocalCacheHandler activityTemplateDriveLocalCacheHandler
        ) {
            this.activityTemplateMaintainService = activityTemplateMaintainService;
            this.activityTemplateDriveLocalCacheHandler = activityTemplateDriveLocalCacheHandler;
        }

        @Override
        public void work() throws Exception {
            // 记录日志。
            LOGGER.info("活动模板驱动器开始工作...");

            List<ActivityTemplate> activityTemplates = activityTemplateMaintainService.lookupAsList();
            // 注册所有活动模板驱动成功标志。
            boolean successFlag = true;
            // 获取所有活动模板驱动信息。
            for (ActivityTemplate activityTemplate : activityTemplates) {
                ActivityTemplateDriveInfo activityTemplateDriveInfo = activityTemplateDriveLocalCacheHandler.get(
                        activityTemplate.getKey()
                );
                if (Objects.isNull(activityTemplateDriveInfo)) {
                    throw new ActivityTemplateDriverException(
                            "无法在本地缓存中找到有效的活动模板驱动上下文: " + activityTemplate.getKey()
                    );
                }
                if (!registerActivityTemplateDriver(activityTemplateDriveInfo)) {
                    successFlag = false;
                }
            }
            if (successFlag) {
                LOGGER.info("所有活动模板驱动信息注册成功");
            } else {
                LOGGER.warn("至少一条活动模板驱动信息注册失败，请查看警报日志以了解详细原因");
            }
        }

        private boolean registerActivityTemplateDriver(ActivityTemplateDriveInfo activityTemplateDriveInfo) {
            boolean successFlag = true;
            Map<ActivityTemplateDriverInfo, ActivityTemplateDriver> activityTemplateDriverMap =
                    activityTemplateDriveInfo.getActivityTemplateDriverMap();
            for (
                    Map.Entry<ActivityTemplateDriverInfo, ActivityTemplateDriver> entry :
                    activityTemplateDriverMap.entrySet()
            ) {
                ActivityTemplateDriverInfo activityTemplateDriverInfo = entry.getKey();
                ActivityTemplateDriver activityTemplateDriver = entry.getValue();
                try {
                    activityTemplateDriver.register(activityTemplateDriverInfo);
                    usedActivityTemplateDrivers.add(activityTemplateDriver);
                } catch (Exception e) {
                    successFlag = false;
                    LOGGER.warn("活动模板驱动信息 {} 注册失败，将忽略此条注册信息", activityTemplateDriverInfo, e);
                }
            }
            return successFlag;
        }

        @Override
        public void rest() throws Exception {
            // 记录日志。
            LOGGER.info("活动模板驱动器停止工作...");

            for (
                    Iterator<ActivityTemplateDriver> iterator = usedActivityTemplateDrivers.iterator();
                    iterator.hasNext();
            ) {
                ActivityTemplateDriver activityTemplateDriver = iterator.next();
                activityTemplateDriver.unregisterAll();
                iterator.remove();
            }
        }
    }
}
