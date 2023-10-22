package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 活动模板参与者创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateParticipantCreateInfo implements Dto {

    private static final long serialVersionUID = -7656226664443458079L;
    
    private LongIdKey activityTemplateKey;
    private StringIdKey userKey;
    private String remark;

    public ActivityTemplateParticipantCreateInfo() {
    }

    public ActivityTemplateParticipantCreateInfo(LongIdKey activityTemplateKey, StringIdKey userKey, String remark) {
        this.activityTemplateKey = activityTemplateKey;
        this.userKey = userKey;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityTemplateParticipantCreateInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                ", remark='" + remark + '\'' +
                '}';
    }
}
