package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 活动模板数据数据信息访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDataInfoDao extends BatchBaseDao<LongIdKey, ActivityTemplateDataInfo>,
        EntireLookupDao<ActivityTemplateDataInfo>, PresetLookupDao<ActivityTemplateDataInfo> {
}
