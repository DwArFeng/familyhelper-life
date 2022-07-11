package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 个人最佳记录。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbRecord implements Entity<LongIdKey> {

    private static final long serialVersionUID = 1588533401165453467L;

    private LongIdKey key;
    private LongIdKey itemKey;
    private Double value;
    private Date recordedDate;
    private String remark;

    public PbRecord() {
    }

    public PbRecord(LongIdKey key, LongIdKey itemKey, Double value, Date recordedDate, String remark) {
        this.key = key;
        this.itemKey = itemKey;
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
        return "PbRecord{" +
                "key=" + key +
                ", itemKey=" + itemKey +
                ", value=" + value +
                ", recordedDate=" + recordedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
