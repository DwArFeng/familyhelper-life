package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.impl.bean.key.HibernatePopbKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernatePopbKey.class)
@Table(name = "tbl_popb")
public class HibernatePopb implements Bean {

    private static final long serialVersionUID = -5793982172048613982L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "pb_id", nullable = false)
    private Long pbLongId;

    @Id
    @Column(name = "user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String userStringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "permission_level")
    private int permissionLevel;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernatePbSet.class)
    @JoinColumns({ //
            @JoinColumn(name = "pb_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernatePbSet pbSet;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernatePopb() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernatePopbKey getKey() {
        return new HibernatePopbKey(pbLongId, userStringId);
    }

    public void setKey(HibernatePopbKey key) {
        if (Objects.isNull(key)) {
            this.pbLongId = null;
            this.userStringId = null;
        } else {
            this.pbLongId = key.getPbLongId();
            this.userStringId = key.getUserStringId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getPbLongId() {
        return pbLongId;
    }

    public void setPbLongId(Long pbLongId) {
        this.pbLongId = pbLongId;
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

    public HibernatePbSet getPbSet() {
        return pbSet;
    }

    public void setPbSet(HibernatePbSet pbSet) {
        this.pbSet = pbSet;
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
                "pbLongId = " + pbLongId + ", " +
                "userStringId = " + userStringId + ", " +
                "permissionLevel = " + permissionLevel + ", " +
                "remark = " + remark + ", " +
                "pbSet = " + pbSet + ", " +
                "user = " + user + ")";
    }
}
