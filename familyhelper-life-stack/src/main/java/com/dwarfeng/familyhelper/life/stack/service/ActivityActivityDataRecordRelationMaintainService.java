package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动活动数据记录关联维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityActivityDataRecordRelationMaintainService extends
        BatchCrudService<LongLongRelationKey, ActivityActivityDataRecordRelation>,
        EntireLookupService<ActivityActivityDataRecordRelation>,
        PresetLookupService<ActivityActivityDataRecordRelation> {

    String CHILD_FOR_ACTIVITY = "child_for_activity";
    String CHILD_FOR_ACTIVITY_DATA_RECORD = "child_for_activity_data_record";
    String CHILD_FOR_ACTIVITY_DATA_RECORD_RECORDED_DATE_ASC = "child_for_activity_data_record_recorded_date_asc";
    String CHILD_FOR_ACTIVITY_DATA_RECORD_RECORDED_DATE_DESC = "child_for_activity_data_record_recorded_date_desc";
}
