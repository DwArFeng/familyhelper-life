package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.sdk.util.ValidComparator;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人最佳项目创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbItemCreateInfo implements Dto {

    private static final long serialVersionUID = -6542119065189962590L;

    public static PbItemCreateInfo toStackBean(WebInputPbItemCreateInfo webInputPbItemCreateInfo) {
        if (Objects.isNull(webInputPbItemCreateInfo)) {
            return null;
        } else {
            return new PbItemCreateInfo(
                    WebInputLongIdKey.toStackBean(webInputPbItemCreateInfo.getSetKey()),
                    WebInputLongIdKey.toStackBean(webInputPbItemCreateInfo.getNodeKey()),
                    webInputPbItemCreateInfo.getName(), webInputPbItemCreateInfo.getUnit(),
                    webInputPbItemCreateInfo.getComparator(), webInputPbItemCreateInfo.getRemark()
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

    @JSONField(name = "unit")
    @Length(max = Constraints.LENGTH_UNIT)
    private String unit;

    @JSONField(name = "comparator")
    @ValidComparator
    private Integer comparator;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputPbItemCreateInfo() {
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getComparator() {
        return comparator;
    }

    public void setComparator(Integer comparator) {
        this.comparator = comparator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputPbItemCreateInfo{" +
                "setKey=" + setKey +
                ", nodeKey=" + nodeKey +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", comparator=" + comparator +
                ", remark='" + remark + '\'' +
                '}';
    }
}
