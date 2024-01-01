package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUploadInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityFileOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityFileOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityFileOperateServiceImpl implements ActivityFileOperateService {

    private final ActivityFileOperateHandler activityFileOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityFileOperateServiceImpl(
            ActivityFileOperateHandler activityFileOperateHandler, ServiceExceptionMapper sem
    ) {
        this.activityFileOperateHandler = activityFileOperateHandler;
        this.sem = sem;
    }

    @Override
    public ActivityFile downloadActivityFile(StringIdKey userKey, LongIdKey activityFileKey)
            throws ServiceException {
        try {
            return activityFileOperateHandler.downloadActivityFile(userKey, activityFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("下载活动文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void uploadActivityFile(
            StringIdKey userKey, ActivityFileUploadInfo activityFileUploadInfo
    ) throws ServiceException {
        try {
            activityFileOperateHandler.uploadActivityFile(userKey, activityFileUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("上传活动文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updateActivityFile(
            StringIdKey userKey, ActivityFileUpdateInfo activityFileUpdateInfo
    ) throws ServiceException {
        try {
            activityFileOperateHandler.updateActivityFile(userKey, activityFileUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新活动文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removeActivityFile(StringIdKey userKey, LongIdKey activityFileKey)
            throws ServiceException {
        try {
            activityFileOperateHandler.removeActivityFile(userKey, activityFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除活动文件时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
