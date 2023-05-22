package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityParticipant;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动参与者。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityParticipant implements Bean {

    private static final long serialVersionUID = -7703387940565891901L;

    public static FastJsonActivityParticipant of(ActivityParticipant activityParticipant) {
        if (Objects.isNull(activityParticipant)) {
            return null;
        } else {
            return new FastJsonActivityParticipant(
                    FastJsonActivityParticipantKey.of(activityParticipant.getKey()),
                    activityParticipant.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonActivityParticipantKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    public FastJsonActivityParticipant() {
    }

    public FastJsonActivityParticipant(FastJsonActivityParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public FastJsonActivityParticipantKey getKey() {
        return key;
    }

    public void setKey(FastJsonActivityParticipantKey key) {
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
        return "FastJsonActivityParticipant{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
