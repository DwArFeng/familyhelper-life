package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.sdk.util.ValidRemindScopeType;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动模板驱动信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateDriverInfo implements Bean {

    private static final long serialVersionUID = 3063461513597313021L;

    public static ActivityTemplateDriverInfo toStackBean(WebInputActivityTemplateDriverInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateDriverInfo(
                    WebInputLongIdKey.toStackBean(webInput.getKey()),
                    WebInputLongIdKey.toStackBean(webInput.getActivityTemplateKey()),
                    webInput.isEnabled(),
                    webInput.getType(),
                    webInput.getParam(),
                    webInput.isRemindFlag(),
                    webInput.isGenerateFlag(),
                    webInput.getRemark(),
                    webInput.getRemindScopeType()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

    @JSONField(name = "activity_template_key")
    @Valid
    private WebInputLongIdKey activityTemplateKey;

    @JSONField(name = "enabled")
    private boolean enabled;

    @JSONField(name = "type")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_TYPE)
    private String type;

    @JSONField(name = "param")
    private String param;

    @JSONField(name = "remind_flag")
    private boolean remindFlag;

    @JSONField(name = "generate_flag")
    private boolean generateFlag;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    @JSONField(name = "remind_scope_type")
    @ValidRemindScopeType
    private int remindScopeType;

    public WebInputActivityTemplateDriverInfo() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
    }

    public WebInputLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(WebInputLongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isRemindFlag() {
        return remindFlag;
    }

    public void setRemindFlag(boolean remindFlag) {
        this.remindFlag = remindFlag;
    }

    public boolean isGenerateFlag() {
        return generateFlag;
    }

    public void setGenerateFlag(boolean generateFlag) {
        this.generateFlag = generateFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getRemindScopeType() {
        return remindScopeType;
    }

    public void setRemindScopeType(int remindScopeType) {
        this.remindScopeType = remindScopeType;
    }

    @Override
    public String toString() {
        return "WebInputActivityTemplateDriverInfo{" +
                "key=" + key +
                ", activityTemplateKey=" + activityTemplateKey +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                ", param='" + param + '\'' +
                ", remindFlag=" + remindFlag +
                ", generateFlag=" + generateFlag +
                ", remark='" + remark + '\'' +
                ", remindScopeType=" + remindScopeType +
                '}';
    }
}
