package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;

/**
 * 活动模板驱动器提供器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ActivityTemplateDriverProvider {

    /**
     * 返回提供器是否支持指定的类型。
     *
     * @param type 指定的类型。
     * @return 提供器是否支持指定的类型。
     */
    boolean supportType(String type);

    /**
     * 提供活动模板驱动器。
     *
     * @return 提供的活动模板驱动器。
     */
    ActivityTemplateDriver provide();
}
