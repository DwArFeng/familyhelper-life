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

    private final OperateHandlerValidator operateHandlerValidator;

    public PbSetOperateHandlerImpl(
            PbSetMaintainService pbSetMaintainService,
            PopbMaintainService popbMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.pbSetMaintainService = pbSetMaintainService;
        this.popbMaintainService = popbMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }


    @Override
    public LongIdKey createPbSet(StringIdKey userKey, PbSetCreateInfo pbSetCreateInfo)
            throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 根据 pbSetCreateInfo 以及创建的规则组合 个人最佳集合 实体。
            PbSet pbSet = new PbSet(null, pbSetCreateInfo.getName(), pbSetCreateInfo.getRemark(), new Date());

            // 3. 插入个人最佳集合实体，并获取生成的主键。
            LongIdKey pbSetKey = pbSetMaintainService.insert(pbSet);

            // 4. 由个人最佳集合实体生成的主键和用户主键组合权限信息，并插入。
            Popb popb = new Popb(
                    new PopbKey(pbSetKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建个人最佳集合时自动插入，赋予创建人所有者权限"
            );
            popbMaintainService.insert(popb);

            // 5. 返回生成的主键。
            return pbSetKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updatePbSet(StringIdKey userKey, PbSetUpdateInfo pbSetUpdateInfo)
            throws HandlerException {
        try {
            LongIdKey pbSetKey = pbSetUpdateInfo.getPbSetKey();

            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetExists(pbSetKey);

            // 3. 确认用户有权限操作指定的个人最佳集合。
            operateHandlerValidator.makeSureUserModifyPermittedForPbSet(userKey, pbSetKey);

            // 4. 根据 pbSetUpdateInfo 以及更新的规则设置 个人最佳集合 实体。
            PbSet pbSet = pbSetMaintainService.get(pbSetKey);
            pbSet.setName(pbSetUpdateInfo.getName());
            pbSet.setRemark(pbSetUpdateInfo.getRemark());

            // 5. 更新个人最佳集合实体。
            pbSetMaintainService.update(pbSet);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePbSet(StringIdKey userKey, LongIdKey pbSetKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetExists(pbSetKey);

            // 3. 确认用户有权限操作指定的个人最佳集合。
            operateHandlerValidator.makeSureUserModifyPermittedForPbSet(userKey, pbSetKey);

            // 4. 删除指定主键的个人最佳集合。
            pbSetMaintainService.delete(pbSetKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey ownerUserKey, PbSetPermissionUpsertInfo pbSetPermissionUpsertInfo
    ) throws HandlerException {
        try {
            LongIdKey pbSetKey = pbSetPermissionUpsertInfo.getPbSetKey();
            StringIdKey targetUserKey = pbSetPermissionUpsertInfo.getUserKey();
            int permissionLevel = pbSetPermissionUpsertInfo.getPermissionLevel();

            // 1. 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(ownerUserKey, targetUserKey)) {
                return;
            }

            // 2. 确认 permissionLevel 有效。
            operateHandlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 3. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(ownerUserKey);
            operateHandlerValidator.makeSureUserExists(targetUserKey);

            // 4. 确认个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetExists(pbSetKey);

            // 5. 确认用户有权限操作指定的个人最佳集合。
            operateHandlerValidator.makeSureUserModifyPermittedForPbSet(ownerUserKey, pbSetKey);

            // 6. 通过入口信息组合权限实体，并进行插入或更新操作。
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
            Popb popb = new Popb(
                    new PopbKey(pbSetKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            popbMaintainService.insertOrUpdate(popb);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePermission(
            StringIdKey ownerUserKey, PbSetPermissionRemoveInfo pbSetPermissionRemoveInfo
    ) throws HandlerException {
        try {
            LongIdKey pbSetKey = pbSetPermissionRemoveInfo.getPbSetKey();
            StringIdKey targetUserKey = pbSetPermissionRemoveInfo.getUserKey();

            // 1. 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(ownerUserKey, targetUserKey)) {
                return;
            }

            // 2. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(ownerUserKey);
            operateHandlerValidator.makeSureUserExists(targetUserKey);

            // 3. 确认个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetExists(pbSetKey);

            // 4. 确认用户有权限操作指定的个人最佳集合。
            operateHandlerValidator.makeSureUserModifyPermittedForPbSet(ownerUserKey, pbSetKey);

            // 5. 通过入口信息组合权限实体主键，并进行存在删除操作。
            PopbKey popbKey = new PopbKey(pbSetKey.getLongId(), targetUserKey.getStringId());
            popbMaintainService.deleteIfExists(popbKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
