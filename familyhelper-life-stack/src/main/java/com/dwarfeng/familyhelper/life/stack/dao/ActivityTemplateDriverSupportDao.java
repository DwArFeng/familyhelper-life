package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverSupport;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动模板驱动器支持数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDriverSupportDao extends BatchBaseDao<StringIdKey, ActivityTemplateDriverSupport>,
        EntireLookupDao<ActivityTemplateDriverSupport>, PresetLookupDao<ActivityTemplateDriverSupport> {
}
