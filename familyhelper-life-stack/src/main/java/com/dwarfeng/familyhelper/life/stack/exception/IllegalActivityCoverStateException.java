package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动封面状态非法异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class IllegalActivityCoverStateException extends HandlerException {

    private static final long serialVersionUID = 5844057456338691999L;

    private final LongIdKey activityCoverKey;

    public IllegalActivityCoverStateException(LongIdKey activityCoverKey) {
        this.activityCoverKey = activityCoverKey;
    }

    public IllegalActivityCoverStateException(Throwable cause, LongIdKey activityCoverKey) {
        super(cause);
        this.activityCoverKey = activityCoverKey;
    }

    @Override
    public String getMessage() {
        return "活动封面 " + activityCoverKey + " 状态异常: 它是否与其它活动封面不一致，" +
                "或是否没绑定活动?";
    }
}
