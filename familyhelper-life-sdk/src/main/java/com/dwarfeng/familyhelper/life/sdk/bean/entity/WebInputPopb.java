package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.bean.key.WebInputPopbKey;
import com.dwarfeng.familyhelper.life.sdk.util.ValidPermissionLevel;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 个人最佳权限。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPopb implements Bean {

    private static final long serialVersionUID = 6528133524197195662L;

    public static Popb toStackBean(WebInputPopb webInputPopb) {
        if (Objects.isNull(webInputPopb)) {
            return null;
        } else {
            return new Popb(
                    WebInputPopbKey.toStackBean(webInputPopb.getKey()),
                    webInputPopb.getPermissionLevel(),
                    webInputPopb.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    @Valid
    private WebInputPopbKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    @ValidPermissionLevel
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public WebInputPopb() {
    }

    public WebInputPopbKey getKey() {
        return key;
    }

    public void setKey(WebInputPopbKey key) {
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
        return "WebInputPopb{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
