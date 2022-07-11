package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.PbSetOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbSetOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class PbSetOperateServiceImpl implements PbSetOperateService {

    private final PbSetOperateHandler pbSetOperateHandler;

    private final ServiceExceptionMapper sem;

    public PbSetOperateServiceImpl(
            PbSetOperateHandler pbSetOperateHandler, ServiceExceptionMapper sem
    ) {
        this.pbSetOperateHandler = pbSetOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createPbSet(StringIdKey userKey, PbSetCreateInfo pbSetCreateInfo)
            throws ServiceException {
        try {
            return pbSetOperateHandler.createPbSet(userKey, pbSetCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("创建个人最佳集合时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void updatePbSet(StringIdKey userKey, PbSetUpdateInfo pbSetUpdateInfo)
            throws ServiceException {
        try {
            pbSetOperateHandler.updatePbSet(userKey, pbSetUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新个人最佳集合时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removePbSet(StringIdKey userKey, LongIdKey pbSetKey) throws ServiceException {
        try {
            pbSetOperateHandler.removePbSet(userKey, pbSetKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除个人最佳集合时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey ownerUserKey, PbSetPermissionUpsertInfo pbSetPermissionUpsertInfo
    ) throws ServiceException {
        try {
            pbSetOperateHandler.upsertPermission(ownerUserKey, pbSetPermissionUpsertInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("添加个人最佳集合的访客权限时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removePermission(
            StringIdKey ownerUserKey, PbSetPermissionRemoveInfo pbSetPermissionRemoveInfo
    ) throws ServiceException {
        try {
            pbSetOperateHandler.removePermission(ownerUserKey, pbSetPermissionRemoveInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("移除个人最佳集合的访客权限时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
