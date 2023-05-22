package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动模板权限删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplatePermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = -8404892175909202494L;

    private LongIdKey activityTemplateKey;
    private StringIdKey userKey;

    public ActivityTemplatePermissionRemoveInfo() {
    }

    public ActivityTemplatePermissionRemoveInfo(LongIdKey activityTemplateKey, StringIdKey userKey) {
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
        return "ActivityTemplatePermissionRemoveInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                '}';
    }
}
