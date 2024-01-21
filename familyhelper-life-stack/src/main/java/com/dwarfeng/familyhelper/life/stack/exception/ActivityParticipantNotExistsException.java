package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动参与者不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityParticipantNotExistsException extends HandlerException {

    private static final long serialVersionUID = -6261550510955998735L;

    private final ActivityParticipantKey activityParticipantKey;

    public ActivityParticipantNotExistsException(
            ActivityParticipantKey activityParticipantKey
    ) {
        this.activityParticipantKey = activityParticipantKey;
    }

    public ActivityParticipantNotExistsException(
            Throwable cause, ActivityParticipantKey activityParticipantKey
    ) {
        super(cause);
        this.activityParticipantKey = activityParticipantKey;
    }

    @Override
    public String getMessage() {
        return "活动参与者不存在: " + activityParticipantKey;
    }
}
