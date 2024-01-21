package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动数据记录操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataRecordOperateService extends Service {

    /**
     * 创建活动数据记录。
     *
     * @param userKey    执行用户主键。
     * @param createInfo 活动数据记录创建信息。
     * @return 生成的活动数据记录的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey create(StringIdKey userKey, ActivityDataRecordCreateInfo createInfo) throws ServiceException;

    /**
     * 更新活动数据记录。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 活动数据记录更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(StringIdKey userKey, ActivityDataRecordUpdateInfo updateInfo) throws ServiceException;

    /**
     * 删除活动数据记录。
     *
     * @param userKey 执行用户主键。
     * @param key     活动数据记录主键。
     * @throws ServiceException 服务异常。
     */
    void remove(StringIdKey userKey, LongIdKey key) throws ServiceException;
}
