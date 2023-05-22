package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplatePermissionRemoveInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 活动模板权限删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplatePermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 9060006071771693494L;

    public static ActivityTemplatePermissionRemoveInfo toStackBean(
            WebInputActivityTemplatePermissionRemoveInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplatePermissionRemoveInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityTemplateKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey())
            );
        }
    }

    @JSONField(name = "activity_template_key")
    @Valid
    private WebInputLongIdKey activityTemplateKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputActivityTemplatePermissionRemoveInfo() {
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

    @Override
    public String toString() {
        return "WebInputActivityTemplatePermissionRemoveInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                '}';
    }
}
