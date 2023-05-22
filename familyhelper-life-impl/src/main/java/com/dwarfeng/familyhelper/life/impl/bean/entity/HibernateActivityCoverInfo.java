package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_cover_info")
public class HibernateActivityCoverInfo implements Bean {

    private static final long serialVersionUID = 6718352370244707510L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "activity_id")
    private Long activityLongId;

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
    @ManyToOne(targetEntity = HibernateActivity.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivity activity;

    public HibernateActivityCoverInfo() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
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

    public Long getActivityLongId() {
        return activityLongId;
    }

    public void setActivityLongId(Long activityLongId) {
        this.activityLongId = activityLongId;
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
                "activityLongId = " + activityLongId + ", " +
                "originName = " + originName + ", " +
                "length = " + length + ", " +
                "createdDate = " + createdDate + ", " +
                "modifiedDate = " + modifiedDate + ", " +
                "remark = " + remark + ", " +
                "index = " + index + ", " +
                "activity = " + activity + ")";
    }
}
