package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 活动数据记录。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityDataRecord implements Bean {

    private static final long serialVersionUID = -1935324859042229110L;

    public static JSFixedFastJsonActivityDataRecord of(ActivityDataRecord activityDataRecord) {
        if (Objects.isNull(activityDataRecord)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityDataRecord(
                    JSFixedFastJsonLongIdKey.of(activityDataRecord.getKey()),
                    JSFixedFastJsonLongIdKey.of(activityDataRecord.getActivityKey()),
                    JSFixedFastJsonLongIdKey.of(activityDataRecord.getActivityKey()),
                    activityDataRecord.getValue(),
                    activityDataRecord.getRecordedDate(),
                    activityDataRecord.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "item_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey itemKey;

    @JSONField(name = "activity_key", ordinal = 3)
    private JSFixedFastJsonLongIdKey activityKey;

    @JSONField(name = "value", ordinal = 4)
    private BigDecimal value;

    @JSONField(name = "recorded_date", ordinal = 5)
    private Date recordedDate;

    @JSONField(name = "remark", ordinal = 6)
    private String remark;

    public JSFixedFastJsonActivityDataRecord() {
    }

    public JSFixedFastJsonActivityDataRecord(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey itemKey, JSFixedFastJsonLongIdKey activityKey,
            BigDecimal value, Date recordedDate, String remark
    ) {
        this.key = key;
        this.itemKey = itemKey;
        this.activityKey = activityKey;
        this.value = value;
        this.recordedDate = recordedDate;
        this.remark = remark;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public JSFixedFastJsonLongIdKey getItemKey() {
        return itemKey;
    }

    public void setItemKey(JSFixedFastJsonLongIdKey itemKey) {
        this.itemKey = itemKey;
    }

    public JSFixedFastJsonLongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(JSFixedFastJsonLongIdKey activityKey) {
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
        return "JSFixedFastJsonActivityDataRecord{" +
                "key=" + key +
                ", itemKey=" + itemKey +
                ", activityKey=" + activityKey +
                ", value=" + value +
                ", recordedDate=" + recordedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
