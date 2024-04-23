package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.io.InputStream;

/**
 * 活动文件流上传信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ActivityFileStreamUploadInfo implements Dto {

    private static final long serialVersionUID = 8254395455161281111L;

    private LongIdKey activityKey;
    private String originName;
    private long length;
    private InputStream content;

    public ActivityFileStreamUploadInfo() {
    }

    public ActivityFileStreamUploadInfo(LongIdKey activityKey, String originName, long length, InputStream content) {
        this.activityKey = activityKey;
        this.originName = originName;
        this.length = length;
        this.content = content;
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

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ActivityFileStreamUploadInfo{" +
                "activityKey=" + activityKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", content=" + content +
                '}';
    }
}
