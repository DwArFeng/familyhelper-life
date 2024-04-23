package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.io.InputStream;

/**
 * 活动文件流更新信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ActivityFileStreamUpdateInfo implements Dto {

    private static final long serialVersionUID = -1697143584198722232L;

    private LongIdKey activityFileKey;
    private String originName;
    private long length;
    private InputStream content;

    public ActivityFileStreamUpdateInfo() {
    }

    public ActivityFileStreamUpdateInfo(
            LongIdKey activityFileKey, String originName, long length, InputStream content
    ) {
        this.activityFileKey = activityFileKey;
        this.originName = originName;
        this.length = length;
        this.content = content;
    }

    public LongIdKey getActivityFileKey() {
        return activityFileKey;
    }

    public void setActivityFileKey(LongIdKey activityFileKey) {
        this.activityFileKey = activityFileKey;
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
        return "ActivityFileStreamUpdateInfo{" +
                "activityFileKey=" + activityFileKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", content=" + content +
                '}';
    }
}
