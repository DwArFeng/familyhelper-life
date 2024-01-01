package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动封面不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityCoverNotExistsException extends HandlerException {

    private static final long serialVersionUID = -1777948066066508549L;

    private final LongIdKey activityCoverKey;

    public ActivityCoverNotExistsException(LongIdKey activityCoverKey) {
        this.activityCoverKey = activityCoverKey;
    }

    public ActivityCoverNotExistsException(Throwable cause, LongIdKey activityCoverKey) {
        super(cause);
        this.activityCoverKey = activityCoverKey;
    }

    @Override
    public String getMessage() {
        return "活动封面不存在: " + activityCoverKey;
    }
}
