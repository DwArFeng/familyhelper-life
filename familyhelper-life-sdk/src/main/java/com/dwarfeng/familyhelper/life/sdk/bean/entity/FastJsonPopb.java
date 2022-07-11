package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonPopbKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 个人最佳权限。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class FastJsonPopb implements Bean {

    private static final long serialVersionUID = 3450138286551323620L;

    public static FastJsonPopb of(Popb popb) {
        if (Objects.isNull(popb)) {
            return null;
        } else {
            return new FastJsonPopb(FastJsonPopbKey.of(popb.getKey()), popb.getPermissionLevel(), popb.getRemark());
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonPopbKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonPopb() {
    }

    public FastJsonPopb(FastJsonPopbKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public FastJsonPopbKey getKey() {
        return key;
    }

    public void setKey(FastJsonPopbKey key) {
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
        return "FastJsonPopb{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
