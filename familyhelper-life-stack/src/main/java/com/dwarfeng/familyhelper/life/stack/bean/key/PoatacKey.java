package com.dwarfeng.familyhelper.life.stack.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * 活动模板活动权限主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class PoatacKey implements Key {

    private static final long serialVersionUID = 4153816996791236898L;

    private Long activityTemplateLongId;
    private String userStringId;

    public PoatacKey() {
    }

    public PoatacKey(Long activityTemplateLongId, String userStringId) {
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

        PoatacKey poatacKey = (PoatacKey) o;

        if (!Objects.equals(activityTemplateLongId, poatacKey.activityTemplateLongId))
            return false;
        return Objects.equals(userStringId, poatacKey.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityTemplateLongId != null ? activityTemplateLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PoatacKey{" +
                "activityTemplateLongId=" + activityTemplateLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
