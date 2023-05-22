package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * @author DwArFeng
 * @since 1.1.0
 */
public class UserNotPermittedForActivityTemplateException extends HandlerException {

    private static final long serialVersionUID = 1803459869538143196L;

    private final StringIdKey userKey;
    private final LongIdKey activityTemplateKey;

    public UserNotPermittedForActivityTemplateException(StringIdKey userKey, LongIdKey activityTemplateKey) {
        this.userKey = userKey;
        this.activityTemplateKey = activityTemplateKey;
    }

    public UserNotPermittedForActivityTemplateException(
            Throwable cause, StringIdKey userKey, LongIdKey activityTemplateKey
    ) {
        super(cause);
        this.userKey = userKey;
        this.activityTemplateKey = activityTemplateKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 没有操作活动模板 " + activityTemplateKey + " 的权限";
    }
}
