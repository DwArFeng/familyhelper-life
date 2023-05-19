package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataNodeCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataNodeUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataNodeOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataNodeOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityDataNodeOperateServiceImpl implements ActivityDataNodeOperateService {

    private final ActivityDataNodeOperateHandler activityDataNodeOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityDataNodeOperateServiceImpl(
            ActivityDataNodeOperateHandler activityDataNodeOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityDataNodeOperateHandler = activityDataNodeOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createActivityDataNode(
            StringIdKey userKey, ActivityDataNodeCreateInfo activityDataNodeCreateInfo
    ) throws ServiceException {
        try {
            return activityDataNodeOperateHandler.createActivityDataNode(userKey, activityDataNodeCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("创建活动数据节点时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updateActivityDataNode(StringIdKey userKey, ActivityDataNodeUpdateInfo activityDataNodeUpdateInfo)
            throws ServiceException {
        try {
            activityDataNodeOperateHandler.updateActivityDataNode(userKey, activityDataNodeUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新活动数据节点时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removeActivityDataNode(StringIdKey userKey, LongIdKey activityDataNodeKey) throws ServiceException {
        try {
            activityDataNodeOperateHandler.removeActivityDataNode(userKey, activityDataNodeKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除活动数据节点时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
