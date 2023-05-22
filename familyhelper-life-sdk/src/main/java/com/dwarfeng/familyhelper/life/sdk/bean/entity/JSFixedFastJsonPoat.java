package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonPoatKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poat;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 活动模板权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonPoat implements Bean {

    private static final long serialVersionUID = 478188599167708549L;

    public static JSFixedFastJsonPoat of(Poat poat) {
        if (Objects.isNull(poat)) {
            return null;
        } else {
            return new JSFixedFastJsonPoat(
                    JSFixedFastJsonPoatKey.of(poat.getKey()),
                    poat.getPermissionLevel(), poat.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonPoatKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public JSFixedFastJsonPoat() {
    }

    public JSFixedFastJsonPoat(JSFixedFastJsonPoatKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public JSFixedFastJsonPoatKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonPoatKey key) {
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
        return "JSFixedFastJsonPoat{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
