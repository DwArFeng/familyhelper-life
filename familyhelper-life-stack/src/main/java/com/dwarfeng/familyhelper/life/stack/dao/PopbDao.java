package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 个人最佳权限数据访问层。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PopbDao extends BatchBaseDao<PopbKey, Popb>, EntireLookupDao<Popb>,
        PresetLookupDao<Popb> {
}
