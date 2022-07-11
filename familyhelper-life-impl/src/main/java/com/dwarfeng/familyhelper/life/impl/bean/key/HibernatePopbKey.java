package com.dwarfeng.familyhelper.life.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 个人最佳权限主键。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class HibernatePopbKey implements Key {

    private static final long serialVersionUID = 3773148582748561070L;

    private Long pbLongId;
    private String userStringId;

    public HibernatePopbKey() {
    }

    public HibernatePopbKey(Long pbLongId, String userStringId) {
        this.pbLongId = pbLongId;
        this.userStringId = userStringId;
    }

    public Long getPbLongId() {
        return pbLongId;
    }

    public void setPbLongId(Long pbLongId) {
        this.pbLongId = pbLongId;
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

        HibernatePopbKey popbKey = (HibernatePopbKey) o;

        if (!Objects.equals(pbLongId, popbKey.pbLongId)) return false;
        return Objects.equals(userStringId, popbKey.userStringId);
    }

    @Override
    public int hashCode() {
        int result = pbLongId != null ? pbLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HibernatePopbKey{" +
                "pbLongId=" + pbLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
