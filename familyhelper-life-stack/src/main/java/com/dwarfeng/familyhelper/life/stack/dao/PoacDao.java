package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poac;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动权限数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoacDao extends BatchBaseDao<PoacKey, Poac>, EntireLookupDao<Poac>, PresetLookupDao<Poac> {
}
