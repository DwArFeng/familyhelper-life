package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.PoatKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 活动模板权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class Poat implements Entity<PoatKey> {

    private static final long serialVersionUID = 7628312078790836905L;

    private PoatKey key;
    private int permissionLevel;
    private String remark;

    public Poat() {
    }

    public Poat(PoatKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    @Override
    public PoatKey getKey() {
        return key;
    }

    @Override
    public void setKey(PoatKey key) {
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
        return "Poat{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
