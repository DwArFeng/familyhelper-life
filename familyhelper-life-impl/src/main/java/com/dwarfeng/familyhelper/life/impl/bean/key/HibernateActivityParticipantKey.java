package com.dwarfeng.familyhelper.life.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 活动参与者主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class HibernateActivityParticipantKey implements Key {

    private static final long serialVersionUID = 6296914172063076438L;

    private Long activityLongId;
    private String userStringId;

    public HibernateActivityParticipantKey() {
    }

    public HibernateActivityParticipantKey(Long activityLongId, String userStringId) {
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

        HibernateActivityParticipantKey that = (HibernateActivityParticipantKey) o;

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
        return "HibernateActivityParticipantKey{" +
                "activityLongId=" + activityLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
