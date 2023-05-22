package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 活动活动数据记录关联。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityActivityDataRecordRelation implements Entity<LongLongRelationKey> {

    private static final long serialVersionUID = 7772232714262255406L;

    private LongLongRelationKey key;
    private String remark;

    public ActivityActivityDataRecordRelation() {
    }

    public ActivityActivityDataRecordRelation(LongLongRelationKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    @Override
    public LongLongRelationKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongLongRelationKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityActivityDataRecordRelation{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
