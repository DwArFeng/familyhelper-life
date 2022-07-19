package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.familyhelper.life.stack.handler.PbRecordOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbRecordMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbSetMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PbRecordOperateHandlerImpl implements PbRecordOperateHandler {

    private final PbRecordMaintainService pbRecordMaintainService;
    private final PbItemMaintainService pbItemMaintainService;
    private final PbSetMaintainService pbSetMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public PbRecordOperateHandlerImpl(
            PbRecordMaintainService pbRecordMaintainService,
            PbItemMaintainService pbItemMaintainService,
            PbSetMaintainService pbSetMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.pbRecordMaintainService = pbRecordMaintainService;
        this.pbItemMaintainService = pbItemMaintainService;
        this.pbSetMaintainService = pbSetMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public LongIdKey createPbRecord(StringIdKey userKey, PbRecordCreateInfo pbRecordCreateInfo)
            throws HandlerException {
        try {
            LongIdKey itemKey = pbRecordCreateInfo.getItemKey();

            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbItemExists(itemKey);
            PbItem pbItem = pbItemMaintainService.get(itemKey);
            LongIdKey setKey = pbItem.getSetKey();

            // 确认个人最佳集合存在。
            operateHandlerValidator.makeSurePbSetExists(setKey);

            // 确认用户有权限操作指定的个人最佳项目。
            operateHandlerValidator.makeSureUserModifyPermittedForPbItem(userKey, itemKey);

            // 根据 pbRecordCreateInfo 以及创建的规则组合 个人最佳项目 实体。
            Date currentDate = new Date();
            PbRecord pbRecord = new PbRecord(
                    null, itemKey, pbRecordCreateInfo.getValue(), currentDate, pbRecordCreateInfo.getRemark()
            );

            // 插入个人最佳项目，并返回个人最佳项目实体的主键。
            LongIdKey pbRecordKey = pbRecordMaintainService.insert(pbRecord);

            // 更新个人最佳集合的最近记录日期。
            PbSet pbSet = pbSetMaintainService.get(setKey);
            pbSet.setLastRecordedDate(currentDate);
            pbSetMaintainService.update(pbSet);

            // 返回主键。
            return pbRecordKey;
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

            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbRecordExists(pbRecordKey);
            PbRecord record = pbRecordMaintainService.get(pbRecordKey);
            LongIdKey itemKey = record.getItemKey();

            // 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbItemExists(itemKey);


            // 确认用户有权限操作指定的个人最佳项目。
            operateHandlerValidator.makeSureUserModifyPermittedForPbRecord(userKey, pbRecordKey);

            // 根据 pbRecordUpdateInfo 以及更新的规则设置 个人最佳项目 实体。
            PbRecord pbRecord = pbRecordMaintainService.get(pbRecordKey);
            pbRecord.setValue(pbRecordUpdateInfo.getValue());
            pbRecord.setRemark(pbRecordUpdateInfo.getRemark());

            // 更新 个人最佳项目 实体。
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
            // 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认个人最佳项目存在。
            operateHandlerValidator.makeSurePbRecordExists(pbRecordKey);

            // 确认用户有权限操作指定的银行卡。
            operateHandlerValidator.makeSureUserModifyPermittedForPbRecord(userKey, pbRecordKey);

            // 存在删除指定的个人最佳项目。
            pbRecordMaintainService.deleteIfExists(pbRecordKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
