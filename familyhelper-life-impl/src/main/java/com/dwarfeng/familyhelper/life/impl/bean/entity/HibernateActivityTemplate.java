package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_template")
public class HibernateActivityTemplate implements Bean {

    private static final long serialVersionUID = -1987093679535821065L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "activity_type", length = Constraints.LENGTH_TYPE)
    private String activityType;

    @Column(name = "name", length = Constraints.LENGTH_NAME, nullable = false)
    private String name;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "activity_name_template", columnDefinition = "TEXT")
    private String activityNameTemplate;

    @Column(name = "activity_remark_template", columnDefinition = "TEXT")
    private String activityRemarkTemplate;

    @Column(name = "activity_start_date_template", columnDefinition = "TEXT")
    private String activityStartDateTemplate;

    @Column(name = "activity_end_date_template", columnDefinition = "TEXT")
    private String activityEndDateTemplate;

    @Column(name = "baseline_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date baselineDate;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "inspected_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inspectedDate;

    @Column(name = "generated_count")
    private int generatedCount;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityTemplateParticipant.class, mappedBy = "activityTemplate")
    private Set<HibernateActivityTemplateParticipant> activityTemplateParticipants = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityTemplateCoverInfo.class, mappedBy = "activityTemplate")
    private Set<HibernateActivityTemplateCoverInfo> activityTemplateCoverInfos = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityTemplateFileInfo.class, mappedBy = "activityTemplate")
    private Set<HibernateActivityTemplateFileInfo> activityTemplateFileInfos = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoat.class, mappedBy = "activityTemplate")
    private Set<HibernatePoat> poats = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoatac.class, mappedBy = "activityTemplate")
    private Set<HibernatePoatac> poatacs = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityTemplateDriverInfo.class, mappedBy = "activityTemplate")
    private Set<HibernateActivityTemplateDriverInfo> activityTemplateDriverInfos = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityTemplateDataInfo.class, mappedBy = "activityTemplate")
    private Set<HibernateActivityTemplateDataInfo> activityTemplateDataInfos = new HashSet<>();

    public HibernateActivityTemplate() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
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

    public Set<HibernateActivityTemplateParticipant> getActivityTemplateParticipants() {
        return activityTemplateParticipants;
    }

    public void setActivityTemplateParticipants(Set<HibernateActivityTemplateParticipant> activityTemplateParticipants) {
        this.activityTemplateParticipants = activityTemplateParticipants;
    }

    public Set<HibernateActivityTemplateCoverInfo> getActivityTemplateCoverInfos() {
        return activityTemplateCoverInfos;
    }

    public void setActivityTemplateCoverInfos(Set<HibernateActivityTemplateCoverInfo> activityTemplateCoverInfos) {
        this.activityTemplateCoverInfos = activityTemplateCoverInfos;
    }

    public Set<HibernateActivityTemplateFileInfo> getActivityTemplateFileInfos() {
        return activityTemplateFileInfos;
    }

    public void setActivityTemplateFileInfos(Set<HibernateActivityTemplateFileInfo> activityTemplateFileInfos) {
        this.activityTemplateFileInfos = activityTemplateFileInfos;
    }

    public Set<HibernatePoat> getPoats() {
        return poats;
    }

    public void setPoats(Set<HibernatePoat> poats) {
        this.poats = poats;
    }

    public Set<HibernatePoatac> getPoatacs() {
        return poatacs;
    }

    public void setPoatacs(Set<HibernatePoatac> poatacs) {
        this.poatacs = poatacs;
    }

    public Set<HibernateActivityTemplateDriverInfo> getActivityTemplateDriverInfos() {
        return activityTemplateDriverInfos;
    }

    public void setActivityTemplateDriverInfos(Set<HibernateActivityTemplateDriverInfo> activityTemplateDriverInfos) {
        this.activityTemplateDriverInfos = activityTemplateDriverInfos;
    }

    public Set<HibernateActivityTemplateDataInfo> getActivityTemplateDataInfos() {
        return activityTemplateDataInfos;
    }

    public void setActivityTemplateDataInfos(Set<HibernateActivityTemplateDataInfo> activityTemplateDataInfos) {
        this.activityTemplateDataInfos = activityTemplateDataInfos;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "activityType = " + activityType + ", " +
                "name = " + name + ", " +
                "remark = " + remark + ", " +
                "activityNameTemplate = " + activityNameTemplate + ", " +
                "activityRemarkTemplate = " + activityRemarkTemplate + ", " +
                "activityStartDateTemplate = " + activityStartDateTemplate + ", " +
                "activityEndDateTemplate = " + activityEndDateTemplate + ", " +
                "baselineDate = " + baselineDate + ", " +
                "createdDate = " + createdDate + ", " +
                "modifiedDate = " + modifiedDate + ", " +
                "inspectedDate = " + inspectedDate + ", " +
                "generatedCount = " + generatedCount + ")";
    }
}
