package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityOperateService extends Service {

    /**
     * 创建活动。
     *
     * @param userKey            操作者的主键。
     * @param activityCreateInfo 活动的创建信息。
     * @return 生成的活动的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createActivity(StringIdKey userKey, ActivityCreateInfo activityCreateInfo) throws ServiceException;

    /**
     * 更新活动。
     *
     * @param userKey            操作者的主键。
     * @param activityUpdateInfo 活动的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateActivity(StringIdKey userKey, ActivityUpdateInfo activityUpdateInfo) throws ServiceException;

    /**
     * 删除活动。
     *
     * @param userKey     操作者的主键。
     * @param activityKey 活动的主键。
     * @throws ServiceException 服务异常。
     */
    void removeActivity(StringIdKey userKey, LongIdKey activityKey) throws ServiceException;

    /**
     * 添加或更新活动的访客权限。
     *
     * @param userKey                      操作者的主键。
     * @param activityPermissionUpsertInfo 权限添加信息。
     * @throws ServiceException 服务异常。
     */
    void upsertPermission(StringIdKey userKey, ActivityPermissionUpsertInfo activityPermissionUpsertInfo)
            throws ServiceException;

    /**
     * 移除活动的访客权限。
     *
     * @param userKey                      操作者的主键。
     * @param activityPermissionRemoveInfo 权限移除信息。
     * @throws ServiceException 服务异常。
     */
    void removePermission(StringIdKey userKey, ActivityPermissionRemoveInfo activityPermissionRemoveInfo)
            throws ServiceException;

    /**
     * 锁定活动。
     *
     * @param userKey     操作者的主键。
     * @param activityKey 活动的主键。
     * @throws ServiceException 服务异常。
     */
    void lockActivity(StringIdKey userKey, LongIdKey activityKey) throws ServiceException;
}
