package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poat;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poatac;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatacKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoatMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoatacMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class ActivityTemplateOperateHandlerImpl implements ActivityTemplateOperateHandler {

    private final ActivityTemplateMaintainService activityTemplateMaintainService;
    private final PoatMaintainService poatMaintainService;
    private final PoatacMaintainService poatacMaintainService;

    private final HandlerValidator handlerValidator;

    public ActivityTemplateOperateHandlerImpl(
            ActivityTemplateMaintainService activityTemplateMaintainService,
            PoatMaintainService poatMaintainService,
            PoatacMaintainService poatacMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.activityTemplateMaintainService = activityTemplateMaintainService;
        this.poatMaintainService = poatMaintainService;
        this.poatacMaintainService = poatacMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey createActivityTemplate(StringIdKey userKey, ActivityTemplateCreateInfo activityTemplateCreateInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 根据 activityTemplateCreateInfo 以及创建的规则组合 活动模板 实体。
            String activityType = activityTemplateCreateInfo.getActivityType();
            String name = activityTemplateCreateInfo.getName();
            String remark = activityTemplateCreateInfo.getRemark();
            String activityNameTemplate = activityTemplateCreateInfo.getActivityNameTemplate();
            String activityRemarkTemplate = activityTemplateCreateInfo.getActivityRemarkTemplate();
            String activityStartDateTemplate = activityTemplateCreateInfo.getActivityStartDateTemplate();
            String activityEndDateTemplate = activityTemplateCreateInfo.getActivityEndDateTemplate();
            Date baselineDate = activityTemplateCreateInfo.getBaselineDate();
            Date currentDate = new Date();
            ActivityTemplate activityTemplate = new ActivityTemplate(
                    null, activityType, name, remark, activityNameTemplate, activityRemarkTemplate,
                    activityStartDateTemplate, activityEndDateTemplate, baselineDate, currentDate, currentDate,
                    currentDate, 0
            );

            // 插入活动模板实体，并获取生成的主键。
            LongIdKey activityTemplateKey = activityTemplateMaintainService.insert(activityTemplate);

            // 由活动模板实体生成的主键和用户主键组合权限信息，并插入。
            Poat poat = new Poat(
                    new PoatKey(activityTemplateKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建活动模板时自动插入，赋予创建人所有者权限"
            );
            poatMaintainService.insert(poat);

            // 由活动模板实体生成的主键和用户主键组合活动权限信息，并插入。
            Poatac poatac = new Poatac(
                    new PoatacKey(activityTemplateKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建活动模板时自动插入，赋予创建人所有者权限"
            );
            poatacMaintainService.insert(poatac);

            // 返回生成的主键。
            return activityTemplateKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updateActivityTemplate(StringIdKey userKey, ActivityTemplateUpdateInfo activityTemplateUpdateInfo)
            throws HandlerException {
        try {
            LongIdKey activityTemplateKey = activityTemplateUpdateInfo.getActivityTemplateKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户对活动模板有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 根据 activityTemplateUpdateInfo 以及更新的规则组合 活动模板 实体。
            ActivityTemplate activityTemplate = activityTemplateMaintainService.get(activityTemplateKey);
            activityTemplate.setActivityType(activityTemplateUpdateInfo.getActivityType());
            activityTemplate.setName(activityTemplateUpdateInfo.getName());
            activityTemplate.setRemark(activityTemplateUpdateInfo.getRemark());
            activityTemplate.setActivityNameTemplate(activityTemplateUpdateInfo.getActivityNameTemplate());
            activityTemplate.setActivityRemarkTemplate(activityTemplateUpdateInfo.getActivityRemarkTemplate());
            activityTemplate.setActivityStartDateTemplate(activityTemplateUpdateInfo.getActivityStartDateTemplate());
            activityTemplate.setActivityEndDateTemplate(activityTemplateUpdateInfo.getActivityEndDateTemplate());
            activityTemplate.setBaselineDate(activityTemplateUpdateInfo.getBaselineDate());
            Date currentDate = new Date();
            activityTemplate.setInspectedDate(currentDate);
            activityTemplate.setModifiedDate(currentDate);

            // 更新活动模板实体。
            activityTemplateMaintainService.update(activityTemplate);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeActivityTemplate(StringIdKey userKey, LongIdKey activityTemplateKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 删除活动模板实体。
            activityTemplateMaintainService.delete(activityTemplateKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void upsertPermission(
            StringIdKey userKey, ActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = activityTemplatePermissionUpsertInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = activityTemplatePermissionUpsertInfo.getUserKey();
            int permissionLevel = activityTemplatePermissionUpsertInfo.getPermissionLevel();

            // 确认 permissionLevel 有效。
            handlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

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
            Poat poat = new Poat(
                    new PoatKey(activityTemplateKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            poatMaintainService.insertOrUpdate(poat);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void removePermission(
            StringIdKey userKey, ActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = activityTemplatePermissionRemoveInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = activityTemplatePermissionRemoveInfo.getUserKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体主键，并进行存在删除操作。
            PoatKey poatKey = new PoatKey(activityTemplateKey.getLongId(), targetUserKey.getStringId());
            poatMaintainService.deleteIfExists(poatKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void upsertActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionUpsertInfo upsertInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = upsertInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = upsertInfo.getUserKey();
            int permissionLevel = upsertInfo.getPermissionLevel();

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 确认 permissionLevel 有效。
            handlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

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
            Poatac poatac = new Poatac(
                    new PoatacKey(activityTemplateKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            poatacMaintainService.insertOrUpdate(poatac);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void removeActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionRemoveInfo removeInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = removeInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = removeInfo.getUserKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体主键，并进行存在删除操作。
            PoatacKey poatacKey = new PoatacKey(activityTemplateKey.getLongId(), targetUserKey.getStringId());
            poatacMaintainService.deleteIfExists(poatacKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
