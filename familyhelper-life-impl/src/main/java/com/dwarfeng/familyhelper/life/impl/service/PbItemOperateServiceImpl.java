package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.PbItemOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbItemOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class PbItemOperateServiceImpl implements PbItemOperateService {

    private final PbItemOperateHandler pbItemOperateHandler;

    private final ServiceExceptionMapper sem;

    public PbItemOperateServiceImpl(PbItemOperateHandler pbItemOperateHandler, ServiceExceptionMapper sem) {
        this.pbItemOperateHandler = pbItemOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createPbItem(StringIdKey userKey, PbItemCreateInfo pbItemCreateInfo)
            throws ServiceException {
        try {
            return pbItemOperateHandler.createPbItem(userKey, pbItemCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("创建个人最佳项目时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updatePbItem(StringIdKey userKey, PbItemUpdateInfo pbItemUpdateInfo)
            throws ServiceException {
        try {
            pbItemOperateHandler.updatePbItem(userKey, pbItemUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新个人最佳项目时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removePbItem(StringIdKey userKey, LongIdKey pbItemKey) throws ServiceException {
        try {
            pbItemOperateHandler.removePbItem(userKey, pbItemKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除个人最佳项目时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
