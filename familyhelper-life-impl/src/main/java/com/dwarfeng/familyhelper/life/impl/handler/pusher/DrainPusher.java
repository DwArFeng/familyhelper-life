package com.dwarfeng.familyhelper.life.impl.handler.pusher;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityGeneratedByDriverPushInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityRemindedByDriverPushInfo;
import org.springframework.stereotype.Component;

/**
 * 简单的丢弃掉所有信息的推送器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
@Component
public class DrainPusher extends AbstractPusher {

    public static final String PUSHER_TYPE = "drain";

    public DrainPusher() {
        super(PUSHER_TYPE);
    }

    @Override
    public void activityGeneratedByDriver(ActivityGeneratedByDriverPushInfo pushInfo) {
    }

    @Override
    public void activityRemindedByDriver(ActivityRemindedByDriverPushInfo pushInfo) {
    }

    @Override
    public void activityTemplateDriveReset() {
    }

    @Override
    public String toString() {
        return "DrainPusher{" +
                "pusherType='" + pusherType + '\'' +
                '}';
    }
}
