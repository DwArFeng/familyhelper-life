package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poat;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动模板权限数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoatDao extends BatchBaseDao<PoatKey, Poat>, EntireLookupDao<Poat>, PresetLookupDao<Poat> {
}
