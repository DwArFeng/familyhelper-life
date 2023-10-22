package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 活动模板参与者删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateParticipantRemoveInfo implements Dto {

    private static final long serialVersionUID = 9052021150233354163L;

    private ActivityTemplateParticipantKey key;

    public ActivityTemplateParticipantRemoveInfo() {
    }

    public ActivityTemplateParticipantRemoveInfo(ActivityTemplateParticipantKey key) {
        this.key = key;
    }

    public ActivityTemplateParticipantKey getKey() {
        return key;
    }

    public void setKey(ActivityTemplateParticipantKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ActivityTemplateParticipantRemoveInfo{" +
                "key=" + key +
                '}';
    }
}
