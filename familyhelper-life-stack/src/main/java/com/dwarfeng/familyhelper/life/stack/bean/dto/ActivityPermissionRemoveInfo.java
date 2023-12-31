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
public class ActivityPermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 6164512465460332153L;
    
    private LongIdKey activityKey;
    private StringIdKey userKey;

    public ActivityPermissionRemoveInfo() {
    }

    public ActivityPermissionRemoveInfo(LongIdKey activityKey, StringIdKey userKey) {
        this.activityKey = activityKey;
        this.userKey = userKey;
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

    @Override
    public String toString() {
        return "ActivityPermissionRemoveInfo{" +
                "activityKey=" + activityKey +
                ", userKey=" + userKey +
                '}';
    }
}
