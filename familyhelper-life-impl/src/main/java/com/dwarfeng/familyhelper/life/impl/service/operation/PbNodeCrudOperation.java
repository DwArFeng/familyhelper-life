package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.familyhelper.life.stack.cache.PbNodeCache;
import com.dwarfeng.familyhelper.life.stack.dao.PbItemDao;
import com.dwarfeng.familyhelper.life.stack.dao.PbNodeDao;
import com.dwarfeng.familyhelper.life.stack.service.PbItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbNodeMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PbNodeCrudOperation implements BatchCrudOperation<LongIdKey, PbNode> {

    private final PbNodeDao pbNodeDao;
    private final PbNodeCache pbNodeCache;

    private final PbItemCrudOperation pbItemCrudOperation;
    private final PbItemDao pbItemDao;

    @Value("${cache.timeout.entity.pb_node}")
    private long pbNodeTimeout;

    public PbNodeCrudOperation(
            PbNodeDao pbNodeDao, PbNodeCache pbNodeCache,
            PbItemCrudOperation pbItemCrudOperation, PbItemDao pbItemDao
    ) {
        this.pbNodeDao = pbNodeDao;
        this.pbNodeCache = pbNodeCache;
        this.pbItemCrudOperation = pbItemCrudOperation;
        this.pbItemDao = pbItemDao;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return pbNodeCache.exists(key) || pbNodeDao.exists(key);
    }

    @Override
    public PbNode get(LongIdKey key) throws Exception {
        if (pbNodeCache.exists(key)) {
            return pbNodeCache.get(key);
        } else {
            if (!pbNodeDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            PbNode pbNode = pbNodeDao.get(key);
            pbNodeCache.push(pbNode, pbNodeTimeout);
            return pbNode;
        }
    }

    @Override
    public LongIdKey insert(PbNode pbNode) throws Exception {
        pbNodeCache.push(pbNode, pbNodeTimeout);
        return pbNodeDao.insert(pbNode);
    }

    @Override
    public void update(PbNode pbNode) throws Exception {
        pbNodeCache.push(pbNode, pbNodeTimeout);
        pbNodeDao.update(pbNode);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 递归寻找并删除个人最佳节点自身的子孙节点。
        List<PbNode> descendantPbNodes = new ArrayList<>();
        findDescendant(descendantPbNodes, pbNodeDao.get(key));
        descendantPbNodes.forEach((pbNode -> pbNode.setParentKey(null)));
        pbNodeDao.batchUpdate(descendantPbNodes);
        List<LongIdKey> descendantPbNodeKeys = descendantPbNodes.stream().map(PbNode::getKey).collect(Collectors.toList());
        pbNodeCache.batchDelete(descendantPbNodeKeys);
        pbNodeDao.batchDelete(descendantPbNodeKeys);

        // 查找删除除所有相关的个人最佳项目。
        List<LongIdKey> pbItemKeys = pbItemDao.lookup(
                PbItemMaintainService.CHILD_FOR_NODE, new Object[]{key}
        ).stream().map(PbItem::getKey).collect(Collectors.toList());
        pbItemCrudOperation.batchDelete(pbItemKeys);

        // 删除个人最佳节点自身。
        pbNodeCache.delete(key);
        pbNodeDao.delete(key);
    }

    private void findDescendant(List<PbNode> descendantPbNodeKeys, PbNode pbNode) throws Exception {
        List<PbNode> childPbNodes = pbNodeDao.lookup(PbNodeMaintainService.CHILD_FOR_PARENT, new Object[]{pbNode.getKey()});
        for (PbNode childPbNode : childPbNodes) {
            descendantPbNodeKeys.add(childPbNode);
            findDescendant(descendantPbNodeKeys, childPbNode);
        }
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return pbNodeCache.allExists(keys) || pbNodeDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return pbNodeCache.nonExists(keys) && pbNodeDao.nonExists(keys);
    }

    @Override
    public List<PbNode> batchGet(List<LongIdKey> keys) throws Exception {
        if (pbNodeCache.allExists(keys)) {
            return pbNodeCache.batchGet(keys);
        } else {
            if (!pbNodeDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<PbNode> pbNodes = pbNodeDao.batchGet(keys);
            pbNodeCache.batchPush(pbNodes, pbNodeTimeout);
            return pbNodes;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<PbNode> pbNodes) throws Exception {
        pbNodeCache.batchPush(pbNodes, pbNodeTimeout);
        return pbNodeDao.batchInsert(pbNodes);
    }

    @Override
    public void batchUpdate(List<PbNode> pbNodes) throws Exception {
        pbNodeCache.batchPush(pbNodes, pbNodeTimeout);
        pbNodeDao.batchUpdate(pbNodes);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
