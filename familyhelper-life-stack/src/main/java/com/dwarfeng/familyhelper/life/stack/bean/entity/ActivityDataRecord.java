package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动数据记录。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataRecord implements Entity<LongIdKey> {

    private static final long serialVersionUID = 5319310814144923468L;

    private LongIdKey key;
    private LongIdKey itemKey;
    private LongIdKey activityKey;
    private BigDecimal value;
    private Date recordedDate;
    private String remark;

    public ActivityDataRecord() {
    }

    public ActivityDataRecord(
            LongIdKey key, LongIdKey itemKey, LongIdKey activityKey, BigDecimal value, Date recordedDate,
            String remark
    ) {
        this.key = key;
        this.itemKey = itemKey;
        this.activityKey = activityKey;
        this.value = value;
        this.recordedDate = recordedDate;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
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

    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityDataRecord{" +
                "key=" + key +
                ", itemKey=" + itemKey +
                ", activityKey=" + activityKey +
                ", value=" + value +
                ", recordedDate=" + recordedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
