package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 个人最佳项目更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbItemUpdateInfo implements Dto {

    private static final long serialVersionUID = 7729560843721461109L;

    private LongIdKey key;
    private String name;
    private String unit;
    private Integer comparator;
    private String remark;

    public PbItemUpdateInfo() {
    }

    public PbItemUpdateInfo(
            LongIdKey key, String name, String unit, Integer comparator, String remark
    ) {
        this.key = key;
        this.name = name;
        this.unit = unit;
        this.comparator = comparator;
        this.remark = remark;
    }

    public LongIdKey getKey() {
        return key;
    }

    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getComparator() {
        return comparator;
    }

    public void setComparator(Integer comparator) {
        this.comparator = comparator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PbItemUpdateInfo{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", comparator=" + comparator +
                ", remark='" + remark + '\'' +
                '}';
    }
}
