package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人最佳更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbSetUpdateInfo implements Dto {

    private static final long serialVersionUID = 5080169830091727311L;

    public static PbSetUpdateInfo toStackBean(WebInputPbSetUpdateInfo webInputPbSetUpdateInfo) {
        if (Objects.isNull(webInputPbSetUpdateInfo)) {
            return null;
        } else {
            return new PbSetUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInputPbSetUpdateInfo.getPbSetKey()),
                    webInputPbSetUpdateInfo.getName(),
                    webInputPbSetUpdateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "account_book_key")
    @Valid
    @NotNull
    private WebInputLongIdKey pbSetKey;

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @JSONField(name = "remark")
    private String remark;

    public WebInputPbSetUpdateInfo() {
    }

    public WebInputLongIdKey getPbSetKey() {
        return pbSetKey;
    }

    public void setPbSetKey(WebInputLongIdKey pbSetKey) {
        this.pbSetKey = pbSetKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputPbSetUpdateInfo{" +
                "pbSetKey=" + pbSetKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
