package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳节点不存在异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbNodeNotExistsException extends HandlerException {

    private static final long serialVersionUID = -7588956395687403965L;

    private final LongIdKey pbNodeKey;

    public PbNodeNotExistsException(LongIdKey pbNodeKey) {
        this.pbNodeKey = pbNodeKey;
    }

    public PbNodeNotExistsException(Throwable cause, LongIdKey pbNodeKey) {
        super(cause);
        this.pbNodeKey = pbNodeKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳节点 " + pbNodeKey + " 不存在";
    }
}
