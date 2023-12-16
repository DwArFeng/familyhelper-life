package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * WebInput 活动模板数据信息创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateDataInfoCreateInfo implements Dto {

    private static final long serialVersionUID = -985184060575414809L;

    public static ActivityTemplateDataInfoCreateInfo toStackBean(WebInputActivityTemplateDataInfoCreateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateDataInfoCreateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityTemplateKey()),
                    WebInputLongIdKey.toStackBean(webInput.getActivityDataItemKey()),
                    webInput.getRemark(),
                    webInput.getInitialValue()
            );
        }
    }

    @JSONField(name = "activity_template_key")
    @NotNull
    @Valid
    private WebInputLongIdKey activityTemplateKey;

    @JSONField(name = "activity_data_item_key")
    @NotNull
    @Valid
    private WebInputLongIdKey activityDataItemKey;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    @JSONField(name = "initial_value")
    private BigDecimal initialValue;

    public WebInputActivityTemplateDataInfoCreateInfo() {
    }

    public WebInputLongIdKey getActivityTemplateKey() {
        return activityTemplateKey;
    }

    public void setActivityTemplateKey(WebInputLongIdKey activityTemplateKey) {
        this.activityTemplateKey = activityTemplateKey;
    }

    public WebInputLongIdKey getActivityDataItemKey() {
        return activityDataItemKey;
    }

    public void setActivityDataItemKey(WebInputLongIdKey activityDataItemKey) {
        this.activityDataItemKey = activityDataItemKey;
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
        return "WebInputActivityTemplateDataInfoCreateInfo{" +
                "activityTemplateKey=" + activityTemplateKey +
                ", activityDataItemKey=" + activityDataItemKey +
                ", remark='" + remark + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
