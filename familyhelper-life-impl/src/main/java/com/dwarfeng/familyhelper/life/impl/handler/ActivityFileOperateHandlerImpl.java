package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFile;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityFileUploadInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityFileInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityFileOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityFileInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ActivityFileOperateHandlerImpl implements ActivityFileOperateHandler {

    private final ActivityFileInfoMaintainService activityFileInfoMaintainService;
    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> keyGenerator;

    private final HandlerValidator handlerValidator;

    public ActivityFileOperateHandlerImpl(
            ActivityFileInfoMaintainService activityFileInfoMaintainService,
            FtpHandler ftpHandler,
            KeyGenerator<LongIdKey> keyGenerator,
            HandlerValidator handlerValidator
    ) {
        this.activityFileInfoMaintainService = activityFileInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyGenerator = keyGenerator;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public ActivityFile downloadActivityFile(StringIdKey userKey, LongIdKey activityFileKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认项目文件存在。
            handlerValidator.makeSureActivityFileExists(activityFileKey);

            // 获取项目文件对应的项目，并确认用户有权限操作项目。
            ActivityFileInfo activityFileInfo = activityFileInfoMaintainService.get(
                    activityFileKey
            );
            handlerValidator.makeSureUserInspectPermittedForActivity(
                    userKey, activityFileInfo.getActivityKey()
            );

            // 下载项目文件。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_FILE, getFileName(activityFileKey)
            );

            // 更新文件的查看时间。
            activityFileInfo.setInspectedDate(new Date());
            activityFileInfoMaintainService.update(activityFileInfo);

            // 拼接 ActivityFile 并返回。
            return new ActivityFile(activityFileInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings({"ExtractMethodRecommender", "DuplicatedCode"})
    @Override
    public void uploadActivityFile(StringIdKey userKey, ActivityFileUploadInfo activityFileUploadInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认项目文件所属的项目存在。
            LongIdKey activityKey = activityFileUploadInfo.getActivityKey();
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户有权限操作项目。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认项目未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 分配主键。
            LongIdKey activityFileKey = keyGenerator.generate();

            // 项目文件内容并存储（覆盖）。
            byte[] content = activityFileUploadInfo.getContent();
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_FILE, getFileName(activityFileKey), content
            );

            // 根据 activityFileUploadInfo 构造 ActivityFileInfo，插入或更新。
            Date currentDate = new Date();
            // 映射属性。
            ActivityFileInfo activityFileInfo = new ActivityFileInfo();
            activityFileInfo.setKey(activityFileKey);
            activityFileInfo.setActivityKey(activityKey);
            activityFileInfo.setOriginName(activityFileUploadInfo.getOriginName());
            activityFileInfo.setLength(activityFileUploadInfo.getContent().length);
            activityFileInfo.setCreatedDate(currentDate);
            activityFileInfo.setModifiedDate(currentDate);
            activityFileInfo.setInspectedDate(currentDate);
            activityFileInfo.setRemark("通过 familyhelper-assets 服务上传/更新项目文件");
            activityFileInfoMaintainService.insertOrUpdate(activityFileInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void updateActivityFile(
            StringIdKey userKey, ActivityFileUpdateInfo activityFileUpdateInfo
    ) throws HandlerException {
        try {
            LongIdKey activityFileKey = activityFileUpdateInfo.getActivityFileKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认项目文件信息存在。
            handlerValidator.makeSureActivityFileExists(activityFileKey);

            // 确认项目存在。
            ActivityFileInfo activityFileInfo = activityFileInfoMaintainService.get(activityFileKey);
            LongIdKey activityKey = activityFileInfo.getActivityKey();
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户有权限操作项目文件信息。
            handlerValidator.makeSureUserModifyPermittedForActivityFileInfo(userKey, activityFileKey);

            // 确认项目未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 项目文件内容并存储（覆盖）。
            byte[] content = activityFileUpdateInfo.getContent();
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_FILE, getFileName(activityFileKey), content
            );

            // 根据 activityFileUpdateInfo 更新字段。
            activityFileInfo.setOriginName(activityFileUpdateInfo.getOriginName());
            activityFileInfo.setLength(content.length);
            activityFileInfo.setModifiedDate(new Date());
            activityFileInfoMaintainService.update(activityFileInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removeActivityFile(StringIdKey userKey, LongIdKey activityFileKey)
            throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认项目文件存在。
            handlerValidator.makeSureActivityFileExists(activityFileKey);

            // 获取项目文件对应的项目，并确认用户有权限操作项目。
            ActivityFileInfo activityFileInfo = activityFileInfoMaintainService.get(activityFileKey);
            LongIdKey activityKey = activityFileInfo.getActivityKey();
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认项目未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 如果存在 ActivityFile 文件，则删除。
            if (ftpHandler.existsFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_FILE, getFileName(activityFileKey)
            )) {
                ftpHandler.deleteFile(
                        FtpConstants.FILE_PATHS_ACTIVITY_FILE, getFileName(activityFileKey)
                );
            }

            // 如果存在 ActivityFileInfo 实体，则删除。
            activityFileInfoMaintainService.deleteIfExists(activityFileKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey activityFileKey) {
        return Long.toString(activityFileKey.getLongId());
    }
}
