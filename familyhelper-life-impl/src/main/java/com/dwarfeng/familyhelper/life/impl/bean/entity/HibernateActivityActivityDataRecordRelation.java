package com.dwarfeng.familyhelper.life.impl.bean.entity;

import com.dwarfeng.familyhelper.life.impl.bean.key.HibernateLongLongRelationKey;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernateLongLongRelationKey.class)
@Table(name = "tbl_activity_activity_data_record_relation")
public class HibernateActivityActivityDataRecordRelation implements Bean {

    private static final long serialVersionUID = 8929580239371414120L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "left_id", nullable = false)
    private Long leftLongId;

    @Id
    @Column(name = "right_id", nullable = false)
    private Long rightLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateActivity.class)
    @JoinColumns({ //
            @JoinColumn(name = "left_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivity activity;

    @ManyToOne(targetEntity = HibernateActivityDataRecord.class)
    @JoinColumns({ //
            @JoinColumn(name = "right_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateActivityDataRecord activityDataRecord;

    public HibernateActivityActivityDataRecordRelation() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongLongRelationKey getKey() {
        return new HibernateLongLongRelationKey(leftLongId, rightLongId);
    }

    public void setKey(HibernateLongLongRelationKey key) {
        if (Objects.isNull(key)) {
            this.leftLongId = null;
            this.rightLongId = null;
        } else {
            this.leftLongId = key.getLeftLongId();
            this.rightLongId = key.getRightLongId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLeftLongId() {
        return leftLongId;
    }

    public void setLeftLongId(Long leftLongId) {
        this.leftLongId = leftLongId;
    }

    public Long getRightLongId() {
        return rightLongId;
    }

    public void setRightLongId(Long rightLongId) {
        this.rightLongId = rightLongId;
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

    public HibernateActivityDataRecord getActivityDataRecord() {
        return activityDataRecord;
    }

    public void setActivityDataRecord(HibernateActivityDataRecord activityDataRecord) {
        this.activityDataRecord = activityDataRecord;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "leftLongId = " + leftLongId + ", " +
                "rightLongId = " + rightLongId + ", " +
                "remark = " + remark + ", " +
                "activity = " + activity + ", " +
                "activityDataRecord = " + activityDataRecord + ")";
    }
}
