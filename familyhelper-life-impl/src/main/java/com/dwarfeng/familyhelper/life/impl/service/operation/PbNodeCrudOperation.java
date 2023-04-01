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
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
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
        // 寻找自身的子孙节点和子孙条目。
        DescendantStruct descendantStruct = findDescendant(key);

        // 依次删除子孙条目和子孙节点。
        List<LongIdKey> pbItemKeys = descendantStruct.getPbItemKeys();
        pbItemCrudOperation.batchDelete(pbItemKeys);
        List<LongIdKey> pbNodeKeys = descendantStruct.getPbNodeKeys();
        pbNodeCache.batchDelete(pbNodeKeys);
        pbNodeDao.batchDelete(pbNodeKeys);
    }

    private DescendantStruct findDescendant(LongIdKey key) throws Exception {
        // 本方法使用递归形式，并转化为迭代。

        // 定义结果变量。
        List<LongIdKey> pbNodeKeys = new LinkedList<>();
        List<LongIdKey> pbItemKeys = new ArrayList<>();

        // 定义一个栈，并初始化。
        Stack<LongIdKey> pbNodeStack = new Stack<>();
        pbNodeStack.push(key);

        // 在栈清空之前，一直执行循环。
        while (!pbNodeStack.isEmpty()) {
            // 从栈中取出当前的节点。
            LongIdKey pbNodeKey = pbNodeStack.pop();
            // 查询节点的子节点。
            List<LongIdKey> childPbNodeKeys = pbNodeDao.lookup(
                    PbNodeMaintainService.CHILD_FOR_PARENT, new Object[]{pbNodeKey}
            ).stream().map(PbNode::getKey).collect(Collectors.toList());
            // 查询节点的子条目。
            List<LongIdKey> childPbItemKeys = pbItemDao.lookup(
                    PbItemMaintainService.CHILD_FOR_NODE, new Object[]{pbNodeKey}
            ).stream().map(PbItem::getKey).collect(Collectors.toList());
            // 将结果添加到结果变量中（插入到最前面）。
            pbNodeKeys.add(0, pbNodeKey);
            pbItemKeys.addAll(childPbItemKeys);
            // 向栈中推送节点的子节点。
            childPbNodeKeys.forEach(pbNodeStack::push);
        }

        // 返回结果。
        return new DescendantStruct(pbNodeKeys, pbItemKeys);
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

    private static final class DescendantStruct {

        private final List<LongIdKey> pbNodeKeys;
        private final List<LongIdKey> pbItemKeys;

        private DescendantStruct(List<LongIdKey> pbNodeKeys, List<LongIdKey> pbItemKeys) {
            this.pbNodeKeys = pbNodeKeys;
            this.pbItemKeys = pbItemKeys;
        }

        public List<LongIdKey> getPbNodeKeys() {
            return pbNodeKeys;
        }

        public List<LongIdKey> getPbItemKeys() {
            return pbItemKeys;
        }

        @Override
        public String toString() {
            return "DescendantStruct{" +
                    "pbNodeKeys=" + pbNodeKeys +
                    ", pbItemKeys=" + pbItemKeys +
                    '}';
        }
    }
}
