package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动数据集合操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataSetOperateService extends Service {

    /**
     * 创建活动数据集合。
     *
     * @param userKey                   操作者的主键。
     * @param activityDataSetCreateInfo 活动数据集合的创建信息。
     * @return 生成的活动数据集合的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createActivityDataSet(StringIdKey userKey, ActivityDataSetCreateInfo activityDataSetCreateInfo)
            throws ServiceException;

    /**
     * 更新活动数据集合。
     *
     * @param userKey                   操作者的主键。
     * @param activityDataSetUpdateInfo 活动数据集合的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateActivityDataSet(StringIdKey userKey, ActivityDataSetUpdateInfo activityDataSetUpdateInfo)
            throws ServiceException;

    /**
     * 删除活动数据集合。
     *
     * @param userKey            操作者的主键。
     * @param activityDataSetKey 活动数据集合的主键。
     * @throws ServiceException 服务异常。
     */
    void removeActivityDataSet(StringIdKey userKey, LongIdKey activityDataSetKey) throws ServiceException;

    /**
     * 添加或更新活动数据集合的访客权限。
     *
     * @param userKey                        操作者的主键。
     * @param activityDataSetPermissionUpsertInfo 权限添加信息。
     * @throws ServiceException 服务异常。
     */
    void upsertPermission(
            StringIdKey userKey, ActivityDataSetPermissionUpsertInfo activityDataSetPermissionUpsertInfo
    ) throws ServiceException;

    /**
     * 移除活动数据集合的访客权限。
     *
     * @param userKey                        操作者的主键。
     * @param activityDataSetPermissionRemoveInfo 权限移除信息。
     * @throws ServiceException 服务异常。
     */
    void removePermission(
            StringIdKey userKey, ActivityDataSetPermissionRemoveInfo activityDataSetPermissionRemoveInfo
    ) throws ServiceException;
}
