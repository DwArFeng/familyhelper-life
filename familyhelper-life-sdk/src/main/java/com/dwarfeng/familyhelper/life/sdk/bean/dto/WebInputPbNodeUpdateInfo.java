package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人最佳节点更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbNodeUpdateInfo implements Dto {

    private static final long serialVersionUID = -2920547004286878913L;

    public static PbNodeUpdateInfo toStackBean(WebInputPbNodeUpdateInfo webInputPbNodeUpdateInfo) {
        if (Objects.isNull(webInputPbNodeUpdateInfo)) {
            return null;
        } else {
            return new PbNodeUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInputPbNodeUpdateInfo.getKey()),
                    WebInputLongIdKey.toStackBean(webInputPbNodeUpdateInfo.getParentKey()),
                    webInputPbNodeUpdateInfo.getName(), webInputPbNodeUpdateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

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

    public WebInputPbNodeUpdateInfo() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
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
        return "WebInputPbNodeUpdateInfo{" +
                "key=" + key +
                ", parentKey=" + parentKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
