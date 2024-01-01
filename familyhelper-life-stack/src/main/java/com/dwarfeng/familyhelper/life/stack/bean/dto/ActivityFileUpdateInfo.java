package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 项目文件更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityFileUpdateInfo implements Dto {

    private static final long serialVersionUID = -7112016664202699668L;

    private LongIdKey activityFileKey;
    private String originName;
    private byte[] content;

    public ActivityFileUpdateInfo() {
    }

    public ActivityFileUpdateInfo(LongIdKey activityFileKey, String originName, byte[] content) {
        this.activityFileKey = activityFileKey;
        this.originName = originName;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ActivityFileUpdateInfo{" +
                "activityFileKey=" + activityFileKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
