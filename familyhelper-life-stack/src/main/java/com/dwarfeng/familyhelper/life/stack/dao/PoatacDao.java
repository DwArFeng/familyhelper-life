package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poatac;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatacKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动模板活动权限数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoatacDao extends BatchBaseDao<PoatacKey, Poatac>, EntireLookupDao<Poatac>, PresetLookupDao<Poatac> {
}
