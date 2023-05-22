package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动数据记录缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataRecordCache extends BatchBaseCache<LongIdKey, ActivityDataRecord> {
}
