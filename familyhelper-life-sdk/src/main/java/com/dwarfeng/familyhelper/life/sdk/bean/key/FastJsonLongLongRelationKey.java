package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 长整型长整型关联主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonLongLongRelationKey implements Key {

    private static final long serialVersionUID = -9003908249407952228L;

    public static FastJsonLongLongRelationKey of(LongLongRelationKey longLongRelationKey) {
        if (Objects.isNull(longLongRelationKey)) {
            return null;
        } else {
            return new FastJsonLongLongRelationKey(
                    longLongRelationKey.getLeftLongId(), longLongRelationKey.getRightLongId()
            );
        }
    }

    @JSONField(name = "left_long_id", ordinal = 1)
    private Long leftLongId;

    @JSONField(name = "right_long_id", ordinal = 2)
    private Long rightLongId;

    public FastJsonLongLongRelationKey() {
    }

    public FastJsonLongLongRelationKey(Long leftLongId, Long rightLongId) {
        this.leftLongId = leftLongId;
        this.rightLongId = rightLongId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FastJsonLongLongRelationKey that = (FastJsonLongLongRelationKey) o;

        if (!Objects.equals(leftLongId, that.leftLongId)) return false;
        return Objects.equals(rightLongId, that.rightLongId);
    }

    @Override
    public int hashCode() {
        int result = leftLongId != null ? leftLongId.hashCode() : 0;
        result = 31 * result + (rightLongId != null ? rightLongId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FastJsonLongLongRelationKey{" +
                "leftLongId=" + leftLongId +
                ", rightLongId=" + rightLongId +
                '}';
    }
}
