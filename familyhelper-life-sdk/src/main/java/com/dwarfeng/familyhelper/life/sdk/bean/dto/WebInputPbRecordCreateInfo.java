package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 个人最佳记录创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbRecordCreateInfo implements Dto {

    private static final long serialVersionUID = 669599484003654945L;

    public static PbRecordCreateInfo toStackBean(WebInputPbRecordCreateInfo webInputPbRecordCreateInfo) {
        if (Objects.isNull(webInputPbRecordCreateInfo)) {
            return null;
        } else {
            return new PbRecordCreateInfo(
                    WebInputLongIdKey.toStackBean(webInputPbRecordCreateInfo.getItemKey()),
                    webInputPbRecordCreateInfo.getValue(), webInputPbRecordCreateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "itemKey")
    @Valid
    private WebInputLongIdKey itemKey;

    @JSONField(name = "value")
    private Double value;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputPbRecordCreateInfo() {
    }

    public WebInputLongIdKey getItemKey() {
        return itemKey;
    }

    public void setItemKey(WebInputLongIdKey itemKey) {
        this.itemKey = itemKey;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputPbRecordCreateInfo{" +
                "itemKey=" + itemKey +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
