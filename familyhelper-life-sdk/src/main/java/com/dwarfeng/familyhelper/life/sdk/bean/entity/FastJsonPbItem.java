package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 个人最佳项目。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class FastJsonPbItem implements Bean {

    private static final long serialVersionUID = 2321135619595737706L;

    public static FastJsonPbItem of(PbItem pbItem) {
        if (Objects.isNull(pbItem)) {
            return null;
        } else {
            return new FastJsonPbItem(
                    FastJsonLongIdKey.of(pbItem.getKey()),
                    FastJsonLongIdKey.of(pbItem.getNodeKey()),
                    FastJsonLongIdKey.of(pbItem.getSetKey()),
                    pbItem.getName(), pbItem.getUnit(), pbItem.getComparator(), pbItem.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "node_key", ordinal = 2)
    private FastJsonLongIdKey nodeKey;

    @JSONField(name = "set_key", ordinal = 3)
    private FastJsonLongIdKey setKey;

    @JSONField(name = "name", ordinal = 4)
    private String name;

    @JSONField(name = "unit", ordinal = 5)
    private String unit;

    @JSONField(name = "comparator", ordinal = 6)
    private Integer comparator;

    @JSONField(name = "remark", ordinal = 7)
    private String remark;

    public FastJsonPbItem() {
    }

    public FastJsonPbItem(
            FastJsonLongIdKey key, FastJsonLongIdKey nodeKey, FastJsonLongIdKey setKey, String name, String unit,
            Integer comparator, String remark
    ) {
        this.key = key;
        this.nodeKey = nodeKey;
        this.setKey = setKey;
        this.name = name;
        this.unit = unit;
        this.comparator = comparator;
        this.remark = remark;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonLongIdKey getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(FastJsonLongIdKey nodeKey) {
        this.nodeKey = nodeKey;
    }

    public FastJsonLongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(FastJsonLongIdKey setKey) {
        this.setKey = setKey;
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
        return "FastJsonPbItem{" +
                "key=" + key +
                ", nodeKey=" + nodeKey +
                ", setKey=" + setKey +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", comparator=" + comparator +
                ", remark='" + remark + '\'' +
                '}';
    }
}
