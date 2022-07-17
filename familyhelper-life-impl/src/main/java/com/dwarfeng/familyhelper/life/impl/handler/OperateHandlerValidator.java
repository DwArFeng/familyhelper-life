package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.familyhelper.life.stack.exception.*;
import com.dwarfeng.familyhelper.life.stack.service.*;
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
    private final PopbMaintainService popbMaintainService;
    private final PbSetMaintainService pbSetMaintainService;
    private final PbNodeMaintainService pbNodeMaintainService;
    private final PbItemMaintainService pbItemMaintainService;
    private final PbRecordMaintainService pbRecordMaintainService;
    private final PbFileInfoMaintainService pbFileInfoMaintainService;

    public OperateHandlerValidator(
            UserMaintainService userMaintainService,
            PopbMaintainService popbMaintainService,
            PbSetMaintainService pbSetMaintainService,
            PbNodeMaintainService pbNodeMaintainService,
            PbItemMaintainService pbItemMaintainService,
            PbRecordMaintainService pbRecordMaintainService,
            PbFileInfoMaintainService pbFileInfoMaintainService
    ) {
        this.userMaintainService = userMaintainService;
        this.popbMaintainService = popbMaintainService;
        this.pbSetMaintainService = pbSetMaintainService;
        this.pbNodeMaintainService = pbNodeMaintainService;
        this.pbItemMaintainService = pbItemMaintainService;
        this.pbRecordMaintainService = pbRecordMaintainService;
        this.pbFileInfoMaintainService = pbFileInfoMaintainService;
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

    public void makeSurePbNodeExists(LongIdKey pbNodeKey) throws HandlerException {
        try {
            if (!pbNodeMaintainService.exists(pbNodeKey)) {
                throw new PbNodeNotExistsException(pbNodeKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbItemExists(LongIdKey pbItemKey) throws HandlerException {
        try {
            if (!pbItemMaintainService.exists(pbItemKey)) {
                throw new PbItemNotExistsException(pbItemKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbRecordExists(LongIdKey pbRecordKey) throws HandlerException {
        try {
            if (!pbRecordMaintainService.exists(pbRecordKey)) {
                throw new PbRecordNotExistsException(pbRecordKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbFileExists(LongIdKey pbFileKey) throws HandlerException {
        try {
            if (!pbFileInfoMaintainService.exists(pbFileKey)) {
                throw new PbFileNotExistsException(pbFileKey);
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
    public void makeSureUserModifyPermittedForPbSet(StringIdKey userKey, LongIdKey pbSetKey)
            throws HandlerException {
        try {
            // 1. 构造 Popb 主键。
            PopbKey popbKey = new PopbKey(pbSetKey.getLongId(), userKey.getStringId());

            // 2. 查看 Popb 实体是否存在，如果不存在，则没有权限。
            if (!popbMaintainService.exists(popbKey)) {
                throw new UserNotPermittedForPbSetException(userKey, pbSetKey);
            }

            // 3. 查看 Popb.permissionLevel 是否为 Popb.PERMISSION_LEVEL_OWNER，如果不是，则没有权限。
            Popb popb = popbMaintainService.get(popbKey);
            if (Objects.equals(popb.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            throw new UserNotPermittedForPbSetException(userKey, pbSetKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbSetIdenticalForPbSet(LongIdKey nodeKey, LongIdKey setKey)
            throws HandlerException {
        try {
            // 如果 leftNodeKey 为 null，则表示该项目是根项目，不需要进行任何判断。
            if (Objects.isNull(nodeKey)) {
                return;
            }

            PbNode parentNode = pbNodeMaintainService.get(nodeKey);
            LongIdKey parentSetKey = parentNode.getSetKey();
            if (Objects.isNull(parentSetKey)) {
                throw new IllegalPbNodeStateException(nodeKey);
            }
            if (!Objects.equals(parentSetKey, setKey)) {
                throw new PbSetNotIdenticalException(parentSetKey, setKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserInspectPermittedForPbNode(StringIdKey userKey, LongIdKey pbNodeKey) throws HandlerException {
        try {
            // 1. 查找指定的个人最佳节点是否绑定个人最佳集合，如果不绑定个人最佳集合，则抛出个人最佳节点状态异常。
            PbNode pbNode = pbNodeMaintainService.get(pbNodeKey);
            if (Objects.isNull(pbNode.getSetKey())) {
                throw new IllegalPbNodeStateException(pbNodeKey);
            }

            // 2. 取出个人最佳节点的个人最佳集合外键，判断用户是否拥有该个人最佳集合的权限。
            makeSureUserInspectPermittedForPbSet(userKey, pbNode.getSetKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForPbNode(StringIdKey userKey, LongIdKey pbNodeKey) throws HandlerException {
        try {
            // 1. 查找指定的个人最佳节点是否绑定个人最佳集合，如果不绑定个人最佳集合，则抛出个人最佳节点状态异常。
            PbNode pbNode = pbNodeMaintainService.get(pbNodeKey);
            if (Objects.isNull(pbNode.getSetKey())) {
                throw new IllegalPbNodeStateException(pbNodeKey);
            }

            // 2. 取出个人最佳节点的个人最佳集合外键，判断用户是否拥有该个人最佳集合的权限。
            makeSureUserModifyPermittedForPbSet(userKey, pbNode.getSetKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserInspectPermittedForPbItem(StringIdKey userKey, LongIdKey pbItemKey) throws HandlerException {
        try {
            // 1. 查找指定的个人最佳项目是否绑定个人最佳节点，如果不绑定个人最佳节点，则抛出个人最佳项目状态异常。
            PbItem pbItem = pbItemMaintainService.get(pbItemKey);
            if (Objects.isNull(pbItem.getNodeKey())) {
                throw new IllegalPbItemStateException(pbItemKey);
            }

            // 2. 取出个人最佳项目的个人最佳节点外键，判断用户是否拥有该个人最佳节点的权限。
            makeSureUserInspectPermittedForPbNode(userKey, pbItem.getNodeKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForPbItem(StringIdKey userKey, LongIdKey pbItemKey) throws HandlerException {
        try {
            // 1. 查找指定的个人最佳项目是否绑定个人最佳节点，如果不绑定个人最佳节点，则抛出个人最佳项目状态异常。
            PbItem pbItem = pbItemMaintainService.get(pbItemKey);
            if (Objects.isNull(pbItem.getNodeKey())) {
                throw new IllegalPbItemStateException(pbItemKey);
            }

            // 2. 取出个人最佳项目的个人最佳节点外键，判断用户是否拥有该个人最佳节点的权限。
            makeSureUserModifyPermittedForPbNode(userKey, pbItem.getNodeKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserInspectPermittedForPbRecord(StringIdKey userKey, LongIdKey pbRecordKey) throws HandlerException {
        try {
            // 1. 查找指定的个人最佳记录是否绑定个人最佳节点，如果不绑定个人最佳节点，则抛出个人最佳记录状态异常。
            PbRecord pbRecord = pbRecordMaintainService.get(pbRecordKey);
            if (Objects.isNull(pbRecord.getItemKey())) {
                throw new IllegalPbRecordStateException(pbRecordKey);
            }

            // 2. 取出个人最佳记录的个人最佳节点外键，判断用户是否拥有该个人最佳节点的权限。
            makeSureUserInspectPermittedForPbItem(userKey, pbRecord.getItemKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForPbRecord(StringIdKey userKey, LongIdKey pbRecordKey) throws HandlerException {
        try {
            // 1. 查找指定的个人最佳记录是否绑定个人最佳节点，如果不绑定个人最佳节点，则抛出个人最佳记录状态异常。
            PbRecord pbRecord = pbRecordMaintainService.get(pbRecordKey);
            if (Objects.isNull(pbRecord.getItemKey())) {
                throw new IllegalPbRecordStateException(pbRecordKey);
            }

            // 2. 取出个人最佳记录的个人最佳节点外键，判断用户是否拥有该个人最佳节点的权限。
            makeSureUserModifyPermittedForPbItem(userKey, pbRecord.getItemKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbSetIdenticalForPbNode(LongIdKey leftNodeKey, LongIdKey rightNodeKey)
            throws HandlerException {
        try {
            PbNode childNode = pbNodeMaintainService.get(rightNodeKey);
            LongIdKey childSetKey = childNode.getSetKey();
            if (Objects.isNull(childSetKey)) {
                throw new IllegalPbNodeStateException(leftNodeKey);
            }
            makeSurePbSetIdenticalForPbSet(leftNodeKey, childSetKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
