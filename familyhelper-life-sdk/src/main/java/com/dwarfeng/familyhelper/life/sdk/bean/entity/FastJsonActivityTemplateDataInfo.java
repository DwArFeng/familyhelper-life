package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * FastJson 活动模板数据信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityTemplateDataInfo implements Bean {

    private static final long serialVersionUID = -8315050855977661928L;

    public static FastJsonActivityTemplateDataInfo of(ActivityTemplateDataInfo activityTemplateDataInfo) {
        if (Objects.isNull(activityTemplateDataInfo)) {
            return null;
        } else {
            return new FastJsonActivityTemplateDataInfo(
                    FastJsonLongIdKey.of(activityTemplateDataInfo.getKey()),
                    FastJsonLongIdKey.of(activityTemplateDataInfo.getActivityTemplateKey()),
                    FastJsonLongIdKey.of(activityTemplateDataInfo.getActivityDataItemKey()),
                    activityTemplateDataInfo.getRemark(),
                    activityTemplateDataInfo.getInitialValue()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "activity_template_key", ordinal = 2)
    private FastJsonLongIdKey activityTemplateKey;

    @JSONField(name = "activity_data_item_key", ordinal = 3)
    private FastJsonLongIdKey activityDataItemKey;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    @JSONField(name = "initial_value", ordinal = 5)
    private BigDecimal initialValue;

    public FastJsonActivityTemplateDataInfo() {
    }

    public FastJsonActivityTemplateDataInfo(
            FastJsonLongIdKey key, FastJsonLongIdKey activityTemplateKey, FastJsonLongIdKey activityDataItemKey,
            String remark, BigDecimal initialValue
    ) {
        this.key = key;
        this.activityTemplateKey = activityTemplateKey;
        this.activityDataItemKey = activityDataItemKey;
        this.remark = remark;
        this.initialValue = initialValue;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(FastJsonLongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public FastJsonLongIdKey getActivityDataItemKey() {
        return activityDataItemKey;
    }

    public void setActivityDataItemKey(FastJsonLongIdKey activityDataItemKey) {
        this.activityDataItemKey = activityDataItemKey;
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
        return "FastJsonActivityTemplateDataInfo{" +
                "key=" + key +
                ", activityTemplateKey=" + activityTemplateKey +
                ", activityDataItemKey=" + activityDataItemKey +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
