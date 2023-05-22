package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateActivityDataItemRelation;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动模板活动数据条目关联数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateActivityDataItemRelationDao extends
        BatchBaseDao<LongLongRelationKey, ActivityTemplateActivityDataItemRelation>,
        EntireLookupDao<ActivityTemplateActivityDataItemRelation>,
        PresetLookupDao<ActivityTemplateActivityDataItemRelation> {
}
