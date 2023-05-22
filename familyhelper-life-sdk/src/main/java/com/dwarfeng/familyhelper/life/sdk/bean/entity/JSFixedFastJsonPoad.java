package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.JSFixedFastJsonPoadKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 活动权限。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonPoad implements Bean {

    private static final long serialVersionUID = -1367169597916339780L;

    public static JSFixedFastJsonPoad of(Poad poad) {
        if (Objects.isNull(poad)) {
            return null;
        } else {
            return new JSFixedFastJsonPoad(
                    JSFixedFastJsonPoadKey.of(poad.getKey()),
                    poad.getPermissionLevel(), poad.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonPoadKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public JSFixedFastJsonPoad() {
    }

    public JSFixedFastJsonPoad(JSFixedFastJsonPoadKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public JSFixedFastJsonPoadKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonPoadKey key) {
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
        return "JSFixedFastJsonPoad{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
