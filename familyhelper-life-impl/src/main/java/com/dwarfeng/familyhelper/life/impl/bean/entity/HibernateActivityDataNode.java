package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_data_node")
public class HibernateActivityDataNode implements Bean {

    private static final long serialVersionUID = -7117195906955762028L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "parent_id")
    private Long parentLongId;

    @Column(name = "set_id")
    private Long setLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "name", length = Constraints.LENGTH_NAME, nullable = false)
    private String name;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityDataNode.class)
    @JoinColumns({ //
            @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataNode parent;

    @ManyToOne(targetEntity = HibernateActivityDataSet.class)
    @JoinColumns({ //
            @JoinColumn(name = "set_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataSet activityDataSet;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityDataItem.class, mappedBy = "activityDataNode")
    private Set<HibernateActivityDataItem> activityDataItems = new HashSet<>();

    public HibernateActivityDataNode() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateLongIdKey getParentKey() {
        return Optional.ofNullable(parentLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setParentKey(HibernateLongIdKey idKey) {
        this.parentLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateLongIdKey getSetKey() {
        return Optional.ofNullable(setLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setSetKey(HibernateLongIdKey idKey) {
        this.setLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }

    public Long getParentLongId() {
        return parentLongId;
    }

    public void setParentLongId(Long parentLongId) {
        this.parentLongId = parentLongId;
    }

    public Long getSetLongId() {
        return setLongId;
    }

    public void setSetLongId(Long setLongId) {
        this.setLongId = setLongId;
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

    public HibernateActivityDataNode getParent() {
        return parent;
    }

    public void setParent(HibernateActivityDataNode parent) {
        this.parent = parent;
    }

    public HibernateActivityDataSet getActivityDataSet() {
        return activityDataSet;
    }

    public void setActivityDataSet(HibernateActivityDataSet activityDataSet) {
        this.activityDataSet = activityDataSet;
    }

    public Set<HibernateActivityDataItem> getActivityDataItems() {
        return activityDataItems;
    }

    public void setActivityDataItems(Set<HibernateActivityDataItem> activityDataItems) {
        this.activityDataItems = activityDataItems;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "parentLongId = " + parentLongId + ", " +
                "setLongId = " + setLongId + ", " +
                "name = " + name + ", " +
                "remark = " + remark + ", " +
                "parent = " + parent + ", " +
                "activityDataSet = " + activityDataSet + ")";
    }
}
