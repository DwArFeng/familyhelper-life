package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动数据条目数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataItemDao extends BatchBaseDao<LongIdKey, ActivityDataItem>,
        EntireLookupDao<ActivityDataItem>, PresetLookupDao<ActivityDataItem> {
}
