package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_template_data_info")
public class HibernateActivityTemplateDataInfo implements Bean {

    private static final long serialVersionUID = -2465309750439033687L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "activity_template_id")
    private Long activityTemplateLongId;

    @Column(name = "activity_data_item_id")
    private Long activityDataItemLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "initial_value")
    private BigDecimal initialValue;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityTemplate.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_template_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityTemplate activityTemplate;

    @ManyToOne(targetEntity = HibernateActivityDataItem.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_data_item_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataItem activityDataItem;

    public HibernateActivityTemplateDataInfo() {
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

    public HibernateLongIdKey getActivityDataItemKey() {
        return Optional.ofNullable(activityDataItemLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setActivityDataItemKey(HibernateLongIdKey idKey) {
        this.activityDataItemLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
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

    public Long getActivityDataItemLongId() {
        return activityDataItemLongId;
    }

    public void setActivityDataItemLongId(Long activityDataItemLongId) {
        this.activityDataItemLongId = activityDataItemLongId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(BigDecimal initialValue) {
        this.initialValue = initialValue;
    }

    public HibernateActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public void setActivityTemplate(HibernateActivityTemplate activityTemplate) {
        this.activityTemplate = activityTemplate;
    }

    public HibernateActivityDataItem getActivityDataItem() {
        return activityDataItem;
    }

    public void setActivityDataItem(HibernateActivityDataItem activityDataItem) {
        this.activityDataItem = activityDataItem;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "activityTemplateLongId = " + activityTemplateLongId + ", " +
                "activityDataItemLongId = " + activityDataItemLongId + ", " +
                "remark = " + remark + ", " +
                "initialValue = " + initialValue + ", " +
                "activityTemplate = " + activityTemplate + ", " +
                "activityDataItem = " + activityDataItem + ")";
    }
}
