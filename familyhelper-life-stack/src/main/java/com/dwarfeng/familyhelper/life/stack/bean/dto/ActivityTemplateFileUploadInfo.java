package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 活动模板文件上传信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateFileUploadInfo implements Dto {

    private static final long serialVersionUID = -328426217991251734L;

    private LongIdKey activityTemplateKey;
    private String originName;
    private byte[] content;

    public ActivityTemplateFileUploadInfo() {
    }

    public ActivityTemplateFileUploadInfo(LongIdKey activityTemplateKey, String originName, byte[] content) {
        this.activityTemplateKey = activityTemplateKey;
        this.originName = originName;
        this.content = content;
    }

    public LongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(LongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
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
        return "ActivityTemplateFileUploadInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
