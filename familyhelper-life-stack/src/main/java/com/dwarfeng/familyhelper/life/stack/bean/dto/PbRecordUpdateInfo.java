package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 个人最佳记录更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbRecordUpdateInfo implements Dto {

    private static final long serialVersionUID = -2286323699916783468L;

    private LongIdKey key;
    private Double value;
    private String remark;

    public PbRecordUpdateInfo() {
    }

    public PbRecordUpdateInfo(LongIdKey key, Double value, String remark) {
        this.key = key;
        this.value = value;
        this.remark = remark;
    }

    public LongIdKey getKey() {
        return key;
    }

    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
        return "PbRecordUpdateInfo{" +
                "key=" + key +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
