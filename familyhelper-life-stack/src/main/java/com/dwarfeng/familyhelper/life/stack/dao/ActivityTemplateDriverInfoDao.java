package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动模板驱动信息数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDriverInfoDao extends BatchBaseDao<LongIdKey, ActivityTemplateDriverInfo>,
        EntireLookupDao<ActivityTemplateDriverInfo>, PresetLookupDao<ActivityTemplateDriverInfo> {
}
