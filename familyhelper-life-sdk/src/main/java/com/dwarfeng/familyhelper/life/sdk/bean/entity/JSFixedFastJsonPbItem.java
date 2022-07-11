package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 个人最佳项目。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonPbItem implements Bean {

    private static final long serialVersionUID = -621587976940770653L;

    public static JSFixedFastJsonPbItem of(PbItem pbItem) {
        if (Objects.isNull(pbItem)) {
            return null;
        } else {
            return new JSFixedFastJsonPbItem(
                    JSFixedFastJsonLongIdKey.of(pbItem.getKey()),
                    JSFixedFastJsonLongIdKey.of(pbItem.getNodeKey()),
                    pbItem.getName(), pbItem.getUnit(), pbItem.getComparator(), pbItem.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "node_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey nodeKey;

    @JSONField(name = "name", ordinal = 3)
    private String name;

    @JSONField(name = "unit", ordinal = 4)
    private String unit;

    @JSONField(name = "comparator", ordinal = 5)
    private Integer comparator;

    @JSONField(name = "remark", ordinal = 6)
    private String remark;

    public JSFixedFastJsonPbItem() {
    }

    public JSFixedFastJsonPbItem(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey nodeKey, String name, String unit,
            Integer comparator, String remark
    ) {
        this.key = key;
        this.nodeKey = nodeKey;
        this.name = name;
        this.unit = unit;
        this.comparator = comparator;
        this.remark = remark;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public JSFixedFastJsonLongIdKey getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(JSFixedFastJsonLongIdKey nodeKey) {
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
        return "JSFixedFastJsonPbItem{" +
                "key=" + key +
                ", nodeKey=" + nodeKey +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", comparator=" + comparator +
                ", remark='" + remark + '\'' +
                '}';
    }
}
