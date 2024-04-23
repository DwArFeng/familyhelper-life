package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriveHandler;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriveLocalCacheHandler;
import com.dwarfeng.familyhelper.life.stack.handler.PushHandler;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 重置处理器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
@Component
public class ResetProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResetProcessor.class);

    private final ActivityTemplateDriveHandler activityTemplateDriveHandler;
    private final ActivityTemplateDriveLocalCacheHandler activityTemplateDriveLocalCacheHandler;

    private final PushHandler pushHandler;

    public ResetProcessor(
            ActivityTemplateDriveHandler activityTemplateDriveHandler,
            ActivityTemplateDriveLocalCacheHandler activityTemplateDriveLocalCacheHandler,
            PushHandler pushHandler
    ) {
        this.activityTemplateDriveHandler = activityTemplateDriveHandler;
        this.activityTemplateDriveLocalCacheHandler = activityTemplateDriveLocalCacheHandler;
        this.pushHandler = pushHandler;
    }

    public void resetActivityTemplateDrive() throws HandlerException {
        // 重置活动模板驱动。
        activityTemplateDriveHandler.stop();
        activityTemplateDriveLocalCacheHandler.clear();
        activityTemplateDriveHandler.start();

        // 推送消息。
        try {
            pushHandler.activityTemplateDriveReset();
        } catch (Exception e) {
            LOGGER.warn("推送记录功能重置消息时发生异常, 本次消息将不会被推送, 异常信息如下: ", e);
        }
    }
}
