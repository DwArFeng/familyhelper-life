package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳记录不存在异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbRecordNotExistsException extends HandlerException {

    private static final long serialVersionUID = 1016843580842339115L;

    private final LongIdKey pbRecordKey;

    public PbRecordNotExistsException(LongIdKey pbRecordKey) {
        this.pbRecordKey = pbRecordKey;
    }

    public PbRecordNotExistsException(Throwable cause, LongIdKey pbRecordKey) {
        super(cause);
        this.pbRecordKey = pbRecordKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳记录 " + pbRecordKey + " 不存在";
    }
}
