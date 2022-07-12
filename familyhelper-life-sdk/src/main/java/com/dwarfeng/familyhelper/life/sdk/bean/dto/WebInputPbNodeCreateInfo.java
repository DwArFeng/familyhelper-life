package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人最佳节点创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbNodeCreateInfo implements Dto {

    private static final long serialVersionUID = 45667578686316171L;

    public static PbNodeCreateInfo toStackBean(WebInputPbNodeCreateInfo webInputPbNodeCreateInfo) {
        if (Objects.isNull(webInputPbNodeCreateInfo)) {
            return null;
        } else {
            return new PbNodeCreateInfo(
                    WebInputLongIdKey.toStackBean(webInputPbNodeCreateInfo.getSetKey()),
                    WebInputLongIdKey.toStackBean(webInputPbNodeCreateInfo.getParentKey()),
                    webInputPbNodeCreateInfo.getName(), webInputPbNodeCreateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "set_key")
    @Valid
    private WebInputLongIdKey setKey;

    @JSONField(name = "parent_key")
    @Valid
    private WebInputLongIdKey parentKey;

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_NAME)
    private String name;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputPbNodeCreateInfo() {
    }

    public WebInputLongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(WebInputLongIdKey setKey) {
        this.setKey = setKey;
    }

    public WebInputLongIdKey getParentKey() {
        return parentKey;
    }

    public void setParentKey(WebInputLongIdKey parentKey) {
        this.parentKey = parentKey;
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
        return "WebInputPbNodeCreateInfo{" +
                "setKey=" + setKey +
                ", parentKey=" + parentKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
