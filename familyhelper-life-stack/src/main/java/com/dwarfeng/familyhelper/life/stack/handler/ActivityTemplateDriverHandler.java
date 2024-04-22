package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 驱动执行器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ActivityTemplateDriverHandler extends Handler {

    /**
     * 寻找指定的活动模板驱动器。
     *
     * @param type 活动模板驱动器的类型。
     * @return 符合驱动类型的指定的活动模板驱动器。
     * @throws HandlerException 执行器。
     */
    ActivityTemplateDriver find(String type) throws HandlerException;
}
