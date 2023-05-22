package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateParticipant;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动模板参与者。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityTemplateParticipant implements Bean {

    private static final long serialVersionUID = -7769255806453092348L;

    public static FastJsonActivityTemplateParticipant of(ActivityTemplateParticipant stackBean) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new FastJsonActivityTemplateParticipant(
                    FastJsonActivityTemplateParticipantKey.of(stackBean.getKey()),
                    stackBean.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonActivityTemplateParticipantKey key;

    @JSONField(name = "remark", ordinal = 1)
    private String remark;

    public FastJsonActivityTemplateParticipant() {
    }

    public FastJsonActivityTemplateParticipant(FastJsonActivityTemplateParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public FastJsonActivityTemplateParticipantKey getKey() {
        return key;
    }

    public void setKey(FastJsonActivityTemplateParticipantKey key) {
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
        return "FastJsonActivityTemplateParticipant{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
