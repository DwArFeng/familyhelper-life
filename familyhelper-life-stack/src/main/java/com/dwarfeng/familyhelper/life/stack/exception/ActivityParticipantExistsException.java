package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 活动参与者已经存在异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityParticipantExistsException extends HandlerException {

    private static final long serialVersionUID = 6848978628898610526L;

    private final ActivityParticipantKey activityParticipantKey;

    public ActivityParticipantExistsException(ActivityParticipantKey activityParticipantKey) {
        this.activityParticipantKey = activityParticipantKey;
    }

    public ActivityParticipantExistsException(
            Throwable cause, ActivityParticipantKey activityParticipantKey
    ) {
        super(cause);
        this.activityParticipantKey = activityParticipantKey;
    }

    @Override
    public String getMessage() {
        return "活动参与者已经存在: " + activityParticipantKey;
    }
}
