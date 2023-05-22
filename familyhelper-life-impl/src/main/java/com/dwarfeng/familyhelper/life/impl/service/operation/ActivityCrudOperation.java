package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.familyhelper.life.stack.cache.*;
import com.dwarfeng.familyhelper.life.stack.dao.*;
import com.dwarfeng.familyhelper.life.stack.service.*;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityCrudOperation implements BatchCrudOperation<LongIdKey, Activity> {

    private final ActivityDao activityDao;
    private final ActivityCache activityCache;

    private final ActivityParticipantDao activityParticipantDao;
    private final ActivityParticipantCache activityParticipantCache;

    private final ActivityCoverInfoDao activityCoverInfoDao;
    private final ActivityCoverInfoCache activityCoverInfoCache;

    private final ActivityFileInfoDao activityFileInfoDao;
    private final ActivityFileInfoCache activityFileInfoCache;

    private final ActivityActivityDataRecordRelationDao activityActivityDataRecordRelationDao;
    private final ActivityActivityDataRecordRelationCache activityActivityDataRecordRelationCache;

    private final PoacDao poacDao;
    private final PoacCache poacCache;

    @Value("${cache.timeout.entity.activity}")
    private long activityTimeout;

    public ActivityCrudOperation(
            ActivityDao ActivityDao, ActivityCache ActivityCache,
            ActivityParticipantDao activityParticipantDao, ActivityParticipantCache activityParticipantCache,
            ActivityCoverInfoDao activityCoverInfoDao, ActivityCoverInfoCache activityCoverInfoCache,
            ActivityFileInfoDao activityFileInfoDao, ActivityFileInfoCache activityFileInfoCache,
            ActivityActivityDataRecordRelationDao activityActivityDataRecordRelationDao,
            ActivityActivityDataRecordRelationCache activityActivityDataRecordRelationCache,
            PoacDao poacDao, PoacCache poacCache
    ) {
        this.activityDao = ActivityDao;
        this.activityCache = ActivityCache;
        this.activityParticipantDao = activityParticipantDao;
        this.activityParticipantCache = activityParticipantCache;
        this.activityCoverInfoDao = activityCoverInfoDao;
        this.activityCoverInfoCache = activityCoverInfoCache;
        this.activityFileInfoDao = activityFileInfoDao;
        this.activityFileInfoCache = activityFileInfoCache;
        this.activityActivityDataRecordRelationDao = activityActivityDataRecordRelationDao;
        this.activityActivityDataRecordRelationCache = activityActivityDataRecordRelationCache;
        this.poacDao = poacDao;
        this.poacCache = poacCache;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return activityCache.exists(key) || activityDao.exists(key);
    }

    @Override
    public Activity get(LongIdKey key) throws Exception {
        if (activityCache.exists(key)) {
            return activityCache.get(key);
        } else {
            if (!activityDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            Activity Activity = activityDao.get(key);
            activityCache.push(Activity, activityTimeout);
            return Activity;
        }
    }

    @Override
    public LongIdKey insert(Activity Activity) throws Exception {
        activityCache.push(Activity, activityTimeout);
        return activityDao.insert(Activity);
    }

    @Override
    public void update(Activity Activity) throws Exception {
        activityCache.push(Activity, activityTimeout);
        activityDao.update(Activity);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 查找删除除所有相关的活动参与者。
        List<ActivityParticipantKey> activityParticipantKeys = activityParticipantDao.lookup(
                ActivityParticipantMaintainService.CHILD_FOR_ACTIVITY, new Object[]{key}
        ).stream().map(ActivityParticipant::getKey).collect(Collectors.toList());
        activityParticipantCache.batchDelete(activityParticipantKeys);
        activityParticipantDao.batchDelete(activityParticipantKeys);

        // 查找删除除所有相关的活动封面信息。
        List<LongIdKey> activityCoverInfoKeys = activityCoverInfoDao.lookup(
                ActivityCoverInfoMaintainService.CHILD_FOR_ACTIVITY, new Object[]{key}
        ).stream().map(ActivityCoverInfo::getKey).collect(Collectors.toList());
        activityCoverInfoCache.batchDelete(activityCoverInfoKeys);
        activityCoverInfoDao.batchDelete(activityCoverInfoKeys);
        // TODO 文件删除。

        // 查找删除除所有相关的活动文件信息。
        List<LongIdKey> activityFileInfoKeys = activityFileInfoDao.lookup(
                ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY, new Object[]{key}
        ).stream().map(ActivityFileInfo::getKey).collect(Collectors.toList());
        activityFileInfoCache.batchDelete(activityFileInfoKeys);
        activityFileInfoDao.batchDelete(activityFileInfoKeys);
        // TODO 文件删除。

        // 查找删除除所有相关的活动活动数据记录关联。
        List<LongLongRelationKey> activityActivityDataRecordRelationKeys = activityActivityDataRecordRelationDao.lookup(
                ActivityActivityDataRecordRelationMaintainService.CHILD_FOR_ACTIVITY, new Object[]{key}
        ).stream().map(ActivityActivityDataRecordRelation::getKey).collect(Collectors.toList());
        activityActivityDataRecordRelationCache.batchDelete(activityActivityDataRecordRelationKeys);
        activityActivityDataRecordRelationDao.batchDelete(activityActivityDataRecordRelationKeys);

        // 查找删除除所有相关的活动权限。
        List<PoacKey> poacKeys = poacDao.lookup(
                PoacMaintainService.CHILD_FOR_ACTIVITY, new Object[]{key}
        ).stream().map(Poac::getKey).collect(Collectors.toList());
        poacCache.batchDelete(poacKeys);
        poacDao.batchDelete(poacKeys);

        // 删除自身。
        activityCache.delete(key);
        activityDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return activityCache.allExists(keys) || activityDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return activityCache.nonExists(keys) && activityDao.nonExists(keys);
    }

    @Override
    public List<Activity> batchGet(List<LongIdKey> keys) throws Exception {
        if (activityCache.allExists(keys)) {
            return activityCache.batchGet(keys);
        } else {
            if (!activityDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<Activity> Activities = activityDao.batchGet(keys);
            activityCache.batchPush(Activities, activityTimeout);
            return Activities;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<Activity> activities) throws Exception {
        activityCache.batchPush(activities, activityTimeout);
        return activityDao.batchInsert(activities);
    }

    @Override
    public void batchUpdate(List<Activity> activities) throws Exception {
        activityCache.batchPush(activities, activityTimeout);
        activityDao.batchUpdate(activities);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
