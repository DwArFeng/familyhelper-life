package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.familyhelper.life.stack.handler.PbNodeOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbNodeMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PbNodeOperateHandlerImpl implements PbNodeOperateHandler {

    private final PbNodeMaintainService pbNodeMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public PbNodeOperateHandlerImpl(
            PbNodeMaintainService pbNodeMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.pbNodeMaintainService = pbNodeMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public LongIdKey createPbNode(StringIdKey userKey, PbNodeCreateInfo pbNodeCreateInfo) throws HandlerException {
        try {
            LongIdKey setKey = pbNodeCreateInfo.getSetKey();
            LongIdKey parentKey = pbNodeCreateInfo.getParentKey();

            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetExists(setKey);

            // 3. 确认父个人最佳节点存在。
            if (Objects.nonNull(parentKey)) {
                operateHandlerValidator.makeSurePbNodeExists(parentKey);
            }

            // 4. 确认用户有权限操作指定的个人最佳集合。
            operateHandlerValidator.makeSureUserModifyPermittedForPbSet(userKey, setKey);

            // 5. 确认个人最佳节点与父个人最佳节点的个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetIdenticalForPbSet(parentKey, setKey);

            // 6. 根据 pbNodeCreateInfo 以及创建的规则组合 个人最佳节点 实体。
            PbNode pbNode = new PbNode(
                    null, parentKey, setKey, pbNodeCreateInfo.getName(), pbNodeCreateInfo.getRemark()
            );

            // 7. 插入个人最佳节点，并返回个人最佳节点实体的主键。
            return pbNodeMaintainService.insert(pbNode);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updatePbNode(StringIdKey userKey, PbNodeUpdateInfo pbNodeUpdateInfo) throws HandlerException {
        try {
            LongIdKey pbNodeKey = pbNodeUpdateInfo.getNodeKey();
            LongIdKey parentKey = pbNodeUpdateInfo.getParentKey();

            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳节点存在。
            operateHandlerValidator.makeSurePbNodeExists(pbNodeKey);

            // 3. 确认父个人最佳节点存在。
            if (Objects.nonNull(parentKey)) {
                operateHandlerValidator.makeSurePbNodeExists(parentKey);
            }

            // 4. 确认用户有权限操作指定的个人最佳节点。
            operateHandlerValidator.makeSureUserModifyPermittedForPbNode(userKey, pbNodeKey);

            // 5. 确认个人最佳节点与父个人最佳节点的个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetIdenticalForPbNode(parentKey, pbNodeKey);

            // 6. 根据 pbNodeUpdateInfo 以及更新的规则设置 个人最佳节点 实体。
            PbNode pbNode = pbNodeMaintainService.get(pbNodeKey);
            pbNode.setParentKey(parentKey);
            pbNode.setName(pbNodeUpdateInfo.getName());
            pbNode.setRemark(pbNodeUpdateInfo.getRemark());

            // 7. 更新 个人最佳节点 实体。
            pbNodeMaintainService.update(pbNode);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePbNode(StringIdKey userKey, LongIdKey pbNodeKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳节点存在。
            operateHandlerValidator.makeSurePbNodeExists(pbNodeKey);

            // 3. 确认用户有权限操作指定的银行卡。
            operateHandlerValidator.makeSureUserModifyPermittedForPbNode(userKey, pbNodeKey);

            // 4. 存在删除指定的个人最佳节点。
            pbNodeMaintainService.deleteIfExists(pbNodeKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
