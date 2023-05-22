package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 活动模板。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplate implements Entity<LongIdKey> {

    private static final long serialVersionUID = 3696277393864797077L;
    
    private LongIdKey key;
    private String activityType;
    private String name;
    private String remark;
    private String activityNameTemplate;
    private String activityRemarkTemplate;
    private String activityStartDateTemplate;
    private String activityEndDateTemplate;
    private Date baselineDate;
    private Date createdDate;
    private Date modifiedDate;
    private Date inspectedDate;
    private int generatedCount;

    public ActivityTemplate() {
    }

    public ActivityTemplate(
            LongIdKey key, String activityType, String name, String remark, String activityNameTemplate,
            String activityRemarkTemplate, String activityStartDateTemplate, String activityEndDateTemplate,
            Date baselineDate, Date createdDate, Date modifiedDate, Date inspectedDate, int generatedCount
    ) {
        this.key = key;
        this.activityType = activityType;
        this.name = name;
        this.remark = remark;
        this.activityNameTemplate = activityNameTemplate;
        this.activityRemarkTemplate = activityRemarkTemplate;
        this.activityStartDateTemplate = activityStartDateTemplate;
        this.activityEndDateTemplate = activityEndDateTemplate;
        this.baselineDate = baselineDate;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.inspectedDate = inspectedDate;
        this.generatedCount = generatedCount;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public int getGeneratedCount() {
        return generatedCount;
    }

    public void setGeneratedCount(int generatedCount) {
        this.generatedCount = generatedCount;
    }

    @Override
    public String toString() {
        return "ActivityTemplate{" +
                "key=" + key +
                ", activityType='" + activityType + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", activityNameTemplate='" + activityNameTemplate + '\'' +
                ", activityRemarkTemplate='" + activityRemarkTemplate + '\'' +
                ", activityStartDateTemplate='" + activityStartDateTemplate + '\'' +
                ", activityEndDateTemplate='" + activityEndDateTemplate + '\'' +
                ", baselineDate=" + baselineDate +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", inspectedDate=" + inspectedDate +
                ", generatedCount=" + generatedCount +
                '}';
    }
}
