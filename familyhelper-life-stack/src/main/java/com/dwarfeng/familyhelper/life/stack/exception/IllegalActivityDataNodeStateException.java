package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动数据节点状态非法异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class IllegalActivityDataNodeStateException extends HandlerException {

    private static final long serialVersionUID = -1263779832598627731L;

    private final LongIdKey activityDataNodeKey;

    public IllegalActivityDataNodeStateException(LongIdKey activityDataNodeKey) {
        this.activityDataNodeKey = activityDataNodeKey;
    }

    public IllegalActivityDataNodeStateException(Throwable cause, LongIdKey activityDataNodeKey) {
        super(cause);
        this.activityDataNodeKey = activityDataNodeKey;
    }

    @Override
    public String getMessage() {
        return "活动数据节点 " + activityDataNodeKey + " 状态异常: 它是否没绑定活动数据集合?";
    }
}
