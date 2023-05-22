package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板参与者维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateParticipantMaintainService extends
        BatchCrudService<ActivityTemplateParticipantKey, ActivityTemplateParticipant>,
        EntireLookupService<ActivityTemplateParticipant>, PresetLookupService<ActivityTemplateParticipant> {

    String CHILD_FOR_ACTIVITY_TEMPLATE = "child_for_activity_template";
    String CHILD_FOR_USER = "child_for_user";
}
