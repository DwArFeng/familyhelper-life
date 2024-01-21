package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动参与者创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityParticipantCreateInfo implements Dto {

    private static final long serialVersionUID = 5103047057034939703L;

    private LongIdKey activityKey;
    private StringIdKey userKey;
    private String remark;

    public ActivityParticipantCreateInfo() {
    }

    public ActivityParticipantCreateInfo(LongIdKey activityKey, StringIdKey userKey, String remark) {
        this.activityKey = activityKey;
        this.userKey = userKey;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityParticipantCreateInfo{" +
                "activityKey=" + activityKey +
                ", userKey=" + userKey +
                ", remark='" + remark + '\'' +
                '}';
    }
}
