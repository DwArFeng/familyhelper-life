package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动文件操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityFileOperateService extends Service {

    /**
     * 下载活动文件。
     *
     * @param userKey         执行用户主键。
     * @param activityFileKey 活动文件主键。
     * @return 活动文件。
     * @throws ServiceException 服务异常。
     */
    ActivityFile downloadActivityFile(StringIdKey userKey, LongIdKey activityFileKey) throws ServiceException;

    /**
     * 上传活动文件。
     *
     * @param userKey                执行用户主键。
     * @param activityFileUploadInfo 活动文件上传信息。
     * @throws ServiceException 服务异常。
     */
    void uploadActivityFile(StringIdKey userKey, ActivityFileUploadInfo activityFileUploadInfo)
            throws ServiceException;

    /**
     * 更新活动文件。
     *
     * @param userKey                执行用户主键。
     * @param activityFileUpdateInfo 活动文件更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateActivityFile(StringIdKey userKey, ActivityFileUpdateInfo activityFileUpdateInfo)
            throws ServiceException;

    /**
     * 删除活动文件。
     *
     * @param userKey         执行用户主键。
     * @param activityFileKey 活动文件主键。
     * @throws ServiceException 服务异常。
     */
    void removeActivityFile(StringIdKey userKey, LongIdKey activityFileKey) throws ServiceException;
}
