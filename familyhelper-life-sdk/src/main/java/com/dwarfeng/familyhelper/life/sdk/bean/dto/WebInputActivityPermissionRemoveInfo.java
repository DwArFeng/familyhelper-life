package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionRemoveInfo;
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
public class WebInputActivityPermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 3529241346254882709L;

    public static ActivityPermissionRemoveInfo toStackBean(WebInputActivityPermissionRemoveInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityPermissionRemoveInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey())
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

    public WebInputActivityPermissionRemoveInfo() {
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

    @Override
    public String toString() {
        return "WebInputActivityPermissionRemoveInfo{" +
                "activityKey=" + activityKey +
                ", userKey=" + userKey +
                '}';
    }
}
