package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 活动数据项目创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataItemCreateInfo implements Dto {

    private static final long serialVersionUID = -6672934941344151314L;

    private LongIdKey setKey;
    private LongIdKey nodeKey;
    private String name;
    private String remark;

    public ActivityDataItemCreateInfo() {
    }

    public ActivityDataItemCreateInfo(LongIdKey setKey, LongIdKey nodeKey, String name, String remark) {
        this.setKey = setKey;
        this.nodeKey = nodeKey;
        this.name = name;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityDataItemCreateInfo{" +
                "setKey=" + setKey +
                ", nodeKey=" + nodeKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
