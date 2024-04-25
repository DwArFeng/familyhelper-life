package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatacKey;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateOperateHandler;
import com.dwarfeng.familyhelper.life.stack.service.*;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ActivityTemplateOperateHandlerImpl implements ActivityTemplateOperateHandler {

    private final ActivityTemplateMaintainService activityTemplateMaintainService;
    private final PoatMaintainService poatMaintainService;
    private final PoatacMaintainService poatacMaintainService;
    private final ActivityMaintainService activityMaintainService;
    private final PoacMaintainService poacMaintainService;
    private final ActivityTemplateCoverInfoMaintainService activityTemplateCoverInfoMaintainService;
    private final ActivityCoverInfoMaintainService activityCoverInfoMaintainService;
    private final ActivityTemplateParticipantMaintainService activityTemplateParticipantMaintainService;
    private final ActivityParticipantMaintainService activityParticipantMaintainService;
    private final ActivityTemplateDataInfoMaintainService activityTemplateDataInfoMaintainService;
    private final ActivityDataRecordMaintainService activityDataRecordMaintainService;
    private final ActivityTemplateFileInfoMaintainService activityTemplateFileInfoMaintainService;
    private final ActivityFileInfoMaintainService activityFileInfoMaintainService;

    private final FtpHandler ftpHandler;

    private final KeyGenerator<LongIdKey> longIdKeyGenerator;

    private final ExpressionParser expressionParser;
    private final ParserContext parserContext;

    private final HandlerValidator handlerValidator;

    public ActivityTemplateOperateHandlerImpl(
            ActivityTemplateMaintainService activityTemplateMaintainService,
            PoatMaintainService poatMaintainService,
            PoatacMaintainService poatacMaintainService,
            ActivityMaintainService activityMaintainService,
            PoacMaintainService poacMaintainService,
            ActivityTemplateCoverInfoMaintainService activityTemplateCoverInfoMaintainService,
            ActivityCoverInfoMaintainService activityCoverInfoMaintainService,
            ActivityTemplateParticipantMaintainService activityTemplateParticipantMaintainService,
            ActivityParticipantMaintainService activityParticipantMaintainService,
            ActivityTemplateDataInfoMaintainService activityTemplateDataInfoMaintainService,
            ActivityDataRecordMaintainService activityDataRecordMaintainService,
            ActivityTemplateFileInfoMaintainService activityTemplateFileInfoMaintainService,
            ActivityFileInfoMaintainService activityFileInfoMaintainService,
            FtpHandler ftpHandler,
            KeyGenerator<LongIdKey> longIdKeyGenerator,
            ExpressionParser expressionParser,
            ParserContext parserContext,
            HandlerValidator handlerValidator
    ) {
        this.activityTemplateMaintainService = activityTemplateMaintainService;
        this.poatMaintainService = poatMaintainService;
        this.poatacMaintainService = poatacMaintainService;
        this.activityMaintainService = activityMaintainService;
        this.poacMaintainService = poacMaintainService;
        this.activityTemplateCoverInfoMaintainService = activityTemplateCoverInfoMaintainService;
        this.activityCoverInfoMaintainService = activityCoverInfoMaintainService;
        this.activityTemplateParticipantMaintainService = activityTemplateParticipantMaintainService;
        this.activityParticipantMaintainService = activityParticipantMaintainService;
        this.activityTemplateDataInfoMaintainService = activityTemplateDataInfoMaintainService;
        this.activityDataRecordMaintainService = activityDataRecordMaintainService;
        this.activityTemplateFileInfoMaintainService = activityTemplateFileInfoMaintainService;
        this.activityFileInfoMaintainService = activityFileInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.longIdKeyGenerator = longIdKeyGenerator;
        this.expressionParser = expressionParser;
        this.parserContext = parserContext;
        this.handlerValidator = handlerValidator;
    }

    @SuppressWarnings("ExtractMethodRecommender")
    @Override
    public LongIdKey createActivityTemplate(StringIdKey userKey, ActivityTemplateCreateInfo activityTemplateCreateInfo)
            throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 根据 activityTemplateCreateInfo 以及创建的规则组合 活动模板 实体。
            String activityType = activityTemplateCreateInfo.getActivityType();
            String name = activityTemplateCreateInfo.getName();
            String remark = activityTemplateCreateInfo.getRemark();
            String activityNameTemplate = activityTemplateCreateInfo.getActivityNameTemplate();
            String activityRemarkTemplate = activityTemplateCreateInfo.getActivityRemarkTemplate();
            String activityStartDateTemplate = activityTemplateCreateInfo.getActivityStartDateTemplate();
            String activityEndDateTemplate = activityTemplateCreateInfo.getActivityEndDateTemplate();
            Date baselineDate = activityTemplateCreateInfo.getBaselineDate();
            Date currentDate = new Date();
            ActivityTemplate activityTemplate = new ActivityTemplate(
                    null, activityType, name, remark, activityNameTemplate, activityRemarkTemplate,
                    activityStartDateTemplate, activityEndDateTemplate, baselineDate, currentDate, currentDate,
                    currentDate, 0
            );

            // 插入活动模板实体，并获取生成的主键。
            LongIdKey activityTemplateKey = activityTemplateMaintainService.insert(activityTemplate);

            // 由活动模板实体生成的主键和用户主键组合权限信息，并插入。
            Poat poat = new Poat(
                    new PoatKey(activityTemplateKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建活动模板时自动插入，赋予创建人所有者权限"
            );
            poatMaintainService.insert(poat);

            // 由活动模板实体生成的主键和用户主键组合活动权限信息，并插入。
            Poatac poatac = new Poatac(
                    new PoatacKey(activityTemplateKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建活动模板时自动插入，赋予创建人所有者权限"
            );
            poatacMaintainService.insert(poatac);

            // 返回生成的主键。
            return activityTemplateKey;
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void updateActivityTemplate(StringIdKey userKey, ActivityTemplateUpdateInfo activityTemplateUpdateInfo)
            throws HandlerException {
        try {
            LongIdKey activityTemplateKey = activityTemplateUpdateInfo.getActivityTemplateKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户对活动模板有修改权限。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 根据 activityTemplateUpdateInfo 以及更新的规则组合 活动模板 实体。
            ActivityTemplate activityTemplate = activityTemplateMaintainService.get(activityTemplateKey);
            activityTemplate.setActivityType(activityTemplateUpdateInfo.getActivityType());
            activityTemplate.setName(activityTemplateUpdateInfo.getName());
            activityTemplate.setRemark(activityTemplateUpdateInfo.getRemark());
            activityTemplate.setActivityNameTemplate(activityTemplateUpdateInfo.getActivityNameTemplate());
            activityTemplate.setActivityRemarkTemplate(activityTemplateUpdateInfo.getActivityRemarkTemplate());
            activityTemplate.setActivityStartDateTemplate(activityTemplateUpdateInfo.getActivityStartDateTemplate());
            activityTemplate.setActivityEndDateTemplate(activityTemplateUpdateInfo.getActivityEndDateTemplate());
            activityTemplate.setBaselineDate(activityTemplateUpdateInfo.getBaselineDate());
            Date currentDate = new Date();
            activityTemplate.setInspectedDate(currentDate);
            activityTemplate.setModifiedDate(currentDate);

            // 更新活动模板实体。
            activityTemplateMaintainService.update(activityTemplate);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removeActivityTemplate(StringIdKey userKey, LongIdKey activityTemplateKey) throws HandlerException {
        try {
            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 删除活动模板实体。
            activityTemplateMaintainService.delete(activityTemplateKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey userKey, ActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = activityTemplatePermissionUpsertInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = activityTemplatePermissionUpsertInfo.getUserKey();
            int permissionLevel = activityTemplatePermissionUpsertInfo.getPermissionLevel();

            // 确认 permissionLevel 有效。
            handlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体，并进行插入或更新操作。
            String permissionLabel = parsePermissionLabel(permissionLevel);
            Poat poat = new Poat(
                    new PoatKey(activityTemplateKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            poatMaintainService.insertOrUpdate(poat);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void removePermission(
            StringIdKey userKey, ActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = activityTemplatePermissionRemoveInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = activityTemplatePermissionRemoveInfo.getUserKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体主键，并进行存在删除操作。
            PoatKey poatKey = new PoatKey(activityTemplateKey.getLongId(), targetUserKey.getStringId());
            poatMaintainService.deleteIfExists(poatKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void upsertActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionUpsertInfo upsertInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = upsertInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = upsertInfo.getUserKey();
            int permissionLevel = upsertInfo.getPermissionLevel();

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 确认 permissionLevel 有效。
            handlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 通过入口信息组合权限实体，并进行插入或更新操作。
            String permissionLabel = parsePermissionLabel(permissionLevel);
            Poatac poatac = new Poatac(
                    new PoatacKey(activityTemplateKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            poatacMaintainService.insertOrUpdate(poatac);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void removeActivityPermission(
            StringIdKey userKey, ActivityTemplateActivityPermissionRemoveInfo removeInfo
    ) throws HandlerException {
        try {
            LongIdKey activityTemplateKey = removeInfo.getActivityTemplateKey();
            StringIdKey targetUserKey = removeInfo.getUserKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);
            handlerValidator.makeSureUserExists(targetUserKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(userKey, targetUserKey)) {
                return;
            }

            // 通过入口信息组合权限实体主键，并进行存在删除操作。
            PoatacKey poatacKey = new PoatacKey(activityTemplateKey.getLongId(), targetUserKey.getStringId());
            poatacMaintainService.deleteIfExists(poatacKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public LongIdKey createActivityFormal(StringIdKey userKey, ActivityTemplateActivityCreateInfo createInfo)
            throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityTemplateKey = createInfo.getActivityTemplateKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 获取活动模板实体。
            ActivityTemplate activityTemplate = activityTemplateMaintainService.get(activityTemplateKey);

            // 从活动模板初始化活动，并获取生成的主键。
            LongIdKey activityKey = initActivityFromActivityTemplate(activityTemplate);

            // 更新活动模板实体。
            activityTemplate.setGeneratedCount(activityTemplate.getGeneratedCount() + 1);
            activityTemplateMaintainService.update(activityTemplate);

            // 返回生成的主键。
            return activityKey;
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public LongIdKey createActivityTest(StringIdKey userKey, ActivityTemplateActivityCreateInfo createInfo)
            throws HandlerException {
        try {
            // 展开参数。
            LongIdKey activityTemplateKey = createInfo.getActivityTemplateKey();

            // 确认用户存在。
            handlerValidator.makeSureUserExists(userKey);

            // 确认活动模板存在。
            handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

            // 确认用户有权限操作指定的活动模板。
            handlerValidator.makeSureUserModifyPermittedForActivityTemplate(userKey, activityTemplateKey);

            // 获取活动模板实体。
            ActivityTemplate activityTemplate = activityTemplateMaintainService.get(activityTemplateKey);

            // 从活动模板初始化活动，并返回生成的主键。
            return initActivityFromActivityTemplate(activityTemplate);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @SuppressWarnings({"ExtractMethodRecommender", "DuplicatedCode"})
    private LongIdKey initActivityFromActivityTemplate(ActivityTemplate activityTemplate) throws Exception {
        // 展开参数。
        LongIdKey activityTemplateKey = activityTemplate.getKey();

        // 获取当前日期。
        Date currentDate = new Date();

        // 根据活动模板实体生成活动创建字段。
        ActivityCreateField activityCreateField = parseActivityCreateField(activityTemplate);

        // 根据活动创建字段生成活动实体。
        String activityType = activityCreateField.getActivityType();
        String name = activityCreateField.getName();
        String remark = activityCreateField.getRemark();
        Date startDate = activityCreateField.getStartDate();
        Date endDate = activityCreateField.getEndDate();
        Activity activity = new Activity(
                null, activityType, name, 100, remark, false, startDate, endDate, currentDate, currentDate,
                currentDate, null
        );

        // 插入活动实体，并获取生成的主键。
        LongIdKey activityKey = activityMaintainService.insert(activity);

        // 根据模板初始化活动权限。
        // 获取活动模板所有的活动权限。
        List<Poatac> poatacs = poatacMaintainService.lookupAsList(
                PoatacMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{activityTemplateKey}
        );
        // 为每一个活动权限生成一个活动权限实体。
        List<Poac> poacs = poatacs.stream().map(
                t -> new Poac(
                        new PoacKey(activityKey.getLongId(), t.getKey().getUserStringId()),
                        t.getPermissionLevel(),
                        "由活动模板初始化活动时自动插入"
                )
        ).collect(Collectors.toList());
        // 调用维护服务进行批量插入。
        poacMaintainService.batchInsert(poacs);

        // 根据模板初始化活动封面。
        // 获取活动模板所有的活动封面。
        List<ActivityTemplateCoverInfo> activityTemplateCoverInfos =
                activityTemplateCoverInfoMaintainService.lookupAsList(
                        ActivityTemplateCoverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                        new Object[]{activityTemplateKey}
                );
        // 为每一个活动封面生成一个活动封面实体。
        List<ActivityCoverInfo> activityCoverInfos = new ArrayList<>();
        Map<LongIdKey, LongIdKey> activityCoverInfoActivityTemplateCoverInfoKeyMap = new HashMap<>();
        for (ActivityTemplateCoverInfo activityTemplateCoverInfo : activityTemplateCoverInfos) {
            LongIdKey activityCoverInfoKey = longIdKeyGenerator.generate();
            activityCoverInfoActivityTemplateCoverInfoKeyMap.put(
                    activityCoverInfoKey, activityTemplateCoverInfo.getKey()
            );
            ActivityCoverInfo coverInfo = new ActivityCoverInfo(
                    activityCoverInfoKey,
                    activityKey,
                    activityTemplateCoverInfo.getOriginName(),
                    activityTemplateCoverInfo.getLength(),
                    currentDate,
                    currentDate,
                    activityTemplateCoverInfo.getRemark(),
                    activityTemplateCoverInfo.getIndex()
            );
            activityCoverInfos.add(coverInfo);
        }
        // 将活动模板封面文件复制到活动封面文件中。
        for (ActivityCoverInfo activityCoverInfo : activityCoverInfos) {
            // 获取 activityCoverInfo 的主键及其对应的 activityTemplateCoverInfo 的主键。
            LongIdKey activityCoverInfoKey = activityCoverInfo.getKey();
            LongIdKey activityTemplateCoverInfoKey =
                    activityCoverInfoActivityTemplateCoverInfoKeyMap.get(activityCoverInfoKey);
            // 获取活动模板封面文件的内容。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_COVER,
                    getActivityTemplateCoverFileName(activityTemplateCoverInfoKey)
            );
            // 将活动模板封面文件的内容复制到活动封面文件中。
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_COVER,
                    getActivityCoverFileName(activityCoverInfoKey),
                    content
            );
        }
        // 调用维护服务进行批量插入。
        activityCoverInfoMaintainService.batchInsert(activityCoverInfos);

        // 根据模板初始化活动参与者。
        // 获取活动模板所有的活动参与者。
        List<ActivityTemplateParticipant> activityTemplateParticipants =
                activityTemplateParticipantMaintainService.lookupAsList(
                        ActivityTemplateParticipantMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                        new Object[]{activityTemplateKey}
                );
        // 为每一个活动参与者生成一个活动参与者实体。
        List<ActivityParticipant> activityParticipants = activityTemplateParticipants.stream().map(
                t -> new ActivityParticipant(
                        new ActivityParticipantKey(activityKey.getLongId(), t.getKey().getUserStringId()),
                        t.getRemark()
                )
        ).collect(Collectors.toList());
        // 调用维护服务进行批量插入。
        activityParticipantMaintainService.batchInsert(activityParticipants);

        // 根据模板初始化活动数据。
        // 获取活动模板所有d的活动模板数据信息。
        List<ActivityTemplateDataInfo> activityTemplateDataInfos = activityTemplateDataInfoMaintainService.lookupAsList(
                ActivityTemplateDataInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                new Object[]{activityTemplateKey}
        );
        // 为每一个活动模板数据信息生成一个活动数据记录实体。
        List<ActivityDataRecord> activityDataRecords = activityTemplateDataInfos.stream().map(
                t -> new ActivityDataRecord(
                        null, t.getActivityDataItemKey(), activityKey, t.getInitialValue(), currentDate, t.getRemark()
                )
        ).collect(Collectors.toList());
        // 调用维护服务进行批量插入。
        activityDataRecordMaintainService.batchInsert(activityDataRecords);

        // 根据模板初始化活动文件。
        // 获取活动模板所有的活动文件。
        List<ActivityTemplateFileInfo> activityTemplateFileInfos =
                activityTemplateFileInfoMaintainService.lookupAsList(
                        ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                        new Object[]{activityTemplateKey}
                );
        // 为每一个活动文件生成一个活动文件实体。
        List<ActivityFileInfo> activityFileInfos = new ArrayList<>();
        Map<LongIdKey, LongIdKey> activityFileInfoActivityTemplateFileInfoKeyMap = new HashMap<>();
        for (ActivityTemplateFileInfo activityTemplateFileInfo : activityTemplateFileInfos) {
            LongIdKey activityFileInfoKey = longIdKeyGenerator.generate();
            activityFileInfoActivityTemplateFileInfoKeyMap.put(
                    activityFileInfoKey, activityTemplateFileInfo.getKey()
            );
            ActivityFileInfo fileInfo = new ActivityFileInfo(
                    activityFileInfoKey,
                    activityKey,
                    activityTemplateFileInfo.getOriginName(),
                    activityTemplateFileInfo.getLength(),
                    currentDate,
                    currentDate,
                    currentDate,
                    activityTemplateFileInfo.getRemark()
            );
            activityFileInfos.add(fileInfo);
        }
        // 将活动模板文件文件复制到活动文件文件中。
        for (ActivityFileInfo activityFileInfo : activityFileInfos) {
            // 获取 activityFileInfo 的主键及其对应的 activityTemplateFileInfo 的主键。
            LongIdKey activityFileInfoKey = activityFileInfo.getKey();
            LongIdKey activityTemplateFileInfoKey =
                    activityFileInfoActivityTemplateFileInfoKeyMap.get(activityFileInfoKey);
            // 获取活动模板文件文件的内容。
            byte[] content = ftpHandler.retrieveFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_TEMPLATE_FILE,
                    getActivityTemplateFileFileName(activityTemplateFileInfoKey)
            );
            // 将活动模板文件文件的内容复制到活动文件文件中。
            ftpHandler.storeFile(
                    FtpConstants.FILE_PATHS_ACTIVITY_FILE,
                    getActivityFileFileName(activityFileInfoKey),
                    content
            );
        }
        // 调用维护服务进行批量插入。
        activityFileInfoMaintainService.batchInsert(activityFileInfos);

        // 返回生成的主键。
        return activityKey;
    }

    @SuppressWarnings("DuplicatedCode")
    private ActivityCreateField parseActivityCreateField(ActivityTemplate activityTemplate) {
        // 展开参数。
        String activityType = activityTemplate.getActivityType();
        String activityNameTemplate = activityTemplate.getActivityNameTemplate();
        String activityRemarkTemplate = activityTemplate.getActivityRemarkTemplate();
        String activityStartDateTemplate = activityTemplate.getActivityStartDateTemplate();
        String activityEndDateTemplate = activityTemplate.getActivityEndDateTemplate();
        Date baselineDate = activityTemplate.getBaselineDate();
        int generatedCount = activityTemplate.getGeneratedCount();
        Date currentDate = new Date();

        // 定义及初始化参数映射。
        Map<String, Object> paramMap = new HashMap<>();
        long baselineOffset = currentDate.getTime() - baselineDate.getTime();
        paramMap.put("baseline_offset", baselineOffset);
        paramMap.put("generated_count", generatedCount);

        // 根据参数映射解析活动的相关参数。
        String name = expressionParser.parseExpression(activityNameTemplate, parserContext)
                .getValue(paramMap, String.class);
        String remark = expressionParser.parseExpression(activityRemarkTemplate, parserContext)
                .getValue(paramMap, String.class);
        Date startDate = expressionParser.parseExpression(activityStartDateTemplate, parserContext)
                .getValue(paramMap, Date.class);
        Date endDate = expressionParser.parseExpression(activityEndDateTemplate, parserContext)
                .getValue(paramMap, Date.class);

        // 返回解析结果。
        return new ActivityCreateField(activityType, name, remark, startDate, endDate);
    }

    private String getActivityTemplateCoverFileName(LongIdKey itemCoverKey) {
        return Long.toString(itemCoverKey.getLongId());
    }

    private String getActivityCoverFileName(LongIdKey itemCoverKey) {
        return Long.toString(itemCoverKey.getLongId());
    }

    private String getActivityTemplateFileFileName(LongIdKey itemFileKey) {
        return Long.toString(itemFileKey.getLongId());
    }

    private String getActivityFileFileName(LongIdKey itemFileKey) {
        return Long.toString(itemFileKey.getLongId());
    }

    private String parsePermissionLabel(int permissionLevel) {
        switch (permissionLevel) {
            case Constants.PERMISSION_LEVEL_GUEST:
                return "访客";
            case Constants.PERMISSION_LEVEL_OWNER:
                return "所有者";
            default:
                return "（未知）";
        }
    }

    private static final class ActivityCreateField {

        private final String activityType;
        private final String name;
        private final String remark;
        private final Date startDate;
        private final Date endDate;

        public ActivityCreateField(
                String activityType, String name, String remark, Date startDate, Date endDate
        ) {
            this.activityType = activityType;
            this.name = name;
            this.remark = remark;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public String getActivityType() {
            return activityType;
        }

        public String getName() {
            return name;
        }

        public String getRemark() {
            return remark;
        }

        public Date getStartDate() {
            return startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        @Override
        public String toString() {
            return "ActivityCreateField{" +
                    "activityType='" + activityType + '\'' +
                    ", name='" + name + '\'' +
                    ", remark='" + remark + '\'' +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    '}';
        }
    }
}
