package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordCreateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbRecordUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 个人最佳记录操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbRecordOperateHandler extends Handler {

    /**
     * 创建个人最佳记录。
     *
     * @param userKey            个人最佳记录的所有者的主键。
     * @param pbRecordCreateInfo 个人最佳记录的创建信息。
     * @return 生成的个人最佳记录的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createPbRecord(StringIdKey userKey, PbRecordCreateInfo pbRecordCreateInfo) throws HandlerException;

    /**
     * 更新个人最佳记录。
     *
     * @param userKey            个人最佳记录的所有者的主键。
     * @param pbRecordUpdateInfo 个人最佳记录的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updatePbRecord(StringIdKey userKey, PbRecordUpdateInfo pbRecordUpdateInfo) throws HandlerException;

    /**
     * 删除个人最佳记录。
     *
     * @param userKey     个人最佳记录的所有者的主键。
     * @param pbRecordKey 个人最佳记录的主键。
     * @throws HandlerException 处理器异常。
     */
    void removePbRecord(StringIdKey userKey, LongIdKey pbRecordKey) throws HandlerException;
}
