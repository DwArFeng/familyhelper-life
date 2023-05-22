package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityMaintainService extends BatchCrudService<LongIdKey, Activity>, EntireLookupService<Activity>,
        PresetLookupService<Activity> {

    String NAME_LIKE = "name_like";
}
