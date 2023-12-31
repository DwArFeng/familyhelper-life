package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 活动更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityUpdateInfo implements Dto {

    private static final long serialVersionUID = -9206734785844035758L;

    private LongIdKey activityKey;
    private String activityType;
    private String name;
    private int score;
    private String remark;
    private Date startDate;
    private Date endDate;

    public ActivityUpdateInfo() {
    }

    public ActivityUpdateInfo(
            LongIdKey activityKey, String activityType, String name, int score, String remark,
            Date startDate, Date endDate
    ) {
        this.activityKey = activityKey;
        this.activityType = activityType;
        this.name = name;
        this.score = score;
        this.remark = remark;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(LongIdKey activityKey) {
        this.activityKey = activityKey;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ActivityUpdateInfo{" +
                "activityKey=" + activityKey +
                ", activityType='" + activityType + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", remark='" + remark + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
