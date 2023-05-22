package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 活动数据集合。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityDataSet implements Bean {

    private static final long serialVersionUID = -2770063219229339987L;

    public static FastJsonActivityDataSet of(ActivityDataSet activityDataSet) {
        if (Objects.isNull(activityDataSet)) {
            return null;
        } else {
            return new FastJsonActivityDataSet(
                    FastJsonLongIdKey.of(activityDataSet.getKey()),
                    activityDataSet.getName(), activityDataSet.getRemark(), activityDataSet.getItemCount(),
                    activityDataSet.getCreatedDate()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "name", ordinal = 2)
    private String name;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    @JSONField(name = "item_count", ordinal = 4)
    private int itemCount;

    @JSONField(name = "created_date", ordinal = 5)
    private Date createdDate;

    public FastJsonActivityDataSet() {
    }

    public FastJsonActivityDataSet(
            FastJsonLongIdKey key, String name, String remark, int itemCount, Date createdDate
    ) {
        this.key = key;
        this.name = name;
        this.remark = remark;
        this.itemCount = itemCount;
        this.createdDate = createdDate;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
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

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "FastJsonActivityDataSet{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", itemCount=" + itemCount +
                ", createdDate=" + createdDate +
                '}';
    }
}
