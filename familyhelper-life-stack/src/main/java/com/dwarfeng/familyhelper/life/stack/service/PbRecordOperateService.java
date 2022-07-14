package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 个人最佳记录操作服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbRecordOperateService extends Service {

    /**
     * 创建个人最佳记录。
     *
     * @param userKey            个人最佳记录的所有者的主键。
     * @param pbRecordCreateInfo 个人最佳记录的创建信息。
     * @return 生成的个人最佳记录的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createPbRecord(StringIdKey userKey, PbRecordCreateInfo pbRecordCreateInfo) throws ServiceException;

    /**
     * 更新个人最佳记录。
     *
     * @param userKey            个人最佳记录的所有者的主键。
     * @param pbRecordUpdateInfo 个人最佳记录的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updatePbRecord(StringIdKey userKey, PbRecordUpdateInfo pbRecordUpdateInfo) throws ServiceException;

    /**
     * 删除个人最佳记录。
     *
     * @param userKey     个人最佳记录的所有者的主键。
     * @param pbRecordKey 个人最佳记录的主键。
     * @throws ServiceException 服务异常。
     */
    void removePbRecord(StringIdKey userKey, LongIdKey pbRecordKey) throws ServiceException;
}
