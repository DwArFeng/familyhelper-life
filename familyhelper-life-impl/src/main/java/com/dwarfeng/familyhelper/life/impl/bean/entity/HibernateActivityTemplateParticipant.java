package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.impl.bean.key.HibernateActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernateActivityTemplateParticipantKey.class)
@Table(name = "tbl_activity_template_participant")
public class HibernateActivityTemplateParticipant implements Bean {

    private static final long serialVersionUID = -8135727909374991462L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "activity_template_id", nullable = false)
    private Long activityTemplateLongId;

    @Id
    @Column(name = "user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String userStringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityTemplate.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_template_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityTemplate activityTemplate;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernateActivityTemplateParticipant() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateActivityTemplateParticipantKey getKey() {
        return new HibernateActivityTemplateParticipantKey(activityTemplateLongId, userStringId);
    }

    public void setKey(HibernateActivityTemplateParticipantKey key) {
        if (Objects.isNull(key)) {
            this.activityTemplateLongId = null;
            this.userStringId = null;
        } else {
            this.activityTemplateLongId = key.getActivityTemplateLongId();
            this.userStringId = key.getUserStringId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getActivityTemplateLongId() {
        return activityTemplateLongId;
    }

    public void setActivityTemplateLongId(Long activityTemplateLongId) {
        this.activityTemplateLongId = activityTemplateLongId;
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

    public HibernateActivityTemplate getActivityTemplate() {
        return activityTemplate;
    }

    public void setActivityTemplate(HibernateActivityTemplate activityTemplate) {
        this.activityTemplate = activityTemplate;
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
                "activityTemplateLongId = " + activityTemplateLongId + ", " +
                "userStringId = " + userStringId + ", " +
                "remark = " + remark + ", " +
                "activityTemplate = " + activityTemplate + ", " +
                "user = " + user + ")";
    }
}
