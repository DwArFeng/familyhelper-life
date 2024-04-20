package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动模板驱动信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityTemplateDriverInfo implements Bean {

    private static final long serialVersionUID = 154614274147108130L;

    public static FastJsonActivityTemplateDriverInfo of(ActivityTemplateDriverInfo activityTemplateDriverInfo) {
        if (Objects.isNull(activityTemplateDriverInfo)) {
            return null;
        } else {
            return new FastJsonActivityTemplateDriverInfo(
                    FastJsonLongIdKey.of(activityTemplateDriverInfo.getKey()),
                    FastJsonLongIdKey.of(activityTemplateDriverInfo.getActivityTemplateKey()),
                    activityTemplateDriverInfo.isEnabled(),
                    activityTemplateDriverInfo.getType(),
                    activityTemplateDriverInfo.getParam(),
                    activityTemplateDriverInfo.isRemindFlag(),
                    activityTemplateDriverInfo.isGenerateFlag(),
                    activityTemplateDriverInfo.getRemark(),
                    activityTemplateDriverInfo.getRemindScopeType()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "activity_template_key", ordinal = 2)
    private FastJsonLongIdKey activityTemplateKey;

    @JSONField(name = "enabled", ordinal = 3)
    private boolean enabled;

    @JSONField(name = "type", ordinal = 4)
    private String type;

    @JSONField(name = "param", ordinal = 5)
    private String param;

    @JSONField(name = "remind_flag", ordinal = 6)
    private boolean remindFlag;

    @JSONField(name = "generate_flag", ordinal = 7)
    private boolean generateFlag;

    @JSONField(name = "remark", ordinal = 8)
    private String remark;

    @JSONField(name = "remind_scope_type", ordinal = 9)
    private int remindScopeType;

    public FastJsonActivityTemplateDriverInfo() {
    }

    public FastJsonActivityTemplateDriverInfo(
            FastJsonLongIdKey key, FastJsonLongIdKey activityTemplateKey, boolean enabled, String type, String param,
            boolean remindFlag, boolean generateFlag, String remark, int remindScopeType
    ) {
        this.key = key;
        this.activityTemplateKey = activityTemplateKey;
        this.enabled = enabled;
        this.type = type;
        this.param = param;
        this.remindFlag = remindFlag;
        this.generateFlag = generateFlag;
        this.remark = remark;
        this.remindScopeType = remindScopeType;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(FastJsonLongIdKey activityTemplateKey) {
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
        return "FastJsonActivityTemplateDriverInfo{" +
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
