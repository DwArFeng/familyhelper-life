package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 活动参与者。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityParticipant implements Entity<ActivityParticipantKey> {

    private static final long serialVersionUID = 7838862481557046041L;

    private ActivityParticipantKey key;
    private String remark;

    public ActivityParticipant() {
    }

    public ActivityParticipant(ActivityParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    @Override
    public ActivityParticipantKey getKey() {
        return key;
    }

    @Override
    public void setKey(ActivityParticipantKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityParticipant{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
