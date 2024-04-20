package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 由驱动生成的活动推送信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ActivityGeneratedByDriverPushInfo implements Dto {

    private static final long serialVersionUID = 4844336021766005580L;

    private ActivityTemplate activityTemplate;
    private Activity activity;

    public ActivityGeneratedByDriverPushInfo() {
    }

    public ActivityGeneratedByDriverPushInfo(ActivityTemplate activityTemplate, Activity activity) {
        this.activityTemplate = activityTemplate;
        this.activity = activity;
    }

    public ActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public void setActivityTemplate(ActivityTemplate activityTemplate) {
        this.activityTemplate = activityTemplate;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "ActivityGeneratedByDriverPushInfo{" +
                "activityTemplate=" + activityTemplate +
                ", activity=" + activity +
                '}';
    }
}
