package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动模板数据信息缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDataInfoCache extends BatchBaseCache<LongIdKey, ActivityTemplateDataInfo> {
}
