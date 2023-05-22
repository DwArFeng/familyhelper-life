package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateActivityDataItemRelation;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动模板活动数据条目关联缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateActivityDataItemRelationCache extends
        BatchBaseCache<LongLongRelationKey, ActivityTemplateActivityDataItemRelation> {
}
