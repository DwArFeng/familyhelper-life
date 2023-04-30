package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人最佳节点维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbNodeMaintainService extends BatchCrudService<LongIdKey, PbNode>,
        EntireLookupService<PbNode>, PresetLookupService<PbNode> {

    String CHILD_FOR_PARENT = "child_for_parent";
    String CHILD_FOR_SET = "child_for_set";
    String CHILD_FOR_SET_ROOT = "child_for_set_root";
    String NAME_LIKE = "name_like";
    String CHILD_FOR_SET_NAME_LIKE = "child_for_set_name_like";
}
