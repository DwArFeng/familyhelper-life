package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poac;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoacMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class ActivityOperateHandlerImpl implements ActivityOperateHandler {

    private final ActivityMaintainService activityMaintainService;
    private final PoacMaintainService poacMaintainService;

    private final HandlerValidator handlerValidator;

    public ActivityOperateHandlerImpl(
            ActivityMaintainService activityMaintainService,
            PoacMaintainService poacMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.activityMaintainService = activityMaintainService;
        this.poacMaintainService = poacMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey createActivity(StringIdKey userKey, ActivityCreateInfo activityCreateInfo)
            throws HandlerException {
        try {
            // 展开参数。
            String activityType = activityCreateInfo.getActivityType();
            String name = activityCreateInfo.getName();
            int score = activityCreateInfo.getScore();
            String remark = activityCreateInfo.getRemark();
            Date startDate = activityCreateInfo.getStartDate();
            Date endDate = activityCreateInfo.getEndDate();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 创建活动实体。
            Date currentDate = new Date();
            Activity activity = new Activity(
                    null, activityType, name, score, remark, false, startDate, endDate, currentDate, currentDate,
                    currentDate, null
            );

            // 插入活动实体，并获取生成的主键。
            LongIdKey activityKey = activityMaintainService.insert(activity);

            // 由活动实体生成的主键和用户主键组合权限信息，并插入。
            Poac poac = new Poac(
                    new PoacKey(activityKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建活动时自动插入，赋予创建人所有者权限"
            );
            poacMaintainService.insert(poac);

            // 返回生成的主键。
            return activityKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updateActivity(StringIdKey userKey, ActivityUpdateInfo activityUpdateInfo) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityKey = activityUpdateInfo.getActivityKey();
            String name = activityUpdateInfo.getName();
            int score = activityUpdateInfo.getScore();
            String remark = activityUpdateInfo.getRemark();
            Date startDate = activityUpdateInfo.getStartDate();
            Date endDate = activityUpdateInfo.getEndDate();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动存在。
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 更新活动实体。
            Activity activity = activityMaintainService.get(activityKey);
            activity.setName(name);
            activity.setScore(score);
            activity.setRemark(remark);
            activity.setStartDate(startDate);
            activity.setEndDate(endDate);
            Date currentDate = new Date();
            activity.setInspectedDate(currentDate);
            activity.setModifiedDate(currentDate);
            activityMaintainService.update(activity);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeActivity(StringIdKey userKey, LongIdKey activityKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动存在。
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 删除活动实体。
            activityMaintainService.delete(activityKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void upsertPermission(StringIdKey userKey, ActivityPermissionUpsertInfo activityPermissionUpsertInfo)
            throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityKey = activityPermissionUpsertInfo.getActivityKey();
            StringIdKey targetUserKey = activityPermissionUpsertInfo.getUserKey();
            int permissionLevel = activityPermissionUpsertInfo.getPermissionLevel();

            // 确认 permissionLevel 有效。
            handlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动存在。
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

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
            Poac poac = new Poac(
                    new PoacKey(activityKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "由" + userKey.getStringId() + "赋予" + targetUserKey.getStringId() + permissionLabel + "权限"
            );
            poacMaintainService.insertOrUpdate(poac);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePermission(StringIdKey userKey, ActivityPermissionRemoveInfo activityPermissionRemoveInfo)
            throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityKey = activityPermissionRemoveInfo.getActivityKey();
            StringIdKey targetUserKey = activityPermissionRemoveInfo.getUserKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动存在。
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 删除权限实体。
            poacMaintainService.deleteIfExists(new PoacKey(activityKey.getLongId(), targetUserKey.getStringId()));
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void lockActivity(StringIdKey userKey, LongIdKey activityKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动存在。
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 更新活动实体属性。
            Date currentDate = new Date();
            Activity activity = activityMaintainService.get(activityKey);
            activity.setLocked(true);
            activity.setModifiedDate(currentDate);

            // 调用维护服务更新活动实体。
            activityMaintainService.update(activity);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
