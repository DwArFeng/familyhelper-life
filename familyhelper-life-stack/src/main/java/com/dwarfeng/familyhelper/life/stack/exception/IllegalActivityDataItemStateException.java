package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动数据项目状态非法异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class IllegalActivityDataItemStateException extends HandlerException {

    private static final long serialVersionUID = -4223555856181278943L;

    private final LongIdKey activityDataItemKey;

    public IllegalActivityDataItemStateException(LongIdKey activityDataItemKey) {
        this.activityDataItemKey = activityDataItemKey;
    }

    public IllegalActivityDataItemStateException(Throwable cause, LongIdKey activityDataItemKey) {
        super(cause);
        this.activityDataItemKey = activityDataItemKey;
    }

    @Override
    public String getMessage() {
        return "活动数据项目 " + activityDataItemKey + " 状态异常: 它是否没绑定活动数据集合?";
    }
}
