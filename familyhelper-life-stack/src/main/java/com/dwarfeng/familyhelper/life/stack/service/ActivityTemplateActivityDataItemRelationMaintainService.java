package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateActivityDataItemRelation;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板活动数据条目关联维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateActivityDataItemRelationMaintainService extends
        BatchCrudService<LongLongRelationKey, ActivityTemplateActivityDataItemRelation>,
        EntireLookupService<ActivityTemplateActivityDataItemRelation>,
        PresetLookupService<ActivityTemplateActivityDataItemRelation> {

    String CHILD_FOR_ACTIVITY_TEMPLATE = "child_for_activity_template";
    String CHILD_FOR_ACTIVITY_DATA_ITEM = "child_for_activity_data_item";
}
