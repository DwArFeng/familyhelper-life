package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.ValidPermissionLevel;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateActivityPermissionUpsertInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 活动模板活动权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateActivityPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = 7575835887001578921L;

    public static ActivityTemplateActivityPermissionUpsertInfo toStackBean(
            WebInputActivityTemplateActivityPermissionUpsertInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateActivityPermissionUpsertInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityTemplateKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getPermissionLevel()
            );
        }
    }

    @JSONField(name = "activity_template_key")
    @Valid
    private WebInputLongIdKey activityTemplateKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "permission_level")
    @ValidPermissionLevel
    private int permissionLevel;

    public WebInputActivityTemplateActivityPermissionUpsertInfo() {
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

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "WebInputActivityTemplateActivityPermissionUpsertInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
