package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.life.sdk.util.Constants;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityGeneratedByDriverPushInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityRemindedByDriverPushInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.familyhelper.life.stack.exception.ActivityTemplateDriverException;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;
import com.dwarfeng.familyhelper.life.stack.handler.PushHandler;
import com.dwarfeng.familyhelper.life.stack.service.*;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.generation.KeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 内部活动模板驱动器上下文。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
@Component
public class InternalActivityTemplateDriverContext implements ActivityTemplateDriver.Context {

    private static final Logger LOGGER = LoggerFactory.getLogger(InternalActivityTemplateDriverContext.class);

    private final ActivityTemplateDriverInfoMaintainService activityTemplateDriverInfoMaintainService;
    private final ActivityTemplateMaintainService activityTemplateMaintainService;
    private final PoatMaintainService poatMaintainService;
    private final PoatacMaintainService poatacMaintainService;
    private final UserMaintainService userMaintainService;
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
    private final PushHandler pushHandler;

    private final KeyGenerator<LongIdKey> longIdKeyGenerator;

    private final ExpressionParser expressionParser;
    private final ParserContext parserContext;

    private final HandlerValidator handlerValidator;

    public InternalActivityTemplateDriverContext(
            ActivityTemplateDriverInfoMaintainService activityTemplateDriverInfoMaintainService,
            ActivityTemplateMaintainService activityTemplateMaintainService,
            PoatMaintainService poatMaintainService,
            PoatacMaintainService poatacMaintainService,
            UserMaintainService userMaintainService,
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
            PushHandler pushHandler,
            KeyGenerator<LongIdKey> longIdKeyGenerator,
            ExpressionParser expressionParser,
            ParserContext parserContext,
            HandlerValidator handlerValidator
    ) {
        this.activityTemplateDriverInfoMaintainService = activityTemplateDriverInfoMaintainService;
        this.activityTemplateMaintainService = activityTemplateMaintainService;
        this.poatMaintainService = poatMaintainService;
        this.poatacMaintainService = poatacMaintainService;
        this.userMaintainService = userMaintainService;
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
        this.pushHandler = pushHandler;
        this.longIdKeyGenerator = longIdKeyGenerator;
        this.expressionParser = expressionParser;
        this.parserContext = parserContext;
        this.handlerValidator = handlerValidator;
    }

    @Override
    public void drive(LongIdKey activityTemplateDriverInfoKey) throws ActivityTemplateDriverException {
        try {
            // 确认活动模板驱动信息存在。
            handlerValidator.makeSureActivityTemplateDriverInfoExists(activityTemplateDriverInfoKey);

            // 获取活动模板驱动信息实体。
            ActivityTemplateDriverInfo driverInfo = activityTemplateDriverInfoMaintainService.get(
                    activityTemplateDriverInfoKey
            );

            // 展开参数。
            boolean remindFlag = driverInfo.isRemindFlag();
            boolean generateFlag = driverInfo.isGenerateFlag();

            // 如果 remindFlag 为 true，则提醒。
            if (remindFlag) {
                doRemind(driverInfo);
            }

            // 如果 generateFlag 为 true，则生成。
            if (generateFlag) {
                doGenerate(driverInfo);
            }
        } catch (ActivityTemplateDriverException e) {
            throw e;
        } catch (Exception e) {
            throw new ActivityTemplateDriverException(e);
        }
    }

    private void doRemind(ActivityTemplateDriverInfo driverInfo) throws Exception {
        // 确认活动模板存在。
        LongIdKey activityTemplateKey = driverInfo.getActivityTemplateKey();
        handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

        // 获取活动模板实体。
        ActivityTemplate activityTemplate = activityTemplateMaintainService.get(activityTemplateKey);

        // 根据 ActivityTemplateDriverInfo.remindScopeType 确定提醒的目标用户。
        List<User> aimedUsers = analyseAimedUsers(activityTemplate, driverInfo);

        // 推送提醒事件。
        pushRemindEvent(activityTemplate, aimedUsers);
    }

    private List<User> analyseAimedUsers(ActivityTemplate activityTemplate, ActivityTemplateDriverInfo driverInfo)
            throws Exception {
        // 展开参数。
        int remindScopeType = driverInfo.getRemindScopeType();

        // 获取与指定活动模板相关的所有权限信息。
        List<Poat> poats = poatMaintainService.lookupAsList(
                PoatMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE, new Object[]{activityTemplate.getKey()}
        );

        // 根据 remindScopeType 确定不同的筛选器。
        Predicate<Poat> predicate;
        switch (remindScopeType) {
            case Constants.REMIND_SCOPE_TYPE_OWNER_ONLY:
                predicate = poat -> poat.getPermissionLevel() == Constants.PERMISSION_LEVEL_OWNER;
                break;
            case Constants.REMIND_SCOPE_TYPE_OWNER_AND_MODIFIER:
            case Constants.REMIND_SCOPE_TYPE_ALL_PERMITTED:
                predicate = poat -> true;
                break;
            default:
                throw new IllegalStateException("不应该执行到此处，请联系开发人员");
        }

        // 筛选出目标用户的主键，并查询出所有用户。
        List<StringIdKey> aimedUserKeys = poats.stream().filter(predicate)
                .map(poat -> new StringIdKey(poat.getKey().getUserStringId())).collect(Collectors.toList());
        return userMaintainService.batchGet(aimedUserKeys);
    }

    private void pushRemindEvent(ActivityTemplate activityTemplate, List<User> aimedUsers) {
        try {
            pushHandler.activityRemindedByDriver(new ActivityRemindedByDriverPushInfo(activityTemplate, aimedUsers));
        } catch (Exception e) {
            LOGGER.warn("推送提醒事件时发生异常, 异常信息如下", e);
        }
    }

    private void doGenerate(ActivityTemplateDriverInfo driverInfo) throws Exception {
        // 确认活动模板存在。
        LongIdKey activityTemplateKey = driverInfo.getActivityTemplateKey();
        handlerValidator.makeSureActivityTemplateExists(activityTemplateKey);

        // 获取活动模板实体。
        ActivityTemplate activityTemplate = activityTemplateMaintainService.get(activityTemplateKey);

        // 从活动模板初始化活动，并获取生成的主键。
        Activity activity = initActivityFromActivityTemplate(activityTemplate);

        // 更新活动模板实体。
        activityTemplate.setGeneratedCount(activityTemplate.getGeneratedCount() + 1);
        activityTemplateMaintainService.update(activityTemplate);

        // 推送活动生成事件。
        pushActivityGeneratedByDriver(activityTemplate, activity);
    }

    private void pushActivityGeneratedByDriver(ActivityTemplate activityTemplate, Activity activity) {
        try {
            pushHandler.activityGeneratedByDriver(new ActivityGeneratedByDriverPushInfo(activityTemplate, activity));
        } catch (Exception e) {
            LOGGER.warn("推送活动生成事件时发生异常, 异常信息如下", e);
        }
    }

    @SuppressWarnings({"ExtractMethodRecommender", "DuplicatedCode"})
    private Activity initActivityFromActivityTemplate(ActivityTemplate activityTemplate) throws Exception {
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

        // 返回活动实体。
        return activity;
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
