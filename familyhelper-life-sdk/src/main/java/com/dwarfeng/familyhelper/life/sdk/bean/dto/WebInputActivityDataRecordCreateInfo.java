package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordCreateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * WebInput 活动数据记录创建信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityDataRecordCreateInfo implements Dto {

    private static final long serialVersionUID = 1349842260114078966L;

    public static ActivityDataRecordCreateInfo toStackBean(WebInputActivityDataRecordCreateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityDataRecordCreateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getItemKey()),
                    WebInputLongIdKey.toStackBean(webInput.getActivityKey()),
                    webInput.getValue(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "item_key")
    @NotNull
    @Valid
    private WebInputLongIdKey itemKey;

    @JSONField(name = "activity_key")
    @NotNull
    @Valid
    private WebInputLongIdKey activityKey;

    @JSONField(name = "value")
    @NotNull
    private BigDecimal value;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputActivityDataRecordCreateInfo() {
    }

    public WebInputLongIdKey getItemKey() {
        return itemKey;
    }

    public void setItemKey(WebInputLongIdKey itemKey) {
        this.itemKey = itemKey;
    }

    public WebInputLongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(WebInputLongIdKey activityKey) {
        this.activityKey = activityKey;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
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
        return "WebInputActivityDataRecordCreateInfo{" +
                "itemKey=" + itemKey +
                ", activityKey=" + activityKey +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
