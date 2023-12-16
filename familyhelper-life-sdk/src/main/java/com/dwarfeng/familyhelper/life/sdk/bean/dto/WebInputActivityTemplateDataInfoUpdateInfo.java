package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * WebInput 活动模板数据信息更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateDataInfoUpdateInfo implements Dto {

    private static final long serialVersionUID = 2012393072238699229L;

    public static ActivityTemplateDataInfoUpdateInfo toStackBean(WebInputActivityTemplateDataInfoUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateDataInfoUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getKey()),
                    webInput.getRemark(),
                    webInput.getInitialValue()
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputLongIdKey key;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    @JSONField(name = "initial_value")
    private BigDecimal initialValue;

    public WebInputActivityTemplateDataInfoUpdateInfo() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(BigDecimal initialValue) {
        this.initialValue = initialValue;
    }

    @Override
    public String toString() {
        return "WebInputActivityTemplateDataInfoUpdateInfo{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
