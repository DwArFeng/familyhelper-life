package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatacKey;
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
public class ActivityTemplateCrudOperation implements BatchCrudOperation<LongIdKey, ActivityTemplate> {

    private final ActivityTemplateDao activityTemplateDao;
    private final ActivityTemplateCache activityTemplateCache;

    private final ActivityTemplateParticipantDao activityTemplateParticipantDao;
    private final ActivityTemplateParticipantCache activityTemplateParticipantCache;

    private final ActivityTemplateCoverInfoDao activityTemplateCoverInfoDao;
    private final ActivityTemplateCoverInfoCache activityTemplateCoverInfoCache;

    private final ActivityTemplateDataInfoDao activityTemplateDataInfoDao;
    private final ActivityTemplateDataInfoCache activityTemplateDataInfoCache;

    private final ActivityTemplateFileInfoDao activityTemplateFileInfoDao;
    private final ActivityTemplateFileInfoCache activityTemplateFileInfoCache;

    private final PoatDao poatDao;
    private final PoatCache poatCache;

    private final PoatacDao poatacDao;
    private final PoatacCache poatacCache;

    private final ActivityTemplateDriverInfoDao activityTemplateDriverInfoDao;
    private final ActivityTemplateDriverInfoCache activityTemplateDriverInfoCache;

    @Value("${cache.timeout.entity.activity_template}")
    private long activityTemplateTimeout;

    public ActivityTemplateCrudOperation(
            ActivityTemplateDao activityTemplateDao,
            ActivityTemplateCache activityTemplateCache,
            ActivityTemplateParticipantDao activityTemplateParticipantDao,
            ActivityTemplateParticipantCache activityTemplateParticipantCache,
            ActivityTemplateCoverInfoDao activityTemplateCoverInfoDao,
            ActivityTemplateCoverInfoCache activityTemplateCoverInfoCache,
            ActivityTemplateDataInfoDao activityTemplateDataInfoDao,
            ActivityTemplateDataInfoCache activityTemplateDataInfoCache,
            ActivityTemplateFileInfoDao activityTemplateFileInfoDao,
            ActivityTemplateFileInfoCache activityTemplateFileInfoCache,
            PoatDao poatDao,
            PoatCache poatCache,
            PoatacDao poatacDao,
            PoatacCache poatacCache,
            ActivityTemplateDriverInfoDao activityTemplateDriverInfoDao,
            ActivityTemplateDriverInfoCache activityTemplateDriverInfoCache
    ) {
        this.activityTemplateDao = activityTemplateDao;
        this.activityTemplateCache = activityTemplateCache;
        this.activityTemplateParticipantDao = activityTemplateParticipantDao;
        this.activityTemplateParticipantCache = activityTemplateParticipantCache;
        this.activityTemplateCoverInfoDao = activityTemplateCoverInfoDao;
        this.activityTemplateCoverInfoCache = activityTemplateCoverInfoCache;
        this.activityTemplateDataInfoDao = activityTemplateDataInfoDao;
        this.activityTemplateDataInfoCache = activityTemplateDataInfoCache;
        this.activityTemplateFileInfoDao = activityTemplateFileInfoDao;
        this.activityTemplateFileInfoCache = activityTemplateFileInfoCache;
        this.poatDao = poatDao;
        this.poatCache = poatCache;
        this.poatacDao = poatacDao;
        this.poatacCache = poatacCache;
        this.activityTemplateDriverInfoDao = activityTemplateDriverInfoDao;
        this.activityTemplateDriverInfoCache = activityTemplateDriverInfoCache;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return activityTemplateCache.exists(key) || activityTemplateDao.exists(key);
    }

    @Override
    public ActivityTemplate get(LongIdKey key) throws Exception {
        if (activityTemplateCache.exists(key)) {
            return activityTemplateCache.get(key);
        } else {
            if (!activityTemplateDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            ActivityTemplate ActivityTemplate = activityTemplateDao.get(key);
            activityTemplateCache.push(ActivityTemplate, activityTemplateTimeout);
            return ActivityTemplate;
        }
    }

    @Override
    public LongIdKey insert(ActivityTemplate ActivityTemplate) throws Exception {
        activityTemplateCache.push(ActivityTemplate, activityTemplateTimeout);
        return activityTemplateDao.insert(ActivityTemplate);
    }

    @Override
    public void update(ActivityTemplate ActivityTemplate) throws Exception {
        activityTemplateCache.push(ActivityTemplate, activityTemplateTimeout);
        activityTemplateDao.update(ActivityTemplate);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 查找删除所有相关的活动模板参与者。
        List<ActivityTemplateParticipantKey> activityTemplateParticipantKeys = activityTemplateParticipantDao.lookup(
                ActivityTemplateParticipantMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{key}
        ).stream().map(ActivityTemplateParticipant::getKey).collect(Collectors.toList());
        activityTemplateParticipantCache.batchDelete(activityTemplateParticipantKeys);
        activityTemplateParticipantDao.batchDelete(activityTemplateParticipantKeys);

        // 查找删除所有相关的活动模板封面信息。
        List<LongIdKey> activityTemplateCoverInfoKeys = activityTemplateCoverInfoDao.lookup(
                ActivityTemplateCoverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{key}
        ).stream().map(ActivityTemplateCoverInfo::getKey).collect(Collectors.toList());
        activityTemplateCoverInfoCache.batchDelete(activityTemplateCoverInfoKeys);
        activityTemplateCoverInfoDao.batchDelete(activityTemplateCoverInfoKeys);
        // TODO 文件删除。

        // 查找删除所有相关的活动模板数据信息。
        List<LongIdKey> activityTemplateDataInfoKeys = activityTemplateDataInfoDao.lookup(
                ActivityTemplateDataInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{key}
        ).stream().map(ActivityTemplateDataInfo::getKey).collect(Collectors.toList());
        activityTemplateDataInfoCache.batchDelete(activityTemplateDataInfoKeys);
        activityTemplateDataInfoDao.batchDelete(activityTemplateDataInfoKeys);

        // 查找删除所有相关的活动模板文件信息。
        List<LongIdKey> activityTemplateFileInfoKeys = activityTemplateFileInfoDao.lookup(
                ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{key}
        ).stream().map(ActivityTemplateFileInfo::getKey).collect(Collectors.toList());
        activityTemplateFileInfoCache.batchDelete(activityTemplateFileInfoKeys);
        activityTemplateFileInfoDao.batchDelete(activityTemplateFileInfoKeys);
        // TODO 文件删除。

        // 查找删除所有相关的活动模板权限。
        List<PoatKey> poatKeys = poatDao.lookup(
                PoatMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{key}
        ).stream().map(Poat::getKey).collect(Collectors.toList());
        poatCache.batchDelete(poatKeys);
        poatDao.batchDelete(poatKeys);

        // 查找删除所有相关的活动模板活动权限。
        List<PoatacKey> poatacKeys = poatacDao.lookup(
                PoatacMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{key}
        ).stream().map(Poatac::getKey).collect(Collectors.toList());
        poatacCache.batchDelete(poatacKeys);
        poatacDao.batchDelete(poatacKeys);

        // 查找删除所有相关的活动模板驱动信息。
        List<LongIdKey> activityTemplateDriverInfoKeys = activityTemplateDriverInfoDao.lookup(
                ActivityTemplateDriverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{key}
        ).stream().map(ActivityTemplateDriverInfo::getKey).collect(Collectors.toList());
        activityTemplateDriverInfoCache.batchDelete(activityTemplateDriverInfoKeys);
        activityTemplateDriverInfoDao.batchDelete(activityTemplateDriverInfoKeys);

        // 删除自身。
        activityTemplateCache.delete(key);
        activityTemplateDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return activityTemplateCache.allExists(keys) || activityTemplateDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return activityTemplateCache.nonExists(keys) && activityTemplateDao.nonExists(keys);
    }

    @Override
    public List<ActivityTemplate> batchGet(List<LongIdKey> keys) throws Exception {
        if (activityTemplateCache.allExists(keys)) {
            return activityTemplateCache.batchGet(keys);
        } else {
            if (!activityTemplateDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<ActivityTemplate> ActivityTemplates = activityTemplateDao.batchGet(keys);
            activityTemplateCache.batchPush(ActivityTemplates, activityTemplateTimeout);
            return ActivityTemplates;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<ActivityTemplate> activityTemplates) throws Exception {
        activityTemplateCache.batchPush(activityTemplates, activityTemplateTimeout);
        return activityTemplateDao.batchInsert(activityTemplates);
    }

    @Override
    public void batchUpdate(List<ActivityTemplate> activityTemplates) throws Exception {
        activityTemplateCache.batchPush(activityTemplates, activityTemplateTimeout);
        activityTemplateDao.batchUpdate(activityTemplates);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
