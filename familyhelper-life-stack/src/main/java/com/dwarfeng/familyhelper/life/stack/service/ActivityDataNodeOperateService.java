package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataNodeCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataNodeUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动数据节点操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataNodeOperateService extends Service {

    /**
     * 创建活动数据节点。
     *
     * @param userKey                    活动数据节点的所有者的主键。
     * @param activityDataNodeCreateInfo 活动数据节点的创建信息。
     * @return 生成的活动数据节点的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createActivityDataNode(StringIdKey userKey, ActivityDataNodeCreateInfo activityDataNodeCreateInfo)
            throws ServiceException;

    /**
     * 更新活动数据节点。
     *
     * @param userKey                    活动数据节点的所有者的主键。
     * @param activityDataNodeUpdateInfo 活动数据节点的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateActivityDataNode(StringIdKey userKey, ActivityDataNodeUpdateInfo activityDataNodeUpdateInfo)
            throws ServiceException;

    /**
     * 删除活动数据节点。
     *
     * @param userKey             活动数据节点的所有者的主键。
     * @param activityDataNodeKey 活动数据节点的主键。
     * @throws ServiceException 服务异常。
     */
    void removeActivityDataNode(StringIdKey userKey, LongIdKey activityDataNodeKey) throws ServiceException;
}
