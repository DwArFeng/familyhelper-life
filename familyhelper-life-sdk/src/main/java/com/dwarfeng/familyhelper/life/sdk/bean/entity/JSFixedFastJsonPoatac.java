package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonPoatacKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poatac;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 活动模板活动权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonPoatac implements Bean {

    private static final long serialVersionUID = 5609262293768544579L;

    public static JSFixedFastJsonPoatac of(Poatac poatac) {
        if (Objects.isNull(poatac)) {
            return null;
        } else {
            return new JSFixedFastJsonPoatac(
                    JSFixedFastJsonPoatacKey.of(poatac.getKey()),
                    poatac.getPermissionLevel(), poatac.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonPoatacKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public JSFixedFastJsonPoatac() {
    }

    public JSFixedFastJsonPoatac(JSFixedFastJsonPoatacKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public JSFixedFastJsonPoatacKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonPoatacKey key) {
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
        return "JSFixedFastJsonPoatac{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
