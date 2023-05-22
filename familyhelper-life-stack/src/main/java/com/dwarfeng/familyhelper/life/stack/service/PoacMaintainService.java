package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poac;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动权限维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoacMaintainService extends BatchCrudService<PoacKey, Poac>, EntireLookupService<Poac>,
        PresetLookupService<Poac> {

    String CHILD_FOR_ACTIVITY = "child_for_activity";
    String CHILD_FOR_USER = "child_for_user";
    String CHILD_FOR_ACTIVITY_PERMISSION_LEVEL_EQUALS = "child_for_activity_permission_level_equals";
    String CHILD_FOR_USER_PERMISSION_LEVEL_EQUALS = "child_for_user_permission_level_equals";
}
