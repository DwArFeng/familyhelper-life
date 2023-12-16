package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.math.BigDecimal;

/**
 * 活动模板数据信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateDataInfo implements Entity<LongIdKey> {

    private static final long serialVersionUID = -1330460225183945288L;

    private LongIdKey key;
    private LongIdKey activityTemplateKey;
    private LongIdKey activityDataItemKey;
    private String remark;
    private BigDecimal initialValue;

    public ActivityTemplateDataInfo() {
    }

    public ActivityTemplateDataInfo(
            LongIdKey key, LongIdKey activityTemplateKey, LongIdKey activityDataItemKey, String remark,
            BigDecimal initialValue
    ) {
        this.key = key;
        this.activityTemplateKey = activityTemplateKey;
        this.activityDataItemKey = activityDataItemKey;
        this.remark = remark;
        this.initialValue = initialValue;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public LongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(LongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public LongIdKey getActivityDataItemKey() {
        return activityDataItemKey;
    }

    public void setActivityDataItemKey(LongIdKey activityDataItemKey) {
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
        return "ActivityTemplateDataInfo{" +
                "key=" + key +
                ", activityTemplateKey=" + activityTemplateKey +
                ", activityDataItemKey=" + activityDataItemKey +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
