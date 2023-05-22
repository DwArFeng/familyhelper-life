package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityCoverInfo;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 活动封面信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityCoverInfo implements Bean {

    private static final long serialVersionUID = 8439093975975951325L;

    public static JSFixedFastJsonActivityCoverInfo of(ActivityCoverInfo activityCoverInfo) {
        if (Objects.isNull(activityCoverInfo)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityCoverInfo(
                    JSFixedFastJsonLongIdKey.of(activityCoverInfo.getKey()),
                    JSFixedFastJsonLongIdKey.of(activityCoverInfo.getActivityKey()),
                    activityCoverInfo.getOriginName(), activityCoverInfo.getLength(),
                    activityCoverInfo.getCreatedDate(), activityCoverInfo.getModifiedDate(),
                    activityCoverInfo.getRemark(), activityCoverInfo.getIndex()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "activity_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey activityKey;

    @JSONField(name = "origin_name", ordinal = 3)
    private String originName;

    @JSONField(name = "length", ordinal = 4)
    private long length;

    @JSONField(name = "created_date", ordinal = 5)
    private Date createdDate;

    @JSONField(name = "modified_date", ordinal = 6)
    private Date modifiedDate;

    @JSONField(name = "remark", ordinal = 7)
    private String remark;

    @JSONField(name = "index", ordinal = 8)
    private int index;

    public JSFixedFastJsonActivityCoverInfo() {
    }

    public JSFixedFastJsonActivityCoverInfo(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey activityKey, String originName, long length, Date createdDate,
            Date modifiedDate, String remark, int index
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

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public JSFixedFastJsonLongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(JSFixedFastJsonLongIdKey activityKey) {
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
        return "JSFixedFastJsonActivityCoverInfo{" +
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
