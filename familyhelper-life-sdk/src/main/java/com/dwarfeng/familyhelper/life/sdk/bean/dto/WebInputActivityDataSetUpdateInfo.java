package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.ValidPermissionLevel;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动数据更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityDataSetUpdateInfo implements Dto {

    private static final long serialVersionUID = -8966742595552740864L;

    public static ActivityDataSetUpdateInfo toStackBean(WebInputActivityDataSetUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityDataSetUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityDataSetKey()),
                    webInput.getName(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "activity_data_set_key")
    @Valid
    @NotNull
    private WebInputLongIdKey activityDataSetKey;

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @JSONField(name = "remark")
    @ValidPermissionLevel
    private String remark;

    public WebInputActivityDataSetUpdateInfo() {
    }

    public WebInputLongIdKey getActivityDataSetKey() {
        return activityDataSetKey;
    }

    public void setActivityDataSetKey(WebInputLongIdKey activityDataSetKey) {
        this.activityDataSetKey = activityDataSetKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputActivityDataSetUpdateInfo{" +
                "activityDataSetKey=" + activityDataSetKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
