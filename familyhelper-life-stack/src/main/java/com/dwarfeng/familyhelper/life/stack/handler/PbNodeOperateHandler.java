package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbNodeUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 个人最佳节点操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbNodeOperateHandler extends Handler {

    /**
     * 创建个人最佳节点。
     *
     * @param userKey          个人最佳节点的所有者的主键。
     * @param pbNodeCreateInfo 个人最佳节点的创建信息。
     * @return 生成的个人最佳节点的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createPbNode(StringIdKey userKey, PbNodeCreateInfo pbNodeCreateInfo) throws HandlerException;

    /**
     * 更新个人最佳节点。
     *
     * @param userKey          个人最佳节点的所有者的主键。
     * @param pbNodeUpdateInfo 个人最佳节点的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updatePbNode(StringIdKey userKey, PbNodeUpdateInfo pbNodeUpdateInfo) throws HandlerException;

    /**
     * 删除个人最佳节点。
     *
     * @param userKey   个人最佳节点的所有者的主键。
     * @param pbNodeKey 个人最佳节点的主键。
     * @throws HandlerException 处理器异常。
     */
    void removePbNode(StringIdKey userKey, LongIdKey pbNodeKey) throws HandlerException;
}
