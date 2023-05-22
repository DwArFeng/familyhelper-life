package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板驱动信息维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDriverInfoMaintainService extends
        BatchCrudService<LongIdKey, ActivityTemplateDriverInfo>, EntireLookupService<ActivityTemplateDriverInfo>,
        PresetLookupService<ActivityTemplateDriverInfo> {

    String CHILD_FOR_ACTIVITY_TEMPLATE = "child_for_activity_template";
    String ENABLED = "enabled";
}
