package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.familyhelper.life.stack.cache.PbFileInfoCache;
import com.dwarfeng.familyhelper.life.stack.dao.PbFileInfoDao;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PbFileInfoCrudOperation implements BatchCrudOperation<LongIdKey, PbFileInfo> {

    private final PbFileInfoDao pbFileInfoDao;
    private final PbFileInfoCache pbFileInfoCache;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.pb_file_info}")
    private long pbFileInfoTimeout;

    public PbFileInfoCrudOperation(
            PbFileInfoDao pbFileInfoDao, PbFileInfoCache pbFileInfoCache,
            FtpHandler ftpHandler
    ) {
        this.pbFileInfoDao = pbFileInfoDao;
        this.pbFileInfoCache = pbFileInfoCache;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return pbFileInfoCache.exists(key) || pbFileInfoDao.exists(key);
    }

    @Override
    public PbFileInfo get(LongIdKey key) throws Exception {
        if (pbFileInfoCache.exists(key)) {
            return pbFileInfoCache.get(key);
        } else {
            if (!pbFileInfoDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            PbFileInfo pbFileInfo = pbFileInfoDao.get(key);
            pbFileInfoCache.push(pbFileInfo, pbFileInfoTimeout);
            return pbFileInfo;
        }
    }

    @Override
    public LongIdKey insert(PbFileInfo pbFileInfo) throws Exception {
        pbFileInfoCache.push(pbFileInfo, pbFileInfoTimeout);
        return pbFileInfoDao.insert(pbFileInfo);
    }

    @Override
    public void update(PbFileInfo pbFileInfo) throws Exception {
        pbFileInfoCache.push(pbFileInfo, pbFileInfoTimeout);
        pbFileInfoDao.update(pbFileInfo);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 如果存在个人最佳文件，则删除个人最佳文件。
        if (ftpHandler.existsFile(new String[]{FtpConstants.PATH_PB_FILE}, getFileName(key))) {
            ftpHandler.deleteFile(new String[]{FtpConstants.PATH_PB_FILE}, getFileName(key));
        }

        // 删除个人最佳文件信息实体自身。
        pbFileInfoCache.delete(key);
        pbFileInfoDao.delete(key);
    }

    private String getFileName(LongIdKey pbFileKey) {
        return Long.toString(pbFileKey.getLongId());
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return pbFileInfoCache.allExists(keys) || pbFileInfoDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return pbFileInfoCache.nonExists(keys) && pbFileInfoDao.nonExists(keys);
    }

    @Override
    public List<PbFileInfo> batchGet(List<LongIdKey> keys) throws Exception {
        if (pbFileInfoCache.allExists(keys)) {
            return pbFileInfoCache.batchGet(keys);
        } else {
            if (!pbFileInfoDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<PbFileInfo> pbFileInfos = pbFileInfoDao.batchGet(keys);
            pbFileInfoCache.batchPush(pbFileInfos, pbFileInfoTimeout);
            return pbFileInfos;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<PbFileInfo> pbFileInfos) throws Exception {
        pbFileInfoCache.batchPush(pbFileInfos, pbFileInfoTimeout);
        return pbFileInfoDao.batchInsert(pbFileInfos);
    }

    @Override
    public void batchUpdate(List<PbFileInfo> pbFileInfos) throws Exception {
        pbFileInfoCache.batchPush(pbFileInfos, pbFileInfoTimeout);
        pbFileInfoDao.batchUpdate(pbFileInfos);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
