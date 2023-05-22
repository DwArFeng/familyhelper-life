package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动活动数据记录关联数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityActivityDataRecordRelationDao extends BatchBaseDao<LongLongRelationKey,
        ActivityActivityDataRecordRelation>, EntireLookupDao<ActivityActivityDataRecordRelation>,
        PresetLookupDao<ActivityActivityDataRecordRelation> {
}
