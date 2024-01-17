package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动模板操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateOperateService extends Service {

    /**
     * 创建活动模板。
     *
     * @param userKey                    操作者的主键。
     * @param activityTemplateCreateInfo 活动模板的创建信息。
     * @return 生成的活动模板的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createActivityTemplate(StringIdKey userKey, ActivityTemplateCreateInfo activityTemplateCreateInfo)
            throws ServiceException;

    /**
     * 更新活动模板。
     *
     * @param userKey                    操作者的主键。
     * @param activityTemplateUpdateInfo 活动模板的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateActivityTemplate(StringIdKey userKey, ActivityTemplateUpdateInfo activityTemplateUpdateInfo)
            throws ServiceException;

    /**
     * 删除活动模板。
     *
     * @param userKey             操作者的主键。
     * @param activityTemplateKey 活动模板的主键。
     * @throws ServiceException 服务异常。
     */
    void removeActivityTemplate(StringIdKey userKey, LongIdKey activityTemplateKey) throws ServiceException;

    /**
     * 添加或更新活动模板的访客权限。
     *
     * @param userKey                              操作者的主键。
     * @param activityTemplatePermissionUpsertInfo 权限添加信息。
     * @throws ServiceException 服务异常。
     */
    void upsertPermission(
            StringIdKey userKey, ActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfo
    ) throws ServiceException;

    /**
     * 移除活动模板的访客权限。
     *
     * @param userKey                              操作者的主键。
     * @param activityTemplatePermissionRemoveInfo 权限移除信息。
     * @throws ServiceException 服务异常。
     */
    void removePermission(
            StringIdKey userKey, ActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfo
    ) throws ServiceException;

    /**
     * 添加或更新活动模板生成的活动的访客权限。
     *
     * @param userKey    操作者的主键。
     * @param upsertInfo 活动权限添加信息。
     * @throws ServiceException 服务异常。
     */
    void upsertActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionUpsertInfo upsertInfo
    ) throws ServiceException;

    /**
     * 移除活动模板生成的活动的访客权限。
     *
     * @param userKey    操作者的主键。
     * @param removeInfo 活动权限移除信息。
     * @throws ServiceException 服务异常。
     */
    void removeActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionRemoveInfo removeInfo
    ) throws ServiceException;

    /**
     * 创建活动。
     *
     * @param userKey    操作者的主键。
     * @param createInfo 活动创建信息。
     * @return 生成的活动的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createActivity(StringIdKey userKey, ActivityTemplateActivityCreateInfo createInfo)
            throws ServiceException;

    /**
     * 创建用于测试的活动。
     *
     * @param userKey    操作者的主键。
     * @param createInfo 活动创建信息。
     * @return 生成的活动的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createActivityForTest(StringIdKey userKey, ActivityTemplateActivityCreateInfo createInfo)
            throws ServiceException;
}
