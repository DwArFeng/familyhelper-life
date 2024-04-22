package com.dwarfeng.familyhelper.life.impl.handler.atdriver;

import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;

/**
 * 活动模板驱动器的抽象实现。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public abstract class AbstractActivityTemplateDriver implements ActivityTemplateDriver {

    protected Context context;

    @Override
    public void init(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "AbstractActivityTemplateDriver{" +
                "context=" + context +
                '}';
    }
}
