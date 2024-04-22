package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板驱动器信息不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ActivityTemplateDriverInfoNotExistsException extends HandlerException {

    private static final long serialVersionUID = -7211695503769401909L;

    private final LongIdKey activityTemplateDriverInfoKey;

    public ActivityTemplateDriverInfoNotExistsException(LongIdKey activityTemplateDriverInfoKey) {
        this.activityTemplateDriverInfoKey = activityTemplateDriverInfoKey;
    }

    public ActivityTemplateDriverInfoNotExistsException(Throwable cause, LongIdKey activityTemplateDriverInfoKey) {
        super(cause);
        this.activityTemplateDriverInfoKey = activityTemplateDriverInfoKey;
    }

    @Override
    public String getMessage() {
        return "活动模板驱动器信息 " + activityTemplateDriverInfoKey + " 不存在";
    }
}
