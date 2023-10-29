package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动模板文件操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateFileOperateService extends Service {

    /**
     * 下载活动模板文件。
     *
     * @param userKey                 执行用户主键。
     * @param activityTemplateFileKey 活动模板文件主键。
     * @return 活动模板文件。
     * @throws ServiceException 服务异常。
     */
    ActivityTemplateFile downloadActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey)
            throws ServiceException;

    /**
     * 上传活动模板文件。
     *
     * @param userKey                        执行用户主键。
     * @param activityTemplateFileUploadInfo 活动模板文件上传信息。
     * @throws ServiceException 服务异常。
     */
    void uploadActivityTemplateFile(StringIdKey userKey, ActivityTemplateFileUploadInfo activityTemplateFileUploadInfo)
            throws ServiceException;

    /**
     * 更新活动模板文件。
     *
     * @param userKey                        执行用户主键。
     * @param activityTemplateFileUpdateInfo 活动模板文件更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateActivityTemplateFile(StringIdKey userKey, ActivityTemplateFileUpdateInfo activityTemplateFileUpdateInfo)
            throws ServiceException;

    /**
     * 删除活动模板文件。
     *
     * @param userKey                 执行用户主键。
     * @param activityTemplateFileKey 活动模板文件主键。
     * @throws ServiceException 服务异常。
     */
    void removeActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey) throws ServiceException;
}
