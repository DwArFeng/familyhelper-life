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

    private static final long serialVersionUID = -960612399719662492L;

    public static FastJsonActivityDataRecord of(ActivityDataRecord activityDataRecord) {
        if (Objects.isNull(activityDataRecord)) {
            return null;
        } else {
            return new FastJsonActivityDataRecord(
                    FastJsonLongIdKey.of(activityDataRecord.getKey()),
                    FastJsonLongIdKey.of(activityDataRecord.getItemKey()),
                    activityDataRecord.getValue(), activityDataRecord.getRecordedDate(), activityDataRecord.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "item_key", ordinal = 2)
    private FastJsonLongIdKey itemKey;

    @JSONField(name = "value", ordinal = 3)
    private BigDecimal value;

    @JSONField(name = "recorded_date", ordinal = 4)
    private Date recordedDate;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    public FastJsonActivityDataRecord() {
    }

    public FastJsonActivityDataRecord(
            FastJsonLongIdKey key, FastJsonLongIdKey itemKey, BigDecimal value, Date recordedDate, String remark
    ) {
        this.key = key;
        this.itemKey = itemKey;
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
                ", value=" + value +
                ", recordedDate=" + recordedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
