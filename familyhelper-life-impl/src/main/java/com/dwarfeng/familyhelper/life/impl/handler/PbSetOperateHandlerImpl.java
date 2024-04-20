package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetPermissionUpsertInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.familyhelper.life.stack.handler.PbSetOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbSetMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PopbMaintainService;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class PbSetOperateHandlerImpl implements PbSetOperateHandler {

    private final PbSetMaintainService pbSetMaintainService;
    private final PopbMaintainService popbMaintainService;

    private final HandlerValidator handlerValidator;

    public PbSetOperateHandlerImpl(
            PbSetMaintainService pbSetMaintainService,
            PopbMaintainService popbMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.pbSetMaintainService = pbSetMaintainService;
        this.popbMaintainService = popbMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey createPbSet(StringIdKey userKey, PbSetCreateInfo pbSetCreateInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 根据 pbSetCreateInfo 以及创建的规则组合 个人最佳集合 实体。
            Date currentDate = new Date();
            PbSet pbSet = new PbSet(
                    null, pbSetCreateInfo.getName(), pbSetCreateInfo.getRemark(), currentDate, 0, currentDate
            );

            // 插入个人最佳集合实体，并获取生成的主键。
            LongIdKey pbSetKey = pbSetMaintainService.insert(pbSet);

            // 由个人最佳集合实体生成的主键和用户主键组合权限信息，并插入。
            Popb popb = new Popb(
                    new PopbKey(pbSetKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建个人最佳集合时自动插入，赋予创建人所有者权限"
            );
            popbMaintainService.insert(popb);

            // 返回生成的主键。
            return pbSetKey;
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void updatePbSet(StringIdKey userKey, PbSetUpdateInfo pbSetUpdateInfo)
            throws HandlerException {
        try {
            LongIdKey pbSetKey = pbSetUpdateInfo.getPbSetKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳集合存在。
            handlerValidator.makeSurePbSetExists(pbSetKey);

            // 确认用户有权限操作指定的个人最佳集合。
            handlerValidator.makeSureUserModifyPermittedForPbSet(userKey, pbSetKey);

            // 根据 pbSetUpdateInfo 以及更新的规则设置 个人最佳集合 实体。
            PbSet pbSet = pbSetMaintainService.get(pbSetKey);
            pbSet.setName(pbSetUpdateInfo.getName());
            pbSet.setRemark(pbSetUpdateInfo.getRemark());

            // 更新个人最佳集合实体。
            pbSetMaintainService.update(pbSet);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removePbSet(StringIdKey userKey, LongIdKey pbSetKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳集合存在。
            handlerValidator.makeSurePbSetExists(pbSetKey);

            // 确认用户有权限操作指定的个人最佳集合。
            handlerValidator.makeSureUserModifyPermittedForPbSet(userKey, pbSetKey);

            // 删除指定主键的个人最佳集合。
            pbSetMaintainService.delete(pbSetKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey userKey, PbSetPermissionUpsertInfo pbSetPermissionUpsertInfo
    ) throws HandlerException {
        try {
            LongIdKey pbSetKey = pbSetPermissionUpsertInfo.getPbSetKey();
            StringIdKey targetUserKey = pbSetPermissionUpsertInfo.getUserKey();
            int permissionLevel = pbSetPermissionUpsertInfo.getPermissionLevel();

            // 确认 permissionLevel 有效。
            handlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认个人最佳集合存在。
            handlerValidator.makeSurePbSetExists(pbSetKey);

            // 确认用户有权限操作指定的个人最佳集合。
            handlerValidator.makeSureUserModifyPermittedForPbSet(userKey, pbSetKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体，并进行插入或更新操作。
            String permissionLabel = parsePermissionLabel(permissionLevel);
            Popb popb = new Popb(
                    new PopbKey(pbSetKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            popbMaintainService.insertOrUpdate(popb);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removePermission(
            StringIdKey userKey, PbSetPermissionRemoveInfo pbSetPermissionRemoveInfo
    ) throws HandlerException {
        try {
            LongIdKey pbSetKey = pbSetPermissionRemoveInfo.getPbSetKey();
            StringIdKey targetUserKey = pbSetPermissionRemoveInfo.getUserKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认个人最佳集合存在。
            handlerValidator.makeSurePbSetExists(pbSetKey);

            // 确认用户有权限操作指定的个人最佳集合。
            handlerValidator.makeSureUserModifyPermittedForPbSet(userKey, pbSetKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体主键，并进行存在删除操作。
            PopbKey popbKey = new PopbKey(pbSetKey.getLongId(), targetUserKey.getStringId());
            popbMaintainService.deleteIfExists(popbKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String parsePermissionLabel(int permissionLevel) {
        switch (permissionLevel) {
            case Constants.PERMISSION_LEVEL_GUEST:
                return "访客";
            case Constants.PERMISSION_LEVEL_OWNER:
                return "所有者";
            default:
                return "（未知）";
        }
    }
}
