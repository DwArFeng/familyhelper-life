package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 活动模板活动创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateActivityCreateInfo implements Dto {

    private static final long serialVersionUID = -3960147996642559486L;

    private LongIdKey activityTemplateKey;

    public ActivityTemplateActivityCreateInfo() {
    }

    public ActivityTemplateActivityCreateInfo(LongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public LongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(LongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    @Override
    public String toString() {
        return "ActivityTemplateActivityCreateInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                '}';
    }
}
