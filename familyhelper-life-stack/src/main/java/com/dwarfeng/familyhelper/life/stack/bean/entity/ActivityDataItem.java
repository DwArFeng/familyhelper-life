package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动数据条目。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityDataItem implements Entity<LongIdKey> {

    private static final long serialVersionUID = 701228734017951389L;

    private LongIdKey key;
    private LongIdKey nodeKey;
    private LongIdKey setKey;
    private String name;
    private String remark;
    private int recordCount;
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private Date earliestDate;
    private Date latestDate;
    private long duration;

    public ActivityDataItem() {
    }

    public ActivityDataItem(
            LongIdKey key, LongIdKey nodeKey, LongIdKey setKey, String name, String remark, int recordCount,
            BigDecimal sum, BigDecimal avg, BigDecimal max, BigDecimal min, Date earliestDate, Date latestDate,
            long duration
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

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public LongIdKey getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(LongIdKey nodeKey) {
        this.nodeKey = nodeKey;
    }

    public LongIdKey getSetKey() {
        return setKey;
    }

    public void setSetKey(LongIdKey setKey) {
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
        return "ActivityDataItem{" +
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
