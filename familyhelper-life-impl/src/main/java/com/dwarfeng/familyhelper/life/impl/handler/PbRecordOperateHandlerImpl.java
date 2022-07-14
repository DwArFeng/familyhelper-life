package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.familyhelper.life.stack.handler.PbRecordOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbRecordMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PbRecordOperateHandlerImpl implements PbRecordOperateHandler {

    private final PbRecordMaintainService pbRecordMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public PbRecordOperateHandlerImpl(
            PbRecordMaintainService pbRecordMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.pbRecordMaintainService = pbRecordMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public LongIdKey createPbRecord(StringIdKey userKey, PbRecordCreateInfo pbRecordCreateInfo)
            throws HandlerException {
        try {
            LongIdKey itemKey = pbRecordCreateInfo.getItemKey();

            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbItemExists(itemKey);

            // 3. 确认用户有权限操作指定的个人最佳项目。
            operateHandlerValidator.makeSureUserModifyPermittedForPbItem(userKey, itemKey);

            // 4. 根据 pbRecordCreateInfo 以及创建的规则组合 个人最佳项目 实体。
            PbRecord pbRecord = new PbRecord(
                    null, itemKey, pbRecordCreateInfo.getValue(), new Date(), pbRecordCreateInfo.getRemark()
            );

            // 5. 插入个人最佳项目，并返回个人最佳项目实体的主键。
            return pbRecordMaintainService.insert(pbRecord);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updatePbRecord(StringIdKey userKey, PbRecordUpdateInfo pbRecordUpdateInfo) throws HandlerException {
        try {
            LongIdKey pbRecordKey = pbRecordUpdateInfo.getKey();

            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbRecordExists(pbRecordKey);
            PbRecord record = pbRecordMaintainService.get(pbRecordKey);
            LongIdKey itemKey = record.getItemKey();

            // 3. 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbItemExists(itemKey);

            // 4. 确认用户有权限操作指定的个人最佳项目。
            operateHandlerValidator.makeSureUserModifyPermittedForPbRecord(userKey, pbRecordKey);

            // 5. 根据 pbRecordUpdateInfo 以及更新的规则设置 个人最佳项目 实体。
            PbRecord pbRecord = pbRecordMaintainService.get(pbRecordKey);
            pbRecord.setValue(pbRecordUpdateInfo.getValue());
            pbRecord.setRemark(pbRecordUpdateInfo.getRemark());

            // 6. 更新 个人最佳项目 实体。
            pbRecordMaintainService.update(pbRecord);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePbRecord(StringIdKey userKey, LongIdKey pbRecordKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbRecordExists(pbRecordKey);

            // 3. 确认用户有权限操作指定的银行卡。
            operateHandlerValidator.makeSureUserModifyPermittedForPbRecord(userKey, pbRecordKey);

            // 4. 存在删除指定的个人最佳项目。
            pbRecordMaintainService.deleteIfExists(pbRecordKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
