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
@Table(name = "tbl_pb_item")
public class HibernatePbItem implements Bean {

    private static final long serialVersionUID = -2620681344168458858L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "node_id")
    private Long nodeLongId;

    @Column(name = "set_id")
    private Long setLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "name", length = Constraints.LENGTH_NAME, nullable = false)
    private String name;

    @Column(name = "unit", length = Constraints.LENGTH_UNIT)
    private String unit;

    @Column(name = "comparator")
    private Integer comparator;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernatePbNode.class)
    @JoinColumns({ //
            @JoinColumn(name = "node_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernatePbNode node;

    @ManyToOne(targetEntity = HibernatePbSet.class)
    @JoinColumns({ //
            @JoinColumn(name = "set_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernatePbSet set;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePbRecord.class, mappedBy = "item")
    private Set<HibernatePbRecord> records = new HashSet<>();

    public HibernatePbItem() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateLongIdKey getNodeKey() {
        return Optional.ofNullable(nodeLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setNodeKey(HibernateLongIdKey idKey) {
        this.nodeLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
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

    public Long getNodeLongId() {
        return nodeLongId;
    }

    public void setNodeLongId(Long nodeLongId) {
        this.nodeLongId = nodeLongId;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getComparator() {
        return comparator;
    }

    public void setComparator(Integer comparator) {
        this.comparator = comparator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernatePbNode getNode() {
        return node;
    }

    public void setNode(HibernatePbNode node) {
        this.node = node;
    }

    public HibernatePbSet getSet() {
        return set;
    }

    public void setSet(HibernatePbSet set) {
        this.set = set;
    }

    public Set<HibernatePbRecord> getRecords() {
        return records;
    }

    public void setRecords(Set<HibernatePbRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "nodeLongId = " + nodeLongId + ", " +
                "setLongId = " + setLongId + ", " +
                "name = " + name + ", " +
                "unit = " + unit + ", " +
                "comparator = " + comparator + ", " +
                "remark = " + remark + ", " +
                "node = " + node + ", " +
                "set = " + set + ")";
    }
}
