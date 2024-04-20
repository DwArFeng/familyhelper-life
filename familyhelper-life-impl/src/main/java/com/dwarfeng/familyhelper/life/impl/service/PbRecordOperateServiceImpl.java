package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.handler.PbRecordOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbRecordOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class PbRecordOperateServiceImpl implements PbRecordOperateService {

    private final PbRecordOperateHandler pbRecordOperateHandler;

    private final ServiceExceptionMapper sem;

    public PbRecordOperateServiceImpl(PbRecordOperateHandler pbRecordOperateHandler, ServiceExceptionMapper sem) {
        this.pbRecordOperateHandler = pbRecordOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createPbRecord(StringIdKey userKey, PbRecordCreateInfo pbRecordCreateInfo)
            throws ServiceException {
        try {
            return pbRecordOperateHandler.createPbRecord(userKey, pbRecordCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建个人最佳记录时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void updatePbRecord(StringIdKey userKey, PbRecordUpdateInfo pbRecordUpdateInfo)
            throws ServiceException {
        try {
            pbRecordOperateHandler.updatePbRecord(userKey, pbRecordUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新个人最佳记录时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removePbRecord(StringIdKey userKey, LongIdKey pbRecordKey) throws ServiceException {
        try {
            pbRecordOperateHandler.removePbRecord(userKey, pbRecordKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除个人最佳记录时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
