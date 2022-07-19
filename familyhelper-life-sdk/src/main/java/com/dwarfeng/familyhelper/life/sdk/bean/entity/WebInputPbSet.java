package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.Objects;

/**
 * FastJson 个人最佳集合。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbSet implements Bean {

    private static final long serialVersionUID = 6889879806535541812L;

    public static PbSet toStackBean(WebInputPbSet webInputPbSet) {
        if (Objects.isNull(webInputPbSet)) {
            return null;
        } else {
            return new PbSet(
                    WebInputLongIdKey.toStackBean(webInputPbSet.getKey()),
                    webInputPbSet.getName(), webInputPbSet.getRemark(), webInputPbSet.getCreatedDate(),
                    webInputPbSet.getItemCount(), webInputPbSet.getLastRecordedDate()
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

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    @JSONField(name = "created_date")
    private Date createdDate;

    @JSONField(name = "item_count")
    @PositiveOrZero
    private int itemCount;

    @JSONField(name = "last_recorded_date")
    private Date lastRecordedDate;

    public WebInputPbSet() {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public Date getLastRecordedDate() {
        return lastRecordedDate;
    }

    public void setLastRecordedDate(Date lastRecordedDate) {
        this.lastRecordedDate = lastRecordedDate;
    }

    @Override
    public String toString() {
        return "WebInputPbSet{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createdDate=" + createdDate +
                ", itemCount=" + itemCount +
                ", lastRecordedDate=" + lastRecordedDate +
                '}';
    }
}
