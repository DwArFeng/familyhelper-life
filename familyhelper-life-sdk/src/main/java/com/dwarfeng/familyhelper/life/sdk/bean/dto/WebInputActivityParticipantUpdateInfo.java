package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.WebInputActivityParticipantKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动参与者更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityParticipantUpdateInfo implements Dto {

    private static final long serialVersionUID = 189622775736317950L;

    public static ActivityParticipantUpdateInfo toStackBean(
            WebInputActivityParticipantUpdateInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityParticipantUpdateInfo(
                    WebInputActivityParticipantKey.toStackBean(webInput.getKey()),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputActivityParticipantKey key;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputActivityParticipantUpdateInfo() {
    }

    public WebInputActivityParticipantKey getKey() {
        return key;
    }

    public void setKey(WebInputActivityParticipantKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputActivityParticipantUpdateInfo{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
