package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动活动数据记录关联缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityActivityDataRecordRelationCache extends
        BatchBaseCache<LongLongRelationKey, ActivityActivityDataRecordRelation> {
}
