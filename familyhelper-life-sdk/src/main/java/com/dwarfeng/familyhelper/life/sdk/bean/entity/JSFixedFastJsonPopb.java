package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonPopbKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 个人最佳权限。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonPopb implements Bean {

    private static final long serialVersionUID = -5977511554383109295L;

    public static JSFixedFastJsonPopb of(Popb popb) {
        if (Objects.isNull(popb)) {
            return null;
        } else {
            return new JSFixedFastJsonPopb(
                    JSFixedFastJsonPopbKey.of(popb.getKey()), popb.getPermissionLevel(), popb.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonPopbKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public JSFixedFastJsonPopb() {
    }

    public JSFixedFastJsonPopb(JSFixedFastJsonPopbKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public JSFixedFastJsonPopbKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonPopbKey key) {
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
        return "JSFixedFastJsonPopb{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
