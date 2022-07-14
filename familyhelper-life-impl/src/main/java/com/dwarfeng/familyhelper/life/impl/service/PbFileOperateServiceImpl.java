package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFileUploadInfo;
import com.dwarfeng.familyhelper.life.stack.handler.PbFileOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbFileOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class PbFileOperateServiceImpl implements PbFileOperateService {

    private final PbFileOperateHandler pbFileOperateHandler;

    private final ServiceExceptionMapper sem;

    public PbFileOperateServiceImpl(
            PbFileOperateHandler pbFileOperateHandler, ServiceExceptionMapper sem
    ) {
        this.pbFileOperateHandler = pbFileOperateHandler;
        this.sem = sem;
    }

    @Override
    public PbFile downloadPbFile(StringIdKey userKey, LongIdKey pbFileKey) throws ServiceException {
        try {
            return pbFileOperateHandler.downloadPbFile(userKey, pbFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("下载个人最佳文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void uploadPbFile(StringIdKey userKey, PbFileUploadInfo pbFileUploadInfo)
            throws ServiceException {
        try {
            pbFileOperateHandler.uploadPbFile(userKey, pbFileUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("上传个人最佳文件时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removePbFile(StringIdKey userKey, LongIdKey pbFileKey) throws ServiceException {
        try {
            pbFileOperateHandler.removePbFile(userKey, pbFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("删除个人最佳文件时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
