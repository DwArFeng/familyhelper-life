package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityParticipantOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityParticipantOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityParticipantOperateServiceImpl implements ActivityParticipantOperateService {

    private final ActivityParticipantOperateHandler activityParticipantOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityParticipantOperateServiceImpl(
            ActivityParticipantOperateHandler activityParticipantOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityParticipantOperateHandler = activityParticipantOperateHandler;
        this.sem = sem;
    }

    @Override
    public ActivityParticipantKey create(StringIdKey userKey, ActivityParticipantCreateInfo createInfo)
            throws ServiceException {
        try {
            return activityParticipantOperateHandler.create(userKey, createInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("插入活动参与者时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityParticipantUpdateInfo updateInfo) throws ServiceException {
        try {
            activityParticipantOperateHandler.update(userKey, updateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新活动参与者时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(StringIdKey userKey, ActivityParticipantRemoveInfo removeInfo) throws ServiceException {
        try {
            activityParticipantOperateHandler.remove(userKey, removeInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除活动参与者时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
