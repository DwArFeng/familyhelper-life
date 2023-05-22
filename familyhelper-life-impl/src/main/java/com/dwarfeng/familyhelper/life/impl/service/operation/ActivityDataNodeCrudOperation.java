package com.dwarfeng.familyhelper.life.impl.service.operation;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataNode;
import com.dwarfeng.familyhelper.life.stack.cache.ActivityDataNodeCache;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataItemDao;
import com.dwarfeng.familyhelper.life.stack.dao.ActivityDataNodeDao;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataNodeMaintainService;
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
public class ActivityDataNodeCrudOperation implements BatchCrudOperation<LongIdKey, ActivityDataNode> {

    private final ActivityDataNodeDao activityDataNodeDao;
    private final ActivityDataNodeCache activityDataNodeCache;

    private final ActivityDataItemCrudOperation activityDataItemCrudOperation;
    private final ActivityDataItemDao activityDataItemDao;

    @Value("${cache.timeout.entity.activity_data_node}")
    private long activityDataNodeTimeout;

    public ActivityDataNodeCrudOperation(
            ActivityDataNodeDao ActivityDataNodeDao, ActivityDataNodeCache ActivityDataNodeCache,
            ActivityDataItemCrudOperation activityDataItemCrudOperation, ActivityDataItemDao activityDataItemDao
    ) {
        this.activityDataNodeDao = ActivityDataNodeDao;
        this.activityDataNodeCache = ActivityDataNodeCache;
        this.activityDataItemCrudOperation = activityDataItemCrudOperation;
        this.activityDataItemDao = activityDataItemDao;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return activityDataNodeCache.exists(key) || activityDataNodeDao.exists(key);
    }

    @Override
    public ActivityDataNode get(LongIdKey key) throws Exception {
        if (activityDataNodeCache.exists(key)) {
            return activityDataNodeCache.get(key);
        } else {
            if (!activityDataNodeDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            ActivityDataNode ActivityDataNode = activityDataNodeDao.get(key);
            activityDataNodeCache.push(ActivityDataNode, activityDataNodeTimeout);
            return ActivityDataNode;
        }
    }

    @Override
    public LongIdKey insert(ActivityDataNode ActivityDataNode) throws Exception {
        activityDataNodeCache.push(ActivityDataNode, activityDataNodeTimeout);
        return activityDataNodeDao.insert(ActivityDataNode);
    }

    @Override
    public void update(ActivityDataNode ActivityDataNode) throws Exception {
        activityDataNodeCache.push(ActivityDataNode, activityDataNodeTimeout);
        activityDataNodeDao.update(ActivityDataNode);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 寻找自身的子孙节点和子孙条目。
        DescendantStruct descendantStruct = findDescendant(key);

        // 依次删除子孙条目和子孙节点。
        List<LongIdKey> activityDataItemKeys = descendantStruct.getActivityDataItemKeys();
        activityDataItemCrudOperation.batchDelete(activityDataItemKeys);
        List<LongIdKey> activityDataNodeKeys = descendantStruct.getActivityDataNodeKeys();
        activityDataNodeCache.batchDelete(activityDataNodeKeys);
        activityDataNodeDao.batchDelete(activityDataNodeKeys);
    }

    private DescendantStruct findDescendant(LongIdKey key) throws Exception {
        // 本方法使用递归形式，并转化为迭代。

        // 定义结果变量。
        List<LongIdKey> activityDataNodeKeys = new LinkedList<>();
        List<LongIdKey> activityDataItemKeys = new ArrayList<>();

        // 定义一个栈，并初始化。
        Stack<LongIdKey> activityDataNodeStack = new Stack<>();
        activityDataNodeStack.push(key);

        // 在栈清空之前，一直执行循环。
        while (!activityDataNodeStack.isEmpty()) {
            // 从栈中取出当前的节点。
            LongIdKey activityDataNodeKey = activityDataNodeStack.pop();
            // 查询节点的子节点。
            List<LongIdKey> childActivityDataNodeKeys = activityDataNodeDao.lookup(
                    ActivityDataNodeMaintainService.CHILD_FOR_PARENT, new Object[]{activityDataNodeKey}
            ).stream().map(ActivityDataNode::getKey).collect(Collectors.toList());
            // 查询节点的子条目。
            List<LongIdKey> childActivityDataItemKeys = activityDataItemDao.lookup(
                    ActivityDataItemMaintainService.CHILD_FOR_NODE, new Object[]{activityDataNodeKey}
            ).stream().map(ActivityDataItem::getKey).collect(Collectors.toList());
            // 将结果添加到结果变量中（插入到最前面）。
            activityDataNodeKeys.add(0, activityDataNodeKey);
            activityDataItemKeys.addAll(childActivityDataItemKeys);
            // 向栈中推送节点的子节点。
            childActivityDataNodeKeys.forEach(activityDataNodeStack::push);
        }

        // 返回结果。
        return new DescendantStruct(activityDataNodeKeys, activityDataItemKeys);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return activityDataNodeCache.allExists(keys) || activityDataNodeDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return activityDataNodeCache.nonExists(keys) && activityDataNodeDao.nonExists(keys);
    }

    @Override
    public List<ActivityDataNode> batchGet(List<LongIdKey> keys) throws Exception {
        if (activityDataNodeCache.allExists(keys)) {
            return activityDataNodeCache.batchGet(keys);
        } else {
            if (!activityDataNodeDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<ActivityDataNode> ActivityDataNodes = activityDataNodeDao.batchGet(keys);
            activityDataNodeCache.batchPush(ActivityDataNodes, activityDataNodeTimeout);
            return ActivityDataNodes;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<ActivityDataNode> ActivityDataNodes) throws Exception {
        activityDataNodeCache.batchPush(ActivityDataNodes, activityDataNodeTimeout);
        return activityDataNodeDao.batchInsert(ActivityDataNodes);
    }

    @Override
    public void batchUpdate(List<ActivityDataNode> ActivityDataNodes) throws Exception {
        activityDataNodeCache.batchPush(ActivityDataNodes, activityDataNodeTimeout);
        activityDataNodeDao.batchUpdate(ActivityDataNodes);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }

    private static final class DescendantStruct {

        private final List<LongIdKey> activityDataNodeKeys;
        private final List<LongIdKey> activityDataItemKeys;

        private DescendantStruct(List<LongIdKey> activityDataNodeKeys, List<LongIdKey> activityDataItemKeys) {
            this.activityDataNodeKeys = activityDataNodeKeys;
            this.activityDataItemKeys = activityDataItemKeys;
        }

        public List<LongIdKey> getActivityDataNodeKeys() {
            return activityDataNodeKeys;
        }

        public List<LongIdKey> getActivityDataItemKeys() {
            return activityDataItemKeys;
        }

        @Override
        public String toString() {
            return "DescendantStruct{" +
                    "activityDataNodeKeys=" + activityDataNodeKeys +
                    ", activityDataItemKeys=" + activityDataItemKeys +
                    '}';
        }
    }
}
