package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 活动模板参与者。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateParticipant implements Entity<ActivityTemplateParticipantKey> {

    private static final long serialVersionUID = -3892880146739180069L;

    private ActivityTemplateParticipantKey key;
    private String remark;

    public ActivityTemplateParticipant() {
    }

    public ActivityTemplateParticipant(ActivityTemplateParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    @Override
    public ActivityTemplateParticipantKey getKey() {
        return key;
    }

    @Override
    public void setKey(ActivityTemplateParticipantKey key) {
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
        return "ActivityTemplateParticipant{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
