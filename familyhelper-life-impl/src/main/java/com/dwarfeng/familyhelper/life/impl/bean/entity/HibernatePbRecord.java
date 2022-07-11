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
@Table(name = "tbl_pb_record")
public class HibernatePbRecord implements Bean {

    private static final long serialVersionUID = 902884004215262450L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "item_id")
    private Long itemLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "value")
    private Double value;

    @Column(name = "recorded_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedDate;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernatePbItem.class)
    @JoinColumns({ //
            @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernatePbItem item;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePbFileInfo.class, mappedBy = "record")
    private Set<HibernatePbFileInfo> fileInfos = new HashSet<>();

    public HibernatePbRecord() {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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

    public HibernatePbItem getItem() {
        return item;
    }

    public void setItem(HibernatePbItem item) {
        this.item = item;
    }

    public Set<HibernatePbFileInfo> getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(Set<HibernatePbFileInfo> fileInfos) {
        this.fileInfos = fileInfos;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "itemLongId = " + itemLongId + ", " +
                "value = " + value + ", " +
                "recordedDate = " + recordedDate + ", " +
                "remark = " + remark + ", " +
                "item = " + item + ")";
    }
}
