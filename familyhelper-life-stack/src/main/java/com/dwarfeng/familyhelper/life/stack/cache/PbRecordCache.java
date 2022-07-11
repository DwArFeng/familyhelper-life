package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 个人最佳记录缓存。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbRecordCache extends BatchBaseCache<LongIdKey, PbRecord> {
}
