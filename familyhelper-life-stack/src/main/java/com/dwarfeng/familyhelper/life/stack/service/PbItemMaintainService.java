package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人最佳项目维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbItemMaintainService extends BatchCrudService<LongIdKey, PbItem>,
        EntireLookupService<PbItem>, PresetLookupService<PbItem> {

    String CHILD_FOR_NODE = "child_for_node";
    String CHILD_FOR_SET = "child_for_set";
    String CHILD_FOR_SET_ROOT = "child_for_set_root";
    String NAME_LIKE = "name_like";
    String CHILD_FOR_SET_NAME_LIKE = "child_for_set_name_like";
}
