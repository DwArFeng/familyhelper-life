package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 个人最佳集合。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonPbSet implements Bean {

    private static final long serialVersionUID = -5387969791393249185L;

    public static JSFixedFastJsonPbSet of(PbSet pbSet) {
        if (Objects.isNull(pbSet)) {
            return null;
        } else {
            return new JSFixedFastJsonPbSet(
                    JSFixedFastJsonLongIdKey.of(pbSet.getKey()),
                    pbSet.getName(), pbSet.getRemark(), pbSet.getCreatedDate(),
                    pbSet.getItemCount(), pbSet.getLastRecordedDate()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "name", ordinal = 2)
    private String name;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    @JSONField(name = "created_date", ordinal = 4)
    private Date createdDate;

    @JSONField(name = "item_count", ordinal = 5)
    private int itemCount;

    @JSONField(name = "last_recorded_date", ordinal = 6)
    private Date lastRecordedDate;

    public JSFixedFastJsonPbSet() {
    }

    public JSFixedFastJsonPbSet(
            JSFixedFastJsonLongIdKey key, String name, String remark, Date createdDate, int itemCount,
            Date lastRecordedDate
    ) {
        this.key = key;
        this.name = name;
        this.remark = remark;
        this.createdDate = createdDate;
        this.itemCount = itemCount;
        this.lastRecordedDate = lastRecordedDate;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
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
        return "JSFixedFastJsonPbSet{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createdDate=" + createdDate +
                ", itemCount=" + itemCount +
                ", lastRecordedDate=" + lastRecordedDate +
                '}';
    }
}
