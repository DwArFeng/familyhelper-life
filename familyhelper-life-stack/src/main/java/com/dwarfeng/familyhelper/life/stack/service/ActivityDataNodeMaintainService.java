package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataNode;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动数据节点维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataNodeMaintainService extends BatchCrudService<LongIdKey, ActivityDataNode>,
        EntireLookupService<ActivityDataNode>, PresetLookupService<ActivityDataNode> {

    String CHILD_FOR_PARENT = "child_for_parent";
    String CHILD_FOR_SET = "child_for_set";
    String CHILD_FOR_SET_ROOT = "child_for_set_root";
    String NAME_LIKE = "name_like";
}
