package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 活动参与者更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityParticipantUpdateInfo implements Dto {

    private static final long serialVersionUID = 1076467092671223954L;

    private ActivityParticipantKey key;
    private String remark;

    public ActivityParticipantUpdateInfo() {
    }

    public ActivityParticipantUpdateInfo(ActivityParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public ActivityParticipantKey getKey() {
        return key;
    }

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
        return "ActivityParticipantUpdateInfo{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
