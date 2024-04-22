package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.struct.ActivityTemplateDriveInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动模板驱动 QOS 服务。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ActivityTemplateDriveQosService extends Service {

    /**
     * 活动模板驱动服务是否上线。
     *
     * @return 是否上线。
     * @throws ServiceException 服务异常。
     */
    boolean isOnline() throws ServiceException;

    /**
     * 上线活动模板驱动服务。
     *
     * @throws ServiceException 服务异常。
     */
    void online() throws ServiceException;

    /**
     * 下线活动模板驱动服务。
     *
     * @throws ServiceException 服务异常。
     */
    void offline() throws ServiceException;

    /**
     * 活动模板驱动服务是否正在持有锁。
     *
     * @return 活动模板驱动服务是否正在持有锁。
     * @throws ServiceException 服务异常。
     */
    boolean isLockHolding() throws ServiceException;

    /**
     * 活动模板驱动服务是否启动。
     *
     * @return 活动模板驱动服务是否启动。
     * @throws ServiceException 服务异常。
     */
    boolean isStarted() throws ServiceException;

    /**
     * 活动模板驱动服务启动。
     *
     * @throws ServiceException 服务异常。
     */
    void start() throws ServiceException;

    /**
     * 活动模板驱动服务停止。
     *
     * @throws ServiceException 服务异常。
     */
    void stop() throws ServiceException;

    /**
     * 活动模板驱动服务是否正在工作。
     *
     * @return 活动模板驱动服务是否正在工作。
     * @throws ServiceException 服务异常。
     */
    boolean isWorking() throws ServiceException;

    /**
     * 获取指定活动模板的活动模板驱动信息。
     *
     * @param activityTemplateKey 指定活动模板的主键。
     * @return 指定活动模板的活动模板驱动信息。
     * @throws ServiceException 服务异常。
     */
    ActivityTemplateDriveInfo getActivityTemplateDriveInfo(LongIdKey activityTemplateKey) throws ServiceException;

    /**
     * 清除本地缓存。
     *
     * @throws ServiceException 服务异常。
     */
    void clearLocalCache() throws ServiceException;
}
