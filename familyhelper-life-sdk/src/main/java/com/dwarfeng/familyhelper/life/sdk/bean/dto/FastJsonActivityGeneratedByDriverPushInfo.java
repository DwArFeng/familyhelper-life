package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.FastJsonActivity;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.FastJsonActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityGeneratedByDriverPushInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Objects;

/**
 * FastJson 由驱动生成的活动推送信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class FastJsonActivityGeneratedByDriverPushInfo implements Dto {

    private static final long serialVersionUID = 576754744382482833L;

    public static FastJsonActivityGeneratedByDriverPushInfo of(ActivityGeneratedByDriverPushInfo stackBean) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new FastJsonActivityGeneratedByDriverPushInfo(
                    FastJsonActivityTemplate.of(stackBean.getActivityTemplate()),
                    FastJsonActivity.of(stackBean.getActivity())
            );
        }
    }

    @JSONField(name = "activity_template", ordinal = 1)
    private FastJsonActivityTemplate activityTemplate;

    @JSONField(name = "activity", ordinal = 2)
    private FastJsonActivity activity;

    public FastJsonActivityGeneratedByDriverPushInfo() {
    }

    public FastJsonActivityGeneratedByDriverPushInfo(
            FastJsonActivityTemplate activityTemplate,
            FastJsonActivity activity
    ) {
        this.activityTemplate = activityTemplate;
        this.activity = activity;
    }

    public FastJsonActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public void setActivityTemplate(FastJsonActivityTemplate activityTemplate) {
        this.activityTemplate = activityTemplate;
    }

    public FastJsonActivity getActivity() {
        return activity;
    }

    public void setActivity(FastJsonActivity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "FastJsonActivityGeneratedByDriverPushInfo{" +
                "activityTemplate=" + activityTemplate +
                ", activity=" + activity +
                '}';
    }
}
