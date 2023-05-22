package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 活动。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivity implements Bean {

    private static final long serialVersionUID = 7681476755756131768L;

    public static FastJsonActivity of(Activity activity) {
        if (Objects.isNull(activity)) {
            return null;
        } else {
            return new FastJsonActivity(
                    FastJsonLongIdKey.of(activity.getKey()),
                    activity.getActivityType(), activity.getName(), activity.getScore(), activity.getRemark(),
                    activity.isLocked(), activity.getStartDate(), activity.getEndDate(), activity.getCreatedDate(),
                    activity.getModifiedDate(), activity.getInspectedDate(), activity.getLockedDate()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "activity_type", ordinal = 2)
    private String activityType;

    @JSONField(name = "name", ordinal = 3)
    private String name;

    @JSONField(name = "score", ordinal = 4)
    private int score;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    @JSONField(name = "locked", ordinal = 6)
    private boolean locked;

    @JSONField(name = "start_date", ordinal = 7)
    private Date startDate;

    @JSONField(name = "end_date", ordinal = 8)
    private Date endDate;

    @JSONField(name = "created_date", ordinal = 9)
    private Date createdDate;

    @JSONField(name = "modified_date", ordinal = 10)
    private Date modifiedDate;

    @JSONField(name = "inspected_date", ordinal = 11)
    private Date inspectedDate;

    @JSONField(name = "locked_date", ordinal = 12)
    private Date lockedDate;

    public FastJsonActivity() {
    }

    public FastJsonActivity(
            FastJsonLongIdKey key, String activityType, String name, int score, String remark, boolean locked,
            Date startDate, Date endDate, Date createdDate, Date modifiedDate, Date inspectedDate, Date lockedDate
    ) {
        this.key = key;
        this.activityType = activityType;
        this.name = name;
        this.score = score;
        this.remark = remark;
        this.locked = locked;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.inspectedDate = inspectedDate;
        this.lockedDate = lockedDate;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
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

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    @Override
    public String toString() {
        return "FastJsonActivity{" +
                "key=" + key +
                ", activityType='" + activityType + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", remark='" + remark + '\'' +
                ", locked=" + locked +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", inspectedDate=" + inspectedDate +
                ", lockedDate=" + lockedDate +
                '}';
    }
}
