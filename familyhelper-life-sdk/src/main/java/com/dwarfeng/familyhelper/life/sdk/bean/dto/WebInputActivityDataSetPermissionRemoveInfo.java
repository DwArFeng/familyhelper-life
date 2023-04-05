package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionRemoveInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 活动数据权限删除信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityDataSetPermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = -6923363153972358749L;

    public static ActivityDataSetPermissionRemoveInfo toStackBean(
            WebInputActivityDataSetPermissionRemoveInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityDataSetPermissionRemoveInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityDataSetKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey())
            );
        }
    }

    @JSONField(name = "activity_data_set_key")
    @Valid
    private WebInputLongIdKey activityDataSetKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputActivityDataSetPermissionRemoveInfo() {
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

    @Override
    public String toString() {
        return "WebInputActivityDataSetPermissionRemoveInfo{" +
                "activityDataSetKey=" + activityDataSetKey +
                ", userKey=" + userKey +
                '}';
    }
}
