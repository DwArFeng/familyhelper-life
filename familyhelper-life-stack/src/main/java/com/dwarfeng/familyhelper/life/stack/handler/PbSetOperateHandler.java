package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 个人最佳集合操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbSetOperateHandler extends Handler {

    /**
     * 创建个人最佳集合。
     *
     * @param userKey         操作者的主键。
     * @param pbSetCreateInfo 个人最佳集合的创建信息。
     * @return 生成的个人最佳集合的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createPbSet(StringIdKey userKey, PbSetCreateInfo pbSetCreateInfo)
            throws HandlerException;

    /**
     * 更新个人最佳集合。
     *
     * @param userKey         操作者的主键。
     * @param pbSetUpdateInfo 个人最佳集合的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updatePbSet(StringIdKey userKey, PbSetUpdateInfo pbSetUpdateInfo) throws HandlerException;

    /**
     * 删除个人最佳集合。
     *
     * @param userKey  操作者的主键。
     * @param pbSetKey 个人最佳集合的主键。
     * @throws HandlerException 处理器异常。
     */
    void removePbSet(StringIdKey userKey, LongIdKey pbSetKey) throws HandlerException;

    /**
     * 添加或更新个人最佳集合的访客权限。
     *
     * @param userKey              操作者的主键。
     * @param pbSetPermissionUpsertInfo 权限添加信息。
     * @throws HandlerException 处理器异常。
     */
    void upsertPermission(StringIdKey userKey, PbSetPermissionUpsertInfo pbSetPermissionUpsertInfo)
            throws HandlerException;

    /**
     * 移除个人最佳集合的访客权限。
     *
     * @param userKey              操作者的主键。
     * @param pbSetPermissionRemoveInfo 权限移除信息。
     * @throws HandlerException 处理器异常。
     */
    void removePermission(StringIdKey userKey, PbSetPermissionRemoveInfo pbSetPermissionRemoveInfo)
            throws HandlerException;
}
