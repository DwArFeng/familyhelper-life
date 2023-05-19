package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动数据集合不一致异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataSetNotIdenticalException extends HandlerException {

    private static final long serialVersionUID = -2855215408341721047L;

    private final LongIdKey parentSetKey;
    private final LongIdKey childSetKey;

    public ActivityDataSetNotIdenticalException(LongIdKey parentSetKey, LongIdKey childSetKey) {
        this.parentSetKey = parentSetKey;
        this.childSetKey = childSetKey;
    }

    public ActivityDataSetNotIdenticalException(
            Throwable cause, LongIdKey parentSetKey, LongIdKey childSetKey
    ) {
        super(cause);
        this.parentSetKey = parentSetKey;
        this.childSetKey = childSetKey;
    }

    @Override
    public String getMessage() {
        return "父项活动数据节点所属集合 " + parentSetKey + " 与子项活动数据节点所属集合 " + childSetKey + " 不一致";
    }
}
