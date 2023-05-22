package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateMaintainService extends
        BatchCrudService<LongIdKey, ActivityTemplate>, EntireLookupService<ActivityTemplate>,
        PresetLookupService<ActivityTemplate> {

    String NAME_LIKE = "name_like";
}
