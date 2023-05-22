package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityParticipant;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 活动参与者。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityParticipant implements Bean {

    private static final long serialVersionUID = -4430429611334781966L;

    public static JSFixedFastJsonActivityParticipant of(ActivityParticipant activityParticipant) {
        if (Objects.isNull(activityParticipant)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityParticipant(
                    JSFixedFastJsonActivityParticipantKey.of(activityParticipant.getKey()),
                    activityParticipant.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonActivityParticipantKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    public JSFixedFastJsonActivityParticipant() {
    }

    public JSFixedFastJsonActivityParticipant(JSFixedFastJsonActivityParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public JSFixedFastJsonActivityParticipantKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonActivityParticipantKey key) {
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
        return "JSFixedFastJsonActivityParticipant{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
