package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataSetOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataSetOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityDataSetOperateServiceImpl implements ActivityDataSetOperateService {

    private final ActivityDataSetOperateHandler activityDataSetOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityDataSetOperateServiceImpl(
            ActivityDataSetOperateHandler activityDataSetOperateHandler, ServiceExceptionMapper sem
    ) {
        this.activityDataSetOperateHandler = activityDataSetOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createActivityDataSet(StringIdKey userKey, ActivityDataSetCreateInfo activityDataSetCreateInfo)
            throws ServiceException {
        try {
            return activityDataSetOperateHandler.createActivityDataSet(userKey, activityDataSetCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("创建活动数据集合时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updateActivityDataSet(StringIdKey userKey, ActivityDataSetUpdateInfo activityDataSetUpdateInfo)
            throws ServiceException {
        try {
            activityDataSetOperateHandler.updateActivityDataSet(userKey, activityDataSetUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新活动数据集合时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removeActivityDataSet(StringIdKey userKey, LongIdKey activityDataSetKey) throws ServiceException {
        try {
            activityDataSetOperateHandler.removeActivityDataSet(userKey, activityDataSetKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除活动数据集合时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey userKey, ActivityDataSetPermissionUpsertInfo activityDataSetPermissionUpsertInfo
    ) throws ServiceException {
        try {
            activityDataSetOperateHandler.upsertPermission(userKey, activityDataSetPermissionUpsertInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("添加活动数据集合的访客权限时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removePermission(
            StringIdKey userKey, ActivityDataSetPermissionRemoveInfo activityDataSetPermissionRemoveInfo
    ) throws ServiceException {
        try {
            activityDataSetOperateHandler.removePermission(userKey, activityDataSetPermissionRemoveInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("移除活动数据集合的访客权限时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
