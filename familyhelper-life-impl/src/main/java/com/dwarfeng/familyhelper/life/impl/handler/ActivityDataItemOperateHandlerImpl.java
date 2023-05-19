package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataItemOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataSetMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class ActivityDataItemOperateHandlerImpl implements ActivityDataItemOperateHandler {

    private final ActivityDataItemMaintainService activityDataItemMaintainService;
    private final ActivityDataSetMaintainService activityDataSetMaintainService;

    private final HandlerValidator handlerValidator;

    public ActivityDataItemOperateHandlerImpl(
            ActivityDataItemMaintainService activityDataItemMaintainService,
            ActivityDataSetMaintainService activityDataSetMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.activityDataItemMaintainService = activityDataItemMaintainService;
        this.activityDataSetMaintainService = activityDataSetMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey createActivityDataItem(StringIdKey userKey, ActivityDataItemCreateInfo activityDataItemCreateInfo)
            throws HandlerException {
        try {
            LongIdKey setKey = activityDataItemCreateInfo.getSetKey();
            LongIdKey nodeKey = activityDataItemCreateInfo.getNodeKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据集合存在。
            handlerValidator.makeSureActivityDataSetExists(setKey);

            // 确认活动数据节点存在。
            if (Objects.nonNull(nodeKey)) {
                handlerValidator.makeSureActivityDataNodeExists(nodeKey);
            }

            // 确认用户有权限操作指定的活动数据节点。
            handlerValidator.makeSureUserModifyPermittedForActivityDataSet(userKey, setKey);

            // 根据 activityDataItemCreateInfo 以及创建的规则组合 活动数据项目 实体。
            ActivityDataItem activityDataItem = new ActivityDataItem(
                    null, nodeKey, setKey, activityDataItemCreateInfo.getName(), activityDataItemCreateInfo.getRemark(),
                    0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, null, null, 0
            );

            // 插入活动数据项目，并保存主键。
            LongIdKey activityDataItemKey = activityDataItemMaintainService.insert(activityDataItem);

            // 自增活动数据集合的活动数据项目计数。
            ActivityDataSet activityDataSet = activityDataSetMaintainService.get(setKey);
            activityDataSet.setItemCount(activityDataSet.getItemCount() + 1);
            activityDataSetMaintainService.update(activityDataSet);

            // 返回活动数据项目的主键。
            return activityDataItemKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updateActivityDataItem(StringIdKey userKey, ActivityDataItemUpdateInfo activityDataItemUpdateInfo)
            throws HandlerException {
        try {
            LongIdKey activityDataItemKey = activityDataItemUpdateInfo.getKey();
            LongIdKey activityDataNodeKey = activityDataItemUpdateInfo.getNodeKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据节点存在。
            if (Objects.nonNull(activityDataNodeKey)) {
                handlerValidator.makeSureActivityDataNodeExists(activityDataNodeKey);
            }

            // 确认活动数据项目存在。
            handlerValidator.makeSureActivityDataItemExists(activityDataItemKey);

            // 确认用户有权限操作指定的活动数据项目。
            handlerValidator.makeSureUserModifyPermittedForActivityDataItem(userKey, activityDataItemKey);

            // 确认新的活动数据节点与活动数据条目的活动数据集合相同。
            handlerValidator.makeSureActivityDataSetIdenticalForActivityDataItem(
                    activityDataNodeKey, activityDataItemKey
            );

            // 根据 activityDataItemUpdateInfo 以及更新的规则组合 活动数据项目 实体。
            ActivityDataItem activityDataItem = activityDataItemMaintainService.get(activityDataItemKey);
            activityDataItem.setNodeKey(activityDataNodeKey);
            activityDataItem.setName(activityDataItemUpdateInfo.getName());
            activityDataItem.setRemark(activityDataItemUpdateInfo.getRemark());

            // 更新 活动数据项目 实体。
            activityDataItemMaintainService.update(activityDataItem);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeActivityDataItem(StringIdKey userKey, LongIdKey activityDataItemKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据项目存在。
            handlerValidator.makeSureActivityDataItemExists(activityDataItemKey);

            // 确认活动数据集合存在。
            ActivityDataItem activityDataItem = activityDataItemMaintainService.get(activityDataItemKey);
            LongIdKey setKey = activityDataItem.getSetKey();
            handlerValidator.makeSureActivityDataSetExists(setKey);

            // 确认用户有权限操作指定的活动数据项目。
            handlerValidator.makeSureUserModifyPermittedForActivityDataItem(userKey, activityDataItemKey);

            // 删除活动数据项目。
            activityDataItemMaintainService.delete(activityDataItemKey);

            // 自减活动数据集合的活动数据项目计数。
            ActivityDataSet activityDataSet = activityDataSetMaintainService.get(setKey);
            activityDataSet.setItemCount(activityDataSet.getItemCount() - 1);
            activityDataSetMaintainService.update(activityDataSet);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
