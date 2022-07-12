package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.sdk.util.ValidComparator;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人最佳项目更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbItemUpdateInfo implements Dto {

    private static final long serialVersionUID = 3508931909692418803L;

    public static PbItemUpdateInfo toStackBean(WebInputPbItemUpdateInfo webInputPbItemUpdateInfo) {
        if (Objects.isNull(webInputPbItemUpdateInfo)) {
            return null;
        } else {
            return new PbItemUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInputPbItemUpdateInfo.getKey()),
                    webInputPbItemUpdateInfo.getName(), webInputPbItemUpdateInfo.getUnit(),
                    webInputPbItemUpdateInfo.getComparator(), webInputPbItemUpdateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

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

    public WebInputPbItemUpdateInfo() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
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
        return "WebInputPbItemUpdateInfo{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", comparator=" + comparator +
                ", remark='" + remark + '\'' +
                '}';
    }
}
