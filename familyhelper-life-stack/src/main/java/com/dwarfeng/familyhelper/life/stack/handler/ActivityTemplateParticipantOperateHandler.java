package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动模板参与者操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityTemplateParticipantOperateHandler extends Handler {

    /**
     * 创建活动模板参与者。
     *
     * @param userKey    操作者的主键。
     * @param createInfo 创建信息。
     * @return 生成的活动模板参与者的主键。
     * @throws HandlerException 处理器异常。
     */
    ActivityTemplateParticipantKey create(StringIdKey userKey, ActivityTemplateParticipantCreateInfo createInfo)
            throws HandlerException;

    /**
     * 更新活动模板参与者。
     *
     * @param userKey    操作者的主键。
     * @param updateInfo 更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(StringIdKey userKey, ActivityTemplateParticipantUpdateInfo updateInfo) throws HandlerException;

    /**
     * 删除活动模板参与者。
     *
     * @param userKey    操作者的主键。
     * @param removeInfo 删除信息。
     * @throws HandlerException 处理器异常。
     */
    void remove(StringIdKey userKey, ActivityTemplateParticipantRemoveInfo removeInfo) throws HandlerException;
}
