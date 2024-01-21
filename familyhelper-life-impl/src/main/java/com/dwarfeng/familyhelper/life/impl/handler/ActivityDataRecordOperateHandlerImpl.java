package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityDataRecordOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataRecordMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.KeyFetcher;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class ActivityDataRecordOperateHandlerImpl implements ActivityDataRecordOperateHandler {

    private final ActivityDataRecordMaintainService activityDataRecordMaintainService;

    private final KeyFetcher<LongIdKey> keyFetcher;

    private final HandlerValidator handlerValidator;

    public ActivityDataRecordOperateHandlerImpl(
            ActivityDataRecordMaintainService activityDataRecordMaintainService,
            KeyFetcher<LongIdKey> keyFetcher,
            HandlerValidator handlerValidator
    ) {
        this.activityDataRecordMaintainService = activityDataRecordMaintainService;
        this.keyFetcher = keyFetcher;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey create(StringIdKey userKey, ActivityDataRecordCreateInfo createInfo) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey itemKey = createInfo.getItemKey();
            LongIdKey activityKey = createInfo.getActivityKey();
            BigDecimal value = createInfo.getValue();
            String remark = createInfo.getRemark();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据项目存在。
            handlerValidator.makeSureActivityDataItemExists(itemKey);

            // 确认活动存在。
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 生成活动数据记录主键。
            LongIdKey key = keyFetcher.fetchKey();

            // 创建活动数据记录。
            Date currentDate = new Date();
            ActivityDataRecord activityDataRecord = new ActivityDataRecord(
                    key, itemKey, activityKey, value, currentDate, remark
            );

            // 调用维护服务插入活动数据记录实体。
            activityDataRecordMaintainService.insert(activityDataRecord);

            // 返回活动数据记录主键。
            return key;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityDataRecordUpdateInfo updateInfo) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey key = updateInfo.getKey();
            BigDecimal value = updateInfo.getValue();
            String remark = updateInfo.getRemark();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据记录存在。
            handlerValidator.makeSureActivityDataRecordExists(key);

            // 确认用户对活动有修改权限。
            ActivityDataRecord activityDataRecord = activityDataRecordMaintainService.get(key);
            LongIdKey activityKey = activityDataRecord.getActivityKey();
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 更新活动数据记录。
            Date currentDate = new Date();
            activityDataRecord.setValue(value);
            activityDataRecord.setRecordedDate(currentDate);
            activityDataRecord.setRemark(remark);

            // 调用维护服务更新活动数据记录实体。
            activityDataRecordMaintainService.update(activityDataRecord);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey key) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动数据记录存在。
            handlerValidator.makeSureActivityDataRecordExists(key);

            // 确认用户对活动有修改权限。
            ActivityDataRecord activityDataRecord = activityDataRecordMaintainService.get(key);
            LongIdKey activityKey = activityDataRecord.getActivityKey();
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 调用维护服务删除活动数据记录实体。
            activityDataRecordMaintainService.delete(key);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
