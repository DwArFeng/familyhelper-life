package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCover;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCoverOrderUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCoverUploadInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateCoverInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateCoverOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateCoverInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ActivityTemplateCoverOperateHandlerImpl implements ActivityTemplateCoverOperateHandler {

    private final ActivityTemplateCoverInfoMaintainService activityTemplateCoverInfoMaintainService;

    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> keyGenerator;

    private final HandlerValidator handlerValidator;

    public ActivityTemplateCoverOperateHandlerImpl(
            ActivityTemplateCoverInfoMaintainService activityTemplateCoverInfoMaintainService,
            FtpHandler ftpHandler,
            KeyGenerator<LongIdKey> keyGenerator,
            HandlerValidator handlerValidator
    ) {
        this.activityTemplateCoverInfoMaintainService = activityTemplateCoverInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyGenerator = keyGenerator;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public ActivityTemplateCover download(StringIdKey userKey, LongIdKey coverKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板封面存在。
            handlerValidator.makeSureActivityTemplateCoverExists(coverKey);

            // 获取活动模板封面对应的活动模板，并确认用户有权限查看活动模板。
            ActivityTemplateCoverInfo activityTemplateCoverInfo = activityTemplateCoverInfoMaintainService.get(
                    coverKey
            );
            handlerValidator.makeSureUserInspectPermittedForActivityTemplate(
                    userKey, activityTemplateCoverInfo.getActivityTemplateKey()
            );

            // 下载活动模板封面。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_COVER, getFileName(coverKey)
            );

            // 构造返回值并返回。
            return new ActivityTemplateCover(activityTemplateCoverInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void upload(StringIdKey userKey, ActivityTemplateCoverUploadInfo coverUploadInfo) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板封面所属的活动模板存在。
            LongIdKey activityTemplateKey = coverUploadInfo.getActivityTemplateKey();
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 分配主键。
            LongIdKey activityTemplateCoverKey = keyGenerator.generate();

            // 获取活动模板封面内容并存储（覆盖）。
            byte[] content = coverUploadInfo.getContent();
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_COVER, getFileName(activityTemplateCoverKey),
                    content
            );

            // 根据 coverUploadInfo 构造 ActivityTemplateCoverInfo，插入或更新。
            Date currentDate = new Date();
            // 映射属性。
            ActivityTemplateCoverInfo activityTemplateCoverInfo = new ActivityTemplateCoverInfo();
            activityTemplateCoverInfo.setKey(activityTemplateCoverKey);
            activityTemplateCoverInfo.setActivityTemplateKey(activityTemplateKey);
            activityTemplateCoverInfo.setOriginName(coverUploadInfo.getOriginName());
            activityTemplateCoverInfo.setLength(content.length);
            activityTemplateCoverInfo.setCreatedDate(currentDate);
            activityTemplateCoverInfo.setModifiedDate(currentDate);
            activityTemplateCoverInfo.setRemark("通过 familyhelper-life 服务上传/更新的活动模板封面。");
            // 查找当前 index 最大的 ActivityTemplateCoverInfo 并且设置 index 为 最大的 index + 1。
            Integer index = Optional.ofNullable(activityTemplateCoverInfoMaintainService.lookupFirst(
                    ActivityTemplateCoverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_INDEX_DESC,
                    new Object[]{activityTemplateKey}
            )).map(info -> info.getIndex() + 1).orElse(0);
            activityTemplateCoverInfo.setIndex(index);
            activityTemplateCoverInfoMaintainService.insertOrUpdate(activityTemplateCoverInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey coverKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板封面存在。
            handlerValidator.makeSureActivityTemplateCoverExists(coverKey);

            // 获取活动模板封面对应的活动模板，并确认用户有权限操作活动模板。
            ActivityTemplateCoverInfo activityTemplateCoverInfo = activityTemplateCoverInfoMaintainService.get(
                    coverKey
            );
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(
                    userKey, activityTemplateCoverInfo.getActivityTemplateKey()
            );

            // 如果存在 ActivityTemplateCover 文件，则删除。
            if (ftpHandler.existsFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_COVER, getFileName(coverKey)
            )) {
                ftpHandler.deleteFile(
                        FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_COVER, getFileName(coverKey)
                );
            }

            // 删除 ActivityTemplateCoverInfo。
            activityTemplateCoverInfoMaintainService.delete(coverKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private String getFileName(LongIdKey itemCoverKey) {
        return Long.toString(itemCoverKey.getLongId());
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void updateOrder(StringIdKey userKey, ActivityTemplateCoverOrderUpdateInfo coverUpdateInfo)
            throws HandlerException {
        try {
            // 展开 coverUpdateInfo。
            List<LongIdKey> activityTemplateCoverKeys = coverUpdateInfo.getActivityTemplateCoverKeys();

            // 特殊情况：itemCoverKeys 为空数组，则不执行任何逻辑。
            if (activityTemplateCoverKeys.isEmpty()) {
                return;
            }

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板封面存在。
            for (LongIdKey activityTemplateCoverKey : activityTemplateCoverKeys) {
                handlerValidator.makeSureActivityTemplateCoverExists(activityTemplateCoverKey);
            }

            // 确认项目封面属于同一个项目，且项目不为空。
            handlerValidator.makeSureActivityTemplateCoverHasSameActivityTemplate(activityTemplateCoverKeys);

            // 获取活动模板封面所属的活动模板对应的主键。
            LongIdKey activityTemplateKey = activityTemplateCoverInfoMaintainService.get(
                    activityTemplateCoverKeys.get(0)
            ).getActivityTemplateKey();

            // 确认用户有权限操作活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 获取按照旧顺序排列的活动模板封面列表。
            List<ActivityTemplateCoverInfo> orderedActivityTemplateCoverInfos =
                    activityTemplateCoverInfoMaintainService.lookupAsList(
                            ActivityTemplateCoverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_INDEX_ASC,
                            new Object[]{activityTemplateKey}
                    );

            // 按照 activityTemplateCoverKeys 重新组织顺序。
            // 将 activityTemplateCoverKeys 列表中存在的元素移除，剩下 activityTemplateCoverKeys 不存在的元素。
            orderedActivityTemplateCoverInfos.removeIf(i -> activityTemplateCoverKeys.contains(i.getKey()));
            // 将 activityTemplateCoverKeys 列表中的元素插入到 orderedActivityTemplateCoverInfos 头部。
            for (int i = activityTemplateCoverKeys.size() - 1; i >= 0; i--) {
                orderedActivityTemplateCoverInfos.add(
                        0, activityTemplateCoverInfoMaintainService.get(activityTemplateCoverKeys.get(i))
                );
            }
            // 重新设置 index。
            for (int i = 0; i < orderedActivityTemplateCoverInfos.size(); i++) {
                orderedActivityTemplateCoverInfos.get(i).setIndex(i);
            }

            // 批量更新。
            activityTemplateCoverInfoMaintainService.batchUpdate(orderedActivityTemplateCoverInfos);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
