package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 用户对个人最佳集合没有权限异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class UserNotPermittedForPbSetException extends HandlerException {

    private static final long serialVersionUID = 6675113827900264917L;

    private final StringIdKey userKey;
    private final LongIdKey pbSetKey;

    public UserNotPermittedForPbSetException(StringIdKey userKey, LongIdKey pbSetKey) {
        this.userKey = userKey;
        this.pbSetKey = pbSetKey;
    }

    public UserNotPermittedForPbSetException(Throwable cause, StringIdKey userKey, LongIdKey pbSetKey) {
        super(cause);
        this.userKey = userKey;
        this.pbSetKey = pbSetKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 没有操作个人最佳集合 " + pbSetKey + " 的权限";
    }
}
