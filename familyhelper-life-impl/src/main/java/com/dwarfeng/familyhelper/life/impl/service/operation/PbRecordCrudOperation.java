package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.familyhelper.life.stack.cache.PbRecordCache;
import com.dwarfeng.familyhelper.life.stack.dao.PbFileInfoDao;
import com.dwarfeng.familyhelper.life.stack.dao.PbRecordDao;
import com.dwarfeng.familyhelper.life.stack.service.PbFileInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PbRecordCrudOperation implements BatchCrudOperation<LongIdKey, PbRecord> {

    private final PbRecordDao pbRecordDao;
    private final PbRecordCache pbRecordCache;

    private final PbFileInfoCrudOperation pbFileInfoCrudOperation;
    private final PbFileInfoDao pbFileInfoDao;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.pb_record}")
    private long pbRecordTimeout;

    public PbRecordCrudOperation(
            PbRecordDao pbRecordDao, PbRecordCache pbRecordCache,
            PbFileInfoCrudOperation pbFileInfoCrudOperation, PbFileInfoDao pbFileInfoDao,
            FtpHandler ftpHandler
    ) {
        this.pbRecordDao = pbRecordDao;
        this.pbRecordCache = pbRecordCache;
        this.pbFileInfoCrudOperation = pbFileInfoCrudOperation;
        this.pbFileInfoDao = pbFileInfoDao;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return pbRecordCache.exists(key) || pbRecordDao.exists(key);
    }

    @Override
    public PbRecord get(LongIdKey key) throws Exception {
        if (pbRecordCache.exists(key)) {
            return pbRecordCache.get(key);
        } else {
            if (!pbRecordDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            PbRecord pbRecord = pbRecordDao.get(key);
            pbRecordCache.push(pbRecord, pbRecordTimeout);
            return pbRecord;
        }
    }

    @Override
    public LongIdKey insert(PbRecord pbRecord) throws Exception {
        pbRecordCache.push(pbRecord, pbRecordTimeout);
        return pbRecordDao.insert(pbRecord);
    }

    @Override
    public void update(PbRecord pbRecord) throws Exception {
        pbRecordCache.push(pbRecord, pbRecordTimeout);
        pbRecordDao.update(pbRecord);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 如果存在个人最佳文件，则删除个人最佳文件。
        if (ftpHandler.existsFile(new String[]{FtpConstants.PATH_PB_FILE}, getFileName(key))) {
            ftpHandler.deleteFile(new String[]{FtpConstants.PATH_PB_FILE}, getFileName(key));
        }

        // 查找删除除所有相关的个人最佳文件信息。
        List<LongIdKey> pbFileInfoKeys = pbFileInfoDao.lookup(
                PbFileInfoMaintainService.CHILD_FOR_RECORD, new Object[]{key}
        ).stream().map(PbFileInfo::getKey).collect(Collectors.toList());
        pbFileInfoCrudOperation.batchDelete(pbFileInfoKeys);

        // 删除个人最佳记录自身。
        pbRecordCache.delete(key);
        pbRecordDao.delete(key);
    }

    private String getFileName(LongIdKey noteFileKey) {
        return Long.toString(noteFileKey.getLongId());
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return pbRecordCache.allExists(keys) || pbRecordDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return pbRecordCache.nonExists(keys) && pbRecordDao.nonExists(keys);
    }

    @Override
    public List<PbRecord> batchGet(List<LongIdKey> keys) throws Exception {
        if (pbRecordCache.allExists(keys)) {
            return pbRecordCache.batchGet(keys);
        } else {
            if (!pbRecordDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<PbRecord> pbRecords = pbRecordDao.batchGet(keys);
            pbRecordCache.batchPush(pbRecords, pbRecordTimeout);
            return pbRecords;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<PbRecord> pbRecords) throws Exception {
        pbRecordCache.batchPush(pbRecords, pbRecordTimeout);
        return pbRecordDao.batchInsert(pbRecords);
    }

    @Override
    public void batchUpdate(List<PbRecord> pbRecords) throws Exception {
        pbRecordCache.batchPush(pbRecords, pbRecordTimeout);
        pbRecordDao.batchUpdate(pbRecords);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
