package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTypeIndicator;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;

/**
 * 活动类型指示器维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTypeIndicatorMaintainService extends BatchCrudService<StringIdKey, ActivityTypeIndicator>,
        EntireLookupService<ActivityTypeIndicator> {
}
