package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板数据信息维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDataInfoMaintainService extends BatchCrudService<LongIdKey, ActivityTemplateDataInfo>,
        EntireLookupService<ActivityTemplateDataInfo>, PresetLookupService<ActivityTemplateDataInfo> {

    String CHILD_FOR_ACTIVITY_TEMPLATE = "child_for_activity_template";
    String CHILD_FOR_ACTIVITY_DATA_ITEM = "child_for_activity_data_item";
}
