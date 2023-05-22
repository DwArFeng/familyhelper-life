package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动数据集合权限缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface PoadCache extends BatchBaseCache<PoadKey, Poad> {
}
