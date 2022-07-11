package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 个人最佳文件信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonPbFileInfo implements Bean {

    private static final long serialVersionUID = 5269383004850066937L;

    public static JSFixedFastJsonPbFileInfo of(PbFileInfo pbFileInfo) {
        if (Objects.isNull(pbFileInfo)) {
            return null;
        } else {
            return new JSFixedFastJsonPbFileInfo(
                    JSFixedFastJsonLongIdKey.of(pbFileInfo.getKey()),
                    JSFixedFastJsonLongIdKey.of(pbFileInfo.getRecordKey()),
                    pbFileInfo.getOriginName(), pbFileInfo.getLength(), pbFileInfo.getUploadedDate(),
                    pbFileInfo.getInspectedDate(), pbFileInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "record_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey recordKey;

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

    public JSFixedFastJsonPbFileInfo() {
    }

    public JSFixedFastJsonPbFileInfo(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey recordKey, String originName, long length, Date uploadedDate,
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

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public JSFixedFastJsonLongIdKey getRecordKey() {
        return recordKey;
    }

    public void setRecordKey(JSFixedFastJsonLongIdKey recordKey) {
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
        return "JSFixedFastJsonPbFileInfo{" +
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
