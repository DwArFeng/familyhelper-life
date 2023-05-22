package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * JSFixedFastJson 活动权限主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonPoacKey implements Key {

    private static final long serialVersionUID = 8141959125641769139L;

    public static JSFixedFastJsonPoacKey of(PoacKey poacKey) {
        if (Objects.isNull(poacKey)) {
            return null;
        } else {
            return new JSFixedFastJsonPoacKey(
                    poacKey.getActivityLongId(), poacKey.getUserStringId()
            );
        }
    }

    @JSONField(name = "activity_long_id", ordinal = 1, serializeUsing = ToStringSerializer.class)
    private Long activityLongId;

    @JSONField(name = "user_string_id", ordinal = 2)
    private String userStringId;

    public JSFixedFastJsonPoacKey() {
    }

    public JSFixedFastJsonPoacKey(Long activityLongId, String userStringId) {
        this.activityLongId = activityLongId;
        this.userStringId = userStringId;
    }

    public Long getActivityLongId() {
        return activityLongId;
    }

    public void setActivityLongId(Long activityLongId) {
        this.activityLongId = activityLongId;
    }

    public String getUserStringId() {
        return userStringId;
    }

    public void setUserStringId(String userStringId) {
        this.userStringId = userStringId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSFixedFastJsonPoacKey that = (JSFixedFastJsonPoacKey) o;

        if (!Objects.equals(activityLongId, that.activityLongId))
            return false;
        return Objects.equals(userStringId, that.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityLongId != null ? activityLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JSFixedFastJsonPoacKey{" +
                "activityLongId=" + activityLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
