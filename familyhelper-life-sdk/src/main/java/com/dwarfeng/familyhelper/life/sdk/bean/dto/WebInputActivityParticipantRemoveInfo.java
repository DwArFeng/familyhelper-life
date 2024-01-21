package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.WebInputActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantRemoveInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动参与者删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityParticipantRemoveInfo implements Dto {

    private static final long serialVersionUID = 907718852894570149L;

    public static ActivityParticipantRemoveInfo toStackBean(
            WebInputActivityParticipantRemoveInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityParticipantRemoveInfo(
                    WebInputActivityParticipantKey.toStackBean(webInput.getKey())
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputActivityParticipantKey key;

    public WebInputActivityParticipantRemoveInfo() {
    }

    public WebInputActivityParticipantKey getKey() {
        return key;
    }

    public void setKey(WebInputActivityParticipantKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "WebInputActivityParticipantRemoveInfo{" +
                "key=" + key +
                '}';
    }
}
