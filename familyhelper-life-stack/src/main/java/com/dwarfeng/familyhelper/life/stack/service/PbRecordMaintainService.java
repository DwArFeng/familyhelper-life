package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人最佳记录维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbRecordMaintainService extends BatchCrudService<LongIdKey, PbRecord>,
        EntireLookupService<PbRecord>, PresetLookupService<PbRecord> {

    String CHILD_FOR_ITEM = "child_for_item";
    String CHILD_FOR_ITEM_RECORDED_DATE_ASC = "child_for_item_recorded_date_asc";
    String CHILD_FOR_ITEM_RECORDED_DATE_DESC = "child_for_item_recorded_date_desc";
}
