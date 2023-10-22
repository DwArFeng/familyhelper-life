package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动模板参与者已经存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateParticipantExistsException extends HandlerException {

    private static final long serialVersionUID = 4007857129110539294L;

    private final ActivityTemplateParticipantKey activityTemplateParticipantKey;

    public ActivityTemplateParticipantExistsException(ActivityTemplateParticipantKey activityTemplateParticipantKey) {
        this.activityTemplateParticipantKey = activityTemplateParticipantKey;
    }

    public ActivityTemplateParticipantExistsException(
            Throwable cause, ActivityTemplateParticipantKey activityTemplateParticipantKey
    ) {
        super(cause);
        this.activityTemplateParticipantKey = activityTemplateParticipantKey;
    }

    @Override
    public String getMessage() {
        return "活动模板参与者已经存在: " + activityTemplateParticipantKey;
    }
}
