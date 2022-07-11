package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 个人最佳记录。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonPbRecord implements Bean {

    private static final long serialVersionUID = 3658299693337666933L;

    public static JSFixedFastJsonPbRecord of(PbRecord pbRecord) {
        if (Objects.isNull(pbRecord)) {
            return null;
        } else {
            return new JSFixedFastJsonPbRecord(
                    JSFixedFastJsonLongIdKey.of(pbRecord.getKey()),
                    JSFixedFastJsonLongIdKey.of(pbRecord.getItemKey()),
                    pbRecord.getValue(), pbRecord.getRecordedDate(), pbRecord.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "item_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey itemKey;

    @JSONField(name = "value", ordinal = 3)
    private Double value;

    @JSONField(name = "recorded_date", ordinal = 4)
    private Date recordedDate;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    public JSFixedFastJsonPbRecord() {
    }

    public JSFixedFastJsonPbRecord(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey itemKey, Double value, Date recordedDate, String remark
    ) {
        this.key = key;
        this.itemKey = itemKey;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
        return "JSFixedFastJsonPbRecord{" +
                "key=" + key +
                ", itemKey=" + itemKey +
                ", value=" + value +
                ", recordedDate=" + recordedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
