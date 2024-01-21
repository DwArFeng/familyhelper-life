package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动数据记录不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataRecordNotExistsException extends HandlerException {

    private static final long serialVersionUID = -8352960233614610280L;
    
    private final LongIdKey activityDataRecordKey;

    public ActivityDataRecordNotExistsException(LongIdKey activityDataRecordKey) {
        this.activityDataRecordKey = activityDataRecordKey;
    }

    public ActivityDataRecordNotExistsException(Throwable cause, LongIdKey activityDataRecordKey) {
        super(cause);
        this.activityDataRecordKey = activityDataRecordKey;
    }

    @Override
    public String getMessage() {
        return "活动数据记录 " + activityDataRecordKey + " 不存在";
    }
}
