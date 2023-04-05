package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 用户对活动数据集合没有权限异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class UserNotPermittedForActivityDataSetException extends HandlerException {

    private static final long serialVersionUID = 9002495503346779896L;

    private final StringIdKey userKey;
    private final LongIdKey activityDataSetKey;

    public UserNotPermittedForActivityDataSetException(StringIdKey userKey, LongIdKey activityDataSetKey) {
        this.userKey = userKey;
        this.activityDataSetKey = activityDataSetKey;
    }

    public UserNotPermittedForActivityDataSetException(
            Throwable cause, StringIdKey userKey, LongIdKey activityDataSetKey
    ) {
        super(cause);
        this.userKey = userKey;
        this.activityDataSetKey = activityDataSetKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 没有操作活动数据集合 " + activityDataSetKey + " 的权限";
    }
}
