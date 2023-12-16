package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动模板数据信息操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateDataInfoOperateService extends Service {

    /**
     * 创建活动模板数据信息。
     *
     * @param userKey    执行用户主键。
     * @param createInfo 活动模板数据信息创建信息。
     * @return 生成的活动模板数据信息的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey create(StringIdKey userKey, ActivityTemplateDataInfoCreateInfo createInfo) throws ServiceException;

    /**
     * 更新活动模板数据信息。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 活动模板数据信息更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(StringIdKey userKey, ActivityTemplateDataInfoUpdateInfo updateInfo) throws ServiceException;

    /**
     * 删除活动模板数据信息。
     *
     * @param userKey 执行用户主键。
     * @param key     活动模板数据信息主键。
     * @throws ServiceException 服务异常。
     */
    void remove(StringIdKey userKey, LongIdKey key) throws ServiceException;
}
