package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 个人最佳记录更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbRecordUpdateInfo implements Dto {

    private static final long serialVersionUID = -4653238529514735856L;

    public static PbRecordUpdateInfo toStackBean(WebInputPbRecordUpdateInfo webInputPbRecordUpdateInfo) {
        if (Objects.isNull(webInputPbRecordUpdateInfo)) {
            return null;
        } else {
            return new PbRecordUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInputPbRecordUpdateInfo.getKey()),
                    webInputPbRecordUpdateInfo.getValue(), webInputPbRecordUpdateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

    @JSONField(name = "value")
    private Double value;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputPbRecordUpdateInfo() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
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
        return "WebInputPbRecordUpdateInfo{" +
                "key=" + key +
                ", value=" + value +
                ", remark='" + remark + '\'' +
                '}';
    }
}
