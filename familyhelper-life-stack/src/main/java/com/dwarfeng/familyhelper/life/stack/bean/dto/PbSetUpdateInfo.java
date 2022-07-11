package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 个人最佳集合更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbSetUpdateInfo implements Dto {

    private static final long serialVersionUID = -6297194612410622431L;

    private LongIdKey pbSetKey;
    private String name;
    private String remark;

    public PbSetUpdateInfo() {
    }

    public PbSetUpdateInfo(LongIdKey pbSetKey, String name, String remark) {
        this.pbSetKey = pbSetKey;
        this.name = name;
        this.remark = remark;
    }

    public LongIdKey getPbSetKey() {
        return pbSetKey;
    }

    public void setPbSetKey(LongIdKey pbSetKey) {
        this.pbSetKey = pbSetKey;
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

    @Override
    public String toString() {
        return "PbSetUpdateInfo{" +
                "pbSetKey=" + pbSetKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
