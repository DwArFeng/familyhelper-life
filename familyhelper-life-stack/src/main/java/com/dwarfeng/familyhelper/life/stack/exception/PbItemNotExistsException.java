package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳项目不存在异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbItemNotExistsException extends HandlerException {

    private static final long serialVersionUID = -6518196734602070935L;

    private final LongIdKey pbItemKey;

    public PbItemNotExistsException(LongIdKey pbItemKey) {
        this.pbItemKey = pbItemKey;
    }

    public PbItemNotExistsException(Throwable cause, LongIdKey pbItemKey) {
        super(cause);
        this.pbItemKey = pbItemKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳项目 " + pbItemKey + " 不存在";
    }
}
