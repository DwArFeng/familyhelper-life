package com.dwarfeng.familyhelper.life.stack.struct;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;

import java.util.Map;

/**
 * 活动模板驱动信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public final class ActivityTemplateDriveInfo {

    private final ActivityTemplate activityTemplate;
    private final Map<ActivityTemplateDriverInfo, ActivityTemplateDriver> activityTemplateDriverMap;

    public ActivityTemplateDriveInfo(
            ActivityTemplate activityTemplate, Map<ActivityTemplateDriverInfo,
            ActivityTemplateDriver> ActivityTemplateDriverMap
    ) {
        this.activityTemplate = activityTemplate;
        this.activityTemplateDriverMap = ActivityTemplateDriverMap;
    }

    public ActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public Map<ActivityTemplateDriverInfo, ActivityTemplateDriver> getActivityTemplateDriverMap() {
        return activityTemplateDriverMap;
    }

    @Override
    public String toString() {
        return "ActivityTemplateDriveInfo{" +
                "activityTemplate=" + activityTemplate +
                ", activityTemplateDriverMap=" + activityTemplateDriverMap +
                '}';
    }
}
