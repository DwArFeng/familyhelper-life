package com.dwarfeng.familyhelper.life.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 活动模板权限主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class HibernatePoatKey implements Key {

    private static final long serialVersionUID = 2709128824785195445L;

    private Long activityTemplateLongId;
    private String userStringId;

    public HibernatePoatKey() {
    }

    public HibernatePoatKey(Long activityTemplateLongId, String userStringId) {
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

        HibernatePoatKey that = (HibernatePoatKey) o;

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
        return "HibernatePoatKey{" +
                "activityTemplateLongId=" + activityTemplateLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
