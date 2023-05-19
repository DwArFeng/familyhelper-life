package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动数据项目创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityDataItemCreateInfo implements Dto {

    private static final long serialVersionUID = 3961667005191615003L;

    public static ActivityDataItemCreateInfo toStackBean(WebInputActivityDataItemCreateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityDataItemCreateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getSetKey()),
                    WebInputLongIdKey.toStackBean(webInput.getNodeKey()),
                    webInput.getName(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "set_key")
    @Valid
    private WebInputLongIdKey setKey;

    @JSONField(name = "node_key")
    @Valid
    private WebInputLongIdKey nodeKey;

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_NAME)
    private String name;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputActivityDataItemCreateInfo() {
    }

    public WebInputLongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(WebInputLongIdKey setKey) {
        this.setKey = setKey;
    }

    public WebInputLongIdKey getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(WebInputLongIdKey nodeKey) {
        this.nodeKey = nodeKey;
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
        return "WebInputActivityDataItemCreateInfo{" +
                "setKey=" + setKey +
                ", nodeKey=" + nodeKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
