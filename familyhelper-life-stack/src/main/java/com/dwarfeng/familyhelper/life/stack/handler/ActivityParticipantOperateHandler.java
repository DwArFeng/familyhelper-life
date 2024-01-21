package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantRemoveInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityParticipantUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动参与者操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityParticipantOperateHandler extends Handler {

    /**
     * 创建活动参与者。
     *
     * @param userKey    操作者的主键。
     * @param createInfo 创建信息。
     * @return 生成的活动参与者的主键。
     * @throws HandlerException 处理器异常。
     */
    ActivityParticipantKey create(StringIdKey userKey, ActivityParticipantCreateInfo createInfo)
            throws HandlerException;

    /**
     * 更新活动参与者。
     *
     * @param userKey    操作者的主键。
     * @param updateInfo 更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(StringIdKey userKey, ActivityParticipantUpdateInfo updateInfo) throws HandlerException;

    /**
     * 删除活动参与者。
     *
     * @param userKey    操作者的主键。
     * @param removeInfo 删除信息。
     * @throws HandlerException 处理器异常。
     */
    void remove(StringIdKey userKey, ActivityParticipantRemoveInfo removeInfo) throws HandlerException;
}
