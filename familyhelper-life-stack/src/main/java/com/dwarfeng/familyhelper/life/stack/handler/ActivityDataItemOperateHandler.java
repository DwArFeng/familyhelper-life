package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataItemUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动数据项目操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataItemOperateHandler extends Handler {

    /**
     * 创建活动数据项目。
     *
     * @param userKey                    活动数据项目的所有者的主键。
     * @param activityDataItemCreateInfo 活动数据项目的创建信息。
     * @return 生成的活动数据项目的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createActivityDataItem(StringIdKey userKey, ActivityDataItemCreateInfo activityDataItemCreateInfo)
            throws HandlerException;

    /**
     * 更新活动数据项目。
     *
     * @param userKey                    活动数据项目的所有者的主键。
     * @param activityDataItemUpdateInfo 活动数据项目的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateActivityDataItem(StringIdKey userKey, ActivityDataItemUpdateInfo activityDataItemUpdateInfo)
            throws HandlerException;

    /**
     * 删除活动数据项目。
     *
     * @param userKey             活动数据项目的所有者的主键。
     * @param activityDataItemKey 活动数据项目的主键。
     * @throws HandlerException 处理器异常。
     */
    void removeActivityDataItem(StringIdKey userKey, LongIdKey activityDataItemKey) throws HandlerException;
}
