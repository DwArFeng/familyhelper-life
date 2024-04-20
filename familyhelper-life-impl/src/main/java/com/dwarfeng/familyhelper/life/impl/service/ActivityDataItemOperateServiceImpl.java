package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataItemOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityDataItemOperateServiceImpl implements ActivityDataItemOperateService {

    private final ActivityDataItemOperateHandler activityDataItemOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityDataItemOperateServiceImpl(
            ActivityDataItemOperateHandler activityDataItemOperateHandler, ServiceExceptionMapper sem
    ) {
        this.activityDataItemOperateHandler = activityDataItemOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createActivityDataItem(StringIdKey userKey, ActivityDataItemCreateInfo activityDataItemCreateInfo)
            throws ServiceException {
        try {
            return activityDataItemOperateHandler.createActivityDataItem(userKey, activityDataItemCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建活动数据项目时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void updateActivityDataItem(StringIdKey userKey, ActivityDataItemUpdateInfo activityDataItemUpdateInfo)
            throws ServiceException {
        try {
            activityDataItemOperateHandler.updateActivityDataItem(userKey, activityDataItemUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新活动数据项目时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removeActivityDataItem(StringIdKey userKey, LongIdKey activityDataItemKey) throws ServiceException {
        try {
            activityDataItemOperateHandler.removeActivityDataItem(userKey, activityDataItemKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除活动数据项目时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
