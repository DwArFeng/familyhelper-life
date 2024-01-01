package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUploadInfo;
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
     * 上传活动文件。
     *
     * @param userKey                执行用户主键。
     * @param activityFileUploadInfo 活动文件上传信息。
     * @throws HandlerException 处理器异常。
     */
    void uploadActivityFile(StringIdKey userKey, ActivityFileUploadInfo activityFileUploadInfo)
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
     * 删除活动文件。
     *
     * @param userKey         执行用户主键。
     * @param activityFileKey 活动文件主键。
     * @throws HandlerException 处理器异常。
     */
    void removeActivityFile(StringIdKey userKey, LongIdKey activityFileKey) throws HandlerException;
}
