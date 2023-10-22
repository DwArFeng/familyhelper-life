package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Objects;

/**
 * 活动模板参与者创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateParticipantCreateInfo implements Dto {

    private static final long serialVersionUID = 5697003646694316947L;

    public static ActivityTemplateParticipantCreateInfo toStackBean(
            WebInputActivityTemplateParticipantCreateInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateParticipantCreateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityTemplateKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "activity_template_key")
    @Valid
    private WebInputLongIdKey activityTemplateKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputActivityTemplateParticipantCreateInfo() {
    }

    public WebInputLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(WebInputLongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputActivityTemplateParticipantCreateInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                ", remark='" + remark + '\'' +
                '}';
    }
}
