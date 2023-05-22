package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityCoverInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动封面信息维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityCoverInfoMaintainService extends BatchCrudService<LongIdKey, ActivityCoverInfo>,
        EntireLookupService<ActivityCoverInfo>, PresetLookupService<ActivityCoverInfo> {

    String CHILD_FOR_ACTIVITY = "child_for_activity";
    String CHILD_FOR_ACTIVITY_INDEX_ASC = "child_for_activity_index_asc";
    String CHILD_FOR_ACTIVITY_INDEX_DESC = "child_for_activity_index_desc";
}
