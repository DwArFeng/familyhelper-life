package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.User;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.List;

/**
 * 由驱动提醒的活动推送信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ActivityRemindedByDriverPushInfo implements Dto {

    private static final long serialVersionUID = 5200359761504283419L;

    private ActivityTemplate activityTemplate;
    private List<User> aimedUsers;

    public ActivityRemindedByDriverPushInfo() {
    }

    public ActivityRemindedByDriverPushInfo(ActivityTemplate activityTemplate, List<User> aimedUsers) {
        this.activityTemplate = activityTemplate;
        this.aimedUsers = aimedUsers;
    }

    public ActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public void setActivityTemplate(ActivityTemplate activityTemplate) {
        this.activityTemplate = activityTemplate;
    }

    public List<User> getAimedUsers() {
        return aimedUsers;
    }

    public void setAimedUsers(List<User> aimedUsers) {
        this.aimedUsers = aimedUsers;
    }

    @Override
    public String toString() {
        return "ActivityRemindedByDriverPushInfo{" +
                "activityTemplate=" + activityTemplate +
                ", aimedUsers=" + aimedUsers +
                '}';
    }
}
