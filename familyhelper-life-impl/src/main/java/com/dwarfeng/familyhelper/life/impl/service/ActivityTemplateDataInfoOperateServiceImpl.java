package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDataInfoOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDataInfoOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityTemplateDataInfoOperateServiceImpl implements ActivityTemplateDataInfoOperateService {

    private final ActivityTemplateDataInfoOperateHandler activityTemplateDataInfoOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityTemplateDataInfoOperateServiceImpl(
            ActivityTemplateDataInfoOperateHandler activityTemplateDataInfoOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityTemplateDataInfoOperateHandler = activityTemplateDataInfoOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey create(StringIdKey userKey, ActivityTemplateDataInfoCreateInfo createInfo) throws ServiceException {
        try {
            return activityTemplateDataInfoOperateHandler.create(userKey, createInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("创建活动模板数据信息时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityTemplateDataInfoUpdateInfo updateInfo) throws ServiceException {
        try {
            activityTemplateDataInfoOperateHandler.update(userKey, updateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新活动模板数据信息时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey key) throws ServiceException {
        try {
            activityTemplateDataInfoOperateHandler.remove(userKey, key);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除活动模板数据信息时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
