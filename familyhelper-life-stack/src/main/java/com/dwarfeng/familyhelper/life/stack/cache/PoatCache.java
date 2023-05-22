package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poat;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动模板权限缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoatCache extends BatchBaseCache<PoatKey, Poat> {
}
