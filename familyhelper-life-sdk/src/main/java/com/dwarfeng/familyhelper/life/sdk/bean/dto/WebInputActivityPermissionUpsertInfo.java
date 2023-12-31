package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.ValidPermissionLevel;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionUpsertInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = -7445192708543397844L;

    public static ActivityPermissionUpsertInfo toStackBean(WebInputActivityPermissionUpsertInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityPermissionUpsertInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getPermissionLevel()
            );
        }
    }

    @JSONField(name = "activity_key")
    @NotNull
    @Valid
    private WebInputLongIdKey activityKey;

    @JSONField(name = "user_key")
    @NotNull
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "permission_level")
    @ValidPermissionLevel
    private int permissionLevel;

    public WebInputActivityPermissionUpsertInfo() {
    }

    public WebInputLongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(WebInputLongIdKey activityKey) {
        this.activityKey = activityKey;
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
        return "WebInputActivityPermissionUpsertInfo{" +
                "activityKey=" + activityKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
