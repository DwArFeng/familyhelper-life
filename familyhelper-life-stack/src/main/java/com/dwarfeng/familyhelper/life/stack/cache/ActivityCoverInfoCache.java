package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityCoverInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动封面信息缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityCoverInfoCache extends BatchBaseCache<LongIdKey, ActivityCoverInfo> {
}
