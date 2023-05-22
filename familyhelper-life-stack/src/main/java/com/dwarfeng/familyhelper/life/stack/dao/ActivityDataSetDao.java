package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动数据集合数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataSetDao extends BatchBaseDao<LongIdKey, ActivityDataSet>, EntireLookupDao<ActivityDataSet>,
        PresetLookupDao<ActivityDataSet> {
}
