package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 资产目录维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PopbMaintainService extends BatchCrudService<PopbKey, Popb>,
        EntireLookupService<Popb>, PresetLookupService<Popb> {

    String CHILD_FOR_PB_SET = "child_for_pb_set";
    String CHILD_FOR_USER = "child_for_user";
    String CHILD_FOR_PB_SET_PERMISSION_LEVEL_EQUALS = "child_for_pb_set_permission_level_equals";
    String CHILD_FOR_USER_PERMISSION_LEVEL_EQUALS = "child_for_user_permission_level_equals";
}
