package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * WebInput 活动数据记录更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityDataRecordUpdateInfo implements Dto {

    private static final long serialVersionUID = -1448707722758023917L;

    public static ActivityDataRecordUpdateInfo toStackBean(WebInputActivityDataRecordUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityDataRecordUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getKey()),
                    webInput.getValue(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @NotNull
    @Valid
    private WebInputLongIdKey key;

    @JSONField(name = "value")
    @NotNull
    private BigDecimal value;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputActivityDataRecordUpdateInfo() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
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
        return "WebInputActivityDataRecordUpdateInfo{" +
                "key=" + key +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
