package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动文件状态非法异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class IllegalActivityFileStateException extends HandlerException {

    private static final long serialVersionUID = -5150397619302988140L;

    private final LongIdKey activityFileKey;

    public IllegalActivityFileStateException(LongIdKey activityFileKey) {
        this.activityFileKey = activityFileKey;
    }

    public IllegalActivityFileStateException(Throwable cause, LongIdKey activityFileKey) {
        super(cause);
        this.activityFileKey = activityFileKey;
    }

    @Override
    public String getMessage() {
        return "活动文件 " + activityFileKey + " 状态异常: 它是否没绑定活动?";
    }
}
