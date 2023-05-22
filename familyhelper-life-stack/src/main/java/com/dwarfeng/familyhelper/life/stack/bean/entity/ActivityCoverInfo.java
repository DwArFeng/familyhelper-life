package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 活动封面信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityCoverInfo implements Entity<LongIdKey> {

    private static final long serialVersionUID = -1672125955224735090L;

    private LongIdKey key;
    private LongIdKey activityKey;
    private String originName;
    private long length;
    private Date createdDate;
    private Date modifiedDate;
    private String remark;
    private int index;

    public ActivityCoverInfo() {
    }

    public ActivityCoverInfo(
            LongIdKey key, LongIdKey activityKey, String originName, long length, Date createdDate, Date modifiedDate,
            String remark, int index
    ) {
        this.key = key;
        this.activityKey = activityKey;
        this.originName = originName;
        this.length = length;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.remark = remark;
        this.index = index;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public LongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(LongIdKey activityKey) {
        this.activityKey = activityKey;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ActivityCoverInfo{" +
                "key=" + key +
                ", activityKey=" + activityKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", remark='" + remark + '\'' +
                ", index=" + index +
                '}';
    }
}
