package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 个人最佳记录创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbRecordCreateInfo implements Dto {

    private static final long serialVersionUID = 4987813574559247039L;

    private LongIdKey itemKey;
    private Double value;
    private String remark;

    public PbRecordCreateInfo() {
    }

    public PbRecordCreateInfo(LongIdKey itemKey, Double value, String remark) {
        this.itemKey = itemKey;
        this.value = value;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PbRecordCreateInfo{" +
                "itemKey=" + itemKey +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
