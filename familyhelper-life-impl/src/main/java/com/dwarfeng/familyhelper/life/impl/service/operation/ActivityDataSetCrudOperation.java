package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataNode;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.familyhelper.life.stack.cache.ActivityDataSetCache;
import com.dwarfeng.familyhelper.life.stack.cache.PoadCache;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataItemDao;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataNodeDao;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataSetDao;
import com.dwarfeng.familyhelper.life.stack.dao.PoadDao;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataNodeMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoadMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityDataSetCrudOperation implements BatchCrudOperation<LongIdKey, ActivityDataSet> {

    private final ActivityDataSetDao activityDataSetDao;
    private final ActivityDataSetCache activityDataSetCache;

    private final PoadDao poadDao;
    private final PoadCache poadCache;

    private final ActivityDataItemDao activityDataItemDao;
    private final ActivityDataItemCrudOperation activityDataItemCrudOperation;

    private final ActivityDataNodeDao activityDataNodeDao;
    private final ActivityDataNodeCrudOperation activityDataNodeCrudOperation;

    @Value("${cache.timeout.entity.activity_data_set}")
    private long activityDataSetTimeout;

    public ActivityDataSetCrudOperation(
            ActivityDataSetDao ActivityDataSetDao, ActivityDataSetCache ActivityDataSetCache,
            PoadDao poadDao, PoadCache poadCache,
            ActivityDataItemDao activityDataItemDao, ActivityDataItemCrudOperation activityDataItemCrudOperation,
            ActivityDataNodeDao activityDataNodeDao, ActivityDataNodeCrudOperation activityDataNodeCrudOperation
    ) {
        this.activityDataSetDao = ActivityDataSetDao;
        this.activityDataSetCache = ActivityDataSetCache;
        this.poadDao = poadDao;
        this.poadCache = poadCache;
        this.activityDataItemDao = activityDataItemDao;
        this.activityDataItemCrudOperation = activityDataItemCrudOperation;
        this.activityDataNodeDao = activityDataNodeDao;
        this.activityDataNodeCrudOperation = activityDataNodeCrudOperation;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return activityDataSetCache.exists(key) || activityDataSetDao.exists(key);
    }

    @Override
    public ActivityDataSet get(LongIdKey key) throws Exception {
        if (activityDataSetCache.exists(key)) {
            return activityDataSetCache.get(key);
        } else {
            if (!activityDataSetDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            ActivityDataSet ActivityDataSet = activityDataSetDao.get(key);
            activityDataSetCache.push(ActivityDataSet, activityDataSetTimeout);
            return ActivityDataSet;
        }
    }

    @Override
    public LongIdKey insert(ActivityDataSet ActivityDataSet) throws Exception {
        activityDataSetCache.push(ActivityDataSet, activityDataSetTimeout);
        return activityDataSetDao.insert(ActivityDataSet);
    }

    @Override
    public void update(ActivityDataSet ActivityDataSet) throws Exception {
        activityDataSetCache.push(ActivityDataSet, activityDataSetTimeout);
        activityDataSetDao.update(ActivityDataSet);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 查找删除除所有相关的活动数据集合权限。
        List<PoadKey> poadKeys = poadDao.lookup(PoadMaintainService.CHILD_FOR_ACTIVITY_DATA_SET, new Object[]{key})
                .stream().map(Poad::getKey).collect(Collectors.toList());
        poadCache.batchDelete(poadKeys);
        poadDao.batchDelete(poadKeys);

        // 删除与个人最佳集合相关的活动数据条目。
        List<LongIdKey> activityDataItemKeys = activityDataItemDao.lookup(
                ActivityDataItemMaintainService.CHILD_FOR_SET, new Object[]{key}
        ).stream().map(ActivityDataItem::getKey).collect(Collectors.toList());
        activityDataItemCrudOperation.batchDelete(activityDataItemKeys);

        // 删除与个人最佳集合相关的活动数据节点。
        List<LongIdKey> activityDataNodeKeys = activityDataNodeDao.lookup(
                ActivityDataNodeMaintainService.CHILD_FOR_SET, new Object[]{key}
        ).stream().map(ActivityDataNode::getKey).collect(Collectors.toList());
        activityDataNodeCrudOperation.batchDelete(activityDataNodeKeys);

        // 删除自身。
        activityDataSetCache.delete(key);
        activityDataSetDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return activityDataSetCache.allExists(keys) || activityDataSetDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return activityDataSetCache.nonExists(keys) && activityDataSetDao.nonExists(keys);
    }

    @Override
    public List<ActivityDataSet> batchGet(List<LongIdKey> keys) throws Exception {
        if (activityDataSetCache.allExists(keys)) {
            return activityDataSetCache.batchGet(keys);
        } else {
            if (!activityDataSetDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<ActivityDataSet> ActivityDataSets = activityDataSetDao.batchGet(keys);
            activityDataSetCache.batchPush(ActivityDataSets, activityDataSetTimeout);
            return ActivityDataSets;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<ActivityDataSet> ActivityDataSets) throws Exception {
        activityDataSetCache.batchPush(ActivityDataSets, activityDataSetTimeout);
        return activityDataSetDao.batchInsert(ActivityDataSets);
    }

    @Override
    public void batchUpdate(List<ActivityDataSet> ActivityDataSets) throws Exception {
        activityDataSetCache.batchPush(ActivityDataSets, activityDataSetTimeout);
        activityDataSetDao.batchUpdate(ActivityDataSets);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
