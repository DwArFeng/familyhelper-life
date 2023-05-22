package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityFileInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动文件信息维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityFileInfoMaintainService extends
        BatchCrudService<LongIdKey, ActivityFileInfo>, EntireLookupService<ActivityFileInfo>,
        PresetLookupService<ActivityFileInfo> {

    String CHILD_FOR_ACTIVITY = "child_for_activity";
    String CHILD_FOR_ACTIVITY_ORIGIN_NAME_ASC = "child_for_activity_origin_name_asc";
    String CHILD_FOR_ACTIVITY_ORIGIN_NAME_DESC = "child_for_activity_origin_name_desc";
    String CHILD_FOR_ACTIVITY_CREATED_DATE_ASC = "child_for_activity_created_date_asc";
    String CHILD_FOR_ACTIVITY_CREATED_DATE_DESC = "child_for_activity_created_date_desc";
    String CHILD_FOR_ACTIVITY_MODIFIED_DATE_ASC = "child_for_activity_modified_date_asc";
    String CHILD_FOR_ACTIVITY_MODIFIED_DATE_DESC = "child_for_activity_modified_date_desc";
    String CHILD_FOR_ACTIVITY_INSPECTED_DATE_ASC = "child_for_activity_inspected_date_asc";
    String CHILD_FOR_ACTIVITY_INSPECTED_DATE_DESC = "child_for_activity_inspected_date_desc";
}
