package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverSupport;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 活动模板驱动器支持维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDriverSupportMaintainService extends
        BatchCrudService<StringIdKey, ActivityTemplateDriverSupport>,
        EntireLookupService<ActivityTemplateDriverSupport>, PresetLookupService<ActivityTemplateDriverSupport> {

    String ID_LIKE = "id_like";
    String LABEL_LIKE = "label_like";

    /**
     * 重置活动模板驱动器支持。
     *
     * @throws ServiceException 服务异常。
     */
    void reset() throws ServiceException;
}
