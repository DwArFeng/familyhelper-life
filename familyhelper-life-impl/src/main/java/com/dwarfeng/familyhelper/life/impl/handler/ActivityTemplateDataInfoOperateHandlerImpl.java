package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDataInfoOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDataInfoMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.KeyFetcher;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ActivityTemplateDataInfoOperateHandlerImpl implements ActivityTemplateDataInfoOperateHandler {

    private final ActivityTemplateDataInfoMaintainService activityTemplateDataInfoMaintainService;

    private final KeyFetcher<LongIdKey> keyFetcher;

    private final HandlerValidator handlerValidator;

    public ActivityTemplateDataInfoOperateHandlerImpl(
            ActivityTemplateDataInfoMaintainService activityTemplateDataInfoMaintainService,
            KeyFetcher<LongIdKey> keyFetcher,
            HandlerValidator handlerValidator
    ) {
        this.activityTemplateDataInfoMaintainService = activityTemplateDataInfoMaintainService;
        this.keyFetcher = keyFetcher;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public LongIdKey create(StringIdKey userKey, ActivityTemplateDataInfoCreateInfo createInfo) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityTemplateKey = createInfo.getActivityTemplateKey();
            LongIdKey activityDataItemKey = createInfo.getActivityDataItemKey();
            String remark = createInfo.getRemark();
            BigDecimal initialValue = createInfo.getInitialValue();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(createInfo.getActivityTemplateKey());

            // 确认用户对活动模板有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(
                    userKey, createInfo.getActivityTemplateKey()
            );

            // 生成活动模板数据信息主键。
            LongIdKey key = keyFetcher.fetchKey();

            // 创建活动模板数据信息。
            ActivityTemplateDataInfo activityTemplateDataInfo = new ActivityTemplateDataInfo(
                    key, activityTemplateKey, activityDataItemKey, remark, initialValue
            );

            // 调用维护服务插入活动模板数据信息实体。
            activityTemplateDataInfoMaintainService.insert(activityTemplateDataInfo);

            // 返回活动模板数据信息主键。
            return key;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityTemplateDataInfoUpdateInfo updateInfo) throws HandlerException {
        try {
            // 展开参数。
            LongIdKey key = updateInfo.getKey();
            String remark = updateInfo.getRemark();
            BigDecimal initialValue = updateInfo.getInitialValue();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板数据信息存在。
            handlerValidator.makeSureActivityTemplateDataInfoExists(key);

            // 确认用户对活动模板有修改权限。
            ActivityTemplateDataInfo activityTemplateDataInfo = activityTemplateDataInfoMaintainService.get(key);
            LongIdKey activityTemplateKey = activityTemplateDataInfo.getActivityTemplateKey();
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 更新活动模板数据信息。
            activityTemplateDataInfo.setRemark(remark);
            activityTemplateDataInfo.setInitialValue(initialValue);

            // 调用维护服务更新活动模板数据信息实体。
            activityTemplateDataInfoMaintainService.update(activityTemplateDataInfo);
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

            // 确认活动模板数据信息存在。
            handlerValidator.makeSureActivityTemplateDataInfoExists(key);

            // 确认用户对活动模板有修改权限。
            ActivityTemplateDataInfo activityTemplateDataInfo = activityTemplateDataInfoMaintainService.get(key);
            LongIdKey activityTemplateKey = activityTemplateDataInfo.getActivityTemplateKey();
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 调用维护服务删除活动模板数据信息实体。
            activityTemplateDataInfoMaintainService.delete(key);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
