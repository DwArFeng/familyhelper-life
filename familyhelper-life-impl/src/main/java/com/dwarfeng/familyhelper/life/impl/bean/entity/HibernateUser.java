package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateStringIdKey.class)
@Table(name = "tbl_user")
public class HibernateUser implements Bean {

    private static final long serialVersionUID = -2145013469605786487L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true, length = Constraints.LENGTH_USER)
    private String stringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePopb.class, mappedBy = "user")
    private Set<HibernatePopb> popbs = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityParticipant.class, mappedBy = "user")
    private Set<HibernateActivityParticipant> activityParticipants = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateActivityTemplateParticipant.class, mappedBy = "user")
    private Set<HibernateActivityTemplateParticipant> activityTemplateParticipants = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoad.class, mappedBy = "user")
    private Set<HibernatePoad> poads = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoac.class, mappedBy = "user")
    private Set<HibernatePoac> poacs = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoat.class, mappedBy = "user")
    private Set<HibernatePoat> poats = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoatac.class, mappedBy = "user")
    private Set<HibernatePoatac> poatacs = new HashSet<>();

    public HibernateUser() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateStringIdKey getKey() {
        return Optional.ofNullable(stringId).map(HibernateStringIdKey::new).orElse(null);
    }

    public void setKey(HibernateStringIdKey idKey) {
        this.stringId = Optional.ofNullable(idKey).map(HibernateStringIdKey::getStringId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<HibernatePopb> getPopbs() {
        return popbs;
    }

    public void setPopbs(Set<HibernatePopb> popbs) {
        this.popbs = popbs;
    }

    public Set<HibernateActivityParticipant> getActivityParticipants() {
        return activityParticipants;
    }

    public void setActivityParticipants(Set<HibernateActivityParticipant> activityParticipants) {
        this.activityParticipants = activityParticipants;
    }

    public Set<HibernateActivityTemplateParticipant> getActivityTemplateParticipants() {
        return activityTemplateParticipants;
    }

    public void setActivityTemplateParticipants(Set<HibernateActivityTemplateParticipant> activityTemplateParticipants) {
        this.activityTemplateParticipants = activityTemplateParticipants;
    }

    public Set<HibernatePoad> getPoads() {
        return poads;
    }

    public void setPoads(Set<HibernatePoad> poads) {
        this.poads = poads;
    }

    public Set<HibernatePoac> getPoacs() {
        return poacs;
    }

    public void setPoacs(Set<HibernatePoac> poacs) {
        this.poacs = poacs;
    }

    public Set<HibernatePoat> getPoats() {
        return poats;
    }

    public void setPoats(Set<HibernatePoat> poats) {
        this.poats = poats;
    }

    public Set<HibernatePoatac> getPoatacs() {
        return poatacs;
    }

    public void setPoatacs(Set<HibernatePoatac> poatacs) {
        this.poatacs = poatacs;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "stringId = " + stringId + ", " +
                "remark = " + remark + ")";
    }
}
