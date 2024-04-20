package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateFileUploadInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateFileInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateFileOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateFileInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ActivityTemplateFileOperateHandlerImpl implements ActivityTemplateFileOperateHandler {

    private final ActivityTemplateFileInfoMaintainService activityTemplateFileInfoMaintainService;
    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> keyGenerator;

    private final HandlerValidator handlerValidator;

    public ActivityTemplateFileOperateHandlerImpl(
            ActivityTemplateFileInfoMaintainService activityTemplateFileInfoMaintainService,
            FtpHandler ftpHandler,
            KeyGenerator<LongIdKey> keyGenerator,
            HandlerValidator handlerValidator
    ) {
        this.activityTemplateFileInfoMaintainService = activityTemplateFileInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyGenerator = keyGenerator;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public ActivityTemplateFile downloadActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 2. 确认项目文件存在。
            handlerValidator.makeSureActivityTemplateFileExists(activityTemplateFileKey);

            // 3. 获取项目文件对应的项目，并确认用户有权限操作项目。
            ActivityTemplateFileInfo activityTemplateFileInfo = activityTemplateFileInfoMaintainService.get(
                    activityTemplateFileKey
            );
            handlerValidator.makeSureUserInspectPermittedForActivityTemplate(
                    userKey, activityTemplateFileInfo.getActivityTemplateKey()
            );

            // 4. 下载项目文件。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_FILE, getFileName(activityTemplateFileKey)
            );

            // 5. 更新文件的查看时间。
            activityTemplateFileInfo.setInspectedDate(new Date());
            activityTemplateFileInfoMaintainService.update(activityTemplateFileInfo);

            // 6. 拼接 ActivityTemplateFile 并返回。
            return new ActivityTemplateFile(activityTemplateFileInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("ExtractMethodRecommender")
    @Override
    public void uploadActivityTemplateFile(
            StringIdKey userKey, ActivityTemplateFileUploadInfo activityTemplateFileUploadInfo
    ) throws HandlerException {
        try {
            // 1. 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 2. 确认项目文件所属的项目存在。
            LongIdKey activityTemplateKey = activityTemplateFileUploadInfo.getActivityTemplateKey();
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 3. 确认用户有权限操作项目。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 4. 分配主键。
            LongIdKey activityTemplateFileKey = keyGenerator.generate();

            // 5. 项目文件内容并存储（覆盖）。
            byte[] content = activityTemplateFileUploadInfo.getContent();
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_FILE, getFileName(activityTemplateFileKey), content
            );

            // 6. 根据 activityTemplateFileUploadInfo 构造 ActivityTemplateFileInfo，插入或更新。
            Date currentDate = new Date();
            // 映射属性。
            ActivityTemplateFileInfo activityTemplateFileInfo = new ActivityTemplateFileInfo();
            activityTemplateFileInfo.setKey(activityTemplateFileKey);
            activityTemplateFileInfo.setActivityTemplateKey(activityTemplateKey);
            activityTemplateFileInfo.setOriginName(activityTemplateFileUploadInfo.getOriginName());
            activityTemplateFileInfo.setLength(activityTemplateFileUploadInfo.getContent().length);
            activityTemplateFileInfo.setCreatedDate(currentDate);
            activityTemplateFileInfo.setModifiedDate(currentDate);
            activityTemplateFileInfo.setInspectedDate(currentDate);
            activityTemplateFileInfo.setRemark("通过 familyhelper-assets 服务上传/更新项目文件");
            activityTemplateFileInfoMaintainService.insertOrUpdate(activityTemplateFileInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void updateActivityTemplateFile(
            StringIdKey userKey, ActivityTemplateFileUpdateInfo activityTemplateFileUpdateInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateFileKey = activityTemplateFileUpdateInfo.getActivityTemplateFileKey();

            // 1. 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 2. 确认项目文件信息存在。
            handlerValidator.makeSureActivityTemplateFileExists(activityTemplateFileKey);

            // 3. 确认用户有权限操作项目文件信息。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplateFileInfo(userKey, activityTemplateFileKey);

            // 4. 项目文件内容并存储（覆盖）。
            byte[] content = activityTemplateFileUpdateInfo.getContent();
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_FILE, getFileName(activityTemplateFileKey), content
            );

            // 5. 根据 activityTemplateFileUpdateInfo 更新字段。
            ActivityTemplateFileInfo activityTemplateFileInfo = activityTemplateFileInfoMaintainService.get(
                    activityTemplateFileKey
            );
            activityTemplateFileInfo.setOriginName(activityTemplateFileUpdateInfo.getOriginName());
            activityTemplateFileInfo.setLength(content.length);
            activityTemplateFileInfo.setModifiedDate(new Date());
            activityTemplateFileInfoMaintainService.update(activityTemplateFileInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removeActivityTemplateFile(StringIdKey userKey, LongIdKey activityTemplateFileKey)
            throws HandlerException {
        try {
            // 1. 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 2. 确认项目文件存在。
            handlerValidator.makeSureActivityTemplateFileExists(activityTemplateFileKey);

            // 3. 获取项目文件对应的项目，并确认用户有权限操作项目。
            ActivityTemplateFileInfo activityTemplateFileInfo = activityTemplateFileInfoMaintainService.get(
                    activityTemplateFileKey
            );
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(
                    userKey, activityTemplateFileInfo.getActivityTemplateKey()
            );

            // 4. 如果存在 ActivityTemplateFile 文件，则删除。
            if (ftpHandler.existsFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_FILE, getFileName(activityTemplateFileKey)
            )) {
                ftpHandler.deleteFile(
                        FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_FILE, getFileName(activityTemplateFileKey)
                );
            }

            // 5. 如果存在 ActivityTemplateFileInfo 实体，则删除。
            activityTemplateFileInfoMaintainService.deleteIfExists(activityTemplateFileKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey activityTemplateFileKey) {
        return Long.toString(activityTemplateFileKey.getLongId());
    }
}
