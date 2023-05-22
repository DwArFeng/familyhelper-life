package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 活动模板更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateUpdateInfo implements Dto {

    private static final long serialVersionUID = -4676676940191944341L;
    
    private LongIdKey activityTemplateKey;
    private String activityType;
    private String name;
    private String remark;
    private String activityNameTemplate;
    private String activityRemarkTemplate;
    private String activityStartDateTemplate;
    private String activityEndDateTemplate;
    private Date baselineDate;

    public ActivityTemplateUpdateInfo() {
    }

    public ActivityTemplateUpdateInfo(
            LongIdKey activityTemplateKey, String activityType, String name, String remark,
            String activityNameTemplate, String activityRemarkTemplate, String activityStartDateTemplate,
            String activityEndDateTemplate, Date baselineDate
    ) {
        this.activityTemplateKey = activityTemplateKey;
        this.activityType = activityType;
        this.name = name;
        this.remark = remark;
        this.activityNameTemplate = activityNameTemplate;
        this.activityRemarkTemplate = activityRemarkTemplate;
        this.activityStartDateTemplate = activityStartDateTemplate;
        this.activityEndDateTemplate = activityEndDateTemplate;
        this.baselineDate = baselineDate;
    }

    public LongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(LongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
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

    public String getActivityNameTemplate() {
        return activityNameTemplate;
    }

    public void setActivityNameTemplate(String activityNameTemplate) {
        this.activityNameTemplate = activityNameTemplate;
    }

    public String getActivityRemarkTemplate() {
        return activityRemarkTemplate;
    }

    public void setActivityRemarkTemplate(String activityRemarkTemplate) {
        this.activityRemarkTemplate = activityRemarkTemplate;
    }

    public String getActivityStartDateTemplate() {
        return activityStartDateTemplate;
    }

    public void setActivityStartDateTemplate(String activityStartDateTemplate) {
        this.activityStartDateTemplate = activityStartDateTemplate;
    }

    public String getActivityEndDateTemplate() {
        return activityEndDateTemplate;
    }

    public void setActivityEndDateTemplate(String activityEndDateTemplate) {
        this.activityEndDateTemplate = activityEndDateTemplate;
    }

    public Date getBaselineDate() {
        return baselineDate;
    }

    public void setBaselineDate(Date baselineDate) {
        this.baselineDate = baselineDate;
    }

    @Override
    public String toString() {
        return "ActivityTemplateUpdateInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", activityType='" + activityType + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", activityNameTemplate='" + activityNameTemplate + '\'' +
                ", activityRemarkTemplate='" + activityRemarkTemplate + '\'' +
                ", activityStartDateTemplate='" + activityStartDateTemplate + '\'' +
                ", activityEndDateTemplate='" + activityEndDateTemplate + '\'' +
                ", baselineDate=" + baselineDate +
                '}';
    }
}
