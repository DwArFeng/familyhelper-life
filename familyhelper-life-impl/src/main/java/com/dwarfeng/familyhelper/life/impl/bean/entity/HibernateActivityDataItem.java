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
@Table(name = "tbl_activity_data_item")
public class HibernateActivityDataItem implements Bean {

    private static final long serialVersionUID = -5375036358497735056L;

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

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "record_count")
    private int recordCount;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "avg")
    private BigDecimal avg;

    @Column(name = "max")
    private BigDecimal max;

    @Column(name = "min")
    private BigDecimal min;

    @Column(name = "earliest_date")
    private Date earliestDate;

    @Column(name = "latest_date")
    private Date latestDate;

    @Column(name = "duration")
    private long duration;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityDataNode.class)
    @JoinColumns({ //
            @JoinColumn(name = "node_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataNode activityDataNode;

    @ManyToOne(targetEntity = HibernateActivityDataSet.class)
    @JoinColumns({ //
            @JoinColumn(name = "set_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataSet activityDataSet;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityDataRecord.class, mappedBy = "activityDataItem")
    private Set<HibernateActivityDataRecord> records = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityTemplateActivityDataItemRelation.class, mappedBy = "activityDataItem")
    private Set<HibernateActivityTemplateActivityDataItemRelation> activityTemplateActivityDataItemRelations = new HashSet<>();

    public HibernateActivityDataItem() {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public Date getEarliestDate() {
        return earliestDate;
    }

    public void setEarliestDate(Date earliestDate) {
        this.earliestDate = earliestDate;
    }

    public Date getLatestDate() {
        return latestDate;
    }

    public void setLatestDate(Date latestDate) {
        this.latestDate = latestDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public HibernateActivityDataNode getActivityDataNode() {
        return activityDataNode;
    }

    public void setActivityDataNode(HibernateActivityDataNode activityDataNode) {
        this.activityDataNode = activityDataNode;
    }

    public HibernateActivityDataSet getActivityDataSet() {
        return activityDataSet;
    }

    public void setActivityDataSet(HibernateActivityDataSet activityDataSet) {
        this.activityDataSet = activityDataSet;
    }

    public Set<HibernateActivityDataRecord> getRecords() {
        return records;
    }

    public void setRecords(Set<HibernateActivityDataRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "nodeLongId = " + nodeLongId + ", " +
                "setLongId = " + setLongId + ", " +
                "name = " + name + ", " +
                "remark = " + remark + ", " +
                "recordCount = " + recordCount + ", " +
                "sum = " + sum + ", " +
                "avg = " + avg + ", " +
                "max = " + max + ", " +
                "min = " + min + ", " +
                "earliestDate = " + earliestDate + ", " +
                "latestDate = " + latestDate + ", " +
                "duration = " + duration + ", " +
                "activityDataNode = " + activityDataNode + ", " +
                "activityDataSet = " + activityDataSet + ")";
    }
}
