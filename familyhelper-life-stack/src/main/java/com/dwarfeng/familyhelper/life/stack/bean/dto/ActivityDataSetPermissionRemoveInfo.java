package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动数据权限删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataSetPermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 8959657514387424440L;

    private LongIdKey activityDataSetKey;
    private StringIdKey userKey;

    public ActivityDataSetPermissionRemoveInfo() {
    }

    public ActivityDataSetPermissionRemoveInfo(LongIdKey activityDataSetKey, StringIdKey userKey) {
        this.activityDataSetKey = activityDataSetKey;
        this.userKey = userKey;
    }

    public LongIdKey getActivityDataSetKey() {
        return activityDataSetKey;
    }

    public void setActivityDataSetKey(LongIdKey activityDataSetKey) {
        this.activityDataSetKey = activityDataSetKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "ActivityDataSetPermissionRemoveInfo{" +
                "activityDataSetKey=" + activityDataSetKey +
                ", userKey=" + userKey +
                '}';
    }
}
