package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 个人最佳项目操作服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbItemOperateService extends Service {

    /**
     * 创建个人最佳项目。
     *
     * @param userKey          个人最佳项目的所有者的主键。
     * @param pbItemCreateInfo 个人最佳项目的创建信息。
     * @return 生成的个人最佳项目的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createPbItem(StringIdKey userKey, PbItemCreateInfo pbItemCreateInfo) throws ServiceException;

    /**
     * 更新个人最佳项目。
     *
     * @param userKey          个人最佳项目的所有者的主键。
     * @param pbItemUpdateInfo 个人最佳项目的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updatePbItem(StringIdKey userKey, PbItemUpdateInfo pbItemUpdateInfo) throws ServiceException;

    /**
     * 删除个人最佳项目。
     *
     * @param userKey   个人最佳项目的所有者的主键。
     * @param pbItemKey 个人最佳项目的主键。
     * @throws ServiceException 服务异常。
     */
    void removePbItem(StringIdKey userKey, LongIdKey pbItemKey) throws ServiceException;
}
