package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动数据集合权限维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoadMaintainService extends BatchCrudService<PoadKey, Poad>, EntireLookupService<Poad>,
        PresetLookupService<Poad> {

    String CHILD_FOR_ACTIVITY_DATA_SET = "child_for_activity_data_set";
    String CHILD_FOR_USER = "child_for_user";
    String CHILD_FOR_ACTIVITY_DATA_SET_PERMISSION_LEVEL_EQUALS = "child_for_activity_data_set_permission_level_equals";
    String CHILD_FOR_USER_PERMISSION_LEVEL_EQUALS = "child_for_user_permission_level_equals";
}
