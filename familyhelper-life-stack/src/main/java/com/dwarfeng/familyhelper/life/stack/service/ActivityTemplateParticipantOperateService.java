package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动模板参与者操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateParticipantOperateService extends Service {

    /**
     * 创建活动模板参与者。
     *
     * @param userKey    操作者的主键。
     * @param createInfo 创建信息。
     * @return 生成的活动模板参与者的主键。
     * @throws ServiceException 服务异常。
     */
    ActivityTemplateParticipantKey create(StringIdKey userKey, ActivityTemplateParticipantCreateInfo createInfo)
            throws ServiceException;

    /**
     * 更新活动模板参与者。
     *
     * @param userKey    操作者的主键。
     * @param updateInfo 更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(StringIdKey userKey, ActivityTemplateParticipantUpdateInfo updateInfo) throws ServiceException;

    /**
     * 删除活动模板参与者。
     *
     * @param userKey    操作者的主键。
     * @param removeInfo 删除信息。
     * @throws ServiceException 服务异常。
     */
    void remove(StringIdKey userKey, ActivityTemplateParticipantRemoveInfo removeInfo) throws ServiceException;
}
