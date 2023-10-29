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
public class ActivityTemplateFileUpdateInfo implements Dto {

    private static final long serialVersionUID = -7531798952067489302L;

    private LongIdKey activityTemplateFileKey;
    private String originName;
    private byte[] content;

    public ActivityTemplateFileUpdateInfo() {
    }

    public ActivityTemplateFileUpdateInfo(LongIdKey activityTemplateFileKey, String originName, byte[] content) {
        this.activityTemplateFileKey = activityTemplateFileKey;
        this.originName = originName;
        this.content = content;
    }

    public LongIdKey getActivityTemplateFileKey() {
        return activityTemplateFileKey;
    }

    public void setActivityTemplateFileKey(LongIdKey activityTemplateFileKey) {
        this.activityTemplateFileKey = activityTemplateFileKey;
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
        return "ActivityTemplateFileUpdateInfo{" +
                "activityTemplateFileKey=" + activityTemplateFileKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
