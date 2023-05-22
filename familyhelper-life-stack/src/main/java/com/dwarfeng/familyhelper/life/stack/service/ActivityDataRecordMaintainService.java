package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动数据记录维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataRecordMaintainService extends BatchCrudService<LongIdKey, ActivityDataRecord>,
        EntireLookupService<ActivityDataRecord>, PresetLookupService<ActivityDataRecord> {

    String CHILD_FOR_ITEM = "child_for_item";
    String CHILD_FOR_ITEM_RECORDED_DATE_ASC = "child_for_item_recorded_date_asc";
    String CHILD_FOR_ITEM_RECORDED_DATE_DESC = "child_for_item_recorded_date_desc";
}
