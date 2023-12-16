package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * JSFixed FastJson 活动模板数据信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityTemplateDataInfo implements Bean {

    private static final long serialVersionUID = -2788268806204072207L;

    public static JSFixedFastJsonActivityTemplateDataInfo of(ActivityTemplateDataInfo activityTemplateDataInfo) {
        if (Objects.isNull(activityTemplateDataInfo)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityTemplateDataInfo(
                    JSFixedFastJsonLongIdKey.of(activityTemplateDataInfo.getKey()),
                    JSFixedFastJsonLongIdKey.of(activityTemplateDataInfo.getActivityTemplateKey()),
                    JSFixedFastJsonLongIdKey.of(activityTemplateDataInfo.getActivityDataItemKey()),
                    activityTemplateDataInfo.getRemark(),
                    activityTemplateDataInfo.getInitialValue()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "activity_template_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey activityTemplateKey;

    @JSONField(name = "activity_data_item_key", ordinal = 3)
    private JSFixedFastJsonLongIdKey activityDataItemKey;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    @JSONField(name = "initial_value", ordinal = 5)
    private BigDecimal initialValue;

    public JSFixedFastJsonActivityTemplateDataInfo() {
    }

    public JSFixedFastJsonActivityTemplateDataInfo(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey activityTemplateKey,
            JSFixedFastJsonLongIdKey activityDataItemKey, String remark, BigDecimal initialValue
    ) {
        this.key = key;
        this.activityTemplateKey = activityTemplateKey;
        this.activityDataItemKey = activityDataItemKey;
        this.remark = remark;
        this.initialValue = initialValue;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public JSFixedFastJsonLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(JSFixedFastJsonLongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public JSFixedFastJsonLongIdKey getActivityDataItemKey() {
        return activityDataItemKey;
    }

    public void setActivityDataItemKey(JSFixedFastJsonLongIdKey activityDataItemKey) {
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
        return "JSFixedFastJsonActivityTemplateDataInfo{" +
                "key=" + key +
                ", activityTemplateKey=" + activityTemplateKey +
                ", activityDataItemKey=" + activityDataItemKey +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
