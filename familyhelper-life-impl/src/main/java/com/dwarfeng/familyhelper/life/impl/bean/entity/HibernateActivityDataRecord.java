package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_data_record")
public class HibernateActivityDataRecord implements Bean {

    private static final long serialVersionUID = 9158782741297857199L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "item_id")
    private Long itemLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "recorded_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedDate;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityDataItem.class)
    @JoinColumns({ //
            @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataItem activityDataItem;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityActivityDataRecordRelation.class, mappedBy = "activityDataRecord")
    private Set<HibernateActivityActivityDataRecordRelation> activityActivityDataRecordRelations = new HashSet<>();

    public HibernateActivityDataRecord() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateLongIdKey getItemKey() {
        return Optional.ofNullable(itemLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setItemKey(HibernateLongIdKey idKey) {
        this.itemLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }

    public Long getItemLongId() {
        return itemLongId;
    }

    public void setItemLongId(Long itemLongId) {
        this.itemLongId = itemLongId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernateActivityDataItem getActivityDataItem() {
        return activityDataItem;
    }

    public void setActivityDataItem(HibernateActivityDataItem activityDataItem) {
        this.activityDataItem = activityDataItem;
    }

    public Set<HibernateActivityActivityDataRecordRelation> getActivityActivityDataRecordRelations() {
        return activityActivityDataRecordRelations;
    }

    public void setActivityActivityDataRecordRelations(Set<HibernateActivityActivityDataRecordRelation> activityActivityDataRecordRelations) {
        this.activityActivityDataRecordRelations = activityActivityDataRecordRelations;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "itemLongId = " + itemLongId + ", " +
                "value = " + value + ", " +
                "recordedDate = " + recordedDate + ", " +
                "remark = " + remark + ", " +
                "activityDataItem = " + activityDataItem + ")";
    }
}
