package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateParticipant;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 活动模板参与者。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityTemplateParticipant implements Bean {

    private static final long serialVersionUID = 2330261955060619562L;

    public static JSFixedFastJsonActivityTemplateParticipant of(ActivityTemplateParticipant stackBean) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityTemplateParticipant(
                    JSFixedFastJsonActivityTemplateParticipantKey.of(stackBean.getKey()),
                    stackBean.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonActivityTemplateParticipantKey key;

    @JSONField(name = "remark", ordinal = 1)
    private String remark;

    public JSFixedFastJsonActivityTemplateParticipant() {
    }

    public JSFixedFastJsonActivityTemplateParticipant(JSFixedFastJsonActivityTemplateParticipantKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public JSFixedFastJsonActivityTemplateParticipantKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonActivityTemplateParticipantKey key) {
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
        return "JSFixedFastJsonActivityTemplateParticipant{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
