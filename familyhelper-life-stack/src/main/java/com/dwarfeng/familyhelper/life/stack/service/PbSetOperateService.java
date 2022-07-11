package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 个人最佳集合操作服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbSetOperateService extends Service {

    /**
     * 创建个人最佳集合。
     *
     * @param userKey         操作者的主键。
     * @param pbSetCreateInfo 个人最佳集合的创建信息。
     * @return 生成的个人最佳集合的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createPbSet(StringIdKey userKey, PbSetCreateInfo pbSetCreateInfo)
            throws ServiceException;

    /**
     * 更新个人最佳集合。
     *
     * @param userKey         操作者的主键。
     * @param pbSetUpdateInfo 个人最佳集合的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updatePbSet(StringIdKey userKey, PbSetUpdateInfo pbSetUpdateInfo) throws ServiceException;

    /**
     * 删除个人最佳集合。
     *
     * @param userKey  操作者的主键。
     * @param pbSetKey 个人最佳集合的主键。
     * @throws ServiceException 服务异常。
     */
    void removePbSet(StringIdKey userKey, LongIdKey pbSetKey) throws ServiceException;

    /**
     * 添加或更新个人最佳集合的访客权限。
     *
     * @param ownerUserKey              操作者的主键。
     * @param pbSetPermissionUpsertInfo 权限添加信息。
     * @throws ServiceException 服务异常。
     */
    void upsertPermission(StringIdKey ownerUserKey, PbSetPermissionUpsertInfo pbSetPermissionUpsertInfo)
            throws ServiceException;

    /**
     * 移除个人最佳集合的访客权限。
     *
     * @param ownerUserKey              操作者的主键。
     * @param pbSetPermissionRemoveInfo 权限移除信息。
     * @throws ServiceException 服务异常。
     */
    void removePermission(StringIdKey ownerUserKey, PbSetPermissionRemoveInfo pbSetPermissionRemoveInfo)
            throws ServiceException;
}
