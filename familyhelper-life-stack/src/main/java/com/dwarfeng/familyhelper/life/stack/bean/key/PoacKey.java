package com.dwarfeng.familyhelper.life.stack.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * 活动权限主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class PoacKey implements Key {

    private static final long serialVersionUID = 950492259501093765L;

    private Long activityLongId;
    private String userStringId;

    public PoacKey() {
    }

    public PoacKey(Long activityLongId, String userStringId) {
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

        PoacKey poacKey = (PoacKey) o;

        if (!Objects.equals(activityLongId, poacKey.activityLongId))
            return false;
        return Objects.equals(userStringId, poacKey.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityLongId != null ? activityLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PoacKey{" +
                "activityLongId=" + activityLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
