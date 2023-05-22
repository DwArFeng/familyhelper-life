package com.dwarfeng.familyhelper.life.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 活动模板参与者主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class HibernateActivityTemplateParticipantKey implements Key {

    private static final long serialVersionUID = 5034421221692010137L;

    private Long activityTemplateLongId;
    private String userStringId;

    public HibernateActivityTemplateParticipantKey() {
    }

    public HibernateActivityTemplateParticipantKey(Long activityTemplateLongId, String userStringId) {
        this.activityTemplateLongId = activityTemplateLongId;
        this.userStringId = userStringId;
    }

    public Long getActivityTemplateLongId() {
        return activityTemplateLongId;
    }

    public void setActivityTemplateLongId(Long activityTemplateLongId) {
        this.activityTemplateLongId = activityTemplateLongId;
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

        HibernateActivityTemplateParticipantKey that = (HibernateActivityTemplateParticipantKey) o;

        if (!Objects.equals(activityTemplateLongId, that.activityTemplateLongId))
            return false;
        return Objects.equals(userStringId, that.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityTemplateLongId != null ? activityTemplateLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HibernateActivityTemplateParticipantKey{" +
                "activityTemplateLongId=" + activityTemplateLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
