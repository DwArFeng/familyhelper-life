package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.FastJsonActivityTemplate;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.FastJsonUser;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityRemindedByDriverPushInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * FastJson 由驱动提醒的活动推送信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class FastJsonActivityRemindedByDriverPushInfo implements Dto {

    private static final long serialVersionUID = -3762625508197033125L;

    public static FastJsonActivityRemindedByDriverPushInfo of(ActivityRemindedByDriverPushInfo stackBean) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new FastJsonActivityRemindedByDriverPushInfo(
                    FastJsonActivityTemplate.of(stackBean.getActivityTemplate()),
                    stackBean.getAimedUsers().stream().map(FastJsonUser::of).collect(Collectors.toList())
            );
        }
    }

    @JSONField(name = "activity_template", ordinal = 1)
    private FastJsonActivityTemplate activityTemplate;

    @JSONField(name = "aimed_users", ordinal = 2)
    private List<FastJsonUser> aimedUsers;

    public FastJsonActivityRemindedByDriverPushInfo() {
    }

    public FastJsonActivityRemindedByDriverPushInfo(
            FastJsonActivityTemplate activityTemplate,
            List<FastJsonUser> aimedUsers
    ) {
        this.activityTemplate = activityTemplate;
        this.aimedUsers = aimedUsers;
    }

    public FastJsonActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public void setActivityTemplate(FastJsonActivityTemplate activityTemplate) {
        this.activityTemplate = activityTemplate;
    }

    public List<FastJsonUser> getAimedUsers() {
        return aimedUsers;
    }

    public void setAimedUsers(List<FastJsonUser> aimedUsers) {
        this.aimedUsers = aimedUsers;
    }

    @Override
    public String toString() {
        return "FastJsonActivityRemindedByDriverPushInfo{" +
                "activityTemplate=" + activityTemplate +
                ", aimedUsers=" + aimedUsers +
                '}';
    }
}
