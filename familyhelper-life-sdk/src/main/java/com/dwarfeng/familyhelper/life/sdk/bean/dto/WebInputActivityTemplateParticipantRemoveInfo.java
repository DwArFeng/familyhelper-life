package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.WebInputActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantRemoveInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动模板参与者删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateParticipantRemoveInfo implements Dto {

    private static final long serialVersionUID = -1281910482645602484L;

    public static ActivityTemplateParticipantRemoveInfo toStackBean(
            WebInputActivityTemplateParticipantRemoveInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateParticipantRemoveInfo(
                    WebInputActivityTemplateParticipantKey.toStackBean(webInput.getKey())
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputActivityTemplateParticipantKey key;

    public WebInputActivityTemplateParticipantRemoveInfo() {
    }

    public WebInputActivityTemplateParticipantKey getKey() {
        return key;
    }

    public void setKey(WebInputActivityTemplateParticipantKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "WebInputActivityTemplateParticipantRemoveInfo{" +
                "key=" + key +
                '}';
    }
}
