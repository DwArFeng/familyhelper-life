package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动数据集合权限数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoadDao extends BatchBaseDao<PoadKey, Poad>, EntireLookupDao<Poad>, PresetLookupDao<Poad> {
}
