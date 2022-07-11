package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 个人最佳节点。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class FastJsonPbNode implements Bean {

    private static final long serialVersionUID = 1629332038803554071L;

    public static FastJsonPbNode of(PbNode pbNode) {
        if (Objects.isNull(pbNode)) {
            return null;
        } else {
            return new FastJsonPbNode(
                    FastJsonLongIdKey.of(pbNode.getKey()),
                    FastJsonLongIdKey.of(pbNode.getParentKey()),
                    FastJsonLongIdKey.of(pbNode.getSetKey()),
                    pbNode.getName(), pbNode.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "parent_key", ordinal = 2)
    private FastJsonLongIdKey parentKey;

    @JSONField(name = "set_key", ordinal = 3)
    private FastJsonLongIdKey setKey;

    @JSONField(name = "name", ordinal = 4)
    private String name;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    public FastJsonPbNode() {
    }

    public FastJsonPbNode(
            FastJsonLongIdKey key, FastJsonLongIdKey parentKey, FastJsonLongIdKey setKey, String name,
            String remark
    ) {
        this.key = key;
        this.parentKey = parentKey;
        this.setKey = setKey;
        this.name = name;
        this.remark = remark;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonLongIdKey getParentKey() {
        return parentKey;
    }

    public void setParentKey(FastJsonLongIdKey parentKey) {
        this.parentKey = parentKey;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonPbNode{" +
                "key=" + key +
                ", parentKey=" + parentKey +
                ", setKey=" + setKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
