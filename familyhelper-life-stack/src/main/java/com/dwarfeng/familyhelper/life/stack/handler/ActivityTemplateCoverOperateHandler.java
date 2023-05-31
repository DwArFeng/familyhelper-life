package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCover;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCoverOrderUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCoverUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动模板封面操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateCoverOperateHandler extends Handler {

    /**
     * 下载活动模板封面。
     *
     * @param userKey 执行用户主键。
     * @param coverKey 活动模板封面主键。
     * @return 活动模板封面。
     * @throws HandlerException 处理器异常。
     */
    ActivityTemplateCover download(StringIdKey userKey, LongIdKey coverKey) throws HandlerException;

    /**
     * 上传活动模板封面。
     *
     * @param userKey 执行用户主键。
     * @param coverUploadInfo 活动模板封面上传信息。
     * @throws HandlerException 处理器异常。
     */
    void upload(StringIdKey userKey, ActivityTemplateCoverUploadInfo coverUploadInfo) throws HandlerException;

    /**
     * 删除活动模板封面。
     *
     * @param userKey  执行用户主键。
     * @param coverKey 活动模板封面主键。
     * @throws HandlerException 处理器异常。
     */
    void remove(StringIdKey userKey, LongIdKey coverKey) throws HandlerException;

    /**
     * 更新活动模板封面的顺序。
     *
     * @param userKey    执行用户主键。
     * @param coverUpdateInfo 活动模板封面顺序更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateOrder(StringIdKey userKey, ActivityTemplateCoverOrderUpdateInfo coverUpdateInfo) throws HandlerException;
}
