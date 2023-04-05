package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionUpsertInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 活动数据权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityDataSetPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = 4135823435920539945L;

    public static ActivityDataSetPermissionUpsertInfo toStackBean(
            WebInputActivityDataSetPermissionUpsertInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityDataSetPermissionUpsertInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityDataSetKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getPermissionLevel()
            );
        }
    }

    @JSONField(name = "activity_data_set_key")
    @Valid
    private WebInputLongIdKey activityDataSetKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "permission_level")
    private int permissionLevel;

    public WebInputActivityDataSetPermissionUpsertInfo() {
    }

    public WebInputLongIdKey getActivityDataSetKey() {
        return activityDataSetKey;
    }

    public void setActivityDataSetKey(WebInputLongIdKey activityDataSetKey) {
        this.activityDataSetKey = activityDataSetKey;
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
        return "WebInputActivityDataSetPermissionUpsertInfo{" +
                "activityDataSetKey=" + activityDataSetKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
