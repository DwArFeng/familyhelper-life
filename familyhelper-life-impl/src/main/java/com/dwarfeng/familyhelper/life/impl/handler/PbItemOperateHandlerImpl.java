package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.familyhelper.life.stack.handler.PbItemOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbSetMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PbItemOperateHandlerImpl implements PbItemOperateHandler {

    private final PbItemMaintainService pbItemMaintainService;
    private final PbSetMaintainService pbSetMaintainService;

    private final HandlerValidator handlerValidator;

    public PbItemOperateHandlerImpl(
            PbItemMaintainService pbItemMaintainService,
            PbSetMaintainService pbSetMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.pbItemMaintainService = pbItemMaintainService;
        this.pbSetMaintainService = pbSetMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey createPbItem(StringIdKey userKey, PbItemCreateInfo pbItemCreateInfo) throws HandlerException {
        try {
            LongIdKey setKey = pbItemCreateInfo.getSetKey();
            LongIdKey nodeKey = pbItemCreateInfo.getNodeKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳集合存在。
            handlerValidator.makeSurePbSetExists(setKey);

            // 确认个人最佳节点存在。
            if (Objects.nonNull(nodeKey)) {
                handlerValidator.makeSurePbNodeExists(nodeKey);
            }

            // 确认用户有权限操作指定的个人最佳节点。
            handlerValidator.makeSureUserModifyPermittedForPbSet(userKey, setKey);

            // 确认个人最佳节点与父个人最佳节点的个人最佳集合存在。
            handlerValidator.makeSurePbSetIdenticalForPbSet(nodeKey, setKey);

            // 根据 pbItemCreateInfo 以及创建的规则组合 个人最佳项目 实体。
            PbItem pbItem = new PbItem(
                    null, nodeKey, setKey, pbItemCreateInfo.getName(), pbItemCreateInfo.getUnit(),
                    pbItemCreateInfo.getComparator(), pbItemCreateInfo.getRemark()
            );

            // 插入个人最佳项目，并返回个人最佳项目实体的主键。
            LongIdKey pbItemKey = pbItemMaintainService.insert(pbItem);

            // 自增个人最佳集合的项目计数。
            PbSet pbSet = pbSetMaintainService.get(setKey);
            pbSet.setItemCount(pbSet.getItemCount() + 1);
            pbSetMaintainService.update(pbSet);

            // 返回主键。
            return pbItemKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updatePbItem(StringIdKey userKey, PbItemUpdateInfo pbItemUpdateInfo) throws HandlerException {
        try {
            LongIdKey pbItemKey = pbItemUpdateInfo.getKey();
            LongIdKey pbNodeKey = pbItemUpdateInfo.getNodeKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳节点存在。
            if (Objects.nonNull(pbNodeKey)) {
                handlerValidator.makeSurePbNodeExists(pbNodeKey);
            }

            // 确认个人最佳项目存在。
            handlerValidator.makeSurePbItemExists(pbItemKey);

            // 确认用户有权限操作指定的个人最佳项目。
            handlerValidator.makeSureUserModifyPermittedForPbItem(userKey, pbItemKey);

            // 确认新的个人最佳节点与个人最佳条目的个人最佳集合相同。
            handlerValidator.makeSurePbSetIdenticalForPbItem(pbNodeKey, pbItemKey);

            // 根据 pbItemUpdateInfo 以及更新的规则设置 个人最佳项目 实体。
            PbItem pbItem = pbItemMaintainService.get(pbItemKey);
            pbItem.setNodeKey(pbNodeKey);
            pbItem.setName(pbItemUpdateInfo.getName());
            pbItem.setUnit(pbItemUpdateInfo.getUnit());
            pbItem.setComparator(pbItemUpdateInfo.getComparator());
            pbItem.setRemark(pbItemUpdateInfo.getRemark());

            // 更新 个人最佳项目 实体。
            pbItemMaintainService.update(pbItem);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePbItem(StringIdKey userKey, LongIdKey pbItemKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳项目存在。
            handlerValidator.makeSurePbItemExists(pbItemKey);

            // 确认个人最佳集合存在。
            PbItem pbItem = pbItemMaintainService.get(pbItemKey);
            LongIdKey setKey = pbItem.getSetKey();
            handlerValidator.makeSurePbSetExists(setKey);

            // 确认用户有权限操作指定的个人最佳项目。
            handlerValidator.makeSureUserModifyPermittedForPbItem(userKey, pbItemKey);

            // 删除指定的个人最佳项目。
            pbItemMaintainService.delete(pbItemKey);

            // 自减个人最佳集合的项目计数。
            PbSet pbSet = pbSetMaintainService.get(setKey);
            pbSet.setItemCount(Math.max(pbSet.getItemCount() - 1, 0));
            pbSetMaintainService.update(pbSet);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
