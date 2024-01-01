package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCover;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCoverOrderUpdateInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCoverUploadInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityCoverInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityCoverOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityCoverInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.stack.bean.key.KeyFetcher;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ActivityCoverOperateHandlerImpl implements ActivityCoverOperateHandler {

    private final ActivityCoverInfoMaintainService activityCoverInfoMaintainService;

    private final FtpHandler ftpHandler;

    private final KeyFetcher<LongIdKey> keyFetcher;

    private final HandlerValidator handlerValidator;

    public ActivityCoverOperateHandlerImpl(
            ActivityCoverInfoMaintainService activityCoverInfoMaintainService,
            FtpHandler ftpHandler,
            KeyFetcher<LongIdKey> keyFetcher,
            HandlerValidator handlerValidator
    ) {
        this.activityCoverInfoMaintainService = activityCoverInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.keyFetcher = keyFetcher;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public ActivityCover download(StringIdKey userKey, LongIdKey coverKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动封面存在。
            handlerValidator.makeSureActivityCoverExists(coverKey);

            // 获取活动封面对应的活动，并确认用户有权限查看活动。
            ActivityCoverInfo activityCoverInfo = activityCoverInfoMaintainService.get(
                    coverKey
            );
            handlerValidator.makeSureUserInspectPermittedForActivity(
                    userKey, activityCoverInfo.getActivityKey()
            );

            // 下载活动封面。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_COVER, getFileName(coverKey)
            );

            // 构造返回值并返回。
            return new ActivityCover(activityCoverInfo.getOriginName(), content);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void upload(StringIdKey userKey, ActivityCoverUploadInfo coverUploadInfo) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动封面所属的活动存在。
            LongIdKey activityKey = coverUploadInfo.getActivityKey();
            handlerValidator.makeSureActivityExists(activityKey);

            // 确认用户有权限操作活动。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 分配主键。
            LongIdKey activityCoverKey = keyFetcher.fetchKey();

            // 获取活动封面内容并存储（覆盖）。
            byte[] content = coverUploadInfo.getContent();
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_COVER, getFileName(activityCoverKey),
                    content
            );

            // 根据 coverUploadInfo 构造 ActivityCoverInfo，插入或更新。
            Date currentDate = new Date();
            // 映射属性。
            ActivityCoverInfo activityCoverInfo = new ActivityCoverInfo();
            activityCoverInfo.setKey(activityCoverKey);
            activityCoverInfo.setActivityKey(activityKey);
            activityCoverInfo.setOriginName(coverUploadInfo.getOriginName());
            activityCoverInfo.setLength(content.length);
            activityCoverInfo.setCreatedDate(currentDate);
            activityCoverInfo.setModifiedDate(currentDate);
            activityCoverInfo.setRemark("通过 familyhelper-life 服务上传/更新的活动封面。");
            // 查找当前 index 最大的 ActivityCoverInfo 并且设置 index 为 最大的 index + 1。
            Integer index = Optional.ofNullable(activityCoverInfoMaintainService.lookupFirst(
                    ActivityCoverInfoMaintainService.CHILD_FOR_ACTIVITY_INDEX_DESC,
                    new Object[]{activityKey}
            )).map(info -> info.getIndex() + 1).orElse(0);
            activityCoverInfo.setIndex(index);
            activityCoverInfoMaintainService.insertOrUpdate(activityCoverInfo);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey coverKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动封面存在。
            handlerValidator.makeSureActivityCoverExists(coverKey);

            // 获取活动封面对应的活动，并确认用户有权限操作活动。
            ActivityCoverInfo activityCoverInfo = activityCoverInfoMaintainService.get(
                    coverKey
            );
            LongIdKey activityKey = activityCoverInfo.getActivityKey();
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 如果存在 ActivityCover 文件，则删除。
            if (ftpHandler.existsFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_COVER, getFileName(coverKey)
            )) {
                ftpHandler.deleteFile(
                        FtpConstants.FILE_PATHS_ACTIVITY_COVER, getFileName(coverKey)
                );
            }

            // 删除 ActivityCoverInfo。
            activityCoverInfoMaintainService.delete(coverKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    private String getFileName(LongIdKey itemCoverKey) {
        return Long.toString(itemCoverKey.getLongId());
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void updateOrder(StringIdKey userKey, ActivityCoverOrderUpdateInfo coverUpdateInfo)
            throws HandlerException {
        try {
            // 展开 coverUpdateInfo。
            List<LongIdKey> activityCoverKeys = coverUpdateInfo.getActivityCoverKeys();

            // 特殊情况：itemCoverKeys 为空数组，则不执行任何逻辑。
            if (activityCoverKeys.isEmpty()) {
                return;
            }

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动封面存在。
            for (LongIdKey activityCoverKey : activityCoverKeys) {
                handlerValidator.makeSureActivityCoverExists(activityCoverKey);
            }

            // 确认项目封面属于同一个项目，且项目不为空。
            handlerValidator.makeSureActivityCoverHasSameActivity(activityCoverKeys);

            // 获取活动封面所属的活动对应的主键。
            LongIdKey activityKey = activityCoverInfoMaintainService.get(activityCoverKeys.get(0)).getActivityKey();

            // 确认用户有权限操作活动。
            handlerValidator.makeSureUserModifyPermittedForActivity(userKey, activityKey);

            // 确认活动未锁定。
            handlerValidator.makeSureActivityNotLocked(activityKey);

            // 获取按照旧顺序排列的活动封面列表。
            List<ActivityCoverInfo> orderedActivityCoverInfos =
                    activityCoverInfoMaintainService.lookupAsList(
                            ActivityCoverInfoMaintainService.CHILD_FOR_ACTIVITY_INDEX_ASC,
                            new Object[]{activityKey}
                    );

            // 按照 activityCoverKeys 重新组织顺序。
            // 将 activityCoverKeys 列表中存在的元素移除，剩下 activityCoverKeys 不存在的元素。
            orderedActivityCoverInfos.removeIf(i -> activityCoverKeys.contains(i.getKey()));
            // 将 activityCoverKeys 列表中的元素插入到 orderedActivityCoverInfos 头部。
            for (int i = activityCoverKeys.size() - 1; i >= 0; i--) {
                orderedActivityCoverInfos.add(
                        0, activityCoverInfoMaintainService.get(activityCoverKeys.get(i))
                );
            }
            // 重新设置 index。
            for (int i = 0; i < orderedActivityCoverInfos.size(); i++) {
                orderedActivityCoverInfos.get(i).setIndex(i);
            }

            // 批量更新。
            activityCoverInfoMaintainService.batchUpdate(orderedActivityCoverInfos);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
