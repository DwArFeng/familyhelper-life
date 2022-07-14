package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFileUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 个人最佳文件操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbFileOperateHandler extends Handler {

    /**
     * 下载个人最佳文件。
     *
     * @param userKey   执行用户主键。
     * @param pbFileKey 个人最佳文件主键。
     * @return 个人最佳文件。
     * @throws HandlerException 处理器异常。
     */
    PbFile downloadPbFile(StringIdKey userKey, LongIdKey pbFileKey) throws HandlerException;

    /**
     * 上传个人最佳文件。
     *
     * @param userKey          执行用户主键。
     * @param pbFileUploadInfo 个人最佳文件上传信息。
     * @throws HandlerException 处理器异常。
     */
    void uploadPbFile(StringIdKey userKey, PbFileUploadInfo pbFileUploadInfo) throws HandlerException;

    /**
     * 删除个人最佳文件。
     *
     * @param userKey   执行用户主键。
     * @param pbFileKey 个人最佳文件主键。
     * @throws HandlerException 处理器异常。
     */
    void removePbFile(StringIdKey userKey, LongIdKey pbFileKey) throws HandlerException;
}
