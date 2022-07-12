package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 个人最佳节点更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbNodeUpdateInfo implements Dto {

    private static final long serialVersionUID = 2839708966123002627L;

    private LongIdKey nodeKey;
    private LongIdKey parentKey;
    private String name;
    private String remark;

    public PbNodeUpdateInfo() {
    }

    public PbNodeUpdateInfo(LongIdKey nodeKey, LongIdKey parentKey, String name, String remark) {
        this.nodeKey = nodeKey;
        this.parentKey = parentKey;
        this.name = name;
        this.remark = remark;
    }

    public LongIdKey getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(LongIdKey nodeKey) {
        this.nodeKey = nodeKey;
    }

    public LongIdKey getParentKey() {
        return parentKey;
    }

    public void setParentKey(LongIdKey parentKey) {
        this.parentKey = parentKey;
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
        return "PbNodeUpdateInfo{" +
                "nodeKey=" + nodeKey +
                ", parentKey=" + parentKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
