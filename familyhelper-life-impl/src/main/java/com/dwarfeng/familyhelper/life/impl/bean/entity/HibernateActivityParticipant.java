package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.impl.bean.key.HibernateActivityParticipantKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernateActivityParticipantKey.class)
@Table(name = "tbl_activity_participant")
public class HibernateActivityParticipant implements Bean {

    private static final long serialVersionUID = 7478274711439564350L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "activity_id", nullable = false)
    private Long activityLongId;

    @Id
    @Column(name = "user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String userStringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
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
            @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernateActivityParticipant() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateActivityParticipantKey getKey() {
        return new HibernateActivityParticipantKey(activityLongId, userStringId);
    }

    public void setKey(HibernateActivityParticipantKey key) {
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
                "remark = " + remark + ", " +
                "activity = " + activity + ", " +
                "user = " + user + ")";
    }
}
