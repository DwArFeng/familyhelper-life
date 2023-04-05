package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 活动数据集合创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataSetCreateInfo implements Dto {

    private static final long serialVersionUID = -8365800842416584090L;

    private String name;
    private String remark;

    public ActivityDataSetCreateInfo() {
    }

    public ActivityDataSetCreateInfo(String name, String remark) {
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
        return "ActivityDataSetCreateInfo{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
