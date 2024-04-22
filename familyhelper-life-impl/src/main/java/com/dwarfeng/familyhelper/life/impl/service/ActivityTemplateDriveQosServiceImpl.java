package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriveHandler;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriveLocalCacheHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriveQosService;
import com.dwarfeng.familyhelper.life.stack.struct.ActivityTemplateDriveInfo;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityTemplateDriveQosServiceImpl implements ActivityTemplateDriveQosService {

    private final ActivityTemplateDriveHandler activityTemplateDriveHandler;
    private final ActivityTemplateDriveLocalCacheHandler activityTemplateDriveLocalCacheHandler;

    private final ServiceExceptionMapper sem;

    public ActivityTemplateDriveQosServiceImpl(
            ActivityTemplateDriveHandler activityTemplateDriveHandler,
            ActivityTemplateDriveLocalCacheHandler activityTemplateDriveLocalCacheHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityTemplateDriveHandler = activityTemplateDriveHandler;
        this.activityTemplateDriveLocalCacheHandler = activityTemplateDriveLocalCacheHandler;
        this.sem = sem;
    }

    @Override
    public boolean isOnline() throws ServiceException {
        try {
            return activityTemplateDriveHandler.isOnline();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("判断活动模板驱动处理器是否上线时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void online() throws ServiceException {
        try {
            activityTemplateDriveHandler.online();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("上线活动模板驱动处理器时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void offline() throws ServiceException {
        try {
            activityTemplateDriveHandler.offline();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下线活动模板驱动处理器时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public boolean isLockHolding() throws ServiceException {
        try {
            return activityTemplateDriveHandler.isLockHolding();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("判断活动模板驱动处理器是否正在持有锁时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public boolean isStarted() throws ServiceException {
        try {
            return activityTemplateDriveHandler.isStarted();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("判断活动模板驱动处理器是否启动时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void start() throws ServiceException {
        try {
            activityTemplateDriveHandler.start();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("活动模板驱动处理器启动时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void stop() throws ServiceException {
        try {
            activityTemplateDriveHandler.stop();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("活动模板驱动处理器停止时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public boolean isWorking() throws ServiceException {
        try {
            return activityTemplateDriveHandler.isWorking();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("判断活动模板驱动处理器是否正在工作时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public ActivityTemplateDriveInfo getActivityTemplateDriveInfo(LongIdKey activityTemplateKey)
            throws ServiceException {
        try {
            return activityTemplateDriveLocalCacheHandler.get(activityTemplateKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("获取指定活动模板的活动模板驱动信息时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void clearLocalCache() throws ServiceException {
        try {
            activityTemplateDriveLocalCacheHandler.clear();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("清除本地缓存时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
