package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.impl.bean.key.HibernateLongLongRelationKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(HibernateLongLongRelationKey.class)
@Table(name = "tbl_activity_template_activity_data_item_relation")
public class HibernateActivityTemplateActivityDataItemRelation implements Bean {

    private static final long serialVersionUID = -6978735813414193928L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "left_id", nullable = false)
    private Long leftLongId;

    @Id
    @Column(name = "right_id", nullable = false)
    private Long rightLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "initial_value")
    private BigDecimal initialValue;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityTemplate.class)
    @JoinColumns({ //
            @JoinColumn(name = "left_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityTemplate activityTemplate;

    @ManyToOne(targetEntity = HibernateActivityDataItem.class)
    @JoinColumns({ //
            @JoinColumn(name = "right_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataItem activityDataItem;

    public HibernateActivityTemplateActivityDataItemRelation() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongLongRelationKey getKey() {
        return new HibernateLongLongRelationKey(leftLongId, rightLongId);
    }

    public void setKey(HibernateLongLongRelationKey key) {
        if (Objects.isNull(key)) {
            this.leftLongId = null;
            this.rightLongId = null;
        } else {
            this.leftLongId = key.getLeftLongId();
            this.rightLongId = key.getRightLongId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLeftLongId() {
        return leftLongId;
    }

    public void setLeftLongId(Long leftLongId) {
        this.leftLongId = leftLongId;
    }

    public Long getRightLongId() {
        return rightLongId;
    }

    public void setRightLongId(Long rightLongId) {
        this.rightLongId = rightLongId;
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
                "leftLongId = " + leftLongId + ", " +
                "rightLongId = " + rightLongId + ", " +
                "remark = " + remark + ", " +
                "initialValue = " + initialValue + ", " +
                "activityTemplate = " + activityTemplate + ", " +
                "activityDataItem = " + activityDataItem + ")";
    }
}
