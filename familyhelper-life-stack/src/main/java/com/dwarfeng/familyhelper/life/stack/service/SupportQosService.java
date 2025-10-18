package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 支持 QoS 服务。
 *
 * @author DwArFeng
 * @since 1.2.0
 */
public interface SupportQosService extends Service {

    /**
     * 重置活动模板驱动器。
     *
     * @throws ServiceException 服务异常。
     */
    void resetActivityTemplateDriver() throws ServiceException;
}
