package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityDataRecordUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 活动数据记录操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ActivityDataRecordOperateHandler extends Handler {

    /**
     * 创建活动数据记录。
     *
     * @param userKey    执行用户主键。
     * @param createInfo 活动数据记录创建信息。
     * @return 生成的活动数据记录的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey create(StringIdKey userKey, ActivityDataRecordCreateInfo createInfo) throws HandlerException;

    /**
     * 更新活动数据记录。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 活动数据记录更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(StringIdKey userKey, ActivityDataRecordUpdateInfo updateInfo) throws HandlerException;

    /**
     * 删除活动数据记录。
     *
     * @param userKey 执行用户主键。
     * @param key     活动数据记录主键。
     * @throws HandlerException 处理器异常。
     */
    void remove(StringIdKey userKey, LongIdKey key) throws HandlerException;
}
