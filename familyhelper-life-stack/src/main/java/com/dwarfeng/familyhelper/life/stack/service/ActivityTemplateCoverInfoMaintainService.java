package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateCoverInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板封面信息维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateCoverInfoMaintainService extends
        BatchCrudService<LongIdKey, ActivityTemplateCoverInfo>, EntireLookupService<ActivityTemplateCoverInfo>,
        PresetLookupService<ActivityTemplateCoverInfo> {

    String CHILD_FOR_ACTIVITY_TEMPLATE = "child_for_activity_template";
    String CHILD_FOR_ACTIVITY_TEMPLATE_INDEX_ASC = "child_for_activity_template_index_asc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_INDEX_DESC = "child_for_activity_template_index_desc";
}
