package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 个人最佳文件信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbFileInfo implements Entity<LongIdKey> {

    private static final long serialVersionUID = 4230713838549857703L;

    private LongIdKey key;
    private LongIdKey recordKey;
    private String originName;
    private long length;
    private Date uploadedDate;
    private Date inspectedDate;
    private String remark;

    public PbFileInfo() {
    }

    public PbFileInfo(
            LongIdKey key, LongIdKey recordKey, String originName, long length, Date uploadedDate, Date inspectedDate,
            String remark
    ) {
        this.key = key;
        this.recordKey = recordKey;
        this.originName = originName;
        this.length = length;
        this.uploadedDate = uploadedDate;
        this.inspectedDate = inspectedDate;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public LongIdKey getRecordKey() {
        return recordKey;
    }

    public void setRecordKey(LongIdKey recordKey) {
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
        return "PbFileInfo{" +
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
