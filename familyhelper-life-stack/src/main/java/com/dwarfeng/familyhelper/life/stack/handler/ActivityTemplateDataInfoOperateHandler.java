package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateDataInfoUpdateInfo;
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
public interface ActivityTemplateDataInfoOperateHandler extends Handler {

    /**
     * 创建活动模板数据信息。
     *
     * @param userKey    执行用户主键。
     * @param createInfo 活动模板数据信息创建信息。
     * @return 生成的活动模板数据信息的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey create(StringIdKey userKey, ActivityTemplateDataInfoCreateInfo createInfo) throws HandlerException;

    /**
     * 更新活动模板数据信息。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 活动模板数据信息更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(StringIdKey userKey, ActivityTemplateDataInfoUpdateInfo updateInfo) throws HandlerException;

    /**
     * 删除活动模板数据信息。
     *
     * @param userKey 执行用户主键。
     * @param key     活动模板数据信息主键。
     * @throws HandlerException 处理器异常。
     */
    void remove(StringIdKey userKey, LongIdKey key) throws HandlerException;
}
