package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityTemplateOperateServiceImpl implements ActivityTemplateOperateService {

    private final ActivityTemplateOperateHandler activityTemplateOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityTemplateOperateServiceImpl(
            ActivityTemplateOperateHandler activityTemplateOperateHandler, ServiceExceptionMapper sem
    ) {
        this.activityTemplateOperateHandler = activityTemplateOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createActivityTemplate(StringIdKey userKey, ActivityTemplateCreateInfo activityTemplateCreateInfo)
            throws ServiceException {
        try {
            return activityTemplateOperateHandler.createActivityTemplate(userKey, activityTemplateCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("创建活动模板时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updateActivityTemplate(StringIdKey userKey, ActivityTemplateUpdateInfo activityTemplateUpdateInfo)
            throws ServiceException {
        try {
            activityTemplateOperateHandler.updateActivityTemplate(userKey, activityTemplateUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新活动模板时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removeActivityTemplate(StringIdKey userKey, LongIdKey activityTemplateKey) throws ServiceException {
        try {
            activityTemplateOperateHandler.removeActivityTemplate(userKey, activityTemplateKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除活动模板时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey userKey, ActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfo
    ) throws ServiceException {
        try {
            activityTemplateOperateHandler.upsertPermission(userKey, activityTemplatePermissionUpsertInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("添加活动模板权限时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removePermission(
            StringIdKey userKey, ActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfo
    ) throws ServiceException {
        try {
            activityTemplateOperateHandler.removePermission(userKey, activityTemplatePermissionRemoveInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("移除活动模板权限时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void upsertActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionUpsertInfo upsertInfo
    ) throws ServiceException {
        try {
            activityTemplateOperateHandler.upsertActivityPermission(userKey, upsertInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("添加活动模板活动权限时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removeActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionRemoveInfo removeInfo
    ) throws ServiceException {
        try {
            activityTemplateOperateHandler.removeActivityPermission(userKey, removeInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("移除活动模板活动权限时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
