package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳文件不存在异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbFileNotExistsException extends HandlerException {

    private static final long serialVersionUID = -8172041574602499698L;

    private final LongIdKey pbFileKey;

    public PbFileNotExistsException(LongIdKey pbFileKey) {
        this.pbFileKey = pbFileKey;
    }

    public PbFileNotExistsException(Throwable cause, LongIdKey pbFileKey) {
        super(cause);
        this.pbFileKey = pbFileKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳文件 " + pbFileKey + " 不存在";
    }
}
