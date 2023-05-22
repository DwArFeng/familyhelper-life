package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityCache extends BatchBaseCache<LongIdKey, Activity> {
}
