package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateFileInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板文件信息维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateFileInfoMaintainService extends BatchCrudService<LongIdKey, ActivityTemplateFileInfo>,
        EntireLookupService<ActivityTemplateFileInfo>, PresetLookupService<ActivityTemplateFileInfo> {

    String CHILD_FOR_ACTIVITY_TEMPLATE = "child_for_activity_template";
    String CHILD_FOR_ACTIVITY_TEMPLATE_ORIGIN_NAME_ASC = "child_for_activity_template_origin_name_asc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_ORIGIN_NAME_DESC = "child_for_activity_template_origin_name_desc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_CREATED_DATE_ASC = "child_for_activity_template_created_date_asc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_CREATED_DATE_DESC = "child_for_activity_template_created_date_desc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_MODIFIED_DATE_ASC = "child_for_activity_template_modified_date_asc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_MODIFIED_DATE_DESC = "child_for_activity_template_modified_date_desc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_INSPECTED_DATE_ASC = "child_for_activity_template_inspected_date_asc";
    String CHILD_FOR_ACTIVITY_TEMPLATE_INSPECTED_DATE_DESC = "child_for_activity_template_inspected_date_desc";
}
