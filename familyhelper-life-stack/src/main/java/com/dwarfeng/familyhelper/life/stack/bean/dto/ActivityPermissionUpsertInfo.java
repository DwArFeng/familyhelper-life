package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = -98283458255970772L;
    
    private LongIdKey activityKey;
    private StringIdKey userKey;
    private int permissionLevel;

    public ActivityPermissionUpsertInfo() {
    }

    public ActivityPermissionUpsertInfo(LongIdKey activityKey, StringIdKey userKey, int permissionLevel) {
        this.activityKey = activityKey;
        this.userKey = userKey;
        this.permissionLevel = permissionLevel;
    }

    public LongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(LongIdKey activityKey) {
        this.activityKey = activityKey;
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
        return "ActivityPermissionUpsertInfo{" +
                "activityKey=" + activityKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
