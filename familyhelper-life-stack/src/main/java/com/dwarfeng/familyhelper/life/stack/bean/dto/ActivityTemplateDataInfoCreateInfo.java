package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.math.BigDecimal;

/**
 * 活动模板数据信息创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateDataInfoCreateInfo implements Dto {

    private static final long serialVersionUID = 1750477193169625981L;

    private LongIdKey activityTemplateKey;
    private LongIdKey activityDataItemKey;
    private String remark;
    private BigDecimal initialValue;

    public ActivityTemplateDataInfoCreateInfo() {
    }

    public ActivityTemplateDataInfoCreateInfo(
            LongIdKey activityTemplateKey, LongIdKey activityDataItemKey, String remark, BigDecimal initialValue
    ) {
        this.activityTemplateKey = activityTemplateKey;
        this.activityDataItemKey = activityDataItemKey;
        this.remark = remark;
        this.initialValue = initialValue;
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
        return "ActivityTemplateDataInfoCreateInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", activityDataItemKey=" + activityDataItemKey +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
