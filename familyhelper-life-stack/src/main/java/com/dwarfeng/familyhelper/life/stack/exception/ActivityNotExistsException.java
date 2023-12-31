package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityNotExistsException extends HandlerException {

    private static final long serialVersionUID = -6651264859059565875L;
    
    private final LongIdKey activityKey;

    public ActivityNotExistsException(LongIdKey activityKey) {
        this.activityKey = activityKey;
    }

    public ActivityNotExistsException(Throwable cause, LongIdKey activityKey) {
        super(cause);
        this.activityKey = activityKey;
    }

    @Override
    public String getMessage() {
        return "活动 " + activityKey + " 不存在";
    }
}
