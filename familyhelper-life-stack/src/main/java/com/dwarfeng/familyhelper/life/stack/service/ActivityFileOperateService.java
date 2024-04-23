package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
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
     * 下载活动文件流。
     *
     * <p>
     * 如果返回的 <code>ActivityFileStream</code> 不为 <code>null</code>，则调用者有义务关闭
     * <code>ActivityFileStream</code> 中的输入流，即其中的 <code>ActivityFileStream.content</code>。
     *
     * @param userKey         执行用户主键。
     * @param activityFileKey 活动文件主键。
     * @return 活动文件流。
     * @throws ServiceException 服务异常。
     * @since 1.1.1
     */
    ActivityFileStream downloadActivityFileStream(StringIdKey userKey, LongIdKey activityFileKey)
            throws ServiceException;

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
     * 上传活动文件流。
     *
     * <p>
     * 调用者有义务关闭 <code>ActivityFileStreamUploadInfo</code> 中的输入流，
     * 即其中的 <code>ActivityFileStreamUploadInfo.content</code>。
     *
     * @param userKey                      执行用户主键。
     * @param activityFileStreamUploadInfo 活动文件流上传信息。
     * @throws ServiceException 服务异常。
     * @since 1.1.1
     */
    void uploadActivityFileStream(StringIdKey userKey, ActivityFileStreamUploadInfo activityFileStreamUploadInfo)
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
     * 更新活动文件流。
     *
     * <p>
     * 调用者有责任关闭 <code>ActivityFileStreamUpdateInfo</code> 中的输入流，
     * 即其中的 <code>ActivityFileStreamUpdateInfo.content</code>。
     *
     * @param userKey                      执行用户主键。
     * @param activityFileStreamUpdateInfo 活动文件流更新信息。
     * @throws ServiceException 服务异常。
     * @since 1.1.1
     */
    void updateActivityFileStream(StringIdKey userKey, ActivityFileStreamUpdateInfo activityFileStreamUpdateInfo)
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
