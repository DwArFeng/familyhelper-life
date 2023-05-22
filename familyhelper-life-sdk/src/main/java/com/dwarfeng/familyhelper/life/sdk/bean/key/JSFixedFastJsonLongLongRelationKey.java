package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * JSFixedFastJson 长整型长整型关联主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonLongLongRelationKey implements Key {

    private static final long serialVersionUID = 8339783304577212109L;

    public static JSFixedFastJsonLongLongRelationKey of(LongLongRelationKey longLongRelationKey) {
        if (Objects.isNull(longLongRelationKey)) {
            return null;
        } else {
            return new JSFixedFastJsonLongLongRelationKey(
                    longLongRelationKey.getLeftLongId(), longLongRelationKey.getRightLongId()
            );
        }
    }

    @JSONField(name = "left_long_id", ordinal = 1, serializeUsing = ToStringSerializer.class)
    private Long leftLongId;

    @JSONField(name = "right_long_id", ordinal = 2, serializeUsing = ToStringSerializer.class)
    private Long rightLongId;

    public JSFixedFastJsonLongLongRelationKey() {
    }

    public JSFixedFastJsonLongLongRelationKey(Long leftLongId, Long rightLongId) {
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

        JSFixedFastJsonLongLongRelationKey that = (JSFixedFastJsonLongLongRelationKey) o;

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
        return "JSFixedFastJsonLongLongRelationKey{" +
                "leftLongId=" + leftLongId +
                ", rightLongId=" + rightLongId +
                '}';
    }
}
