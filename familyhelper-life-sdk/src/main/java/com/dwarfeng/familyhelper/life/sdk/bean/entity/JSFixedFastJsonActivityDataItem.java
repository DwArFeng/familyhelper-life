package com.dwarfeng.familyhelper.life.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 活动数据条目。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class JSFixedFastJsonActivityDataItem implements Bean {

    private static final long serialVersionUID = -7437938886553266166L;

    public static JSFixedFastJsonActivityDataItem of(ActivityDataItem activityDataItem) {
        if (Objects.isNull(activityDataItem)) {
            return null;
        } else {
            return new JSFixedFastJsonActivityDataItem(
                    JSFixedFastJsonLongIdKey.of(activityDataItem.getKey()),
                    JSFixedFastJsonLongIdKey.of(activityDataItem.getNodeKey()),
                    JSFixedFastJsonLongIdKey.of(activityDataItem.getSetKey()),
                    activityDataItem.getName(), activityDataItem.getRemark(), activityDataItem.getRecordCount(),
                    activityDataItem.getSum(), activityDataItem.getAvg(), activityDataItem.getMax(),
                    activityDataItem.getMin(), activityDataItem.getEarliestDate(), activityDataItem.getLatestDate(),
                    activityDataItem.getDuration()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "node_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey nodeKey;

    @JSONField(name = "set_key", ordinal = 3)
    private JSFixedFastJsonLongIdKey setKey;

    @JSONField(name = "name", ordinal = 4)
    private String name;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    @JSONField(name = "record_count", ordinal = 6)
    private int recordCount;

    @JSONField(name = "sum", ordinal = 7)
    private BigDecimal sum;

    @JSONField(name = "avg", ordinal = 8)
    private BigDecimal avg;

    @JSONField(name = "max", ordinal = 9)
    private BigDecimal max;

    @JSONField(name = "min", ordinal = 10)
    private BigDecimal min;

    @JSONField(name = "earliest_date", ordinal = 11)
    private Date earliestDate;

    @JSONField(name = "latest_date", ordinal = 12)
    private Date latestDate;

    @JSONField(name = "duration", ordinal = 13)
    private long duration;

    public JSFixedFastJsonActivityDataItem() {
    }

    public JSFixedFastJsonActivityDataItem(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey nodeKey, JSFixedFastJsonLongIdKey setKey, String name, String remark,
            int recordCount, BigDecimal sum, BigDecimal avg, BigDecimal max, BigDecimal min, Date earliestDate,
            Date latestDate, long duration
    ) {
        this.key = key;
        this.nodeKey = nodeKey;
        this.setKey = setKey;
        this.name = name;
        this.remark = remark;
        this.recordCount = recordCount;
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.earliestDate = earliestDate;
        this.latestDate = latestDate;
        this.duration = duration;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public JSFixedFastJsonLongIdKey getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(JSFixedFastJsonLongIdKey nodeKey) {
        this.nodeKey = nodeKey;
    }

    public JSFixedFastJsonLongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(JSFixedFastJsonLongIdKey setKey) {
        this.setKey = setKey;
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

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public Date getEarliestDate() {
        return earliestDate;
    }

    public void setEarliestDate(Date earliestDate) {
        this.earliestDate = earliestDate;
    }

    public Date getLatestDate() {
        return latestDate;
    }

    public void setLatestDate(Date latestDate) {
        this.latestDate = latestDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "JSFixedFastJsonActivityDataItem{" +
                "key=" + key +
                ", nodeKey=" + nodeKey +
                ", setKey=" + setKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", recordCount=" + recordCount +
                ", sum=" + sum +
                ", avg=" + avg +
                ", max=" + max +
                ", min=" + min +
                ", earliestDate=" + earliestDate +
                ", latestDate=" + latestDate +
                ", duration=" + duration +
                '}';
    }
}
