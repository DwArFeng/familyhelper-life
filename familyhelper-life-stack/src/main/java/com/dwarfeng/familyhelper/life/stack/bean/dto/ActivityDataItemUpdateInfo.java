package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 活动数据项目更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataItemUpdateInfo implements Dto {

    private static final long serialVersionUID = -2330823459340506054L;

    private LongIdKey key;
    private LongIdKey nodeKey;
    private String name;
    private String remark;

    public ActivityDataItemUpdateInfo() {
    }

    public ActivityDataItemUpdateInfo(LongIdKey key, LongIdKey nodeKey, String name, String remark) {
        this.key = key;
        this.nodeKey = nodeKey;
        this.name = name;
        this.remark = remark;
    }

    public LongIdKey getKey() {
        return key;
    }

    public void setKey(LongIdKey key) {
        this.key = key;
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
        return "ActivityDataItemUpdateInfo{" +
                "key=" + key +
                ", nodeKey=" + nodeKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
