package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动数据项目操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataItemOperateService extends Service {

    /**
     * 创建活动数据项目。
     *
     * @param userKey                    活动数据项目的所有者的主键。
     * @param activityDataItemCreateInfo 活动数据项目的创建信息。
     * @return 生成的活动数据项目的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createActivityDataItem(StringIdKey userKey, ActivityDataItemCreateInfo activityDataItemCreateInfo)
            throws ServiceException;

    /**
     * 更新活动数据项目。
     *
     * @param userKey                    活动数据项目的所有者的主键。
     * @param activityDataItemUpdateInfo 活动数据项目的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateActivityDataItem(StringIdKey userKey, ActivityDataItemUpdateInfo activityDataItemUpdateInfo)
            throws ServiceException;

    /**
     * 删除活动数据项目。
     *
     * @param userKey             活动数据项目的所有者的主键。
     * @param activityDataItemKey 活动数据项目的主键。
     * @throws ServiceException 服务异常。
     */
    void removeActivityDataItem(StringIdKey userKey, LongIdKey activityDataItemKey) throws ServiceException;
}
