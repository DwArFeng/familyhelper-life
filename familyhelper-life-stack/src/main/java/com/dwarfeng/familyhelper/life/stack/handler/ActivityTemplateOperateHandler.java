package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动模板操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateOperateHandler extends Handler {

    /**
     * 创建活动模板。
     *
     * @param userKey                    操作者的主键。
     * @param activityTemplateCreateInfo 活动模板的创建信息。
     * @return 生成的活动模板的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createActivityTemplate(StringIdKey userKey, ActivityTemplateCreateInfo activityTemplateCreateInfo)
            throws HandlerException;

    /**
     * 更新活动模板。
     *
     * @param userKey                    操作者的主键。
     * @param activityTemplateUpdateInfo 活动模板的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateActivityTemplate(StringIdKey userKey, ActivityTemplateUpdateInfo activityTemplateUpdateInfo)
            throws HandlerException;

    /**
     * 删除活动模板。
     *
     * @param userKey             操作者的主键。
     * @param activityTemplateKey 活动模板的主键。
     * @throws HandlerException 处理器异常。
     */
    void removeActivityTemplate(StringIdKey userKey, LongIdKey activityTemplateKey) throws HandlerException;

    /**
     * 添加或更新活动模板的访客权限。
     *
     * @param userKey                              操作者的主键。
     * @param activityTemplatePermissionUpsertInfo 权限添加信息。
     * @throws HandlerException 处理器异常。
     */
    void upsertPermission(
            StringIdKey userKey, ActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfo
    ) throws HandlerException;

    /**
     * 移除活动模板的访客权限。
     *
     * @param userKey                              操作者的主键。
     * @param activityTemplatePermissionRemoveInfo 权限移除信息。
     * @throws HandlerException 处理器异常。
     */
    void removePermission(
            StringIdKey userKey, ActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfo
    ) throws HandlerException;

    /**
     * 添加或更新活动模板生成的活动的访客权限。
     *
     * @param userKey    操作者的主键。
     * @param upsertInfo 活动权限添加信息。
     * @throws HandlerException 处理器异常。
     */
    void upsertActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionUpsertInfo upsertInfo
    ) throws HandlerException;

    /**
     * 移除活动模板生成的活动的访客权限。
     *
     * @param userKey    操作者的主键。
     * @param removeInfo 活动权限移除信息。
     * @throws HandlerException 处理器异常。
     */
    void removeActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionRemoveInfo removeInfo
    ) throws HandlerException;
}
