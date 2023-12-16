package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.math.BigDecimal;

/**
 * 活动模板数据信息更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateDataInfoUpdateInfo implements Dto {

    private static final long serialVersionUID = -384738349122024876L;

    private LongIdKey key;
    private String remark;
    private BigDecimal initialValue;

    public ActivityTemplateDataInfoUpdateInfo() {
    }

    public ActivityTemplateDataInfoUpdateInfo(LongIdKey key, String remark, BigDecimal initialValue) {
        this.key = key;
        this.remark = remark;
        this.initialValue = initialValue;
    }

    public LongIdKey getKey() {
        return key;
    }

    public void setKey(LongIdKey key) {
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
        return "ActivityTemplateDataInfoUpdateInfo{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
