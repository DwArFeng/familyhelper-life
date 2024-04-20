package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateParticipantOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateParticipantMaintainService;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

@Component
public class ActivityTemplateParticipantOperateHandlerImpl implements ActivityTemplateParticipantOperateHandler {

    private final ActivityTemplateParticipantMaintainService activityTemplateParticipantMaintainService;

    private final HandlerValidator handlerValidator;

    public ActivityTemplateParticipantOperateHandlerImpl(
            ActivityTemplateParticipantMaintainService activityTemplateParticipantMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.activityTemplateParticipantMaintainService = activityTemplateParticipantMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public ActivityTemplateParticipantKey create(StringIdKey userKey, ActivityTemplateParticipantCreateInfo createInfo)
            throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityTemplateKey = createInfo.getActivityTemplateKey();
            StringIdKey participantUserKey = createInfo.getUserKey();
            String remark = createInfo.getRemark();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户对活动模板有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 生成活动模板参与者主键。
            ActivityTemplateParticipantKey activityTemplateParticipantKey = new ActivityTemplateParticipantKey(
                    activityTemplateKey.getLongId(), participantUserKey.getStringId()
            );

            // 确认活动模板参与者不存在。
            handlerValidator.makeSureActivityTemplateParticipantNotExists(activityTemplateParticipantKey);

            // 创建活动模板参与者。
            ActivityTemplateParticipant activityTemplateParticipant = new ActivityTemplateParticipant(
                    activityTemplateParticipantKey, remark
            );

            // 调用维护服务插入活动模板参与者实体。
            activityTemplateParticipantMaintainService.insert(activityTemplateParticipant);

            // 返回活动模板参与者主键。
            return activityTemplateParticipantKey;
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityTemplateParticipantUpdateInfo updateInfo) throws HandlerException {
        try {
            // 展开参数。
            ActivityTemplateParticipantKey activityTemplateParticipantKey = updateInfo.getKey();
            String remark = updateInfo.getRemark();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            LongIdKey activityTemplateKey = new LongIdKey(activityTemplateParticipantKey.getActivityTemplateLongId());
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户对活动模板有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 确认活动模板参与者存在。
            handlerValidator.makeSureActivityTemplateParticipantExists(activityTemplateParticipantKey);

            // 创建活动模板参与者。
            ActivityTemplateParticipant activityTemplateParticipant = new ActivityTemplateParticipant(
                    activityTemplateParticipantKey, remark
            );

            // 调用维护服务更新活动模板参与者实体。
            activityTemplateParticipantMaintainService.update(activityTemplateParticipant);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void remove(StringIdKey userKey, ActivityTemplateParticipantRemoveInfo removeInfo) throws HandlerException {
        try {
            // 展开参数。
            ActivityTemplateParticipantKey activityTemplateParticipantKey = removeInfo.getKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            LongIdKey activityTemplateKey = new LongIdKey(activityTemplateParticipantKey.getActivityTemplateLongId());
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户对活动模板有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 确认活动模板参与者存在。
            handlerValidator.makeSureActivityTemplateParticipantExists(activityTemplateParticipantKey);

            // 调用维护服务删除活动模板参与者实体。
            activityTemplateParticipantMaintainService.delete(activityTemplateParticipantKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
