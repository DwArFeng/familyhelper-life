package com.dwarfeng.familyhelper.life.stack.service;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCover;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCoverOrderUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCoverUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 活动封面操作服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityCoverOperateService extends Service {

    /**
     * 下载活动封面。
     *
     * @param userKey  执行用户主键。
     * @param coverKey 活动封面主键。
     * @return 活动封面。
     * @throws ServiceException 服务异常。
     */
    ActivityCover download(StringIdKey userKey, LongIdKey coverKey) throws ServiceException;

    /**
     * 上传活动封面。
     *
     * @param userKey         执行用户主键。
     * @param coverUploadInfo 活动封面上传信息。
     * @throws ServiceException 服务异常。
     */
    void upload(StringIdKey userKey, ActivityCoverUploadInfo coverUploadInfo) throws ServiceException;

    /**
     * 删除活动封面。
     *
     * @param userKey  执行用户主键。
     * @param coverKey 活动封面主键。
     * @throws ServiceException 服务异常。
     */
    void remove(StringIdKey userKey, LongIdKey coverKey) throws ServiceException;

    /**
     * 更新活动封面的顺序。
     *
     * @param userKey         执行用户主键。
     * @param coverUpdateInfo 活动封面顺序更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateOrder(StringIdKey userKey, ActivityCoverOrderUpdateInfo coverUpdateInfo) throws ServiceException;
}
