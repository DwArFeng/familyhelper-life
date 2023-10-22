package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.WebInputActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动模板参与者更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateParticipantUpdateInfo implements Dto {

    private static final long serialVersionUID = -8087625946447319603L;

    public static ActivityTemplateParticipantUpdateInfo toStackBean(
            WebInputActivityTemplateParticipantUpdateInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateParticipantUpdateInfo(
                    WebInputActivityTemplateParticipantKey.toStackBean(webInput.getKey()),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputActivityTemplateParticipantKey key;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputActivityTemplateParticipantUpdateInfo() {
    }

    public WebInputActivityTemplateParticipantKey getKey() {
        return key;
    }

    public void setKey(WebInputActivityTemplateParticipantKey key) {
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
        return "WebInputActivityTemplateParticipantUpdateInfo{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
