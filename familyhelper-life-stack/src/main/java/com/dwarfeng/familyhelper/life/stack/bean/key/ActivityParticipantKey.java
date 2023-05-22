package com.dwarfeng.familyhelper.life.stack.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * 活动参与者主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityParticipantKey implements Key {

    private static final long serialVersionUID = -5939396642720311531L;

    private Long activityLongId;
    private String userStringId;

    public ActivityParticipantKey() {
    }

    public ActivityParticipantKey(Long activityLongId, String userStringId) {
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

        ActivityParticipantKey that = (ActivityParticipantKey) o;

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
        return "ActivityParticipantKey{" +
                "activityLongId=" + activityLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
