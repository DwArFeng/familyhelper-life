package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataSetUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataSetOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataSetMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoadMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class ActivityDataSetOperateHandlerImpl implements ActivityDataSetOperateHandler {

    private final ActivityDataSetMaintainService activityDataSetMaintainService;
    private final PoadMaintainService poadMaintainService;

    private final HandlerValidator handlerValidator;

    public ActivityDataSetOperateHandlerImpl(
            ActivityDataSetMaintainService activityDataSetMaintainService,
            PoadMaintainService poadMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.activityDataSetMaintainService = activityDataSetMaintainService;
        this.poadMaintainService = poadMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey createActivityDataSet(StringIdKey userKey, ActivityDataSetCreateInfo activityDataSetCreateInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 根据 activityDataSetCreateInfo 以及创建的规则组合 活动数据集合 实体。
            Date currentDate = new Date();
            ActivityDataSet activityDataSet = new ActivityDataSet(
                    null, activityDataSetCreateInfo.getName(), activityDataSetCreateInfo.getRemark(), 0, currentDate
            );

            // 插入活动数据集合实体，并获取生成的主键。
            LongIdKey activityDataSetKey = activityDataSetMaintainService.insert(activityDataSet);

            // 由活动数据集合实体生成的主键和用户主键组合权限信息，并插入。
            Poad poad = new Poad(
                    new PoadKey(activityDataSetKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建活动数据集合时自动插入，赋予创建人所有者权限"
            );
            poadMaintainService.insert(poad);

            // 返回生成的主键。
            return activityDataSetKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updateActivityDataSet(StringIdKey userKey, ActivityDataSetUpdateInfo activityDataSetUpdateInfo)
            throws HandlerException {
        try {
            LongIdKey activityDataSetKey = activityDataSetUpdateInfo.getActivityDataSetKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据集合存在。
            handlerValidator.makeSureActivityDataSetExists(activityDataSetKey);

            // 确认用户有权限操作指定的活动数据集合。
            handlerValidator.makeSureUserModifyPermittedForActivityDataSet(userKey, activityDataSetKey);

            // 根据 activityDataSetUpdateInfo 以及更新的规则设置 活动数据集合 实体。
            ActivityDataSet activityDataSet = activityDataSetMaintainService.get(activityDataSetKey);
            activityDataSet.setName(activityDataSetUpdateInfo.getName());
            activityDataSet.setRemark(activityDataSetUpdateInfo.getRemark());

            // 更新活动数据集合实体。
            activityDataSetMaintainService.update(activityDataSet);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeActivityDataSet(StringIdKey userKey, LongIdKey activityDataSetKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据集合存在。
            handlerValidator.makeSureActivityDataSetExists(activityDataSetKey);

            // 确认用户有权限操作指定的活动数据集合。
            handlerValidator.makeSureUserModifyPermittedForActivityDataSet(userKey, activityDataSetKey);

            // 删除指定主键的活动数据集合。
            activityDataSetMaintainService.delete(activityDataSetKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void upsertPermission(
            StringIdKey userKey, ActivityDataSetPermissionUpsertInfo activityDataSetPermissionUpsertInfo
    ) throws HandlerException {
        try {
            LongIdKey activityDataSetKey = activityDataSetPermissionUpsertInfo.getActivityDataSetKey();
            StringIdKey targetUserKey = activityDataSetPermissionUpsertInfo.getUserKey();
            int permissionLevel = activityDataSetPermissionUpsertInfo.getPermissionLevel();

            // 确认 permissionLevel 有效。
            handlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动数据集合存在。
            handlerValidator.makeSureActivityDataSetExists(activityDataSetKey);

            // 确认用户有权限操作指定的活动数据集合。
            handlerValidator.makeSureUserModifyPermittedForActivityDataSet(userKey, activityDataSetKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体，并进行插入或更新操作。
            String permissionLabel;
            switch (permissionLevel) {
                case Constants.PERMISSION_LEVEL_GUEST:
                    permissionLabel = "目标";
                    break;
                case Constants.PERMISSION_LEVEL_OWNER:
                    permissionLabel = "所有者";
                    break;
                default:
                    permissionLabel = "（未知）";
            }
            Poad poad = new Poad(
                    new PoadKey(activityDataSetKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            poadMaintainService.insertOrUpdate(poad);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePermission(
            StringIdKey userKey, ActivityDataSetPermissionRemoveInfo activityDataSetPermissionRemoveInfo
    ) throws HandlerException {
        try {
            LongIdKey activityDataSetKey = activityDataSetPermissionRemoveInfo.getActivityDataSetKey();
            StringIdKey targetUserKey = activityDataSetPermissionRemoveInfo.getUserKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动数据集合存在。
            handlerValidator.makeSureActivityDataSetExists(activityDataSetKey);

            // 确认用户有权限操作指定的活动数据集合。
            handlerValidator.makeSureUserModifyPermittedForActivityDataSet(userKey, activityDataSetKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体主键，并进行存在删除操作。
            PoadKey poadKey = new PoadKey(activityDataSetKey.getLongId(), targetUserKey.getStringId());
            poadMaintainService.deleteIfExists(poadKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
