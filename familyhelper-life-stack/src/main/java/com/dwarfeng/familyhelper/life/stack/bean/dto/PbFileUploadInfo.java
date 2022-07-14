package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 个人最佳文件上传信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbFileUploadInfo implements Dto {

    private static final long serialVersionUID = 7715277902086673273L;

    private LongIdKey recordKey;
    private String originName;
    private byte[] content;

    public PbFileUploadInfo() {
    }

    public PbFileUploadInfo(LongIdKey recordKey, String originName, byte[] content) {
        this.recordKey = recordKey;
        this.originName = originName;
        this.content = content;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PbFileUploadInfo{" +
                "recordKey=" + recordKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
