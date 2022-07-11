package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * WebInput 个人最佳记录。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbRecord implements Bean {

    private static final long serialVersionUID = 3797648466871304951L;

    public static PbRecord toStackBean(WebInputPbRecord webInputPbRecord) {
        if (Objects.isNull(webInputPbRecord)) {
            return null;
        } else {
            return new PbRecord(
                    WebInputLongIdKey.toStackBean(webInputPbRecord.getKey()),
                    WebInputLongIdKey.toStackBean(webInputPbRecord.getItemKey()),
                    webInputPbRecord.getValue(), webInputPbRecord.getRecordedDate(), webInputPbRecord.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

    @JSONField(name = "item_key")
    @Valid
    private WebInputLongIdKey itemKey;

    @JSONField(name = "value")
    private Double value;

    @JSONField(name = "recorded_date")
    private Date recordedDate;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputPbRecord() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
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

    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputPbRecord{" +
                "key=" + key +
                ", itemKey=" + itemKey +
                ", value=" + value +
                ", recordedDate=" + recordedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
