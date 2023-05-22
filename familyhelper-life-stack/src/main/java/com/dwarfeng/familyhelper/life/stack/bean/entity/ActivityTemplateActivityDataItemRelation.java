package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

import java.math.BigDecimal;

/**
 * 活动模板活动数据条目关联。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateActivityDataItemRelation implements Entity<LongLongRelationKey> {

    private static final long serialVersionUID = 129328556362226976L;

    private LongLongRelationKey key;
    private String remark;
    private BigDecimal initialValue;

    public ActivityTemplateActivityDataItemRelation() {
    }

    public ActivityTemplateActivityDataItemRelation(LongLongRelationKey key, String remark, BigDecimal initialValue) {
        this.key = key;
        this.remark = remark;
        this.initialValue = initialValue;
    }

    @Override
    public LongLongRelationKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongLongRelationKey key) {
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
        return "ActivityTemplateActivityDataItemRelation{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
