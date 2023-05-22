package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonPoatKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poat;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动模板权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonPoat implements Bean {

    private static final long serialVersionUID = 7339407164376687194L;

    public static FastJsonPoat of(Poat poat) {
        if (Objects.isNull(poat)) {
            return null;
        } else {
            return new FastJsonPoat(
                    FastJsonPoatKey.of(poat.getKey()),
                    poat.getPermissionLevel(), poat.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonPoatKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonPoat() {
    }

    public FastJsonPoat(FastJsonPoatKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public FastJsonPoatKey getKey() {
        return key;
    }

    public void setKey(FastJsonPoatKey key) {
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
        return "FastJsonPoat{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
