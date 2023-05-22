package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Optional;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_activity_template_driver_info")
public class HibernateActivityTemplateDriverInfo implements Bean {

    private static final long serialVersionUID = 1637721034767904865L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "activity_template_id")
    private Long activityTemplateLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "type", length = Constraints.LENGTH_TYPE)
    private String type;

    @Column(name = "param", columnDefinition = "TEXT")
    private String param;

    @Column(name = "remind_flag")
    private boolean remindFlag;

    @Column(name = "generate_flag")
    private boolean generateFlag;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivityTemplate.class)
    @JoinColumns({ //
            @JoinColumn(name = "activity_template_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityTemplate activityTemplate;

    public HibernateActivityTemplateDriverInfo() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateLongIdKey getActivityTemplateKey() {
        return Optional.ofNullable(activityTemplateLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setActivityTemplateKey(HibernateLongIdKey idKey) {
        this.activityTemplateLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }

    public Long getActivityTemplateLongId() {
        return activityTemplateLongId;
    }

    public void setActivityTemplateLongId(Long activityTemplateLongId) {
        this.activityTemplateLongId = activityTemplateLongId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isRemindFlag() {
        return remindFlag;
    }

    public void setRemindFlag(boolean remindFlag) {
        this.remindFlag = remindFlag;
    }

    public boolean isGenerateFlag() {
        return generateFlag;
    }

    public void setGenerateFlag(boolean generateFlag) {
        this.generateFlag = generateFlag;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "activityTemplateLongId = " + activityTemplateLongId + ", " +
                "enabled = " + enabled + ", " +
                "type = " + type + ", " +
                "param = " + param + ", " +
                "remindFlag = " + remindFlag + ", " +
                "generateFlag = " + generateFlag + ", " +
                "remark = " + remark + ", " +
                "activityTemplate = " + activityTemplate + ")";
    }
}
