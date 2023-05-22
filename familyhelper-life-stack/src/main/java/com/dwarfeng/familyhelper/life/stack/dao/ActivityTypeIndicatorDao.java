package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTypeIndicator;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;

/**
 * 活动类型指示器数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTypeIndicatorDao extends BatchBaseDao<StringIdKey, ActivityTypeIndicator>,
        EntireLookupDao<ActivityTypeIndicator> {
}
