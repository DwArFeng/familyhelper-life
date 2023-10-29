package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板文件状态非法异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class IllegalActivityTemplateFileStateException extends HandlerException {

    private static final long serialVersionUID = 9049891047530141183L;

    private final LongIdKey activityTemplateFileKey;

    public IllegalActivityTemplateFileStateException(LongIdKey activityTemplateFileKey) {
        this.activityTemplateFileKey = activityTemplateFileKey;
    }

    public IllegalActivityTemplateFileStateException(Throwable cause, LongIdKey activityTemplateFileKey) {
        super(cause);
        this.activityTemplateFileKey = activityTemplateFileKey;
    }

    @Override
    public String getMessage() {
        return "活动模板文件 " + activityTemplateFileKey + " 状态异常: 它是否没绑定活动模板?";
    }
}
