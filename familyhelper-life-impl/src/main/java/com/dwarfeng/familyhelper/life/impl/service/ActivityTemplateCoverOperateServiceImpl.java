package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCover;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCoverOrderUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCoverUploadInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateCoverOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateCoverOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityTemplateCoverOperateServiceImpl implements ActivityTemplateCoverOperateService {

    private final ActivityTemplateCoverOperateHandler activityTemplateCoverOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityTemplateCoverOperateServiceImpl(
            ActivityTemplateCoverOperateHandler activityTemplateCoverOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityTemplateCoverOperateHandler = activityTemplateCoverOperateHandler;
        this.sem = sem;
    }

    @Override
    public ActivityTemplateCover download(StringIdKey userKey, LongIdKey coverKey) throws ServiceException {
        try {
            return activityTemplateCoverOperateHandler.download(userKey, coverKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载活动模板封面时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void upload(StringIdKey userKey, ActivityTemplateCoverUploadInfo coverUploadInfo) throws ServiceException {
        try {
            activityTemplateCoverOperateHandler.upload(userKey, coverUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("上传活动模板封面时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey coverKey) throws ServiceException {
        try {
            activityTemplateCoverOperateHandler.remove(userKey, coverKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除活动模板封面时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void updateOrder(StringIdKey userKey, ActivityTemplateCoverOrderUpdateInfo coverUpdateInfo)
            throws ServiceException {
        try {
            activityTemplateCoverOperateHandler.updateOrder(userKey, coverUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新活动模板封面的顺序时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
