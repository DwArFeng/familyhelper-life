package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳集合不存在异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbSetNotExistsException extends HandlerException {

    private static final long serialVersionUID = -5734318506220194358L;

    private final LongIdKey pbSetKey;

    public PbSetNotExistsException(LongIdKey pbSetKey) {
        this.pbSetKey = pbSetKey;
    }

    public PbSetNotExistsException(Throwable cause, LongIdKey pbSetKey) {
        super(cause);
        this.pbSetKey = pbSetKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳集合 " + pbSetKey + " 不存在";
    }
}
