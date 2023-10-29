package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Arrays;

/**
 * 活动模板文件。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateFile implements Dto {

    private static final long serialVersionUID = 1572834039838567543L;

    private String originName;
    private byte[] content;

    public ActivityTemplateFile() {
    }

    public ActivityTemplateFile(String originName, byte[] content) {
        this.originName = originName;
        this.content = content;
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
        return "ActivityTemplateFile{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
