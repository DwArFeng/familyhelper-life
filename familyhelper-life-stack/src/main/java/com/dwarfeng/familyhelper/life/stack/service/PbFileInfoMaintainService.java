package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人最佳文件信息维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbFileInfoMaintainService extends BatchCrudService<LongIdKey, PbFileInfo>,
        EntireLookupService<PbFileInfo>, PresetLookupService<PbFileInfo> {

    String CHILD_FOR_RECORD = "child_for_record";
    String CHILD_FOR_RECORD_ORIGIN_NAME_ASC = "child_for_record_origin_name_asc";
    String CHILD_FOR_RECORD_ORIGIN_NAME_DESC = "child_for_record_origin_name_desc";
    String CHILD_FOR_RECORD_UPLOADED_DATE_ASC = "child_for_record_uploaded_date_asc";
    String CHILD_FOR_RECORD_UPLOADED_DATE_DESC = "child_for_record_uploaded_date_desc";
    String CHILD_FOR_RECORD_INSPECTED_DATE_ASC = "child_for_record_inspected_date_asc";
    String CHILD_FOR_RECORD_INSPECTED_DATE_DESC = "child_for_record_inspected_date_desc";
}
