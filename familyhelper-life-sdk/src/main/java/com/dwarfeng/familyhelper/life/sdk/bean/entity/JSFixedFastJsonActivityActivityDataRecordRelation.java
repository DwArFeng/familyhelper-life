package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonLongLongRelationKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 活动活动数据记录关联。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityActivityDataRecordRelation implements Bean {

    private static final long serialVersionUID = 8927168073483353914L;

    public static JSFixedFastJsonActivityActivityDataRecordRelation of(ActivityActivityDataRecordRelation stackBean) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityActivityDataRecordRelation(
                    JSFixedFastJsonLongLongRelationKey.of(stackBean.getKey()),
                    stackBean.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongLongRelationKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    public JSFixedFastJsonActivityActivityDataRecordRelation() {
    }

    public JSFixedFastJsonActivityActivityDataRecordRelation(JSFixedFastJsonLongLongRelationKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    public JSFixedFastJsonLongLongRelationKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongLongRelationKey key) {
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
        return "JSFixedFastJsonActivityActivityDataRecordRelation{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
