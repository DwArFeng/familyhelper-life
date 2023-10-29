package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板文件不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateFileNotExistsException extends HandlerException {

    private static final long serialVersionUID = 8919188263460708071L;

    private final LongIdKey activityTemplateFileKey;

    public ActivityTemplateFileNotExistsException(LongIdKey activityTemplateFileKey) {
        this.activityTemplateFileKey = activityTemplateFileKey;
    }

    public ActivityTemplateFileNotExistsException(Throwable cause, LongIdKey activityTemplateFileKey) {
        super(cause);
        this.activityTemplateFileKey = activityTemplateFileKey;
    }

    @Override
    public String getMessage() {
        return "活动模板文件 " + activityTemplateFileKey + " 不存在";
    }
}
