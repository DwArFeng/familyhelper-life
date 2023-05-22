package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动参与者维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityParticipantMaintainService extends
        BatchCrudService<ActivityParticipantKey, ActivityParticipant>, EntireLookupService<ActivityParticipant>,
        PresetLookupService<ActivityParticipant> {

    String CHILD_FOR_ACTIVITY = "child_for_activity";
    String CHILD_FOR_USER = "child_for_user";
}
