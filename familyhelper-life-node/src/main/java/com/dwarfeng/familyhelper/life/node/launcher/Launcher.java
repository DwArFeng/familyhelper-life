package com.dwarfeng.familyhelper.life.node.launcher;

import com.dwarfeng.familyhelper.life.node.handler.LauncherSettingHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriveQosService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriverSupportMaintainService;
import com.dwarfeng.springterminator.sdk.util.ApplicationUtil;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;

/**
 * 程序启动器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class Launcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {
        ApplicationUtil.launch(new String[]{
                "classpath:spring/application-context*.xml",
                "file:opt/opt*.xml",
                "file:optext/opt*.xml"
        }, ctx -> {
            // 根据启动器设置处理器的设置，选择性重置活动模板驱动器。
            mayResetActivityTemplateDriver(ctx);

            // 根据启动器设置处理器的设置，选择性上线活动模板驱动服务。
            mayOnlineActivityTemplateDrive(ctx);
            // 根据启动器设置处理器的设置，选择性启动活动模板驱动服务。
            mayEnableActivityTemplateDrive(ctx);
        });
    }

    private static void mayResetActivityTemplateDriver(ApplicationContext ctx) {
        // 获取启动器设置处理器，用于获取启动器设置，并按照设置选择性执行功能。
        LauncherSettingHandler launcherSettingHandler = ctx.getBean(LauncherSettingHandler.class);

        // 判断是否重置活动模板驱动器支持，并按条件执行重置操作。
        if (launcherSettingHandler.isResetActivityTemplateDriverSupport()) {
            LOGGER.info("重置活动模板驱动器支持...");
            ActivityTemplateDriverSupportMaintainService maintainService = ctx.getBean(
                    ActivityTemplateDriverSupportMaintainService.class
            );
            try {
                maintainService.reset();
            } catch (ServiceException e) {
                LOGGER.warn("活动模板驱动器支持重置失败，异常信息如下", e);
            }
        }
    }

    private static void mayOnlineActivityTemplateDrive(ApplicationContext ctx) {
        // 获取启动器设置处理器，用于获取启动器设置，并按照设置选择性执行功能。
        LauncherSettingHandler launcherSettingHandler = ctx.getBean(LauncherSettingHandler.class);

        // 获取程序中的 ThreadPoolTaskScheduler，用于处理计划任务。
        ThreadPoolTaskScheduler scheduler = ctx.getBean(ThreadPoolTaskScheduler.class);

        // 获取活动模板驱动 QOS 服务。
        ActivityTemplateDriveQosService activityTemplateDriveQosService = ctx.getBean(
                ActivityTemplateDriveQosService.class
        );

        // 判断活动模板驱动处理器是否上线活动模板驱动服务，并按条件执行不同的操作。
        long onlineActivityTemplateDriveDelay = launcherSettingHandler.getOnlineActivityTemplateDriveDelay();
        if (onlineActivityTemplateDriveDelay == 0) {
            LOGGER.info("立即上线活动模板驱动服务...");
            try {
                activityTemplateDriveQosService.online();
            } catch (ServiceException e) {
                LOGGER.error("无法上线活动模板驱动服务，异常原因如下", e);
            }
        } else if (onlineActivityTemplateDriveDelay > 0) {
            LOGGER.info("{} 毫秒后上线活动模板驱动服务...", onlineActivityTemplateDriveDelay);
            scheduler.schedule(
                    () -> {
                        LOGGER.info("上线活动模板驱动服务...");
                        try {
                            activityTemplateDriveQosService.online();
                        } catch (ServiceException e) {
                            LOGGER.error("无法上线活动模板驱动服务，异常原因如下", e);
                        }
                    },
                    new Date(System.currentTimeMillis() + onlineActivityTemplateDriveDelay)
            );
        }
    }

    private static void mayEnableActivityTemplateDrive(ApplicationContext ctx) {
        // 获取启动器设置处理器，用于获取启动器设置，并按照设置选择性执行功能。
        LauncherSettingHandler launcherSettingHandler = ctx.getBean(LauncherSettingHandler.class);

        // 获取程序中的 ThreadPoolTaskScheduler，用于处理计划任务。
        ThreadPoolTaskScheduler scheduler = ctx.getBean(ThreadPoolTaskScheduler.class);

        // 获取活动模板驱动 QOS 服务。
        ActivityTemplateDriveQosService activityTemplateDriveQosService = ctx.getBean(
                ActivityTemplateDriveQosService.class
        );

        // 判断活动模板驱动处理器是否启动活动模板驱动服务，并按条件执行不同的操作。
        long enableActivityTemplateDriveDelay = launcherSettingHandler.getEnableActivityTemplateDriveDelay();
        if (enableActivityTemplateDriveDelay == 0) {
            LOGGER.info("立即启动活动模板驱动服务...");
            try {
                activityTemplateDriveQosService.online();
            } catch (ServiceException e) {
                LOGGER.error("无法启动活动模板驱动服务，异常原因如下", e);
            }
        } else if (enableActivityTemplateDriveDelay > 0) {
            LOGGER.info("{} 毫秒后启动活动模板驱动服务...", enableActivityTemplateDriveDelay);
            scheduler.schedule(
                    () -> {
                        LOGGER.info("启动活动模板驱动服务...");
                        try {
                            activityTemplateDriveQosService.start();
                        } catch (ServiceException e) {
                            LOGGER.error("无法启动活动模板驱动服务，异常原因如下", e);
                        }
                    },
                    new Date(System.currentTimeMillis() + enableActivityTemplateDriveDelay)
            );
        }
    }
}
