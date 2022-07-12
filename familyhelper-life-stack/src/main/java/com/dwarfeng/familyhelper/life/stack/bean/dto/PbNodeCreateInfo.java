package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 个人最佳节点创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbNodeCreateInfo implements Dto {

    private static final long serialVersionUID = 1617039526736463934L;

    private LongIdKey setKey;
    private LongIdKey parentKey;
    private String name;
    private String remark;

    public PbNodeCreateInfo() {
    }

    public PbNodeCreateInfo(
            LongIdKey setKey, LongIdKey parentKey, String name, String remark
    ) {
        this.setKey = setKey;
        this.parentKey = parentKey;
        this.name = name;
        this.remark = remark;
    }

    public LongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(LongIdKey setKey) {
        this.setKey = setKey;
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
        return "PbNodeCreateInfo{" +
                "setKey=" + setKey +
                ", parentKey=" + parentKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
