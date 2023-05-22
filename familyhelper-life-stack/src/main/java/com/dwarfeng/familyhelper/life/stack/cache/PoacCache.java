package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poac;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动权限缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoacCache extends BatchBaseCache<PoacKey, Poac> {
}
