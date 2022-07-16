package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionUpsertInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 个人最佳权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbSetPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = 5276845432632956927L;

    public static PbSetPermissionUpsertInfo toStackBean(WebInputPbSetPermissionUpsertInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new PbSetPermissionUpsertInfo(
                    WebInputLongIdKey.toStackBean(webInput.getPbSetKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getPermissionLevel()
            );
        }
    }

    @JSONField(name = "pb_set_key")
    @Valid
    private WebInputLongIdKey pbSetKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "permission_level")
    private int permissionLevel;

    public WebInputPbSetPermissionUpsertInfo() {
    }

    public WebInputLongIdKey getPbSetKey() {
        return pbSetKey;
    }

    public void setPbSetKey(WebInputLongIdKey pbSetKey) {
        this.pbSetKey = pbSetKey;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "WebInputPbSetPermissionUpsertInfo{" +
                "pbSetKey=" + pbSetKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
