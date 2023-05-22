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
@Table(name = "tbl_activity_data_set")
public class HibernateActivityDataSet implements Bean {

    private static final long serialVersionUID = 5417384981967258795L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "name", length = Constraints.LENGTH_NAME, nullable = false)
    private String name;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "item_count")
    private int itemCount;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityDataNode.class, mappedBy = "activityDataSet")
    private Set<HibernateActivityDataNode> activityDataNodes = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityDataItem.class, mappedBy = "activityDataSet")
    private Set<HibernateActivityDataItem> activityDataItems = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoad.class, mappedBy = "activityDataSet")
    private Set<HibernatePoad> popbs = new HashSet<>();

    public HibernateActivityDataSet() {
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

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<HibernateActivityDataNode> getActivityDataNodes() {
        return activityDataNodes;
    }

    public void setActivityDataNodes(Set<HibernateActivityDataNode> activityDataNodes) {
        this.activityDataNodes = activityDataNodes;
    }

    public Set<HibernateActivityDataItem> getActivityDataItems() {
        return activityDataItems;
    }

    public void setActivityDataItems(Set<HibernateActivityDataItem> activityDataItems) {
        this.activityDataItems = activityDataItems;
    }

    public Set<HibernatePoad> getPopbs() {
        return popbs;
    }

    public void setPopbs(Set<HibernatePoad> popbs) {
        this.popbs = popbs;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "name = " + name + ", " +
                "remark = " + remark + ", " +
                "itemCount = " + itemCount + ", " +
                "createdDate = " + createdDate + ")";
    }
}
