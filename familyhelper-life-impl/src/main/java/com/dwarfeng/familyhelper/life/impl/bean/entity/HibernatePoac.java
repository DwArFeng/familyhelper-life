package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.impl.bean.key.HibernatePoacKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernatePoacKey.class)
@Table(name = "tbl_poac")
public class HibernatePoac implements Bean {

    private static final long serialVersionUID = -6526634330952006318L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "activity_id", nullable = false)
    private Long activityLongId;

    @Id
    @Column(name = "user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String userStringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "permission_level")
    private int permissionLevel;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivity.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivity activity;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "string_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernatePoac() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernatePoacKey getKey() {
        return new HibernatePoacKey(activityLongId, userStringId);
    }

    public void setKey(HibernatePoacKey key) {
        if (Objects.isNull(key)) {
            this.activityLongId = null;
            this.userStringId = null;
        } else {
            this.activityLongId = key.getActivityLongId();
            this.userStringId = key.getUserStringId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getActivityLongId() {
        return activityLongId;
    }

    public void setActivityLongId(Long activityLongId) {
        this.activityLongId = activityLongId;
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

    public HibernateActivity getActivity() {
        return activity;
    }

    public void setActivity(HibernateActivity activity) {
        this.activity = activity;
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
                "activityLongId = " + activityLongId + ", " +
                "userStringId = " + userStringId + ", " +
                "permissionLevel = " + permissionLevel + ", " +
                "remark = " + remark + ", " +
                "activity = " + activity + ", " +
                "user = " + user + ")";
    }
}
