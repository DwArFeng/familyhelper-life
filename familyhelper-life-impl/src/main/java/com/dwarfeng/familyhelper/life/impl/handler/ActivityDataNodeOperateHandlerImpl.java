package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataNodeCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataNodeUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataNode;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataNodeOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataNodeMaintainService;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ActivityDataNodeOperateHandlerImpl implements ActivityDataNodeOperateHandler {

    private final ActivityDataNodeMaintainService activityDataNodeMaintainService;

    private final HandlerValidator handlerValidator;

    public ActivityDataNodeOperateHandlerImpl(
            ActivityDataNodeMaintainService activityDataNodeMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.activityDataNodeMaintainService = activityDataNodeMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey createActivityDataNode(
            StringIdKey userKey, ActivityDataNodeCreateInfo activityDataNodeCreateInfo
    ) throws HandlerException {
        try {
            LongIdKey setKey = activityDataNodeCreateInfo.getSetKey();
            LongIdKey parentKey = activityDataNodeCreateInfo.getParentKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据集合存在。
            handlerValidator.makeSureActivityDataSetExists(setKey);

            // 确认父活动数据节点存在。
            if (Objects.nonNull(parentKey)) {
                handlerValidator.makeSureActivityDataNodeExists(parentKey);
            }

            // 确认用户有权限操作指定的活动数据集合。
            handlerValidator.makeSureUserModifyPermittedForActivityDataSet(userKey, setKey);

            // 确认活动数据节点与父活动数据节点的活动数据集合相同。
            handlerValidator.makeSureActivityDataSetIdenticalForActivityDataSet(parentKey, setKey);

            // 根据 activityDataNodeCreateInfo 以及创建的规则组合 活动数据节点 实体。
            ActivityDataNode activityDataNode = new ActivityDataNode(
                    null, parentKey, setKey, activityDataNodeCreateInfo.getName(),
                    activityDataNodeCreateInfo.getRemark()
            );

            // 插入活动数据节点，并返回活动数据节点的主键。
            return activityDataNodeMaintainService.insert(activityDataNode);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void updateActivityDataNode(StringIdKey userKey, ActivityDataNodeUpdateInfo activityDataNodeUpdateInfo) throws HandlerException {
        try {
            LongIdKey activityDataNodeKey = activityDataNodeUpdateInfo.getKey();
            LongIdKey parentKey = activityDataNodeUpdateInfo.getParentKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据节点存在。
            handlerValidator.makeSureActivityDataNodeExists(activityDataNodeKey);

            // 确认父活动数据节点存在。
            if (Objects.nonNull(parentKey)) {
                handlerValidator.makeSureActivityDataNodeExists(parentKey);
            }

            // 确认用户有权限操作指定的活动数据节点。
            handlerValidator.makeSureUserModifyPermittedForActivityDataNode(userKey, activityDataNodeKey);

            // 确认活动数据节点与父活动数据节点的活动数据集合相同。
            handlerValidator.makeSureActivityDataSetIdenticalForActivityDataNode(parentKey, activityDataNodeKey);

            // 根据 activityDataNodeUpdateInfo 以及更新的规则组合 活动数据节点 实体。
            ActivityDataNode activityDataNode = activityDataNodeMaintainService.get(activityDataNodeKey);
            activityDataNode.setParentKey(parentKey);
            activityDataNode.setName(activityDataNodeUpdateInfo.getName());
            activityDataNode.setRemark(activityDataNodeUpdateInfo.getRemark());

            // 更新 活动数据节点 实体。
            activityDataNodeMaintainService.update(activityDataNode);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removeActivityDataNode(StringIdKey userKey, LongIdKey activityDataNodeKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据节点存在。
            handlerValidator.makeSureActivityDataNodeExists(activityDataNodeKey);

            // 确认用户有权限操作指定的活动数据节点。
            handlerValidator.makeSureUserModifyPermittedForActivityDataNode(userKey, activityDataNodeKey);

            // 删除活动数据节点。
            activityDataNodeMaintainService.delete(activityDataNodeKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
