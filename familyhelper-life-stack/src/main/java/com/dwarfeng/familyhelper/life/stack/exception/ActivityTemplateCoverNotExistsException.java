package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板封面不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateCoverNotExistsException extends HandlerException {

    private static final long serialVersionUID = -6507699387633203814L;
    
    private final LongIdKey activityTemplateCoverKey;

    public ActivityTemplateCoverNotExistsException(LongIdKey activityTemplateCoverKey) {
        this.activityTemplateCoverKey = activityTemplateCoverKey;
    }

    public ActivityTemplateCoverNotExistsException(Throwable cause, LongIdKey activityTemplateCoverKey) {
        super(cause);
        this.activityTemplateCoverKey = activityTemplateCoverKey;
    }

    @Override
    public String getMessage() {
        return "活动模板封面不存在: " + activityTemplateCoverKey;
    }
}
