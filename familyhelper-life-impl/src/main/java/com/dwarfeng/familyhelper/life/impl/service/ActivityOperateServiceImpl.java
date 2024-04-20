package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityOperateServiceImpl implements ActivityOperateService {

    private final ActivityOperateHandler handler;

    private final ServiceExceptionMapper sem;

    public ActivityOperateServiceImpl(ActivityOperateHandler handler, ServiceExceptionMapper sem) {
        this.handler = handler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createActivity(StringIdKey userKey, ActivityCreateInfo activityCreateInfo)
            throws ServiceException {
        try {
            return handler.createActivity(userKey, activityCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建活动时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void updateActivity(StringIdKey userKey, ActivityUpdateInfo activityUpdateInfo) throws ServiceException {
        try {
            handler.updateActivity(userKey, activityUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新活动时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removeActivity(StringIdKey userKey, LongIdKey activityKey) throws ServiceException {
        try {
            handler.removeActivity(userKey, activityKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除活动时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void upsertPermission(StringIdKey userKey, ActivityPermissionUpsertInfo activityPermissionUpsertInfo)
            throws ServiceException {
        try {
            handler.upsertPermission(userKey, activityPermissionUpsertInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("添加或更新活动的访客权限时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removePermission(StringIdKey userKey, ActivityPermissionRemoveInfo activityPermissionRemoveInfo)
            throws ServiceException {
        try {
            handler.removePermission(userKey, activityPermissionRemoveInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("移除活动的访客权限时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void lockActivity(StringIdKey userKey, LongIdKey activityKey) throws ServiceException {
        try {
            handler.lockActivity(userKey, activityKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("锁定活动时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
