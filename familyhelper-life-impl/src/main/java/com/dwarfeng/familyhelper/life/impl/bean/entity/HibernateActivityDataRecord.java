package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_data_record")
public class HibernateActivityDataRecord implements Bean {

    private static final long serialVersionUID = -8776684050676943478L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "item_id")
    private Long itemLongId;

    @Column(name = "activity_id")
    private Long activityLongId;

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

    @ManyToOne(targetEntity = HibernateActivity.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivity activity;

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

    public HibernateLongIdKey getActivityKey() {
        return Optional.ofNullable(activityLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setActivityKey(HibernateLongIdKey idKey) {
        this.activityLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
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

    public Long getActivityLongId() {
        return activityLongId;
    }

    public void setActivityLongId(Long activityLongId) {
        this.activityLongId = activityLongId;
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

    public HibernateActivity getActivity() {
        return activity;
    }

    public void setActivity(HibernateActivity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "itemLongId = " + itemLongId + ", " +
                "activityLongId = " + activityLongId + ", " +
                "value = " + value + ", " +
                "recordedDate = " + recordedDate + ", " +
                "remark = " + remark + ", " +
                "activityDataItem = " + activityDataItem + ", " +
                "activity = " + activity + ")";
    }
}
