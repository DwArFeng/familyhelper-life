package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人最佳集合维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbSetMaintainService extends BatchCrudService<LongIdKey, PbSet>,
        EntireLookupService<PbSet>, PresetLookupService<PbSet> {

    String NAME_LIKE = "name_like";
}
