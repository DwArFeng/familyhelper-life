package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板封面状态非法异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class IllegalActivityTemplateCoverStateException extends HandlerException {

    private static final long serialVersionUID = -5997155657047978449L;
    
    private final LongIdKey activityTemplateCoverKey;

    public IllegalActivityTemplateCoverStateException(LongIdKey activityTemplateCoverKey) {
        this.activityTemplateCoverKey = activityTemplateCoverKey;
    }

    public IllegalActivityTemplateCoverStateException(Throwable cause, LongIdKey activityTemplateCoverKey) {
        super(cause);
        this.activityTemplateCoverKey = activityTemplateCoverKey;
    }

    @Override
    public String getMessage() {
        return "活动模板封面 " + activityTemplateCoverKey + " 状态异常: 它是否与其它活动模板封面不一致，" +
                "或是否没绑定活动模板?";
    }
}
