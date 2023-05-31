package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Arrays;

/**
 * 活动模板封面。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateCover implements Dto {

    private static final long serialVersionUID = 3127859556667068678L;
    
    private String originName;
    private byte[] content;

    public ActivityTemplateCover() {
    }

    public ActivityTemplateCover(String originName, byte[] content) {
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
        return "ActivityTemplateCover{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
