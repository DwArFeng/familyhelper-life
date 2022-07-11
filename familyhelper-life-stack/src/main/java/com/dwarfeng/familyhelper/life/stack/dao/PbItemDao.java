package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 个人最佳项目数据访问层。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbItemDao extends BatchBaseDao<LongIdKey, PbItem>, EntireLookupDao<PbItem>,
        PresetLookupDao<PbItem> {
}
