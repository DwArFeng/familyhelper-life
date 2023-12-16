package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板数据信息不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateDataInfoNotExistsException extends HandlerException {

    private static final long serialVersionUID = 3871975831659157408L;

    private final LongIdKey activityTemplateDataInfoKey;

    public ActivityTemplateDataInfoNotExistsException(LongIdKey activityTemplateDataInfoKey) {
        this.activityTemplateDataInfoKey = activityTemplateDataInfoKey;
    }

    public ActivityTemplateDataInfoNotExistsException(Throwable cause, LongIdKey activityTemplateDataInfoKey) {
        super(cause);
        this.activityTemplateDataInfoKey = activityTemplateDataInfoKey;
    }

    @Override
    public String getMessage() {
        return "活动模板数据信息不存在: " + activityTemplateDataInfoKey;
    }
}
