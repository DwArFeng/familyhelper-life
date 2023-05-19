package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动数据节点不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataNodeNotExistsException extends HandlerException {

    private static final long serialVersionUID = -3107660441063210638L;

    private final LongIdKey activityDataNodeKey;

    public ActivityDataNodeNotExistsException(LongIdKey activityDataNodeKey) {
        this.activityDataNodeKey = activityDataNodeKey;
    }

    public ActivityDataNodeNotExistsException(Throwable cause, LongIdKey activityDataNodeKey) {
        super(cause);
        this.activityDataNodeKey = activityDataNodeKey;
    }

    @Override
    public String getMessage() {
        return "活动数据节点 " + activityDataNodeKey + " 不存在";
    }
}
