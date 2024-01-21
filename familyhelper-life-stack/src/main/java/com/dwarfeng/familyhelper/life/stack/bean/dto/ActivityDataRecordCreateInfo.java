package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.math.BigDecimal;

/**
 * 活动数据记录创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataRecordCreateInfo implements Dto {

    private static final long serialVersionUID = 6252402814500464659L;

    private LongIdKey itemKey;
    private LongIdKey activityKey;
    private BigDecimal value;
    private String remark;

    public ActivityDataRecordCreateInfo() {
    }

    public ActivityDataRecordCreateInfo(
            LongIdKey itemKey, LongIdKey activityKey, BigDecimal value, String remark
    ) {
        this.itemKey = itemKey;
        this.activityKey = activityKey;
        this.value = value;
        this.remark = remark;
    }

    public LongIdKey getItemKey() {
        return itemKey;
    }

    public void setItemKey(LongIdKey itemKey) {
        this.itemKey = itemKey;
    }

    public LongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(LongIdKey activityKey) {
        this.activityKey = activityKey;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityDataRecordCreateInfo{" +
                "itemKey=" + itemKey +
                ", activityKey=" + activityKey +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
