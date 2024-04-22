package com.dwarfeng.familyhelper.life.impl.handler.atdriver;

import com.dwarfeng.familyhelper.life.impl.handler.ActivityTemplateDriverSupporter;
import org.springframework.stereotype.Component;

/**
 * 固定间隔活动模板驱动支持器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
@Component
public class FixedRateActivityTemplateDriverSupporter implements ActivityTemplateDriverSupporter {

    public static final String SUPPORT_TYPE = "fixed_rate_activity_template_driver";

    @Override
    public String provideType() {
        return SUPPORT_TYPE;
    }

    @Override
    public String provideLabel() {
        return "固定频率活动模板驱动器";
    }

    @Override
    public String provideDescription() {
        return "根据指定的间隔定时活动模板驱动，" +
                "如果某一次活动模板驱动晚于间隔，则后续活动模板驱动的时间会提前，以保持频率不变。";
    }

    @Override
    public String provideExampleParam() {
        return "60000";
    }
}
