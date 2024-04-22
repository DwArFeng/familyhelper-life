package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.familyhelper.life.stack.exception.ActivityTemplateDriverException;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 活动模板驱动器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ActivityTemplateDriver {

    /**
     * 初始化活动模板驱动器。
     *
     * <p>
     * 该方法会在活动模板驱动器初始化后调用。<br>
     * 该方法会传入一个 {@link Context}，此对象为活动模板驱动器的上下文，其中包含了活动模板驱动器需要使用的所有方法。<br>
     * 实现该方法时，应妥善保存上下文，以便在后续的方法调用中使用。
     *
     * @param context 活动模板驱动器的上下文。
     */
    void init(Context context);

    /**
     * 注册指定的活动模板驱动器信息。
     *
     * @param driverInfo 指定的活动模板驱动器信息。
     * @throws ActivityTemplateDriverException 活动模板驱动器异常。
     */
    void register(ActivityTemplateDriverInfo driverInfo) throws ActivityTemplateDriverException;

    /**
     * 解除注册所有的活动模板驱动器信息。
     *
     * @throws ActivityTemplateDriverException 活动模板驱动器异常。
     */
    void unregisterAll() throws ActivityTemplateDriverException;

    /**
     * 活动模板驱动器上下文。
     *
     * @author DwArFeng
     * @since 1.0.0
     */
    interface Context {

        /**
         * 执行驱动操作。
         *
         * @param activityTemplateDriverInfoKey 操作对应的活动模板驱动信息的主键。
         * @throws ActivityTemplateDriverException 活动模板驱动器异常。
         */
        void drive(LongIdKey activityTemplateDriverInfoKey) throws ActivityTemplateDriverException;
    }
}
