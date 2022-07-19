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
@Table(name = "tbl_pb_set")
public class HibernatePbSet implements Bean {

    private static final long serialVersionUID = 699517254559783795L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "name", length = Constraints.LENGTH_NAME, nullable = false)
    private String name;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "item_count")
    private int itemCount;

    @Column(name = "last_recorded_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRecordedDate;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePbNode.class, mappedBy = "set")
    private Set<HibernatePbNode> nodes = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePbItem.class, mappedBy = "set")
    private Set<HibernatePbItem> items = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePopb.class, mappedBy = "pbSet")
    private Set<HibernatePopb> popbs = new HashSet<>();

    public HibernatePbSet() {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public Date getLastRecordedDate() {
        return lastRecordedDate;
    }

    public void setLastRecordedDate(Date lastRecordedDate) {
        this.lastRecordedDate = lastRecordedDate;
    }

    public Set<HibernatePbNode> getNodes() {
        return nodes;
    }

    public void setNodes(Set<HibernatePbNode> nodes) {
        this.nodes = nodes;
    }

    public Set<HibernatePbItem> getItems() {
        return items;
    }

    public void setItems(Set<HibernatePbItem> items) {
        this.items = items;
    }

    public Set<HibernatePopb> getPopbs() {
        return popbs;
    }

    public void setPopbs(Set<HibernatePopb> popbs) {
        this.popbs = popbs;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "name = " + name + ", " +
                "remark = " + remark + ", " +
                "createdDate = " + createdDate + ", " +
                "itemCount = " + itemCount + ", " +
                "lastRecordedDate = " + lastRecordedDate + ")";
    }
}
