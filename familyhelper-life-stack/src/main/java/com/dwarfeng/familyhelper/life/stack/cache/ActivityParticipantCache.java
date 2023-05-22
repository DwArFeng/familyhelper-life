package com.dwarfeng.familyhelper.life.stack.cache;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 活动参与者缓存。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityParticipantCache extends BatchBaseCache<ActivityParticipantKey, ActivityParticipant> {
}
