package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人最佳节点状态非法异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class IllegalPbNodeStateException extends HandlerException {

    private static final long serialVersionUID = 3769792548057248565L;

    private final LongIdKey pbNodeKey;

    public IllegalPbNodeStateException(LongIdKey pbNodeKey) {
        this.pbNodeKey = pbNodeKey;
    }

    public IllegalPbNodeStateException(Throwable cause, LongIdKey pbNodeKey) {
        super(cause);
        this.pbNodeKey = pbNodeKey;
    }

    @Override
    public String getMessage() {
        return "个人最佳节点 " + pbNodeKey + " 状态异常: 它是否没绑定个人最佳集合?";
    }
}
