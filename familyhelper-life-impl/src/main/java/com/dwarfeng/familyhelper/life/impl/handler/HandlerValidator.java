package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.familyhelper.life.stack.exception.*;
import com.dwarfeng.familyhelper.life.stack.service.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.List;
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
public class HandlerValidator {

    private final UserMaintainService userMaintainService;
    private final PopbMaintainService popbMaintainService;
    private final PbSetMaintainService pbSetMaintainService;
    private final PbNodeMaintainService pbNodeMaintainService;
    private final PbItemMaintainService pbItemMaintainService;
    private final PbRecordMaintainService pbRecordMaintainService;
    private final PbFileInfoMaintainService pbFileInfoMaintainService;
    private final PoadMaintainService poadMaintainService;
    private final ActivityDataSetMaintainService activityDataSetMaintainService;
    private final ActivityDataNodeMaintainService activityDataNodeMaintainService;
    private final ActivityDataItemMaintainService activityDataItemMaintainService;
    private final ActivityTemplateMaintainService activityTemplateMaintainService;
    private final PoatMaintainService poatMaintainService;
    private final ActivityTemplateCoverInfoMaintainService activityTemplateCoverInfoMaintainService;
    private final ActivityTemplateParticipantMaintainService activityTemplateParticipantMaintainService;
    private final ActivityTemplateFileInfoMaintainService activityTemplateFileInfoMaintainService;
    private final ActivityTemplateDataInfoMaintainService activityTemplateDataInfoMaintainService;
    private final ActivityMaintainService activityMaintainService;
    private final PoacMaintainService poacMaintainService;
    private final ActivityCoverInfoMaintainService activityCoverInfoMaintainService;
    private final ActivityFileInfoMaintainService activityFileInfoMaintainService;
    private final ActivityParticipantMaintainService activityParticipantMaintainService;
    private final ActivityDataRecordMaintainService activityDataRecordMaintainService;
    private final ActivityTemplateDriverInfoMaintainService activityTemplateDriverInfoMaintainService;

    public HandlerValidator(
            UserMaintainService userMaintainService,
            PopbMaintainService popbMaintainService,
            PbSetMaintainService pbSetMaintainService,
            PbNodeMaintainService pbNodeMaintainService,
            PbItemMaintainService pbItemMaintainService,
            PbRecordMaintainService pbRecordMaintainService,
            PbFileInfoMaintainService pbFileInfoMaintainService,
            PoadMaintainService poadMaintainService,
            ActivityDataSetMaintainService activityDataSetMaintainService,
            ActivityDataNodeMaintainService activityDataNodeMaintainService,
            ActivityDataItemMaintainService activityDataItemMaintainService,
            ActivityTemplateMaintainService activityTemplateMaintainService,
            PoatMaintainService poatMaintainService,
            ActivityTemplateCoverInfoMaintainService activityTemplateCoverInfoMaintainService,
            ActivityTemplateParticipantMaintainService activityTemplateParticipantMaintainService,
            ActivityTemplateFileInfoMaintainService activityTemplateFileInfoMaintainService,
            ActivityTemplateDataInfoMaintainService activityTemplateDataInfoMaintainService,
            ActivityMaintainService activityMaintainService,
            PoacMaintainService poacMaintainService,
            ActivityCoverInfoMaintainService activityCoverInfoMaintainService,
            ActivityFileInfoMaintainService activityFileInfoMaintainService,
            ActivityParticipantMaintainService activityParticipantMaintainService,
            ActivityDataRecordMaintainService activityDataRecordMaintainService,
            ActivityTemplateDriverInfoMaintainService activityTemplateDriverInfoMaintainService
    ) {
        this.userMaintainService = userMaintainService;
        this.popbMaintainService = popbMaintainService;
        this.pbSetMaintainService = pbSetMaintainService;
        this.pbNodeMaintainService = pbNodeMaintainService;
        this.pbItemMaintainService = pbItemMaintainService;
        this.pbRecordMaintainService = pbRecordMaintainService;
        this.pbFileInfoMaintainService = pbFileInfoMaintainService;
        this.poadMaintainService = poadMaintainService;
        this.activityDataSetMaintainService = activityDataSetMaintainService;
        this.activityDataNodeMaintainService = activityDataNodeMaintainService;
        this.activityDataItemMaintainService = activityDataItemMaintainService;
        this.activityTemplateMaintainService = activityTemplateMaintainService;
        this.poatMaintainService = poatMaintainService;
        this.activityTemplateCoverInfoMaintainService = activityTemplateCoverInfoMaintainService;
        this.activityTemplateParticipantMaintainService = activityTemplateParticipantMaintainService;
        this.activityTemplateFileInfoMaintainService = activityTemplateFileInfoMaintainService;
        this.activityTemplateDataInfoMaintainService = activityTemplateDataInfoMaintainService;
        this.activityMaintainService = activityMaintainService;
        this.poacMaintainService = poacMaintainService;
        this.activityCoverInfoMaintainService = activityCoverInfoMaintainService;
        this.activityFileInfoMaintainService = activityFileInfoMaintainService;
        this.activityParticipantMaintainService = activityParticipantMaintainService;
        this.activityDataRecordMaintainService = activityDataRecordMaintainService;
        this.activityTemplateDriverInfoMaintainService = activityTemplateDriverInfoMaintainService;
    }

    public void makeSureUserExists(StringIdKey userKey) throws HandlerException {
        try {
            if (Objects.isNull(userKey) || !userMaintainService.exists(userKey)) {
                throw new UserNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbSetExists(LongIdKey pbSetKey) throws HandlerException {
        try {
            if (Objects.isNull(pbSetKey) || !pbSetMaintainService.exists(pbSetKey)) {
                throw new PbSetNotExistsException(pbSetKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbNodeExists(LongIdKey pbNodeKey) throws HandlerException {
        try {
            if (Objects.isNull(pbNodeKey) || !pbNodeMaintainService.exists(pbNodeKey)) {
                throw new PbNodeNotExistsException(pbNodeKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbItemExists(LongIdKey pbItemKey) throws HandlerException {
        try {
            if (Objects.isNull(pbItemKey) || !pbItemMaintainService.exists(pbItemKey)) {
                throw new PbItemNotExistsException(pbItemKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbRecordExists(LongIdKey pbRecordKey) throws HandlerException {
        try {
            if (Objects.isNull(pbRecordKey) || !pbRecordMaintainService.exists(pbRecordKey)) {
                throw new PbRecordNotExistsException(pbRecordKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePbFileExists(LongIdKey pbFileKey) throws HandlerException {
        try {
            if (Objects.isNull(pbFileKey) || !pbFileInfoMaintainService.exists(pbFileKey)) {
                throw new PbFileNotExistsException(pbFileKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityDataSetExists(LongIdKey activityDataSetKey) throws HandlerException {
        try {
            if (Objects.isNull(activityDataSetKey) || !activityDataSetMaintainService.exists(activityDataSetKey)) {
                throw new ActivityDataSetNotExistsException(activityDataSetKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityDataNodeExists(LongIdKey activityDataNodeKey) throws HandlerException {
        try {
            if (Objects.isNull(activityDataNodeKey) || !activityDataNodeMaintainService.exists(activityDataNodeKey)) {
                throw new ActivityDataNodeNotExistsException(activityDataNodeKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityDataItemExists(LongIdKey activityDataItemKey) throws HandlerException {
        try {
            if (Objects.isNull(activityDataItemKey) || !activityDataItemMaintainService.exists(activityDataItemKey)) {
                throw new ActivityDataItemNotExistsException(activityDataItemKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateExists(LongIdKey activityTemplateKey) throws HandlerException {
        try {
            if (Objects.isNull(activityTemplateKey) || !activityTemplateMaintainService.exists(activityTemplateKey)) {
                throw new ActivityTemplateNotExistsException(activityTemplateKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateCoverExists(LongIdKey activityTemplateCoverKey) throws HandlerException {
        try {
            if (Objects.isNull(activityTemplateCoverKey) || !activityTemplateCoverInfoMaintainService.exists(activityTemplateCoverKey)) {
                throw new ActivityTemplateCoverNotExistsException(activityTemplateCoverKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateParticipantNotExists(
            ActivityTemplateParticipantKey activityTemplateParticipantKey
    ) throws HandlerException {
        try {
            if (Objects.nonNull(activityTemplateParticipantKey) &&
                    activityTemplateParticipantMaintainService.exists(activityTemplateParticipantKey)) {
                throw new ActivityTemplateParticipantExistsException(activityTemplateParticipantKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateParticipantExists(
            ActivityTemplateParticipantKey activityTemplateParticipantKey
    ) throws HandlerException {
        try {
            if (Objects.isNull(activityTemplateParticipantKey) ||
                    !activityTemplateParticipantMaintainService.exists(activityTemplateParticipantKey)) {
                throw new ActivityTemplateParticipantNotExistsException(activityTemplateParticipantKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateFileExists(LongIdKey activityTemplateFileKey) throws HandlerException {
        try {
            if (Objects.isNull(activityTemplateFileKey) ||
                    !activityTemplateFileInfoMaintainService.exists(activityTemplateFileKey)) {
                throw new ActivityTemplateFileNotExistsException(activityTemplateFileKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityExists(LongIdKey activityKey) throws HandlerException {
        try {
            if (Objects.isNull(activityKey) || !activityMaintainService.exists(activityKey)) {
                throw new ActivityNotExistsException(activityKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityCoverExists(LongIdKey activityCoverKey) throws HandlerException {
        try {
            if (Objects.isNull(activityCoverKey) || !activityCoverInfoMaintainService.exists(activityCoverKey)) {
                throw new ActivityCoverNotExistsException(activityCoverKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityFileExists(LongIdKey activityFileKey) throws HandlerException {
        try {
            if (Objects.isNull(activityFileKey) || !activityFileInfoMaintainService.exists(activityFileKey)) {
                throw new ActivityFileNotExistsException(activityFileKey);
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

    public void makeSurePbSetIdenticalForPbItem(LongIdKey nodeKey, LongIdKey itemKey)
            throws HandlerException {
        try {
            // 如果 nodeKey 为 null，则表示该项目是根项目，不需要进行任何判断。
            if (Objects.isNull(nodeKey)) {
                return;
            }

            // 否则，取出父节点的 setKey，以及个人最佳项目的 setKey，判断是否相等。
            PbNode pbNode = pbNodeMaintainService.get(nodeKey);
            LongIdKey nodeSetKey = pbNode.getSetKey();
            PbItem pbItem = pbItemMaintainService.get(itemKey);
            LongIdKey itemSetKey = pbItem.getSetKey();

            // 保证个人最最佳节点的 setKey 不为 null。
            if (Objects.isNull(nodeSetKey)) {
                throw new IllegalPbNodeStateException(nodeKey);
            }
            // 保证个人最佳项目的 setKey 不为 null。
            if (Objects.isNull(itemSetKey)) {
                throw new IllegalPbItemStateException(itemKey);
            }

            // 保证两者的 setKey 相等。
            if (!Objects.equals(nodeSetKey, itemSetKey)) {
                throw new PbSetNotIdenticalException(nodeSetKey, itemSetKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserInspectPermittedForPbNode(StringIdKey userKey, LongIdKey pbNodeKey) throws
            HandlerException {
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

    public void makeSureUserInspectPermittedForPbItem(StringIdKey userKey, LongIdKey pbItemKey)
            throws HandlerException {
        try {
            // 1. 查找指定的个人最佳项目是否绑定个人最佳集合，如果不绑定个人最佳集合，则抛出个人最佳项目状态异常。
            PbItem pbItem = pbItemMaintainService.get(pbItemKey);
            if (Objects.isNull(pbItem.getSetKey())) {
                throw new IllegalPbItemStateException(pbItemKey);
            }

            // 2. 取出个人最佳项目的个人最佳集合外键，判断用户是否拥有该个人最佳节点的权限。
            makeSureUserInspectPermittedForPbSet(userKey, pbItem.getSetKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForPbItem(StringIdKey userKey, LongIdKey pbItemKey)
            throws HandlerException {
        try {
            // 1. 查找指定的个人最佳项目是否绑定个人最佳集合，如果不绑定个人最佳集合，则抛出个人最佳项目状态异常。
            PbItem pbItem = pbItemMaintainService.get(pbItemKey);
            if (Objects.isNull(pbItem.getSetKey())) {
                throw new IllegalPbItemStateException(pbItemKey);
            }

            // 2. 取出个人最佳项目的个人最佳集合外键，判断用户是否拥有该个人最佳节点的权限。
            makeSureUserModifyPermittedForPbSet(userKey, pbItem.getSetKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserInspectPermittedForPbRecord(StringIdKey userKey, LongIdKey pbRecordKey)
            throws HandlerException {
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

    public void makeSureUserModifyPermittedForPbRecord(StringIdKey userKey, LongIdKey pbRecordKey)
            throws HandlerException {
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

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserInspectPermittedForActivityDataSet(StringIdKey userKey, LongIdKey activityDataSetKey)
            throws HandlerException {
        try {
            // 1. 构造 Poad 主键。
            PoadKey poadKey = new PoadKey(activityDataSetKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poad 实体是否存在，如果不存在，则没有权限。
            if (!poadMaintainService.exists(poadKey)) {
                throw new UserNotPermittedForActivityDataSetException(userKey, activityDataSetKey);
            }

            // 3. 查看 Poad.permissionLevel 是否为 Poad.PERMISSION_LEVEL_OWNER 或 Poad.PERMISSION_LEVEL_GUEST，
            // 如果不是，则没有权限。
            Poad poad = poadMaintainService.get(poadKey);
            if (Objects.equals(poad.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            if (Objects.equals(poad.getPermissionLevel(), Constants.PERMISSION_LEVEL_GUEST)) {
                return;
            }
            throw new UserNotPermittedForActivityDataSetException(userKey, activityDataSetKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserModifyPermittedForActivityDataSet(StringIdKey userKey, LongIdKey activityDataSetKey)
            throws HandlerException {
        try {
            // 1. 构造 Poad 主键。
            PoadKey poadKey = new PoadKey(activityDataSetKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poad 实体是否存在，如果不存在，则没有权限。
            if (!poadMaintainService.exists(poadKey)) {
                throw new UserNotPermittedForActivityDataSetException(userKey, activityDataSetKey);
            }

            // 3. 查看 Poad.permissionLevel 是否为 Poad.PERMISSION_LEVEL_OWNER，如果不是，则没有权限。
            Poad poad = poadMaintainService.get(poadKey);
            if (Objects.equals(poad.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            throw new UserNotPermittedForActivityDataSetException(userKey, activityDataSetKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserInspectPermittedForActivityTemplate(StringIdKey userKey, LongIdKey activityTemplateKey)
            throws HandlerException {
        try {
            // 1. 构造 Poat 主键。
            PoatKey poatKey = new PoatKey(activityTemplateKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poat 实体是否存在，如果不存在，则没有权限。
            if (!poatMaintainService.exists(poatKey)) {
                throw new UserNotPermittedForActivityTemplateException(userKey, activityTemplateKey);
            }

            // 3. 查看 Poat.permissionLevel 是否为 Poat.PERMISSION_LEVEL_OWNER 或 Poat.PERMISSION_LEVEL_GUEST，
            // 如果不是，则没有权限。
            Poat poat = poatMaintainService.get(poatKey);
            if (Objects.equals(poat.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            if (Objects.equals(poat.getPermissionLevel(), Constants.PERMISSION_LEVEL_GUEST)) {
                return;
            }
            throw new UserNotPermittedForActivityTemplateException(userKey, activityTemplateKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserModifyPermittedForActivityTemplate(StringIdKey userKey, LongIdKey activityTemplateKey)
            throws HandlerException {
        try {
            // 1. 构造 Poat 主键。
            PoatKey poatKey = new PoatKey(activityTemplateKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poat 实体是否存在，如果不存在，则没有权限。
            if (!poatMaintainService.exists(poatKey)) {
                throw new UserNotPermittedForActivityTemplateException(userKey, activityTemplateKey);
            }

            // 3. 查看 Poat.permissionLevel 是否为 Poat.PERMISSION_LEVEL_OWNER，如果不是，则没有权限。
            Poat poat = poatMaintainService.get(poatKey);
            if (Objects.equals(poat.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            throw new UserNotPermittedForActivityTemplateException(userKey, activityTemplateKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForActivityTemplateFileInfo(
            StringIdKey userKey, LongIdKey activityTemplateFileInfoKey
    ) throws HandlerException {
        try {
            // 确认 activityTemplateFileKey 对应的文件存在。
            makeSureActivityTemplateFileExists(activityTemplateFileInfoKey);

            // 查找指定的活动模板文件是否绑定活动模板，如果不绑定活动模板，则抛出活动模板文件状态异常。
            ActivityTemplateFileInfo activityTemplateFileInfo = activityTemplateFileInfoMaintainService.get(
                    activityTemplateFileInfoKey
            );
            if (Objects.isNull(activityTemplateFileInfo.getActivityTemplateKey())) {
                throw new IllegalActivityTemplateFileStateException(activityTemplateFileInfoKey);
            }

            // 取出活动模板文件的活动模板外键，判断用户是否拥有该活动模板的权限。
            makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateFileInfo.getActivityTemplateKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityDataSetIdenticalForActivityDataSet(LongIdKey nodeKey, LongIdKey setKey)
            throws HandlerException {
        try {
            // 如果 nodeKey 为 null，则代表该节点为根节点，不需要进行校验。
            if (Objects.isNull(nodeKey)) {
                return;
            }

            // 否则，取出父节点的 setKey，判断是否与 setKey 相同。
            ActivityDataNode parentNode = activityDataNodeMaintainService.get(nodeKey);
            LongIdKey parentSetKey = parentNode.getSetKey();
            if (Objects.isNull(parentSetKey)) {
                throw new IllegalActivityDataNodeStateException(nodeKey);
            }
            if (!Objects.equals(parentSetKey, setKey)) {
                throw new ActivityDataSetNotIdenticalException(parentSetKey, setKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForActivityDataNode(StringIdKey userKey, LongIdKey activityDataNodeKey)
            throws HandlerException {
        try {
            // 1. 查找指定的活动数据节点是否绑定活动数据集合，如果不绑定活动数据集合，则抛出活动数据节点状态异常。
            ActivityDataNode activityDataNode = activityDataNodeMaintainService.get(activityDataNodeKey);
            if (Objects.isNull(activityDataNode.getSetKey())) {
                throw new IllegalActivityDataNodeStateException(activityDataNodeKey);
            }

            // 2. 取出活动数据节点的活动数据集合外键，判断用户是否拥有该活动数据集合的权限。
            makeSureUserModifyPermittedForActivityDataSet(userKey, activityDataNode.getSetKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityDataSetIdenticalForActivityDataNode(LongIdKey leftNodeKey, LongIdKey rightNodeKey)
            throws HandlerException {
        try {
            ActivityDataNode childNode = activityDataNodeMaintainService.get(rightNodeKey);
            LongIdKey childSetKey = childNode.getSetKey();
            if (Objects.isNull(childSetKey)) {
                throw new IllegalActivityDataNodeStateException(leftNodeKey);
            }
            makeSureActivityDataSetIdenticalForActivityDataSet(leftNodeKey, childSetKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForActivityDataItem(StringIdKey userKey, LongIdKey activityDataItemKey)
            throws HandlerException {
        try {
            // 1. 查找指定的活动数据项目是否绑定活动数据集合，如果不绑定活动数据集合，则抛出活动数据项目状态异常。
            ActivityDataItem activityDataItem = activityDataItemMaintainService.get(activityDataItemKey);
            if (Objects.isNull(activityDataItem.getSetKey())) {
                throw new IllegalActivityDataItemStateException(activityDataItemKey);
            }

            // 2. 取出活动数据项目的活动数据集合外键，判断用户是否拥有该活动数据节点的权限。
            makeSureUserModifyPermittedForActivityDataSet(userKey, activityDataItem.getSetKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityDataSetIdenticalForActivityDataItem(LongIdKey nodeKey, LongIdKey itemKey)
            throws HandlerException {
        try {
            // 如果 nodeKey 为 null，则表示该项目是根项目，不需要进行任何判断。
            if (Objects.isNull(nodeKey)) {
                return;
            }

            // 否则，取出父节点的 setKey，以及活动数据项目的 setKey，判断是否相等。
            ActivityDataNode activityDataNode = activityDataNodeMaintainService.get(nodeKey);
            LongIdKey nodeSetKey = activityDataNode.getSetKey();
            ActivityDataItem activityDataItem = activityDataItemMaintainService.get(itemKey);
            LongIdKey itemSetKey = activityDataItem.getSetKey();

            // 保证个人最最佳节点的 setKey 不为 null。
            if (Objects.isNull(nodeSetKey)) {
                throw new IllegalActivityDataNodeStateException(nodeKey);
            }
            // 保证活动数据项目的 setKey 不为 null。
            if (Objects.isNull(itemSetKey)) {
                throw new IllegalActivityDataItemStateException(itemKey);
            }

            // 保证两者的 setKey 相等。
            if (!Objects.equals(nodeSetKey, itemSetKey)) {
                throw new ActivityDataSetNotIdenticalException(nodeSetKey, itemSetKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateCoverHasSameActivityTemplate(List<LongIdKey> activityTemplateCoverKeys)
            throws HandlerException {
        try {
            LongIdKey activityTemplateKey = activityTemplateCoverInfoMaintainService.get(
                    activityTemplateCoverKeys.get(0)
            ).getActivityTemplateKey();
            if (Objects.isNull(activityTemplateKey)) {
                throw new IllegalActivityTemplateCoverStateException(activityTemplateCoverKeys.get(0));
            }
            for (LongIdKey activityTemplateCoverKey : activityTemplateCoverKeys) {
                LongIdKey anchorActivityTemplateKey = activityTemplateCoverInfoMaintainService.get(
                        activityTemplateCoverKey
                ).getActivityTemplateKey();
                if (!Objects.equals(activityTemplateKey, anchorActivityTemplateKey)) {
                    throw new IllegalActivityTemplateCoverStateException(activityTemplateCoverKey);
                }
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityCoverHasSameActivity(List<LongIdKey> activityCoverKeys)
            throws HandlerException {
        try {
            LongIdKey activityKey = activityCoverInfoMaintainService.get(
                    activityCoverKeys.get(0)
            ).getActivityKey();
            if (Objects.isNull(activityKey)) {
                throw new IllegalActivityCoverStateException(activityCoverKeys.get(0));
            }
            for (LongIdKey activityCoverKey : activityCoverKeys) {
                LongIdKey anchorActivityKey = activityCoverInfoMaintainService.get(
                        activityCoverKey
                ).getActivityKey();
                if (!Objects.equals(activityKey, anchorActivityKey)) {
                    throw new IllegalActivityCoverStateException(activityCoverKey);
                }
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateDataInfoExists(LongIdKey activityTemplateDataInfoKey) throws HandlerException {
        try {
            if (Objects.isNull(activityTemplateDataInfoKey) ||
                    !activityTemplateDataInfoMaintainService.exists(activityTemplateDataInfoKey)) {
                throw new ActivityTemplateDataInfoNotExistsException(activityTemplateDataInfoKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserInspectPermittedForActivity(StringIdKey userKey, LongIdKey activityKey)
            throws HandlerException {
        try {
            // 1. 构造 Poac 主键。
            PoacKey poacKey = new PoacKey(activityKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poac 实体是否存在，如果不存在，则没有权限。
            if (!poacMaintainService.exists(poacKey)) {
                throw new UserNotPermittedForActivityException(userKey, activityKey);
            }

            // 3. 查看 Poac.permissionLevel 是否为 Poac.PERMISSION_LEVEL_OWNER 或 Poac.PERMISSION_LEVEL_GUEST，
            // 如果不是，则没有权限。
            Poac poac = poacMaintainService.get(poacKey);
            if (Objects.equals(poac.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            if (Objects.equals(poac.getPermissionLevel(), Constants.PERMISSION_LEVEL_GUEST)) {
                return;
            }
            throw new UserNotPermittedForActivityException(userKey, activityKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserModifyPermittedForActivity(StringIdKey userKey, LongIdKey activityKey)
            throws HandlerException {
        try {
            // 1. 构造 Poac 主键。
            PoacKey poacKey = new PoacKey(activityKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poac 实体是否存在，如果不存在，则没有权限。
            if (!poacMaintainService.exists(poacKey)) {
                throw new UserNotPermittedForActivityException(userKey, activityKey);
            }

            // 3. 查看 Poac.permissionLevel 是否为 Poac.PERMISSION_LEVEL_OWNER，如果不是，则没有权限。
            Poac poac = poacMaintainService.get(poacKey);
            if (Objects.equals(poac.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            throw new UserNotPermittedForActivityException(userKey, activityKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityNotLocked(LongIdKey activityKey) throws HandlerException {
        try {
            if (Objects.isNull(activityKey) || !activityMaintainService.exists(activityKey)) {
                throw new ActivityNotExistsException(activityKey);
            }
            Activity activity = activityMaintainService.get(activityKey);
            if (activity.isLocked()) {
                throw new ActivityLockedException(activityKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserModifyPermittedForActivityFileInfo(StringIdKey userKey, LongIdKey activityFileInfoKey)
            throws HandlerException {
        try {
            // 确认 activityFileKey 对应的文件存在。
            makeSureActivityFileExists(activityFileInfoKey);

            // 查找指定的活动文件是否绑定活动，如果不绑定活动，则抛出活动文件状态异常。
            ActivityFileInfo activityFileInfo = activityFileInfoMaintainService.get(activityFileInfoKey);
            if (Objects.isNull(activityFileInfo.getActivityKey())) {
                throw new IllegalActivityFileStateException(activityFileInfoKey);
            }

            // 取出活动文件的活动外键，判断用户是否拥有该活动的权限。
            makeSureUserModifyPermittedForActivity(userKey, activityFileInfo.getActivityKey());
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityParticipantNotExists(ActivityParticipantKey activityParticipantKey)
            throws HandlerException {
        try {
            if (Objects.nonNull(activityParticipantKey) &&
                    activityParticipantMaintainService.exists(activityParticipantKey)) {
                throw new ActivityParticipantExistsException(activityParticipantKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityParticipantExists(ActivityParticipantKey activityParticipantKey)
            throws HandlerException {
        try {
            if (Objects.isNull(activityParticipantKey) ||
                    !activityParticipantMaintainService.exists(activityParticipantKey)) {
                throw new ActivityParticipantNotExistsException(activityParticipantKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityDataRecordExists(LongIdKey activityDataRecordKey) throws HandlerException {
        try {
            if (Objects.isNull(activityDataRecordKey) ||
                    !activityDataRecordMaintainService.exists(activityDataRecordKey)) {
                throw new ActivityDataRecordNotExistsException(activityDataRecordKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureActivityTemplateDriverInfoExists(LongIdKey activityTemplateDriverInfoKey)
            throws HandlerException {
        try {
            if (Objects.isNull(activityTemplateDriverInfoKey) ||
                    !activityTemplateDriverInfoMaintainService.exists(activityTemplateDriverInfoKey)) {
                throw new ActivityTemplateDriverInfoNotExistsException(activityTemplateDriverInfoKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
