package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 活动参与者删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityParticipantRemoveInfo implements Dto {

    private static final long serialVersionUID = 2607084665127395656L;

    private ActivityParticipantKey key;

    public ActivityParticipantRemoveInfo() {
    }

    public ActivityParticipantRemoveInfo(ActivityParticipantKey key) {
        this.key = key;
    }

    public ActivityParticipantKey getKey() {
        return key;
    }

    public void setKey(ActivityParticipantKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ActivityParticipantRemoveInfo{" +
                "key=" + key +
                '}';
    }
}
