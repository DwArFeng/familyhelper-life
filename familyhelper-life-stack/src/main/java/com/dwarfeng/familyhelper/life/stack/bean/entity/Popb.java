package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 个人最佳权限。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class Popb implements Entity<PopbKey> {

    private static final long serialVersionUID = 4779540282956797629L;

    private PopbKey key;
    private int permissionLevel;
    private String remark;

    public Popb() {
    }

    public Popb(PopbKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;

    }

    @Override
    public PopbKey getKey() {
        return key;
    }

    @Override
    public void setKey(PopbKey key) {
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
        return "Popb{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
