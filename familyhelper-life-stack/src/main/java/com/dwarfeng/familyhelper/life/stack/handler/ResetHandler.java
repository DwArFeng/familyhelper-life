package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.StartableHandler;

/**
 * 重置处理器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ResetHandler extends StartableHandler {

    /**
     * 重置活动模板驱动。
     *
     * @throws HandlerException 处理器异常。
     */
    void resetActivityTemplateDrive() throws HandlerException;
}
