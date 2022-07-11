package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 个人最佳文件信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class FastJsonPbFileInfo implements Bean {

    private static final long serialVersionUID = 3473081127693558892L;

    public static FastJsonPbFileInfo of(PbFileInfo pbFileInfo) {
        if (Objects.isNull(pbFileInfo)) {
            return null;
        } else {
            return new FastJsonPbFileInfo(
                    FastJsonLongIdKey.of(pbFileInfo.getKey()),
                    FastJsonLongIdKey.of(pbFileInfo.getRecordKey()),
                    pbFileInfo.getOriginName(), pbFileInfo.getLength(), pbFileInfo.getUploadedDate(),
                    pbFileInfo.getInspectedDate(), pbFileInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "record_key", ordinal = 2)
    private FastJsonLongIdKey recordKey;

    @JSONField(name = "origin_name", ordinal = 3)
    private String originName;

    @JSONField(name = "length", ordinal = 4)
    private long length;

    @JSONField(name = "uploaded_date", ordinal = 5)
    private Date uploadedDate;

    @JSONField(name = "inspected_date", ordinal = 6)
    private Date inspectedDate;

    @JSONField(name = "remark", ordinal = 7)
    private String remark;

    public FastJsonPbFileInfo() {
    }

    public FastJsonPbFileInfo(
            FastJsonLongIdKey key, FastJsonLongIdKey recordKey, String originName, long length, Date uploadedDate,
            Date inspectedDate, String remark
    ) {
        this.key = key;
        this.recordKey = recordKey;
        this.originName = originName;
        this.length = length;
        this.uploadedDate = uploadedDate;
        this.inspectedDate = inspectedDate;
        this.remark = remark;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonLongIdKey getRecordKey() {
        return recordKey;
    }

    public void setRecordKey(FastJsonLongIdKey recordKey) {
        this.recordKey = recordKey;
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

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
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
        return "FastJsonPbFileInfo{" +
                "key=" + key +
                ", recordKey=" + recordKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", uploadedDate=" + uploadedDate +
                ", inspectedDate=" + inspectedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
