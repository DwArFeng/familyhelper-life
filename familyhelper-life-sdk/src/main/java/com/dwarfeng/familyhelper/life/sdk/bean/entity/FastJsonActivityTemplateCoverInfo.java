package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateCoverInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 活动模板封面信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityTemplateCoverInfo implements Bean {

    private static final long serialVersionUID = 4420928586505788271L;

    public static FastJsonActivityTemplateCoverInfo of(ActivityTemplateCoverInfo activityTemplateCoverInfo) {
        if (Objects.isNull(activityTemplateCoverInfo)) {
            return null;
        } else {
            return new FastJsonActivityTemplateCoverInfo(
                    FastJsonLongIdKey.of(activityTemplateCoverInfo.getKey()),
                    FastJsonLongIdKey.of(activityTemplateCoverInfo.getActivityTemplateKey()),
                    activityTemplateCoverInfo.getOriginName(), activityTemplateCoverInfo.getLength(),
                    activityTemplateCoverInfo.getCreatedDate(), activityTemplateCoverInfo.getModifiedDate(),
                    activityTemplateCoverInfo.getRemark(), activityTemplateCoverInfo.getIndex()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "activity_template_key", ordinal = 2)
    private FastJsonLongIdKey activityTemplateKey;

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

    public FastJsonActivityTemplateCoverInfo() {
    }

    public FastJsonActivityTemplateCoverInfo(
            FastJsonLongIdKey key, FastJsonLongIdKey activityTemplateKey, String originName, long length,
            Date createdDate, Date modifiedDate, String remark, int index
    ) {
        this.key = key;
        this.activityTemplateKey = activityTemplateKey;
        this.originName = originName;
        this.length = length;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.remark = remark;
        this.index = index;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(FastJsonLongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
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
        return "FastJsonActivityTemplateCoverInfo{" +
                "key=" + key +
                ", activityTemplateKey=" + activityTemplateKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", remark='" + remark + '\'' +
                ", index=" + index +
                '}';
    }
}
