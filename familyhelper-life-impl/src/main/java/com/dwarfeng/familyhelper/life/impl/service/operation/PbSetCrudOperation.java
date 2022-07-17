package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.familyhelper.life.stack.cache.PbSetCache;
import com.dwarfeng.familyhelper.life.stack.cache.PopbCache;
import com.dwarfeng.familyhelper.life.stack.dao.PbItemDao;
import com.dwarfeng.familyhelper.life.stack.dao.PbNodeDao;
import com.dwarfeng.familyhelper.life.stack.dao.PbSetDao;
import com.dwarfeng.familyhelper.life.stack.dao.PopbDao;
import com.dwarfeng.familyhelper.life.stack.service.PbItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbNodeMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PopbMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PbSetCrudOperation implements BatchCrudOperation<LongIdKey, PbSet> {

    private final PbSetDao pbSetDao;
    private final PbSetCache pbSetCache;

    private final PopbDao popbDao;
    private final PopbCache popbCache;

    private final PbItemDao pbItemDao;
    private final PbItemCrudOperation pbItemCrudOperation;

    private final PbNodeDao pbNodeDao;
    private final PbNodeCrudOperation pbNodeCrudOperation;

    @Value("${cache.timeout.entity.pb_set}")
    private long pbSetTimeout;

    public PbSetCrudOperation(
            PbSetDao pbSetDao, PbSetCache pbSetCache,
            PopbDao popbDao, PopbCache popbCache,
            PbItemDao pbItemDao, PbItemCrudOperation pbItemCrudOperation,
            PbNodeDao pbNodeDao, PbNodeCrudOperation pbNodeCrudOperation
    ) {
        this.pbSetDao = pbSetDao;
        this.pbSetCache = pbSetCache;
        this.popbDao = popbDao;
        this.popbCache = popbCache;
        this.pbItemDao = pbItemDao;
        this.pbItemCrudOperation = pbItemCrudOperation;
        this.pbNodeDao = pbNodeDao;
        this.pbNodeCrudOperation = pbNodeCrudOperation;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return pbSetCache.exists(key) || pbSetDao.exists(key);
    }

    @Override
    public PbSet get(LongIdKey key) throws Exception {
        if (pbSetCache.exists(key)) {
            return pbSetCache.get(key);
        } else {
            if (!pbSetDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            PbSet pbSet = pbSetDao.get(key);
            pbSetCache.push(pbSet, pbSetTimeout);
            return pbSet;
        }
    }

    @Override
    public LongIdKey insert(PbSet pbSet) throws Exception {
        pbSetCache.push(pbSet, pbSetTimeout);
        return pbSetDao.insert(pbSet);
    }

    @Override
    public void update(PbSet pbSet) throws Exception {
        pbSetCache.push(pbSet, pbSetTimeout);
        pbSetDao.update(pbSet);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 删除与个人最佳集合相关的个人最佳集合项目。
        List<LongIdKey> pbItemKeys = pbItemDao.lookup(
                PbItemMaintainService.CHILD_FOR_SET, new Object[]{key}
        ).stream().map(PbItem::getKey).collect(Collectors.toList());
        pbItemCrudOperation.batchDelete(pbItemKeys);

        // 删除与个人最佳集合相关的个人最佳集合节点。
        List<LongIdKey> pbNodeKeys = pbNodeDao.lookup(
                PbNodeMaintainService.CHILD_FOR_SET, new Object[]{key}
        ).stream().map(PbNode::getKey).collect(Collectors.toList());
        pbNodeCrudOperation.batchDelete(pbNodeKeys);

        // 删除与个人最佳集合相关的个人最佳集合权限。
        List<PopbKey> popbKeys = popbDao.lookup(PopbMaintainService.CHILD_FOR_PB_SET, new Object[]{key})
                .stream().map(Popb::getKey).collect(Collectors.toList());
        popbCache.batchDelete(popbKeys);
        popbDao.batchDelete(popbKeys);

        // 删除个人最佳集合实体自身。
        pbSetCache.delete(key);
        pbSetDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return pbSetCache.allExists(keys) || pbSetDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return pbSetCache.nonExists(keys) && pbSetDao.nonExists(keys);
    }

    @Override
    public List<PbSet> batchGet(List<LongIdKey> keys) throws Exception {
        if (pbSetCache.allExists(keys)) {
            return pbSetCache.batchGet(keys);
        } else {
            if (!pbSetDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<PbSet> pbSets = pbSetDao.batchGet(keys);
            pbSetCache.batchPush(pbSets, pbSetTimeout);
            return pbSets;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<PbSet> pbSets) throws Exception {
        pbSetCache.batchPush(pbSets, pbSetTimeout);
        return pbSetDao.batchInsert(pbSets);
    }

    @Override
    public void batchUpdate(List<PbSet> pbSets) throws Exception {
        pbSetCache.batchPush(pbSets, pbSetTimeout);
        pbSetDao.batchUpdate(pbSets);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
