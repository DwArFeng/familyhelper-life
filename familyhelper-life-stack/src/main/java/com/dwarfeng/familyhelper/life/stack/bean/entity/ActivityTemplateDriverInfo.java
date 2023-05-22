package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 活动模板驱动信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateDriverInfo implements Entity<LongIdKey> {

    private static final long serialVersionUID = 9018597310499171025L;
    
    private LongIdKey key;
    private LongIdKey activityTemplateKey;
    private boolean enabled;
    private String type;
    private String param;

    /**
     * 提醒标志。
     *
     * <p>
     * 指示该驱动是否提醒。<br>
     * 如果该值为 <code>true</code>，则该驱动提醒，否则不提醒。
     */
    private boolean remindFlag;

    /**
     * 生成标志。
     *
     * <p>
     * 指示该驱动是否生成活动。<br>
     * 如果该值为 <code>true</code>，则该驱动生成活动，否则不生成。
     */
    private boolean generateFlag;
    private String remark;

    public ActivityTemplateDriverInfo() {
    }

    public ActivityTemplateDriverInfo(
            LongIdKey key, LongIdKey activityTemplateKey, boolean enabled, String type, String param,
            boolean remindFlag, boolean generateFlag, String remark
    ) {
        this.key = key;
        this.activityTemplateKey = activityTemplateKey;
        this.enabled = enabled;
        this.type = type;
        this.param = param;
        this.remindFlag = remindFlag;
        this.generateFlag = generateFlag;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public LongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(LongIdKey activityTemplateKey) {
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

    @Override
    public String toString() {
        return "ActivityTemplateDriverInfo{" +
                "key=" + key +
                ", activityTemplateKey=" + activityTemplateKey +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                ", param='" + param + '\'' +
                ", remindFlag=" + remindFlag +
                ", generateFlag=" + generateFlag +
                ", remark='" + remark + '\'' +
                '}';
    }
}
