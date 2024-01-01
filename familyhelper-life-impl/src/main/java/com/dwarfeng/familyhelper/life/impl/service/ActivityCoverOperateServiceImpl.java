package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCover;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCoverOrderUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCoverUploadInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityCoverOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityCoverOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityCoverOperateServiceImpl implements ActivityCoverOperateService {

    private final ActivityCoverOperateHandler activityCoverOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityCoverOperateServiceImpl(
            ActivityCoverOperateHandler activityCoverOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityCoverOperateHandler = activityCoverOperateHandler;
        this.sem = sem;
    }

    @Override
    public ActivityCover download(StringIdKey userKey, LongIdKey coverKey) throws ServiceException {
        try {
            return activityCoverOperateHandler.download(userKey, coverKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("下载活动封面时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void upload(StringIdKey userKey, ActivityCoverUploadInfo coverUploadInfo) throws ServiceException {
        try {
            activityCoverOperateHandler.upload(userKey, coverUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("上传活动封面时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey coverKey) throws ServiceException {
        try {
            activityCoverOperateHandler.remove(userKey, coverKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除活动封面时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updateOrder(StringIdKey userKey, ActivityCoverOrderUpdateInfo coverUpdateInfo)
            throws ServiceException {
        try {
            activityCoverOperateHandler.updateOrder(userKey, coverUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新活动封面的顺序时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
