package com.dwarfeng.familyhelper.life.stack.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * 活动数据集合权限主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class PoadKey implements Key {

    private static final long serialVersionUID = 4418702594736226144L;

    private Long activityDataSetLongId;
    private String userStringId;

    public PoadKey() {
    }

    public PoadKey(Long activityDataSetLongId, String userStringId) {
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

        PoadKey poadKey = (PoadKey) o;

        if (!Objects.equals(activityDataSetLongId, poadKey.activityDataSetLongId))
            return false;
        return Objects.equals(userStringId, poadKey.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityDataSetLongId != null ? activityDataSetLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PoadKey{" +
                "activityDataSetLongId=" + activityDataSetLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
