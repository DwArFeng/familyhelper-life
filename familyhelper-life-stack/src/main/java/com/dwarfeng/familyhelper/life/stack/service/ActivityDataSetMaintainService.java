package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动数据集合维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataSetMaintainService extends
        BatchCrudService<LongIdKey, ActivityDataSet>, EntireLookupService<ActivityDataSet>,
        PresetLookupService<ActivityDataSet> {

    String NAME_LIKE = "name_like";
}
