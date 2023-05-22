package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动模板活动权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateActivityPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = 3989308655454833396L;

    private LongIdKey activityTemplateKey;
    private StringIdKey userKey;
    private int permissionLevel;

    public ActivityTemplateActivityPermissionUpsertInfo() {
    }

    public ActivityTemplateActivityPermissionUpsertInfo(
            LongIdKey activityTemplateKey, StringIdKey userKey, int permissionLevel
    ) {
        this.activityTemplateKey = activityTemplateKey;
        this.userKey = userKey;
        this.permissionLevel = permissionLevel;
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

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "ActivityTemplateActivityPermissionUpsertInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
