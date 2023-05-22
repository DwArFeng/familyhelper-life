package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动数据集合缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataSetCache extends BatchBaseCache<LongIdKey, ActivityDataSet> {
}
