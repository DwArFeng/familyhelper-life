package com.dwarfeng.familyhelper.life.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 个人最佳集合。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbSet implements Entity<LongIdKey> {

    private static final long serialVersionUID = 4135852001285148078L;

    private LongIdKey key;
    private String name;
    private String remark;
    private Date createdDate;

    public PbSet() {
    }

    public PbSet(LongIdKey key, String name, String remark, Date createdDate) {
        this.key = key;
        this.name = name;
        this.remark = remark;
        this.createdDate = createdDate;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
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

    @Override
    public String toString() {
        return "PbSet{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
