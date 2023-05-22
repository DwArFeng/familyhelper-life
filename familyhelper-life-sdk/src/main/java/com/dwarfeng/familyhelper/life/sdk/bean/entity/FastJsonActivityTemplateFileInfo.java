package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateFileInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 活动模板文件信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityTemplateFileInfo implements Bean {

    private static final long serialVersionUID = -9003802618518912876L;

    public static FastJsonActivityTemplateFileInfo of(ActivityTemplateFileInfo activityTemplateFileInfo) {
        if (Objects.isNull(activityTemplateFileInfo)) {
            return null;
        } else {
            return new FastJsonActivityTemplateFileInfo(
                    FastJsonLongIdKey.of(activityTemplateFileInfo.getKey()),
                    FastJsonLongIdKey.of(activityTemplateFileInfo.getActivityTemplateKey()),
                    activityTemplateFileInfo.getOriginName(), activityTemplateFileInfo.getLength(),
                    activityTemplateFileInfo.getCreatedDate(), activityTemplateFileInfo.getModifiedDate(),
                    activityTemplateFileInfo.getInspectedDate(), activityTemplateFileInfo.getRemark()
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

    @JSONField(name = "inspected_date", ordinal = 7)
    private Date inspectedDate;

    @JSONField(name = "remark", ordinal = 8)
    private String remark;

    public FastJsonActivityTemplateFileInfo() {
    }

    public FastJsonActivityTemplateFileInfo(
            FastJsonLongIdKey key, FastJsonLongIdKey activityTemplateKey, String originName, long length,
            Date createdDate, Date modifiedDate, Date inspectedDate, String remark
    ) {
        this.key = key;
        this.activityTemplateKey = activityTemplateKey;
        this.originName = originName;
        this.length = length;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.inspectedDate = inspectedDate;
        this.remark = remark;
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

    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonActivityTemplateFileInfo{" +
                "key=" + key +
                ", activityTemplateKey=" + activityTemplateKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", inspectedDate=" + inspectedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
