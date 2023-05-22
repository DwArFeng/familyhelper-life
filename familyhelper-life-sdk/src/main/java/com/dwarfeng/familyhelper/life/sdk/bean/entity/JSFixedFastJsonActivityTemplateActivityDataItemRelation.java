package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonLongLongRelationKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateActivityDataItemRelation;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * JSFixed FastJson 活动模板活动数据条目关联。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityTemplateActivityDataItemRelation implements Bean {

    private static final long serialVersionUID = 668049942208662446L;

    public static JSFixedFastJsonActivityTemplateActivityDataItemRelation of(
            ActivityTemplateActivityDataItemRelation stackBean
    ) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityTemplateActivityDataItemRelation(
                    JSFixedFastJsonLongLongRelationKey.of(stackBean.getKey()),
                    stackBean.getRemark(), stackBean.getInitialValue()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongLongRelationKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    @JSONField(name = "initial_value", ordinal = 3)
    private BigDecimal initialValue;

    public JSFixedFastJsonActivityTemplateActivityDataItemRelation() {
    }

    public JSFixedFastJsonActivityTemplateActivityDataItemRelation(
            JSFixedFastJsonLongLongRelationKey key, String remark, BigDecimal initialValue
    ) {
        this.key = key;
        this.remark = remark;
        this.initialValue = initialValue;
    }

    public JSFixedFastJsonLongLongRelationKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongLongRelationKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(BigDecimal initialValue) {
        this.initialValue = initialValue;
    }

    @Override
    public String toString() {
        return "JSFixedFastJsonActivityTemplateActivityDataItemRelation{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
