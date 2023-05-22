package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonPoatacKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poatac;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 活动模板活动权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonPoatac implements Bean {

    private static final long serialVersionUID = 3547656272013507538L;

    public static FastJsonPoatac of(Poatac poatac) {
        if (Objects.isNull(poatac)) {
            return null;
        } else {
            return new FastJsonPoatac(
                    FastJsonPoatacKey.of(poatac.getKey()),
                    poatac.getPermissionLevel(), poatac.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonPoatacKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonPoatac() {
    }

    public FastJsonPoatac(FastJsonPoatacKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public FastJsonPoatacKey getKey() {
        return key;
    }

    public void setKey(FastJsonPoatacKey key) {
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
        return "FastJsonPoatac{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
