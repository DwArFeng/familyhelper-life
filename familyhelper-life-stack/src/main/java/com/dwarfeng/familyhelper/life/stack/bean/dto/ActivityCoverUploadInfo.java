package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 活动封面上传信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityCoverUploadInfo implements Dto {

    private static final long serialVersionUID = 8996865615895403236L;

    private LongIdKey activityKey;
    private String originName;
    private byte[] content;

    public ActivityCoverUploadInfo() {
    }

    public ActivityCoverUploadInfo(LongIdKey activityKey, String originName, byte[] content) {
        this.activityKey = activityKey;
        this.originName = originName;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ActivityCoverUploadInfo{" +
                "activityKey=" + activityKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
