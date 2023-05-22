package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动模板活动权限删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateActivityPermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 3695123058302766086L;

    private LongIdKey activityTemplateKey;
    private StringIdKey userKey;

    public ActivityTemplateActivityPermissionRemoveInfo() {
    }

    public ActivityTemplateActivityPermissionRemoveInfo(LongIdKey activityTemplateKey, StringIdKey userKey) {
        this.activityTemplateKey = activityTemplateKey;
        this.userKey = userKey;
    }

    public LongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(LongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "ActivityTemplateActivityPermissionRemoveInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                '}';
    }
}
