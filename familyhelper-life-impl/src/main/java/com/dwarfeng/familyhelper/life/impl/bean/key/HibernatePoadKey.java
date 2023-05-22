package com.dwarfeng.familyhelper.life.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 活动数据主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class HibernatePoadKey implements Key {

    private static final long serialVersionUID = -7766885753056121723L;

    private Long activityDataSetLongId;
    private String userStringId;

    public HibernatePoadKey() {
    }

    public HibernatePoadKey(Long activityDataSetLongId, String userStringId) {
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

        HibernatePoadKey that = (HibernatePoadKey) o;

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
        return "HibernatePoadKey{" +
                "activityDataSetLongId=" + activityDataSetLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
