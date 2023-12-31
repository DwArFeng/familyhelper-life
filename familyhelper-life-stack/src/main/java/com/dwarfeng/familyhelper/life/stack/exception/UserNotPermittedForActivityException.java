package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 用户没有权限进行活动操作的异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class UserNotPermittedForActivityException extends HandlerException {

    private static final long serialVersionUID = -2238951063630589890L;
    
    private final StringIdKey userKey;
    private final LongIdKey activityTemplateKey;

    public UserNotPermittedForActivityException(StringIdKey userKey, LongIdKey activityTemplateKey) {
        this.userKey = userKey;
        this.activityTemplateKey = activityTemplateKey;
    }

    public UserNotPermittedForActivityException(Throwable cause, StringIdKey userKey, LongIdKey activityTemplateKey) {
        super(cause);
        this.userKey = userKey;
        this.activityTemplateKey = activityTemplateKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 没有操作活动 " + activityTemplateKey + " 的权限";
    }
}
