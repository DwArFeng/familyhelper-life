package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 活动模板参与者更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateParticipantUpdateInfo implements Dto {

    private static final long serialVersionUID = 1065425453194914116L;

    private ActivityTemplateParticipantKey key;
    private String remark;

    public ActivityTemplateParticipantUpdateInfo() {
    }

    public ActivityTemplateParticipantUpdateInfo(ActivityTemplateParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public ActivityTemplateParticipantKey getKey() {
        return key;
    }

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
        return "ActivityTemplateParticipantUpdateInfo{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
