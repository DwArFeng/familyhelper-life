package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.familyhelper.life.stack.cache.ActivityDataItemCache;
import com.dwarfeng.familyhelper.life.stack.cache.ActivityDataRecordCache;
import com.dwarfeng.familyhelper.life.stack.cache.ActivityTemplateDataInfoCache;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataItemDao;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataRecordDao;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityTemplateDataInfoDao;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataRecordMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDataInfoMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityDataItemCrudOperation implements BatchCrudOperation<LongIdKey, ActivityDataItem> {

    private final ActivityDataItemDao activityDataItemDao;
    private final ActivityDataItemCache activityDataItemCache;

    private final ActivityDataRecordDao activityDataRecordDao;
    private final ActivityDataRecordCache activityDataRecordCache;

    private final ActivityTemplateDataInfoDao activityTemplateDataInfoDao;
    private final ActivityTemplateDataInfoCache activityTemplateDataInfoCache;

    @Value("${cache.timeout.entity.activity_data_item}")
    private long activityDataItemTimeout;

    public ActivityDataItemCrudOperation(
            ActivityDataItemDao activityDataItemDao,
            ActivityDataItemCache activityDataItemCache,
            ActivityDataRecordDao activityDataRecordDao,
            ActivityDataRecordCache activityDataRecordCache,
            ActivityTemplateDataInfoDao activityTemplateDataInfoDao,
            ActivityTemplateDataInfoCache activityTemplateDataInfoCache
    ) {
        this.activityDataItemDao = activityDataItemDao;
        this.activityDataItemCache = activityDataItemCache;
        this.activityDataRecordDao = activityDataRecordDao;
        this.activityDataRecordCache = activityDataRecordCache;
        this.activityTemplateDataInfoDao = activityTemplateDataInfoDao;
        this.activityTemplateDataInfoCache = activityTemplateDataInfoCache;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return activityDataItemCache.exists(key) || activityDataItemDao.exists(key);
    }

    @Override
    public ActivityDataItem get(LongIdKey key) throws Exception {
        if (activityDataItemCache.exists(key)) {
            return activityDataItemCache.get(key);
        } else {
            if (!activityDataItemDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            ActivityDataItem ActivityDataItem = activityDataItemDao.get(key);
            activityDataItemCache.push(ActivityDataItem, activityDataItemTimeout);
            return ActivityDataItem;
        }
    }

    @Override
    public LongIdKey insert(ActivityDataItem ActivityDataItem) throws Exception {
        activityDataItemCache.push(ActivityDataItem, activityDataItemTimeout);
        return activityDataItemDao.insert(ActivityDataItem);
    }

    @Override
    public void update(ActivityDataItem ActivityDataItem) throws Exception {
        activityDataItemCache.push(ActivityDataItem, activityDataItemTimeout);
        activityDataItemDao.update(ActivityDataItem);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 查找删除所有相关的活动数据记录。
        List<LongIdKey> activityDataRecordKeys = activityDataRecordDao.lookup(
                ActivityDataRecordMaintainService.CHILD_FOR_ITEM, new Object[]{key}
        ).stream().map(ActivityDataRecord::getKey).collect(Collectors.toList());
        activityDataRecordCache.batchDelete(activityDataRecordKeys);
        activityDataRecordDao.batchDelete(activityDataRecordKeys);

        // 查找删除所有相关的活动模板数据信息。
        List<LongIdKey> activityTemplateDataInfoKeys = activityTemplateDataInfoDao.lookup(
                ActivityTemplateDataInfoMaintainService.CHILD_FOR_ACTIVITY_DATA_ITEM, new Object[]{key}
        ).stream().map(ActivityTemplateDataInfo::getKey).collect(Collectors.toList());
        activityTemplateDataInfoCache.batchDelete(activityTemplateDataInfoKeys);
        activityTemplateDataInfoDao.batchDelete(activityTemplateDataInfoKeys);

        // 删除自身。
        activityDataItemCache.delete(key);
        activityDataItemDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return activityDataItemCache.allExists(keys) || activityDataItemDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return activityDataItemCache.nonExists(keys) && activityDataItemDao.nonExists(keys);
    }

    @Override
    public List<ActivityDataItem> batchGet(List<LongIdKey> keys) throws Exception {
        if (activityDataItemCache.allExists(keys)) {
            return activityDataItemCache.batchGet(keys);
        } else {
            if (!activityDataItemDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<ActivityDataItem> ActivityDataItems = activityDataItemDao.batchGet(keys);
            activityDataItemCache.batchPush(ActivityDataItems, activityDataItemTimeout);
            return ActivityDataItems;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<ActivityDataItem> ActivityDataItems) throws Exception {
        activityDataItemCache.batchPush(ActivityDataItems, activityDataItemTimeout);
        return activityDataItemDao.batchInsert(ActivityDataItems);
    }

    @Override
    public void batchUpdate(List<ActivityDataItem> ActivityDataItems) throws Exception {
        activityDataItemCache.batchPush(ActivityDataItems, activityDataItemTimeout);
        activityDataItemDao.batchUpdate(ActivityDataItems);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
