package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 个人最佳集合缓存。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbSetCache extends BatchBaseCache<LongIdKey, PbSet> {
}
