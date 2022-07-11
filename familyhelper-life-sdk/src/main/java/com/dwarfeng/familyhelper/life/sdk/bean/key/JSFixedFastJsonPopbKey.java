package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * JSFixed FastJson 个人最佳权限主键。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonPopbKey implements Key {

    private static final long serialVersionUID = -440128343621175625L;

    public static JSFixedFastJsonPopbKey of(PopbKey key) {
        if (Objects.isNull(key)) {
            return null;
        } else {
            return new JSFixedFastJsonPopbKey(key.getPbLongId(), key.getUserStringId());
        }
    }

    @JSONField(name = "pb_long_id", ordinal = 1, serializeUsing = ToStringSerializer.class)
    private Long pbLongId;

    @JSONField(name = "user_string_id", ordinal = 2)
    private String userStringId;

    public JSFixedFastJsonPopbKey() {
    }

    public JSFixedFastJsonPopbKey(Long pbLongId, String userStringId) {
        this.pbLongId = pbLongId;
        this.userStringId = userStringId;
    }

    public Long getPbLongId() {
        return pbLongId;
    }

    public void setPbLongId(Long pbLongId) {
        this.pbLongId = pbLongId;
    }

    public String getUserStringId() {
        return userStringId;
    }

    public void setUserStringId(String userStringId) {
        this.userStringId = userStringId;
    }

    @Override
    public String toString() {
        return "JSFixedFastJsonPopbKey{" +
                "pbLongId=" + pbLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
