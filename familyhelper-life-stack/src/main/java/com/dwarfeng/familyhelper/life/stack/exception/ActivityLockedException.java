package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动锁定异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityLockedException extends HandlerException {

    private static final long serialVersionUID = 1614083737140252279L;

    private final LongIdKey activityKey;

    public ActivityLockedException(LongIdKey activityKey) {
        this.activityKey = activityKey;
    }

    public ActivityLockedException(Throwable cause, LongIdKey activityKey) {
        super(cause);
        this.activityKey = activityKey;
    }

    @Override
    public String getMessage() {
        return "活动 " + activityKey + " 已经被锁定";
    }
}
