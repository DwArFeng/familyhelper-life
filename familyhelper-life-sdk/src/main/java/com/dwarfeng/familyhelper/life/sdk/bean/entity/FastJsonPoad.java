package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonPoadKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonPoad implements Bean {

    private static final long serialVersionUID = 6928391764658300649L;

    public static FastJsonPoad of(Poad poad) {
        if (Objects.isNull(poad)) {
            return null;
        } else {
            return new FastJsonPoad(
                    FastJsonPoadKey.of(poad.getKey()),
                    poad.getPermissionLevel(), poad.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonPoadKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonPoad() {
    }

    public FastJsonPoad(FastJsonPoadKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public FastJsonPoadKey getKey() {
        return key;
    }

    public void setKey(FastJsonPoadKey key) {
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
        return "FastJsonPoad{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
