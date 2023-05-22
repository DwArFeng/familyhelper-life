package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 活动数据集合权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class Poad implements Entity<PoadKey> {

    private static final long serialVersionUID = 4349724973213133669L;

    private PoadKey key;
    private int permissionLevel;
    private String remark;

    public Poad() {
    }

    public Poad(PoadKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    @Override
    public PoadKey getKey() {
        return key;
    }

    @Override
    public void setKey(PoadKey key) {
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
        return "Poad{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
