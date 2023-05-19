package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动数据项目更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityDataItemUpdateInfo implements Dto {

    private static final long serialVersionUID = -6821281453429791071L;

    public static ActivityDataItemUpdateInfo toStackBean(WebInputActivityDataItemUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityDataItemUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getKey()),
                    WebInputLongIdKey.toStackBean(webInput.getNodeKey()),
                    webInput.getName(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

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

    public WebInputActivityDataItemUpdateInfo() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
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
        return "WebInputActivityDataItemUpdateInfo{" +
                "key=" + key +
                ", nodeKey=" + nodeKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
