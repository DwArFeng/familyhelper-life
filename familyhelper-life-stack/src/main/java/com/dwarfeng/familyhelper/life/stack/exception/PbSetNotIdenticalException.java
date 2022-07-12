package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳集合不一致异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbSetNotIdenticalException extends HandlerException {

    private static final long serialVersionUID = -6333729332883321643L;

    private final LongIdKey parentSetKey;
    private final LongIdKey childSetKey;

    public PbSetNotIdenticalException(LongIdKey parentSetKey, LongIdKey childSetKey) {
        this.parentSetKey = parentSetKey;
        this.childSetKey = childSetKey;
    }

    public PbSetNotIdenticalException(
            Throwable cause, LongIdKey parentSetKey, LongIdKey childSetKey
    ) {
        super(cause);
        this.parentSetKey = parentSetKey;
        this.childSetKey = childSetKey;
    }

    @Override
    public String getMessage() {
        return "父项个人最佳节点所属集合 " + parentSetKey + " 与子项个人最佳节点所属集合 " + childSetKey + " 不一致";
    }
}
