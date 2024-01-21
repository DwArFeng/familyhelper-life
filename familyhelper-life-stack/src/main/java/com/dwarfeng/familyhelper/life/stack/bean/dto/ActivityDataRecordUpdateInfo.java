package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.math.BigDecimal;

/**
 * 活动数据记录更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataRecordUpdateInfo implements Dto {

    private static final long serialVersionUID = 6655644914254187195L;
    
    private LongIdKey key;
    private BigDecimal value;
    private String remark;

    public ActivityDataRecordUpdateInfo() {
    }

    public ActivityDataRecordUpdateInfo(LongIdKey key, BigDecimal value, String remark) {
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
        return "ActivityDataRecordUpdateInfo{" +
                "key=" + key +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
