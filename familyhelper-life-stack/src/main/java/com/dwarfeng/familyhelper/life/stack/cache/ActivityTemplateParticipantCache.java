package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动模板参与者缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateParticipantCache extends
        BatchBaseCache<ActivityTemplateParticipantKey, ActivityTemplateParticipant> {
}
