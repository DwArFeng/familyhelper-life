package com.dwarfeng.familyhelper.life.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 长整型长整型关联主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class HibernateLongLongRelationKey implements Key {

    private static final long serialVersionUID = -2628383142956610756L;

    private Long leftLongId;
    private Long rightLongId;

    public HibernateLongLongRelationKey() {
    }

    public HibernateLongLongRelationKey(Long leftLongId, Long rightLongId) {
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

        HibernateLongLongRelationKey that = (HibernateLongLongRelationKey) o;

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
        return "HibernateLongLongRelationKey{" +
                "leftLongId=" + leftLongId +
                ", rightLongId=" + rightLongId +
                '}';
    }
}
