package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动模板权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplatePermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = 2900671211596637008L;

    private LongIdKey activityTemplateKey;
    private StringIdKey userKey;
    private int permissionLevel;

    public ActivityTemplatePermissionUpsertInfo() {
    }

    public ActivityTemplatePermissionUpsertInfo(
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
        return "ActivityTemplatePermissionUpsertInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
