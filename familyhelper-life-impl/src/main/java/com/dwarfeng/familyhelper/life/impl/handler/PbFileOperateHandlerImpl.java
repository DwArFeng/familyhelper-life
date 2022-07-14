package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbFileUploadInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.familyhelper.life.stack.handler.PbFileOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.PbFileInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.stack.bean.key.KeyFetcher;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PbFileOperateHandlerImpl implements PbFileOperateHandler {

    private final PbFileInfoMaintainService pbFileInfoMaintainService;
    private final FtpHandler ftpHandler;

    private final KeyFetcher<LongIdKey> keyFetcher;

    private final OperateHandlerValidator operateHandlerValidator;

    public PbFileOperateHandlerImpl(
            PbFileInfoMaintainService pbFileInfoMaintainService,
            FtpHandler ftpHandler,
            KeyFetcher<LongIdKey> keyFetcher,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.pbFileInfoMaintainService = pbFileInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyFetcher = keyFetcher;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public PbFile downloadPbFile(StringIdKey userKey, LongIdKey pbFileKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳文件存在。
            operateHandlerValidator.makeSurePbFileExists(pbFileKey);

            // 3. 获取个人最佳文件对应的项目，并确认用户有权限操作项目。
            PbFileInfo pbFileInfo = pbFileInfoMaintainService.get(pbFileKey);
            operateHandlerValidator.makeSureUserInspectPermittedForPbRecord(userKey, pbFileInfo.getRecordKey());

            // 4. 下载个人最佳文件。
            byte[] content = ftpHandler.getFileContent(
                    new String[]{FtpConstants.PATH_PB_FILE}, getFileName(pbFileKey)
            );

            // 5. 更新文件的查看时间。
            pbFileInfo.setInspectedDate(new Date());
            pbFileInfoMaintainService.update(pbFileInfo);

            // 6. 拼接 PbFile 并返回。
            return new PbFile(pbFileInfo.getOriginName(), content);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void uploadPbFile(StringIdKey userKey, PbFileUploadInfo pbFileUploadInfo) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳文件所属的项目存在。
            LongIdKey recordKey = pbFileUploadInfo.getRecordKey();
            operateHandlerValidator.makeSurePbRecordExists(recordKey);

            // 3. 确认用户有权限操作项目。
            operateHandlerValidator.makeSureUserModifyPermittedForPbRecord(userKey, recordKey);

            // 4. 分配主键。
            LongIdKey pbFileKey = keyFetcher.fetchKey();

            // 5. 个人最佳文件内容并存储（覆盖）。
            byte[] content = pbFileUploadInfo.getContent();
            ftpHandler.storeFile(new String[]{FtpConstants.PATH_PB_FILE}, getFileName(pbFileKey), content);

            // 6. 根据 pbFileUploadInfo 构造 PbFileInfo，插入或更新。
            // 映射属性。
            PbFileInfo pbFileInfo = new PbFileInfo();
            pbFileInfo.setKey(pbFileKey);
            pbFileInfo.setRecordKey(recordKey);
            pbFileInfo.setOriginName(pbFileUploadInfo.getOriginName());
            pbFileInfo.setLength(pbFileUploadInfo.getContent().length);
            pbFileInfo.setUploadedDate(new Date());
            pbFileInfo.setRemark("通过 familyhelper-assets 服务上传/更新个人最佳文件");
            pbFileInfoMaintainService.insertOrUpdate(pbFileInfo);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePbFile(StringIdKey userKey, LongIdKey pbFileKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认个人最佳文件存在。
            operateHandlerValidator.makeSurePbFileExists(pbFileKey);

            // 3. 获取个人最佳文件对应的项目，并确认用户有权限操作项目。
            PbFileInfo pbFileInfo = pbFileInfoMaintainService.get(pbFileKey);
            operateHandlerValidator.makeSureUserModifyPermittedForPbRecord(userKey, pbFileInfo.getRecordKey());

            // 4. 如果存在 PbFile 文件，则删除。
            if (ftpHandler.existsFile(new String[]{FtpConstants.PATH_PB_FILE}, getFileName(pbFileKey))) {
                ftpHandler.deleteFile(new String[]{FtpConstants.PATH_PB_FILE}, getFileName(pbFileKey));
            }

            // 5. 如果存在 PbFileInfo 实体，则删除。
            pbFileInfoMaintainService.deleteIfExists(pbFileKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    private String getFileName(LongIdKey pbFileKey) {
        return Long.toString(pbFileKey.getLongId());
    }
}
