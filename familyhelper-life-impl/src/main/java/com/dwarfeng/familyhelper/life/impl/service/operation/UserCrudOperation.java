package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.familyhelper.life.stack.cache.*;
import com.dwarfeng.familyhelper.life.stack.dao.*;
import com.dwarfeng.familyhelper.life.stack.service.*;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserCrudOperation implements BatchCrudOperation<StringIdKey, User> {

    private final UserDao userDao;
    private final UserCache userCache;

    private final PopbDao popbDao;
    private final PopbCache popbCache;

    private final ActivityParticipantDao activityParticipantDao;
    private final ActivityParticipantCache activityParticipantCache;

    private final ActivityTemplateParticipantDao activityTemplateParticipantDao;
    private final ActivityTemplateParticipantCache activityTemplateParticipantCache;

    private final PoadDao poadDao;
    private final PoadCache poadCache;

    private final PoacDao poacDao;
    private final PoacCache poacCache;

    private final PoatDao poatDao;
    private final PoatCache poatCache;

    private final PoatacDao poatacDao;
    private final PoatacCache poatacCache;

    @Value("${cache.timeout.entity.user}")
    private long userTimeout;

    public UserCrudOperation(
            UserDao userDao, UserCache userCache,
            PopbDao popbDao, PopbCache popbCache,
            ActivityParticipantDao activityParticipantDao, ActivityParticipantCache activityParticipantCache,
            ActivityTemplateParticipantDao activityTemplateParticipantDao,
            ActivityTemplateParticipantCache activityTemplateParticipantCache,
            PoadDao poadDao, PoadCache poadCache,
            PoacDao poacDao, PoacCache poacCache,
            PoatDao poatDao, PoatCache poatCache,
            PoatacDao poatacDao, PoatacCache poatacCache
    ) {
        this.userDao = userDao;
        this.userCache = userCache;
        this.popbDao = popbDao;
        this.popbCache = popbCache;
        this.activityParticipantDao = activityParticipantDao;
        this.activityParticipantCache = activityParticipantCache;
        this.activityTemplateParticipantDao = activityTemplateParticipantDao;
        this.activityTemplateParticipantCache = activityTemplateParticipantCache;
        this.poadDao = poadDao;
        this.poadCache = poadCache;
        this.poacDao = poacDao;
        this.poacCache = poacCache;
        this.poatDao = poatDao;
        this.poatCache = poatCache;
        this.poatacDao = poatacDao;
        this.poatacCache = poatacCache;
    }

    @Override
    public boolean exists(StringIdKey key) throws Exception {
        return userCache.exists(key) || userDao.exists(key);
    }

    @Override
    public User get(StringIdKey key) throws Exception {
        if (userCache.exists(key)) {
            return userCache.get(key);
        } else {
            if (!userDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            User user = userDao.get(key);
            userCache.push(user, userTimeout);
            return user;
        }
    }

    @Override
    public StringIdKey insert(User user) throws Exception {
        userCache.push(user, userTimeout);
        return userDao.insert(user);
    }

    @Override
    public void update(User user) throws Exception {
        userCache.push(user, userTimeout);
        userDao.update(user);
    }

    @Override
    public void delete(StringIdKey key) throws Exception {
        // 删除与用户相关的个人最佳权限。
        List<PopbKey> popbKeys = popbDao.lookup(PopbMaintainService.CHILD_FOR_USER, new Object[]{key})
                .stream().map(Popb::getKey).collect(Collectors.toList());
        popbCache.batchDelete(popbKeys);
        popbDao.batchDelete(popbKeys);

        // 查找删除除所有相关的活动参与者。
        List<ActivityParticipantKey> activityParticipantKeys = activityParticipantDao.lookup(
                ActivityParticipantMaintainService.CHILD_FOR_USER, new Object[]{key}
        ).stream().map(ActivityParticipant::getKey).collect(Collectors.toList());
        activityParticipantCache.batchDelete(activityParticipantKeys);
        activityParticipantDao.batchDelete(activityParticipantKeys);

        // 查找删除除所有相关的活动模板参与者。
        List<ActivityTemplateParticipantKey> activityTemplateParticipantKeys = activityTemplateParticipantDao.lookup(
                ActivityTemplateParticipantMaintainService.CHILD_FOR_USER, new Object[]{key}
        ).stream().map(ActivityTemplateParticipant::getKey).collect(Collectors.toList());
        activityTemplateParticipantCache.batchDelete(activityTemplateParticipantKeys);
        activityTemplateParticipantDao.batchDelete(activityTemplateParticipantKeys);

        // 查找删除除所有相关的活动数据集合权限。
        List<PoadKey> poadKeys = poadDao.lookup(PoadMaintainService.CHILD_FOR_USER, new Object[]{key})
                .stream().map(Poad::getKey).collect(Collectors.toList());
        poadCache.batchDelete(poadKeys);
        poadDao.batchDelete(poadKeys);

        // 查找删除除所有相关的活动权限。
        List<PoacKey> poacKeys = poacDao.lookup(
                PoacMaintainService.CHILD_FOR_USER, new Object[]{key}
        ).stream().map(Poac::getKey).collect(Collectors.toList());
        poacCache.batchDelete(poacKeys);
        poacDao.batchDelete(poacKeys);

        // 查找删除除所有相关的活动模板权限。
        List<PoatKey> poatKeys = poatDao.lookup(
                PoatMaintainService.CHILD_FOR_USER, new Object[]{key}
        ).stream().map(Poat::getKey).collect(Collectors.toList());
        poatCache.batchDelete(poatKeys);
        poatDao.batchDelete(poatKeys);

        // 查找删除除所有相关的活动模板活动权限。
        List<PoatacKey> poatacKeys = poatacDao.lookup(
                PoatacMaintainService.CHILD_FOR_USER, new Object[]{key}
        ).stream().map(Poatac::getKey).collect(Collectors.toList());
        poatacCache.batchDelete(poatacKeys);
        poatacDao.batchDelete(poatacKeys);

        // 删除用户实体自身。
        userCache.delete(key);
        userDao.delete(key);
    }

    @Override
    public boolean allExists(List<StringIdKey> keys) throws Exception {
        return userCache.allExists(keys) || userDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<StringIdKey> keys) throws Exception {
        return userCache.nonExists(keys) && userDao.nonExists(keys);
    }

    @Override
    public List<User> batchGet(List<StringIdKey> keys) throws Exception {
        if (userCache.allExists(keys)) {
            return userCache.batchGet(keys);
        } else {
            if (!userDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<User> users = userDao.batchGet(keys);
            userCache.batchPush(users, userTimeout);
            return users;
        }
    }

    @Override
    public List<StringIdKey> batchInsert(List<User> users) throws Exception {
        userCache.batchPush(users, userTimeout);
        return userDao.batchInsert(users);
    }

    @Override
    public void batchUpdate(List<User> users) throws Exception {
        userCache.batchPush(users, userTimeout);
        userDao.batchUpdate(users);
    }

    @Override
    public void batchDelete(List<StringIdKey> keys) throws Exception {
        for (StringIdKey key : keys) {
            delete(key);
        }
    }
}
