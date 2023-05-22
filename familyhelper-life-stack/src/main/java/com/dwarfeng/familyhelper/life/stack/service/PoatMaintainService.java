package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poat;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板权限维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoatMaintainService extends BatchCrudService<PoatKey, Poat>, EntireLookupService<Poat>,
        PresetLookupService<Poat> {

    String CHILD_FOR_ACTIVITY_TEMPLATE = "child_for_activity_template";
    String CHILD_FOR_USER = "child_for_user";
    String CHILD_FOR_ACTIVITY_TEMPLATE_PERMISSION_LEVEL_EQUALS = "child_for_activity_template_permission_level_equals";
    String CHILD_FOR_USER_PERMISSION_LEVEL_EQUALS = "child_for_user_permission_level_equals";
}
