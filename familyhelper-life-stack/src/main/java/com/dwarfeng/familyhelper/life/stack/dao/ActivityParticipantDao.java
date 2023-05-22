package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动参与者数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityParticipantDao extends BatchBaseDao<ActivityParticipantKey, ActivityParticipant>,
        EntireLookupDao<ActivityParticipant>, PresetLookupDao<ActivityParticipant> {
}
