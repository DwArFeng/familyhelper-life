package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 个人最佳权限删除信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbSetPermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 7509145036042152882L;

    private LongIdKey pbSetKey;
    private StringIdKey userKey;

    public PbSetPermissionRemoveInfo() {
    }

    public PbSetPermissionRemoveInfo(LongIdKey pbSetKey, StringIdKey userKey) {
        this.pbSetKey = pbSetKey;
        this.userKey = userKey;
    }

    public LongIdKey getPbSetKey() {
        return pbSetKey;
    }

    public void setPbSetKey(LongIdKey pbSetKey) {
        this.pbSetKey = pbSetKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "PbSetPermissionRemoveInfo{" +
                "pbSetKey=" + pbSetKey +
                ", userKey=" + userKey +
                '}';
    }
}
