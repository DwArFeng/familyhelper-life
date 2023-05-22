package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_template_cover_info")
public class HibernateActivityTemplateCoverInfo implements Bean {

    private static final long serialVersionUID = -8639318103811999969L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "activity_template_id")
    private Long activityTemplateLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "origin_name")
    private String originName;

    @Column(name = "column_length")
    private long length;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "column_index", nullable = false)
    private int index;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityTemplate.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_template_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityTemplate activityTemplate;

    public HibernateActivityTemplateCoverInfo() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateLongIdKey getActivityTemplateKey() {
        return Optional.ofNullable(activityTemplateLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setActivityTemplateKey(HibernateLongIdKey idKey) {
        this.activityTemplateLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }

    public Long getActivityTemplateLongId() {
        return activityTemplateLongId;
    }

    public void setActivityTemplateLongId(Long activityTemplateLongId) {
        this.activityTemplateLongId = activityTemplateLongId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public HibernateActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public void setActivityTemplate(HibernateActivityTemplate activityTemplate) {
        this.activityTemplate = activityTemplate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "activityTemplateLongId = " + activityTemplateLongId + ", " +
                "originName = " + originName + ", " +
                "length = " + length + ", " +
                "createdDate = " + createdDate + ", " +
                "modifiedDate = " + modifiedDate + ", " +
                "remark = " + remark + ", " +
                "index = " + index + ", " +
                "activityTemplate = " + activityTemplate + ")";
    }
}
