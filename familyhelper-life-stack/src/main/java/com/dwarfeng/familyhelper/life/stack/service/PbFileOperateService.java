package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFileUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 个人最佳文件操作服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbFileOperateService extends Service {

    /**
     * 下载个人最佳文件。
     *
     * @param userKey   执行用户主键。
     * @param pbFileKey 个人最佳文件主键。
     * @return 个人最佳文件。
     * @throws ServiceException 服务异常。
     */
    PbFile downloadPbFile(StringIdKey userKey, LongIdKey pbFileKey) throws ServiceException;

    /**
     * 上传个人最佳文件。
     *
     * @param userKey          执行用户主键。
     * @param pbFileUploadInfo 个人最佳文件上传信息。
     * @throws ServiceException 服务异常。
     */
    void uploadPbFile(StringIdKey userKey, PbFileUploadInfo pbFileUploadInfo) throws ServiceException;

    /**
     * 删除个人最佳文件。
     *
     * @param userKey   执行用户主键。
     * @param pbFileKey 个人最佳文件主键。
     * @throws ServiceException 服务异常。
     */
    void removePbFile(StringIdKey userKey, LongIdKey pbFileKey) throws ServiceException;
}
