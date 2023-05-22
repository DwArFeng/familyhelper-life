package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTypeIndicator;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动类型指示器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityTypeIndicator implements Bean {

    private static final long serialVersionUID = -3325300392303299822L;

    public static FastJsonActivityTypeIndicator of(ActivityTypeIndicator activityTypeIndicator) {
        if (Objects.isNull(activityTypeIndicator)) {
            return null;
        } else {
            return new FastJsonActivityTypeIndicator(
                    FastJsonStringIdKey.of(activityTypeIndicator.getKey()),
                    activityTypeIndicator.getLabel(), activityTypeIndicator.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "label", ordinal = 2)
    private String label;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonActivityTypeIndicator() {
    }

    public FastJsonActivityTypeIndicator(FastJsonStringIdKey key, String label, String remark) {
        this.key = key;
        this.label = label;
        this.remark = remark;
    }

    public FastJsonStringIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonStringIdKey key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonActivityTypeIndicator{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
