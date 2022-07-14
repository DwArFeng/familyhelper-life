package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳记录状态非法异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class IllegalPbRecordStateException extends HandlerException {

    private static final long serialVersionUID = -5344638251057606645L;

    private final LongIdKey pbRecordKey;

    public IllegalPbRecordStateException(LongIdKey pbRecordKey) {
        this.pbRecordKey = pbRecordKey;
    }

    public IllegalPbRecordStateException(Throwable cause, LongIdKey pbRecordKey) {
        super(cause);
        this.pbRecordKey = pbRecordKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳记录 " + pbRecordKey + " 状态异常: 它是否没绑定个人最佳项目?";
    }
}
