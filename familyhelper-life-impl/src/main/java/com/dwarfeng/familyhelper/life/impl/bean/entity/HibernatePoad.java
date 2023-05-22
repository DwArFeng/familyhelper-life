package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.impl.bean.key.HibernatePoadKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernatePoadKey.class)
@Table(name = "tbl_poad")
public class HibernatePoad implements Bean {

    private static final long serialVersionUID = -8535790806010524474L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "activity_data_set_id", nullable = false)
    private Long activityDataSetLongId;

    @Id
    @Column(name = "user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String userStringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "permission_level")
    private int permissionLevel;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityDataSet.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_data_set_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataSet activityDataSet;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernatePoad() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernatePoadKey getKey() {
        return new HibernatePoadKey(activityDataSetLongId, userStringId);
    }

    public void setKey(HibernatePoadKey key) {
        if (Objects.isNull(key)) {
            this.activityDataSetLongId = null;
            this.userStringId = null;
        } else {
            this.activityDataSetLongId = key.getActivityDataSetLongId();
            this.userStringId = key.getUserStringId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getActivityDataSetLongId() {
        return activityDataSetLongId;
    }

    public void setActivityDataSetLongId(Long activityDataSetLongId) {
        this.activityDataSetLongId = activityDataSetLongId;
    }

    public String getUserStringId() {
        return userStringId;
    }

    public void setUserStringId(String userStringId) {
        this.userStringId = userStringId;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernateActivityDataSet getActivityDataSet() {
        return activityDataSet;
    }

    public void setActivityDataSet(HibernateActivityDataSet activityDataSet) {
        this.activityDataSet = activityDataSet;
    }

    public HibernateUser getUser() {
        return user;
    }

    public void setUser(HibernateUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "activityDataSetLongId = " + activityDataSetLongId + ", " +
                "userStringId = " + userStringId + ", " +
                "permissionLevel = " + permissionLevel + ", " +
                "remark = " + remark + ", " +
                "activityDataSet = " + activityDataSet + ", " +
                "user = " + user + ")";
    }
}
