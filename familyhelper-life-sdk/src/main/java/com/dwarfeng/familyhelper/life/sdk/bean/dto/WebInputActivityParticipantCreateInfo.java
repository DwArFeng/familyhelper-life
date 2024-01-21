package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Objects;

/**
 * 活动参与者创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityParticipantCreateInfo implements Dto {

    private static final long serialVersionUID = -2577670689579304379L;

    public static ActivityParticipantCreateInfo toStackBean(
            WebInputActivityParticipantCreateInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityParticipantCreateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "activity_key")
    @Valid
    private WebInputLongIdKey activityKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputActivityParticipantCreateInfo() {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputActivityParticipantCreateInfo{" +
                "activityKey=" + activityKey +
                ", userKey=" + userKey +
                ", remark='" + remark + '\'' +
                '}';
    }
}
