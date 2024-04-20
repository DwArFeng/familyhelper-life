package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateParticipantOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateParticipantOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class ActivityTemplateParticipantOperateServiceImpl implements ActivityTemplateParticipantOperateService {

    private final ActivityTemplateParticipantOperateHandler activityTemplateParticipantOperateHandler;

    private final ServiceExceptionMapper sem;

    public ActivityTemplateParticipantOperateServiceImpl(
            ActivityTemplateParticipantOperateHandler activityTemplateParticipantOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.activityTemplateParticipantOperateHandler = activityTemplateParticipantOperateHandler;
        this.sem = sem;
    }

    @Override
    public ActivityTemplateParticipantKey create(StringIdKey userKey, ActivityTemplateParticipantCreateInfo createInfo)
            throws ServiceException {
        try {
            return activityTemplateParticipantOperateHandler.create(userKey, createInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("插入活动模板参与者时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityTemplateParticipantUpdateInfo updateInfo) throws ServiceException {
        try {
            activityTemplateParticipantOperateHandler.update(userKey, updateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新活动模板参与者时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(StringIdKey userKey, ActivityTemplateParticipantRemoveInfo removeInfo) throws ServiceException {
        try {
            activityTemplateParticipantOperateHandler.remove(userKey, removeInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除活动模板参与者时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
