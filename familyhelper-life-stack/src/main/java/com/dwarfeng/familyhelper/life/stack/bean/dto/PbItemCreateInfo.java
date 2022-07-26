package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 个人最佳项目创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbItemCreateInfo implements Dto {

    private static final long serialVersionUID = 7199800898079276045L;

    private LongIdKey setKey;
    private LongIdKey nodeKey;
    private String name;
    private String unit;
    private Integer comparator;
    private String remark;

    public PbItemCreateInfo() {
    }

    public PbItemCreateInfo(
            LongIdKey setKey, LongIdKey nodeKey, String name, String unit, Integer comparator, String remark
    ) {
        this.setKey = setKey;
        this.nodeKey = nodeKey;
        this.name = name;
        this.unit = unit;
        this.comparator = comparator;
        this.remark = remark;
    }

    public LongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(LongIdKey setKey) {
        this.setKey = setKey;
    }

    public LongIdKey getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(LongIdKey nodeKey) {
        this.nodeKey = nodeKey;
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
        return "PbItemCreateInfo{" +
                "setKey=" + setKey +
                ", nodeKey=" + nodeKey +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", comparator=" + comparator +
                ", remark='" + remark + '\'' +
                '}';
    }
}
