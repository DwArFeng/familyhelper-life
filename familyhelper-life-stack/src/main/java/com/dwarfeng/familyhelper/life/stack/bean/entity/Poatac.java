package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.PoatacKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 活动模板活动权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class Poatac implements Entity<PoatacKey> {

    private static final long serialVersionUID = 2751176141397158982L;

    private PoatacKey key;
    private int permissionLevel;
    private String remark;

    public Poatac() {
    }

    public Poatac(PoatacKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    @Override
    public PoatacKey getKey() {
        return key;
    }

    @Override
    public void setKey(PoatacKey key) {
        this.key = key;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Poatac{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
