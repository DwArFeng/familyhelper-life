package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动数据集合不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataSetNotExistsException extends HandlerException {

    private static final long serialVersionUID = 6612362420579576141L;

    private final LongIdKey activityDataSetKey;

    public ActivityDataSetNotExistsException(LongIdKey activityDataSetKey) {
        this.activityDataSetKey = activityDataSetKey;
    }

    public ActivityDataSetNotExistsException(Throwable cause, LongIdKey activityDataSetKey) {
        super(cause);
        this.activityDataSetKey = activityDataSetKey;
    }

    @Override
    public String getMessage() {
        return "活动数据集合 " + activityDataSetKey + " 不存在";
    }
}
