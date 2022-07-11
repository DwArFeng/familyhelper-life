package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.familyhelper.life.stack.exception.InvalidPermissionLevelException;
import com.dwarfeng.familyhelper.life.stack.exception.PbSetNotExistsException;
import com.dwarfeng.familyhelper.life.stack.exception.UserNotExistsException;
import com.dwarfeng.familyhelper.life.stack.exception.UserNotPermittedForPbSetException;
import com.dwarfeng.familyhelper.life.stack.service.PbSetMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PopbMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 操作处理器验证器。
 *
 * <p>
 * 为操作处理器提供公共的验证方法。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class OperateHandlerValidator {

    private final UserMaintainService userMaintainService;
    private final PbSetMaintainService pbSetMaintainService;
    private final PopbMaintainService popbMaintainService;

    public OperateHandlerValidator(
            UserMaintainService userMaintainService,
            PbSetMaintainService pbSetMaintainService,
            PopbMaintainService popbMaintainService
    ) {
        this.userMaintainService = userMaintainService;
        this.pbSetMaintainService = pbSetMaintainService;
        this.popbMaintainService = popbMaintainService;
    }

    public void makeSureUserExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!userMaintainService.exists(userKey)) {
                throw new UserNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbSetExists(LongIdKey pbSetKey) throws HandlerException {
        try {
            if (!pbSetMaintainService.exists(pbSetKey)) {
                throw new PbSetNotExistsException(pbSetKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePermissionLevelValid(int permissionLevel) throws HandlerException {
        if (permissionLevel == Constants.PERMISSION_LEVEL_GUEST) {
            return;
        }
        throw new InvalidPermissionLevelException(permissionLevel);
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserInspectPermittedForPbSet(StringIdKey userKey, LongIdKey pbSetKey)
            throws HandlerException {
        try {
            // 1. 构造 Popb 主键。
            PopbKey popbKey = new PopbKey(pbSetKey.getLongId(), userKey.getStringId());

            // 2. 查看 Popb 实体是否存在，如果不存在，则没有权限。
            if (!popbMaintainService.exists(popbKey)) {
                throw new UserNotPermittedForPbSetException(userKey, pbSetKey);
            }

            // 3. 查看 Popb.permissionLevel 是否为 Popb.PERMISSION_LEVEL_OWNER 或 Popb.PERMISSION_LEVEL_GUEST，
            // 如果不是，则没有权限。
            Popb popb = popbMaintainService.get(popbKey);
            if (Objects.equals(popb.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            if (Objects.equals(popb.getPermissionLevel(), Constants.PERMISSION_LEVEL_GUEST)) {
                return;
            }
            throw new UserNotPermittedForPbSetException(userKey, pbSetKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserModifyPermittedForPbSet(StringIdKey userKey, LongIdKey assetCatalogKey)
            throws HandlerException {
        try {
            // 1. 构造 Popb 主键。
            PopbKey popbKey = new PopbKey(assetCatalogKey.getLongId(), userKey.getStringId());

            // 2. 查看 Popb 实体是否存在，如果不存在，则没有权限。
            if (!popbMaintainService.exists(popbKey)) {
                throw new UserNotPermittedForPbSetException(userKey, assetCatalogKey);
            }

            // 3. 查看 Popb.permissionLevel 是否为 Popb.PERMISSION_LEVEL_OWNER，如果不是，则没有权限。
            Popb popb = popbMaintainService.get(popbKey);
            if (Objects.equals(popb.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            throw new UserNotPermittedForPbSetException(userKey, assetCatalogKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
