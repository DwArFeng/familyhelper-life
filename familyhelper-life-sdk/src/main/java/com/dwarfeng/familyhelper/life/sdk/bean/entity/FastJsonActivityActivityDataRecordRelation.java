package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonLongLongRelationKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动活动数据记录关联。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityActivityDataRecordRelation implements Bean {

    private static final long serialVersionUID = -3544584264472089950L;

    public static FastJsonActivityActivityDataRecordRelation of(ActivityActivityDataRecordRelation stackBean) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new FastJsonActivityActivityDataRecordRelation(
                    FastJsonLongLongRelationKey.of(stackBean.getKey()),
                    stackBean.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongLongRelationKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    public FastJsonActivityActivityDataRecordRelation() {
    }

    public FastJsonActivityActivityDataRecordRelation(FastJsonLongLongRelationKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public FastJsonLongLongRelationKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongLongRelationKey key) {
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
        return "FastJsonActivityActivityDataRecordRelation{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
