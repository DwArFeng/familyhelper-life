package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateNotExistsException extends HandlerException {

    private static final long serialVersionUID = -2510939487658082395L;

    private final LongIdKey activityTemplateKey;

    public ActivityTemplateNotExistsException(LongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public ActivityTemplateNotExistsException(Throwable cause, LongIdKey activityTemplateKey) {
        super(cause);
        this.activityTemplateKey = activityTemplateKey;
    }

    @Override
    public String getMessage() {
        return "活动模板 " + activityTemplateKey + " 不存在";
    }
}
