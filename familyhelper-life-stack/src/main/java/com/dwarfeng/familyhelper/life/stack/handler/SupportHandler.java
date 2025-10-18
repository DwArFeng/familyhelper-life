package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 支持处理器。
 *
 * @author DwArFeng
 * @since 1.2.0
 */
public interface SupportHandler {

    /**
     * 重置活动模板驱动器。
     *
     * @throws HandlerException 处理器异常。
     */
    void resetActivityTemplateDriver() throws HandlerException;
}
