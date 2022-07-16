package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionRemoveInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 个人最佳权限删除信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbSetPermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 9175809674664133036L;

    public static PbSetPermissionRemoveInfo toStackBean(WebInputPbSetPermissionRemoveInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new PbSetPermissionRemoveInfo(
                    WebInputLongIdKey.toStackBean(webInput.getPbSetKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey())
            );
        }
    }

    @JSONField(name = "pb_set_key")
    @Valid
    private WebInputLongIdKey pbSetKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputPbSetPermissionRemoveInfo() {
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

    @Override
    public String toString() {
        return "WebInputPbSetPermissionRemoveInfo{" +
                "pbSetKey=" + pbSetKey +
                ", userKey=" + userKey +
                '}';
    }
}
