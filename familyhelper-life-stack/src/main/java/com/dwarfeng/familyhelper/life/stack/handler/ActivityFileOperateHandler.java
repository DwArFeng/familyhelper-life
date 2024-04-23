package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动文件操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityFileOperateHandler extends Handler {

    /**
     * 下载活动文件。
     *
     * @param userKey         执行用户主键。
     * @param activityFileKey 活动文件主键。
     * @return 活动文件。
     * @throws HandlerException 处理器异常。
     */
    ActivityFile downloadActivityFile(StringIdKey userKey, LongIdKey activityFileKey) throws HandlerException;

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
     * @throws HandlerException 处理器异常。
     * @since 1.1.1
     */
    ActivityFileStream downloadActivityFileStream(StringIdKey userKey, LongIdKey activityFileKey)
            throws HandlerException;

    /**
     * 上传活动文件。
     *
     * @param userKey                执行用户主键。
     * @param activityFileUploadInfo 活动文件上传信息。
     * @throws HandlerException 处理器异常。
     */
    void uploadActivityFile(StringIdKey userKey, ActivityFileUploadInfo activityFileUploadInfo)
            throws HandlerException;

    /**
     * 上传活动文件流。
     *
     * <p>
     * 调用者有义务关闭 <code>ActivityFileStreamUploadInfo</code> 中的输入流，
     * 即其中的 <code>ActivityFileStreamUploadInfo.content</code>。
     *
     * @param userKey                      执行用户主键。
     * @param activityFileStreamUploadInfo 活动文件流上传信息。
     * @throws HandlerException 处理器异常。
     * @since 1.1.1
     */
    void uploadActivityFileStream(StringIdKey userKey, ActivityFileStreamUploadInfo activityFileStreamUploadInfo)
            throws HandlerException;

    /**
     * 更新活动文件。
     *
     * @param userKey                执行用户主键。
     * @param activityFileUpdateInfo 活动文件更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateActivityFile(StringIdKey userKey, ActivityFileUpdateInfo activityFileUpdateInfo)
            throws HandlerException;

    /**
     * 更新活动文件流。
     *
     * <p>
     * 调用者有责任关闭 <code>ActivityFileStreamUpdateInfo</code> 中的输入流，
     * 即其中的 <code>ActivityFileStreamUpdateInfo.content</code>。
     *
     * @param userKey                      执行用户主键。
     * @param activityFileStreamUpdateInfo 活动文件流更新信息。
     * @throws HandlerException 处理器异常。
     * @since 1.1.1
     */
    void updateActivityFileStream(StringIdKey userKey, ActivityFileStreamUpdateInfo activityFileStreamUpdateInfo)
            throws HandlerException;

    /**
     * 删除活动文件。
     *
     * @param userKey         执行用户主键。
     * @param activityFileKey 活动文件主键。
     * @throws HandlerException 处理器异常。
     */
    void removeActivityFile(StringIdKey userKey, LongIdKey activityFileKey) throws HandlerException;
}
