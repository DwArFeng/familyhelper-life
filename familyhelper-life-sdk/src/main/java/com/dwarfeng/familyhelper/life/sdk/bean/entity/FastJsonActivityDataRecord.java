package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * FastJson 活动数据记录。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityDataRecord implements Bean {

    private static final long serialVersionUID = 2837354669571799151L;

    public static FastJsonActivityDataRecord of(ActivityDataRecord activityDataRecord) {
        if (Objects.isNull(activityDataRecord)) {
            return null;
        } else {
            return new FastJsonActivityDataRecord(
                    FastJsonLongIdKey.of(activityDataRecord.getKey()),
                    FastJsonLongIdKey.of(activityDataRecord.getActivityKey()),
                    FastJsonLongIdKey.of(activityDataRecord.getActivityKey()),
                    activityDataRecord.getValue(),
                    activityDataRecord.getRecordedDate(),
                    activityDataRecord.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "item_key", ordinal = 2)
    private FastJsonLongIdKey itemKey;

    @JSONField(name = "activity_key", ordinal = 3)
    private FastJsonLongIdKey activityKey;

    @JSONField(name = "value", ordinal = 4)
    private BigDecimal value;

    @JSONField(name = "recorded_date", ordinal = 5)
    private Date recordedDate;

    @JSONField(name = "remark", ordinal = 6)
    private String remark;

    public FastJsonActivityDataRecord() {
    }

    public FastJsonActivityDataRecord(
            FastJsonLongIdKey key, FastJsonLongIdKey itemKey, FastJsonLongIdKey activityKey, BigDecimal value,
            Date recordedDate, String remark
    ) {
        this.key = key;
        this.itemKey = itemKey;
        this.activityKey = activityKey;
        this.value = value;
        this.recordedDate = recordedDate;
        this.remark = remark;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonLongIdKey getItemKey() {
        return itemKey;
    }

    public void setItemKey(FastJsonLongIdKey itemKey) {
        this.itemKey = itemKey;
    }

    public FastJsonLongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(FastJsonLongIdKey activityKey) {
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
        return "FastJsonActivityDataRecord{" +
                "key=" + key +
                ", itemKey=" + itemKey +
                ", activityKey=" + activityKey +
                ", value=" + value +
                ", recordedDate=" + recordedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
