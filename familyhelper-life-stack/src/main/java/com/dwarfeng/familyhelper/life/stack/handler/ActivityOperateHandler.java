package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityOperateHandler extends Handler {

    /**
     * 创建活动。
     *
     * @param userKey            操作者的主键。
     * @param activityCreateInfo 活动的创建信息。
     * @return 生成的活动的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createActivity(StringIdKey userKey, ActivityCreateInfo activityCreateInfo) throws HandlerException;

    /**
     * 更新活动。
     *
     * @param userKey            操作者的主键。
     * @param activityUpdateInfo 活动的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateActivity(StringIdKey userKey, ActivityUpdateInfo activityUpdateInfo) throws HandlerException;

    /**
     * 删除活动。
     *
     * @param userKey     操作者的主键。
     * @param activityKey 活动的主键。
     * @throws HandlerException 处理器异常。
     */
    void removeActivity(StringIdKey userKey, LongIdKey activityKey) throws HandlerException;

    /**
     * 添加或更新活动的访客权限。
     *
     * @param userKey                      操作者的主键。
     * @param activityPermissionUpsertInfo 权限添加信息。
     * @throws HandlerException 处理器异常。
     */
    void upsertPermission(StringIdKey userKey, ActivityPermissionUpsertInfo activityPermissionUpsertInfo)
            throws HandlerException;

    /**
     * 移除活动的访客权限。
     *
     * @param userKey                      操作者的主键。
     * @param activityPermissionRemoveInfo 权限移除信息。
     * @throws HandlerException 处理器异常。
     */
    void removePermission(StringIdKey userKey, ActivityPermissionRemoveInfo activityPermissionRemoveInfo)
            throws HandlerException;

    /**
     * 锁定活动。
     *
     * @param userKey     操作者的主键。
     * @param activityKey 活动的主键。
     * @throws HandlerException 处理器异常。
     */
    void lockActivity(StringIdKey userKey, LongIdKey activityKey) throws HandlerException;
}
