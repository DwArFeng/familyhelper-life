package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUploadInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateFileOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateFileOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityTemplateFileOperateServiceImpl implements ActivityTemplateFileOperateService {

    private final ActivityTemplateFileOperateHandler activityTemplateFileOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityTemplateFileOperateServiceImpl(
            ActivityTemplateFileOperateHandler activityTemplateFileOperateHandler, ServiceExceptionMapper sem
    ) {
        this.activityTemplateFileOperateHandler = activityTemplateFileOperateHandler;
        this.sem = sem;
    }

    @Override
    public ActivityTemplateFile downloadActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey)
            throws ServiceException {
        try {
            return activityTemplateFileOperateHandler.downloadActivityTemplateFile(userKey, activityTemplateFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("下载活动模板文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void uploadActivityTemplateFile(
            StringIdKey userKey, ActivityTemplateFileUploadInfo activityTemplateFileUploadInfo
    ) throws ServiceException {
        try {
            activityTemplateFileOperateHandler.uploadActivityTemplateFile(userKey, activityTemplateFileUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("上传活动模板文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updateActivityTemplateFile(
            StringIdKey userKey, ActivityTemplateFileUpdateInfo activityTemplateFileUpdateInfo
    ) throws ServiceException {
        try {
            activityTemplateFileOperateHandler.updateActivityTemplateFile(userKey, activityTemplateFileUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新活动模板文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removeActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey)
            throws ServiceException {
        try {
            activityTemplateFileOperateHandler.removeActivityTemplateFile(userKey, activityTemplateFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除活动模板文件时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
