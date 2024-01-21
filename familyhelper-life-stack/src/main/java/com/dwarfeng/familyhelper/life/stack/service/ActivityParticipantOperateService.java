package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动参与者操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityParticipantOperateService extends Service {

    /**
     * 创建活动参与者。
     *
     * @param userKey    操作者的主键。
     * @param createInfo 创建信息。
     * @return 生成的活动参与者的主键。
     * @throws ServiceException 服务异常。
     */
    ActivityParticipantKey create(StringIdKey userKey, ActivityParticipantCreateInfo createInfo)
            throws ServiceException;

    /**
     * 更新活动参与者。
     *
     * @param userKey    操作者的主键。
     * @param updateInfo 更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(StringIdKey userKey, ActivityParticipantUpdateInfo updateInfo) throws ServiceException;

    /**
     * 删除活动参与者。
     *
     * @param userKey    操作者的主键。
     * @param removeInfo 删除信息。
     * @throws ServiceException 服务异常。
     */
    void remove(StringIdKey userKey, ActivityParticipantRemoveInfo removeInfo) throws ServiceException;
}
