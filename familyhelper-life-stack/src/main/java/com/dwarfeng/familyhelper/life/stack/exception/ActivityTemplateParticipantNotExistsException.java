package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板参与者不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateParticipantNotExistsException extends HandlerException {

    private static final long serialVersionUID = -4741888343095978727L;

    private final ActivityTemplateParticipantKey activityTemplateParticipantKey;

    public ActivityTemplateParticipantNotExistsException(
            ActivityTemplateParticipantKey activityTemplateParticipantKey
    ) {
        this.activityTemplateParticipantKey = activityTemplateParticipantKey;
    }

    public ActivityTemplateParticipantNotExistsException(
            Throwable cause, ActivityTemplateParticipantKey activityTemplateParticipantKey
    ) {
        super(cause);
        this.activityTemplateParticipantKey = activityTemplateParticipantKey;
    }

    @Override
    public String getMessage() {
        return "活动模板参与者不存在: " + activityTemplateParticipantKey;
    }
}
