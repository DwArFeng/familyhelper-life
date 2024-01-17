package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateActivityCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动模板活动创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateActivityCreateInfo implements Dto {

    private static final long serialVersionUID = 8729361675647819564L;

    public static ActivityTemplateActivityCreateInfo toStackBean(WebInputActivityTemplateActivityCreateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateActivityCreateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityTemplateKey())
            );
        }
    }

    @JSONField(name = "activity_template_key")
    @NotNull
    @Valid
    private WebInputLongIdKey activityTemplateKey;

    public WebInputActivityTemplateActivityCreateInfo() {
    }

    public WebInputLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(WebInputLongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    @Override
    public String toString() {
        return "WebInputActivityTemplateActivityCreateInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                '}';
    }
}
