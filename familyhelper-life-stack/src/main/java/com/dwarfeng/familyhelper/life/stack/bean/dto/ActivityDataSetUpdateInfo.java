package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 活动数据集合更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataSetUpdateInfo implements Dto {

    private static final long serialVersionUID = -8034070653103401595L;

    private LongIdKey activityDataSetKey;
    private String name;
    private String remark;

    public ActivityDataSetUpdateInfo() {
    }

    public ActivityDataSetUpdateInfo(LongIdKey activityDataSetKey, String name, String remark) {
        this.activityDataSetKey = activityDataSetKey;
        this.name = name;
        this.remark = remark;
    }

    public LongIdKey getActivityDataSetKey() {
        return activityDataSetKey;
    }

    public void setActivityDataSetKey(LongIdKey activityDataSetKey) {
        this.activityDataSetKey = activityDataSetKey;
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
        return "ActivityDataSetUpdateInfo{" +
                "activityDataSetKey=" + activityDataSetKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
