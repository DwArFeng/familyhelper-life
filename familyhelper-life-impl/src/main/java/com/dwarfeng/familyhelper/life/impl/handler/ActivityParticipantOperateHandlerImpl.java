package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityParticipantOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityParticipantMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

@Component
public class ActivityParticipantOperateHandlerImpl implements ActivityParticipantOperateHandler {

    private final ActivityParticipantMaintainService activityParticipantMaintainService;

    private final HandlerValidator handlerValidator;

    public ActivityParticipantOperateHandlerImpl(
            ActivityParticipantMaintainService activityParticipantMaintainService,
            HandlerValidator handlerValidator
    ) {
        this.activityParticipantMaintainService = activityParticipantMaintainService;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public ActivityParticipantKey create(StringIdKey userKey, ActivityParticipantCreateInfo createInfo)
            throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityKey = createInfo.getActivityKey();
            StringIdKey participantUserKey = createInfo.getUserKey();
            String remark = createInfo.getRemark();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动存在。
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 生成活动参与者主键。
            ActivityParticipantKey activityParticipantKey = new ActivityParticipantKey(
                    activityKey.getLongId(), participantUserKey.getStringId()
            );

            // 确认活动参与者不存在。
            handlerValidator.makeSureActivityParticipantNotExists(activityParticipantKey);

            // 创建活动参与者。
            ActivityParticipant activityParticipant = new ActivityParticipant(
                    activityParticipantKey, remark
            );

            // 调用维护服务插入活动参与者实体。
            activityParticipantMaintainService.insert(activityParticipant);

            // 返回活动参与者主键。
            return activityParticipantKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void update(StringIdKey userKey, ActivityParticipantUpdateInfo updateInfo) throws HandlerException {
        try {
            // 展开参数。
            ActivityParticipantKey activityParticipantKey = updateInfo.getKey();
            String remark = updateInfo.getRemark();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动存在。
            LongIdKey activityKey = new LongIdKey(activityParticipantKey.getActivityLongId());
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动参与者存在。
            handlerValidator.makeSureActivityParticipantExists(activityParticipantKey);

            // 创建活动参与者。
            ActivityParticipant activityParticipant = new ActivityParticipant(
                    activityParticipantKey, remark
            );

            // 调用维护服务更新活动参与者实体。
            activityParticipantMaintainService.update(activityParticipant);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void remove(StringIdKey userKey, ActivityParticipantRemoveInfo removeInfo) throws HandlerException {
        try {
            // 展开参数。
            ActivityParticipantKey activityParticipantKey = removeInfo.getKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动存在。
            LongIdKey activityKey = new LongIdKey(activityParticipantKey.getActivityLongId());
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户对活动有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动参与者存在。
            handlerValidator.makeSureActivityParticipantExists(activityParticipantKey);

            // 调用维护服务删除活动参与者实体。
            activityParticipantMaintainService.delete(activityParticipantKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
