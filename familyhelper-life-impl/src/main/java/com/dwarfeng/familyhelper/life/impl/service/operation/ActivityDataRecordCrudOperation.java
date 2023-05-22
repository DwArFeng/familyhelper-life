package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.familyhelper.life.stack.cache.ActivityActivityDataRecordRelationCache;
import com.dwarfeng.familyhelper.life.stack.cache.ActivityDataRecordCache;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityActivityDataRecordRelationDao;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataRecordDao;
import com.dwarfeng.familyhelper.life.stack.service.ActivityActivityDataRecordRelationMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityDataRecordCrudOperation implements BatchCrudOperation<LongIdKey, ActivityDataRecord> {

    private final ActivityDataRecordDao activityDataRecordDao;
    private final ActivityDataRecordCache activityDataRecordCache;

    private final ActivityActivityDataRecordRelationDao activityActivityDataRecordRelationDao;
    private final ActivityActivityDataRecordRelationCache activityActivityDataRecordRelationCache;

    @Value("${cache.timeout.entity.activity_data_record}")
    private long activityDataRecordTimeout;

    public ActivityDataRecordCrudOperation(
            ActivityDataRecordDao ActivityDataRecordDao, ActivityDataRecordCache ActivityDataRecordCache,
            ActivityActivityDataRecordRelationDao activityActivityDataRecordRelationDao,
            ActivityActivityDataRecordRelationCache activityActivityDataRecordRelationCache
    ) {
        this.activityDataRecordDao = ActivityDataRecordDao;
        this.activityDataRecordCache = ActivityDataRecordCache;
        this.activityActivityDataRecordRelationDao = activityActivityDataRecordRelationDao;
        this.activityActivityDataRecordRelationCache = activityActivityDataRecordRelationCache;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return activityDataRecordCache.exists(key) || activityDataRecordDao.exists(key);
    }

    @Override
    public ActivityDataRecord get(LongIdKey key) throws Exception {
        if (activityDataRecordCache.exists(key)) {
            return activityDataRecordCache.get(key);
        } else {
            if (!activityDataRecordDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            ActivityDataRecord ActivityDataRecord = activityDataRecordDao.get(key);
            activityDataRecordCache.push(ActivityDataRecord, activityDataRecordTimeout);
            return ActivityDataRecord;
        }
    }

    @Override
    public LongIdKey insert(ActivityDataRecord ActivityDataRecord) throws Exception {
        activityDataRecordCache.push(ActivityDataRecord, activityDataRecordTimeout);
        return activityDataRecordDao.insert(ActivityDataRecord);
    }

    @Override
    public void update(ActivityDataRecord ActivityDataRecord) throws Exception {
        activityDataRecordCache.push(ActivityDataRecord, activityDataRecordTimeout);
        activityDataRecordDao.update(ActivityDataRecord);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 查找删除除所有相关的活动活动数据记录关联。
        List<LongLongRelationKey> activityActivityDataRecordRelationKeys = activityActivityDataRecordRelationDao.lookup(
                ActivityActivityDataRecordRelationMaintainService.CHILD_FOR_ACTIVITY_DATA_RECORD, new Object[]{key}
        ).stream().map(ActivityActivityDataRecordRelation::getKey).collect(Collectors.toList());
        activityActivityDataRecordRelationCache.batchDelete(activityActivityDataRecordRelationKeys);
        activityActivityDataRecordRelationDao.batchDelete(activityActivityDataRecordRelationKeys);

        // 删除自身。
        activityDataRecordCache.delete(key);
        activityDataRecordDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return activityDataRecordCache.allExists(keys) || activityDataRecordDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return activityDataRecordCache.nonExists(keys) && activityDataRecordDao.nonExists(keys);
    }

    @Override
    public List<ActivityDataRecord> batchGet(List<LongIdKey> keys) throws Exception {
        if (activityDataRecordCache.allExists(keys)) {
            return activityDataRecordCache.batchGet(keys);
        } else {
            if (!activityDataRecordDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<ActivityDataRecord> ActivityDataRecords = activityDataRecordDao.batchGet(keys);
            activityDataRecordCache.batchPush(ActivityDataRecords, activityDataRecordTimeout);
            return ActivityDataRecords;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<ActivityDataRecord> ActivityDataRecords) throws Exception {
        activityDataRecordCache.batchPush(ActivityDataRecords, activityDataRecordTimeout);
        return activityDataRecordDao.batchInsert(ActivityDataRecords);
    }

    @Override
    public void batchUpdate(List<ActivityDataRecord> ActivityDataRecords) throws Exception {
        activityDataRecordCache.batchPush(ActivityDataRecords, activityDataRecordTimeout);
        activityDataRecordDao.batchUpdate(ActivityDataRecords);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
