package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 活动数据主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonPoadKey implements Key {

    private static final long serialVersionUID = -2364594750927495388L;

    public static FastJsonPoadKey of(PoadKey poadKey) {
        if (Objects.isNull(poadKey)) {
            return null;
        } else {
            return new FastJsonPoadKey(
                    poadKey.getActivityDataSetLongId(), poadKey.getUserStringId()
            );
        }
    }

    @JSONField(name = "activity_data_set_long_id", ordinal = 1)
    private Long activityDataSetLongId;

    @JSONField(name = "user_string_id", ordinal = 2)
    private String userStringId;

    public FastJsonPoadKey() {
    }

    public FastJsonPoadKey(Long activityDataSetLongId, String userStringId) {
        this.activityDataSetLongId = activityDataSetLongId;
        this.userStringId = userStringId;
    }

    public Long getActivityDataSetLongId() {
        return activityDataSetLongId;
    }

    public void setActivityDataSetLongId(Long activityDataSetLongId) {
        this.activityDataSetLongId = activityDataSetLongId;
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

        FastJsonPoadKey that = (FastJsonPoadKey) o;

        if (!Objects.equals(activityDataSetLongId, that.activityDataSetLongId))
            return false;
        return Objects.equals(userStringId, that.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityDataSetLongId != null ? activityDataSetLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FastJsonPoadKey{" +
                "activityDataSetLongId=" + activityDataSetLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
