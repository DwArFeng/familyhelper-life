package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动数据条目缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataItemCache extends BatchBaseCache<LongIdKey, ActivityDataItem> {
}
