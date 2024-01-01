package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动文件不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityFileNotExistsException extends HandlerException {

    private static final long serialVersionUID = 5911817665674336115L;

    private final LongIdKey activityFileKey;

    public ActivityFileNotExistsException(LongIdKey activityFileKey) {
        this.activityFileKey = activityFileKey;
    }

    public ActivityFileNotExistsException(Throwable cause, LongIdKey activityFileKey) {
        super(cause);
        this.activityFileKey = activityFileKey;
    }

    @Override
    public String getMessage() {
        return "活动文件 " + activityFileKey + " 不存在";
    }
}
