package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 个人最佳集合创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbSetCreateInfo implements Dto {

    private static final long serialVersionUID = -3250683492389330791L;

    private String name;
    private String remark;

    public PbSetCreateInfo() {
    }

    public PbSetCreateInfo(String name, String remark) {
        this.name = name;
        this.remark = remark;
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
        return "PbSetCreateInfo{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
