package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityGeneratedByDriverPushInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityRemindedByDriverPushInfo;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 事件推送器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface Pusher {

    /**
     * 返回制造器是否支持指定的类型。
     *
     * @param type 指定的类型。
     * @return 制造器是否支持指定的类型。
     */
    boolean supportType(String type);

    /**
     * 由驱动生成活动时执行的推送操作。
     *
     * @param pushInfo 推送信息。
     * @throws HandlerException 处理器异常。
     */
    void activityGeneratedByDriver(ActivityGeneratedByDriverPushInfo pushInfo) throws HandlerException;

    /**
     * 由驱动提醒活动时执行的推送操作。
     *
     * @param pushInfo 推送信息。
     * @throws HandlerException 处理器异常。
     */
    void activityRemindedByDriver(ActivityRemindedByDriverPushInfo pushInfo) throws HandlerException;

    /**
     * 活动模板驱动重置时执行的推送操作。
     */
    void activityTemplateDriveReset() throws HandlerException;
}
