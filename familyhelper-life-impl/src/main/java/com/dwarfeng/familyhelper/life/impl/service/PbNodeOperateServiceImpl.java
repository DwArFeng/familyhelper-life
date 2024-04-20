package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.PbNodeOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbNodeOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class PbNodeOperateServiceImpl implements PbNodeOperateService {

    private final PbNodeOperateHandler pbNodeOperateHandler;

    private final ServiceExceptionMapper sem;

    public PbNodeOperateServiceImpl(PbNodeOperateHandler pbNodeOperateHandler, ServiceExceptionMapper sem) {
        this.pbNodeOperateHandler = pbNodeOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createPbNode(StringIdKey userKey, PbNodeCreateInfo pbNodeCreateInfo)
            throws ServiceException {
        try {
            return pbNodeOperateHandler.createPbNode(userKey, pbNodeCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建个人最佳节点时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void updatePbNode(StringIdKey userKey, PbNodeUpdateInfo pbNodeUpdateInfo)
            throws ServiceException {
        try {
            pbNodeOperateHandler.updatePbNode(userKey, pbNodeUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新个人最佳节点时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removePbNode(StringIdKey userKey, LongIdKey pbNodeKey) throws ServiceException {
        try {
            pbNodeOperateHandler.removePbNode(userKey, pbNodeKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除个人最佳节点时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
