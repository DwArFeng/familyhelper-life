package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动数据项目不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataItemNotExistsException extends HandlerException {

    private static final long serialVersionUID = -3655816499856139249L;

    private final LongIdKey activityDataItemKey;

    public ActivityDataItemNotExistsException(LongIdKey activityDataItemKey) {
        this.activityDataItemKey = activityDataItemKey;
    }

    public ActivityDataItemNotExistsException(Throwable cause, LongIdKey activityDataItemKey) {
        super(cause);
        this.activityDataItemKey = activityDataItemKey;
    }

    @Override
    public String getMessage() {
        return "活动数据项目 " + activityDataItemKey + " 不存在";
    }
}
