package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 个人最佳权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PbSetPermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = -2971588195313895753L;

    private LongIdKey pbSetKey;
    private StringIdKey userKey;
    private int permissionLevel;

    public PbSetPermissionUpsertInfo() {
    }

    public PbSetPermissionUpsertInfo(LongIdKey PbSetKey, StringIdKey userKey, int permissionLevel) {
        this.pbSetKey = PbSetKey;
        this.userKey = userKey;
        this.permissionLevel = permissionLevel;
    }

    public LongIdKey getPbSetKey() {
        return pbSetKey;
    }

    public void setPbSetKey(LongIdKey PbSetKey) {
        this.pbSetKey = PbSetKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "PbSetPermissionUpsertInfo{" +
                "pbSetKey=" + pbSetKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
