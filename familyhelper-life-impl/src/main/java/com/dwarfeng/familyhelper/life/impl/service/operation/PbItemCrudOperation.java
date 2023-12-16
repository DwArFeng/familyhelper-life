package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.familyhelper.life.stack.cache.PbItemCache;
import com.dwarfeng.familyhelper.life.stack.dao.PbItemDao;
import com.dwarfeng.familyhelper.life.stack.dao.PbRecordDao;
import com.dwarfeng.familyhelper.life.stack.service.PbRecordMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PbItemCrudOperation implements BatchCrudOperation<LongIdKey, PbItem> {

    private final PbItemDao pbItemDao;
    private final PbItemCache pbItemCache;

    private final PbRecordCrudOperation pbRecordCrudOperation;
    private final PbRecordDao pbRecordDao;

    @Value("${cache.timeout.entity.pb_item}")
    private long pbItemTimeout;

    public PbItemCrudOperation(
            PbItemDao pbItemDao, PbItemCache pbItemCache,
            PbRecordCrudOperation pbRecordCrudOperation, PbRecordDao pbRecordDao
    ) {
        this.pbItemDao = pbItemDao;
        this.pbItemCache = pbItemCache;
        this.pbRecordCrudOperation = pbRecordCrudOperation;
        this.pbRecordDao = pbRecordDao;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return pbItemCache.exists(key) || pbItemDao.exists(key);
    }

    @Override
    public PbItem get(LongIdKey key) throws Exception {
        if (pbItemCache.exists(key)) {
            return pbItemCache.get(key);
        } else {
            if (!pbItemDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            PbItem pbItem = pbItemDao.get(key);
            pbItemCache.push(pbItem, pbItemTimeout);
            return pbItem;
        }
    }

    @Override
    public LongIdKey insert(PbItem pbItem) throws Exception {
        pbItemCache.push(pbItem, pbItemTimeout);
        return pbItemDao.insert(pbItem);
    }

    @Override
    public void update(PbItem pbItem) throws Exception {
        pbItemCache.push(pbItem, pbItemTimeout);
        pbItemDao.update(pbItem);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 查找删除所有相关的个人最佳记录。
        List<LongIdKey> pbRecordKeys = pbRecordDao.lookup(
                PbRecordMaintainService.CHILD_FOR_ITEM, new Object[]{key}
        ).stream().map(PbRecord::getKey).collect(Collectors.toList());
        pbRecordCrudOperation.batchDelete(pbRecordKeys);

        // 删除个人最佳项目自身。
        pbItemCache.delete(key);
        pbItemDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return pbItemCache.allExists(keys) || pbItemDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return pbItemCache.nonExists(keys) && pbItemDao.nonExists(keys);
    }

    @Override
    public List<PbItem> batchGet(List<LongIdKey> keys) throws Exception {
        if (pbItemCache.allExists(keys)) {
            return pbItemCache.batchGet(keys);
        } else {
            if (!pbItemDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<PbItem> pbItems = pbItemDao.batchGet(keys);
            pbItemCache.batchPush(pbItems, pbItemTimeout);
            return pbItems;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<PbItem> pbItems) throws Exception {
        pbItemCache.batchPush(pbItems, pbItemTimeout);
        return pbItemDao.batchInsert(pbItems);
    }

    @Override
    public void batchUpdate(List<PbItem> pbItems) throws Exception {
        pbItemCache.batchPush(pbItems, pbItemTimeout);
        pbItemDao.batchUpdate(pbItems);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
