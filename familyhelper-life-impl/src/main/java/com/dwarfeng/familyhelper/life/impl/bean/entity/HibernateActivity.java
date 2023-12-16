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
@Table(name = "tbl_activity")
public class HibernateActivity implements Bean {

    private static final long serialVersionUID = -6383938328794476177L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "activity_type", length = Constraints.LENGTH_TYPE)
    private String activityType;

    @Column(name = "name", length = Constraints.LENGTH_NAME, nullable = false)
    private String name;

    @Column(name = "score")
    private int score;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "inspected_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inspectedDate;

    @Column(name = "locked_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedDate;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityParticipant.class, mappedBy = "activity")
    private Set<HibernateActivityParticipant> activityParticipants = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityCoverInfo.class, mappedBy = "activity")
    private Set<HibernateActivityCoverInfo> activityCoverInfos = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityFileInfo.class, mappedBy = "activity")
    private Set<HibernateActivityFileInfo> activityFileInfos = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoac.class, mappedBy = "activity")
    private Set<HibernatePoac> poacs = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityDataRecord.class, mappedBy = "activity")
    private Set<HibernateActivityDataRecord> activityDataRecords = new HashSet<>();

    public HibernateActivity() {
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

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Set<HibernateActivityParticipant> getActivityParticipants() {
        return activityParticipants;
    }

    public void setActivityParticipants(Set<HibernateActivityParticipant> activityParticipants) {
        this.activityParticipants = activityParticipants;
    }

    public Set<HibernateActivityCoverInfo> getActivityCoverInfos() {
        return activityCoverInfos;
    }

    public void setActivityCoverInfos(Set<HibernateActivityCoverInfo> activityCoverInfos) {
        this.activityCoverInfos = activityCoverInfos;
    }

    public Set<HibernateActivityFileInfo> getActivityFileInfos() {
        return activityFileInfos;
    }

    public void setActivityFileInfos(Set<HibernateActivityFileInfo> activityFileInfos) {
        this.activityFileInfos = activityFileInfos;
    }

    public Set<HibernatePoac> getPoacs() {
        return poacs;
    }

    public void setPoacs(Set<HibernatePoac> poacs) {
        this.poacs = poacs;
    }

    public Set<HibernateActivityDataRecord> getActivityDataRecords() {
        return activityDataRecords;
    }

    public void setActivityDataRecords(Set<HibernateActivityDataRecord> activityDataRecords) {
        this.activityDataRecords = activityDataRecords;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "activityType = " + activityType + ", " +
                "name = " + name + ", " +
                "score = " + score + ", " +
                "remark = " + remark + ", " +
                "locked = " + locked + ", " +
                "startDate = " + startDate + ", " +
                "endDate = " + endDate + ", " +
                "createdDate = " + createdDate + ", " +
                "modifiedDate = " + modifiedDate + ", " +
                "inspectedDate = " + inspectedDate + ", " +
                "lockedDate = " + lockedDate + ")";
    }
}
