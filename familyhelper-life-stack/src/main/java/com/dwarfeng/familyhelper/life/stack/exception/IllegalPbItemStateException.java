package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳项目状态非法异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class IllegalPbItemStateException extends HandlerException {

    private static final long serialVersionUID = -7646465912676869413L;

    private final LongIdKey pbItemKey;

    public IllegalPbItemStateException(LongIdKey pbItemKey) {
        this.pbItemKey = pbItemKey;
    }

    public IllegalPbItemStateException(Throwable cause, LongIdKey pbItemKey) {
        super(cause);
        this.pbItemKey = pbItemKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳项目 " + pbItemKey + " 状态异常: 它是否没绑定个人最佳节点?";
    }
}
