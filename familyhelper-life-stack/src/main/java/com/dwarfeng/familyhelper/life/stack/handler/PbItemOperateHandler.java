package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbItemUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 个人最佳项目操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbItemOperateHandler extends Handler {

    /**
     * 创建个人最佳项目。
     *
     * @param userKey          个人最佳项目的所有者的主键。
     * @param pbItemCreateInfo 个人最佳项目的创建信息。
     * @return 生成的个人最佳项目的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createPbItem(StringIdKey userKey, PbItemCreateInfo pbItemCreateInfo) throws HandlerException;

    /**
     * 更新个人最佳项目。
     *
     * @param userKey          个人最佳项目的所有者的主键。
     * @param pbItemUpdateInfo 个人最佳项目的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updatePbItem(StringIdKey userKey, PbItemUpdateInfo pbItemUpdateInfo) throws HandlerException;

    /**
     * 删除个人最佳项目。
     *
     * @param userKey   个人最佳项目的所有者的主键。
     * @param pbItemKey 个人最佳项目的主键。
     * @throws HandlerException 处理器异常。
     */
    void removePbItem(StringIdKey userKey, LongIdKey pbItemKey) throws HandlerException;
}
