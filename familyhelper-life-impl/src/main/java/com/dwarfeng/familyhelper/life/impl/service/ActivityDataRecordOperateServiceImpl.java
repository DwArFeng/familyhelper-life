package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataRecordOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataRecordOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityDataRecordOperateServiceImpl implements ActivityDataRecordOperateService {

    private final ActivityDataRecordOperateHandler activityDataRecordOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityDataRecordOperateServiceImpl(
            ActivityDataRecordOperateHandler activityDataRecordOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityDataRecordOperateHandler = activityDataRecordOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey create(StringIdKey userKey, ActivityDataRecordCreateInfo createInfo) throws ServiceException {
        try {
            return activityDataRecordOperateHandler.create(userKey, createInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建活动数据记录时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityDataRecordUpdateInfo updateInfo) throws ServiceException {
        try {
            activityDataRecordOperateHandler.update(userKey, updateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新活动数据记录时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey key) throws ServiceException {
        try {
            activityDataRecordOperateHandler.remove(userKey, key);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除活动数据记录时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
