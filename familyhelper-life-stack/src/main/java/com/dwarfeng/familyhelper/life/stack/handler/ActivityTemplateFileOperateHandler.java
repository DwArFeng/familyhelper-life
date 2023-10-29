package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动模板文件操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateFileOperateHandler extends Handler {

    /**
     * 下载活动模板文件。
     *
     * @param userKey                 执行用户主键。
     * @param activityTemplateFileKey 活动模板文件主键。
     * @return 活动模板文件。
     * @throws HandlerException 处理器异常。
     */
    ActivityTemplateFile downloadActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey)
            throws HandlerException;

    /**
     * 上传活动模板文件。
     *
     * @param userKey                        执行用户主键。
     * @param activityTemplateFileUploadInfo 活动模板文件上传信息。
     * @throws HandlerException 处理器异常。
     */
    void uploadActivityTemplateFile(StringIdKey userKey, ActivityTemplateFileUploadInfo activityTemplateFileUploadInfo)
            throws HandlerException;

    /**
     * 更新活动模板文件。
     *
     * @param userKey                        执行用户主键。
     * @param activityTemplateFileUpdateInfo 活动模板文件更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateActivityTemplateFile(StringIdKey userKey, ActivityTemplateFileUpdateInfo activityTemplateFileUpdateInfo)
            throws HandlerException;

    /**
     * 删除活动模板文件。
     *
     * @param userKey                 执行用户主键。
     * @param activityTemplateFileKey 活动模板文件主键。
     * @throws HandlerException 处理器异常。
     */
    void removeActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey) throws HandlerException;
}
