package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 活动数据节点。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataNode implements Entity<LongIdKey> {

    private static final long serialVersionUID = -4176355534713016363L;

    private LongIdKey key;
    private LongIdKey parentKey;
    private LongIdKey setKey;
    private String name;
    private String remark;

    public ActivityDataNode() {
    }

    public ActivityDataNode(LongIdKey key, LongIdKey parentKey, LongIdKey setKey, String name, String remark) {
        this.key = key;
        this.parentKey = parentKey;
        this.setKey = setKey;
        this.name = name;
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

    public LongIdKey getParentKey() {
        return parentKey;
    }

    public void setParentKey(LongIdKey parentKey) {
        this.parentKey = parentKey;
    }

    public LongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(LongIdKey setKey) {
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
        return "ActivityDataNode{" +
                "key=" + key +
                ", parentKey=" + parentKey +
                ", setKey=" + setKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
