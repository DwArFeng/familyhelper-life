package com.dwarfeng.familyhelper.life.impl.handler.atdriver;

import com.dwarfeng.familyhelper.life.impl.handler.ActivityTemplateDriverSupporter;
import org.springframework.stereotype.Component;

/**
 * Cron 活动模板驱动器支持器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
@Component
public class CronActivityTemplateDriverSupporter implements ActivityTemplateDriverSupporter {

    public static final String SUPPORT_TYPE = "cron_activity_template_driver";

    @Override
    public String provideType() {
        return SUPPORT_TYPE;
    }

    @Override
    public String provideLabel() {
        return "Cron 活动模板驱动器";
    }

    @Override
    public String provideDescription() {
        return "根据指定的 Cron 表达式定时活动模板驱动的活动模板驱动器";
    }

    @Override
    public String provideExampleParam() {
        return "0/2 * * * * *";
    }
}
