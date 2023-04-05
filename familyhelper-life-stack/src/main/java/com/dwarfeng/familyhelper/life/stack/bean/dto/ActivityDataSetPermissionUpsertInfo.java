package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动数据权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataSetPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = 4587787692376831877L;

    private LongIdKey activityDataSetKey;
    private StringIdKey userKey;
    private int permissionLevel;

    public ActivityDataSetPermissionUpsertInfo() {
    }

    public ActivityDataSetPermissionUpsertInfo(LongIdKey ActivityDataSetKey, StringIdKey userKey, int permissionLevel) {
        this.activityDataSetKey = ActivityDataSetKey;
        this.userKey = userKey;
        this.permissionLevel = permissionLevel;
    }

    public LongIdKey getActivityDataSetKey() {
        return activityDataSetKey;
    }

    public void setActivityDataSetKey(LongIdKey ActivityDataSetKey) {
        this.activityDataSetKey = ActivityDataSetKey;
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
        return "ActivityDataSetPermissionUpsertInfo{" +
                "activityDataSetKey=" + activityDataSetKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
