package com.dwarfeng.familyhelper.life.node.configuration;

import com.dwarfeng.familyhelper.life.impl.service.operation.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.familyhelper.life.stack.cache.*;
import com.dwarfeng.familyhelper.life.stack.dao.*;
import com.dwarfeng.subgrade.impl.generation.ExceptionKeyGenerator;
import com.dwarfeng.subgrade.impl.service.CustomBatchCrudService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyEntireLookupService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyPresetLookupService;
import com.dwarfeng.subgrade.impl.service.GeneralBatchCrudService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class P02ServiceConfiguration {

    private final GenerateConfiguration generateConfiguration;
    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;

    private final ActivityCrudOperation activityCrudOperation;
    private final ActivityDao activityDao;
    private final ActivityCoverInfoDao activityCoverInfoDao;
    private final ActivityCoverInfoCache activityCoverInfoCache;
    private final ActivityDataItemCrudOperation activityDataItemCrudOperation;
    private final ActivityDataItemDao activityDataItemDao;
    private final ActivityDataNodeCrudOperation activityDataNodeCrudOperation;
    private final ActivityDataNodeDao activityDataNodeDao;
    private final ActivityDataRecordDao activityDataRecordDao;
    private final ActivityDataRecordCache activityDataRecordCache;
    private final ActivityDataSetCrudOperation activityDataSetCrudOperation;
    private final ActivityDataSetDao activityDataSetDao;
    private final ActivityFileInfoDao activityFileInfoDao;
    private final ActivityFileInfoCache activityFileInfoCache;
    private final ActivityParticipantDao activityParticipantDao;
    private final ActivityParticipantCache activityParticipantCache;
    private final ActivityTemplateCrudOperation activityTemplateCrudOperation;
    private final ActivityTemplateDao activityTemplateDao;
    private final ActivityTemplateCoverInfoDao activityTemplateCoverInfoDao;
    private final ActivityTemplateCoverInfoCache activityTemplateCoverInfoCache;
    private final ActivityTemplateDataInfoDao activityTemplateDataInfoDao;
    private final ActivityTemplateDataInfoCache activityTemplateDataInfoCache;
    private final ActivityTemplateDriverInfoDao activityTemplateDriverInfoDao;
    private final ActivityTemplateDriverInfoCache activityTemplateDriverInfoCache;
    private final ActivityTemplateDriverSupportDao activityTemplateDriverSupportDao;
    private final ActivityTemplateDriverSupportCache activityTemplateDriverSupportCache;
    private final ActivityTemplateFileInfoDao activityTemplateFileInfoDao;
    private final ActivityTemplateFileInfoCache activityTemplateFileInfoCache;
    private final ActivityTemplateParticipantDao activityTemplateParticipantDao;
    private final ActivityTemplateParticipantCache activityTemplateParticipantCache;
    private final ActivityTypeIndicatorDao activityTypeIndicatorDao;
    private final ActivityTypeIndicatorCache activityTypeIndicatorCache;
    private final PoacDao poacDao;
    private final PoacCache poacCache;
    private final PoadDao poadDao;
    private final PoadCache poadCache;
    private final PoatDao poatDao;
    private final PoatCache poatCache;
    private final PoatacDao poatacDao;
    private final PoatacCache poatacCache;

    @Value("${cache.timeout.entity.activity_cover_info}")
    private long activityCoverInfoTimeout;
    @Value("${cache.timeout.entity.activity_data_record}")
    private long activityDataRecordTimeout;
    @Value("${cache.timeout.entity.activity_file_info}")
    private long activityFileInfoTimeout;
    @Value("${cache.timeout.entity.activity_participant}")
    private long activityParticipantTimeout;
    @Value("${cache.timeout.entity.activity_template_cover_info}")
    private long activityTemplateCoverInfoTimeout;
    @Value("${cache.timeout.entity.activity_template_data_info}")
    private long activityTemplateDataInfoTimeout;
    @Value("${cache.timeout.entity.activity_template_driver_info}")
    private long activityTemplateDriverInfoTimeout;
    @Value("${cache.timeout.entity.activity_template_driver_support}")
    private long activityTemplateDriverSupportTimeout;
    @Value("${cache.timeout.entity.activity_template_file_info}")
    private long activityTemplateFileInfoTimeout;
    @Value("${cache.timeout.entity.activity_template_participant}")
    private long activityTemplateParticipantTimeout;
    @Value("${cache.timeout.entity.activity_type_indicator}")
    private long activityTypeIndicatorTimeout;
    @Value("${cache.timeout.entity.poac}")
    private long poacTimeout;
    @Value("${cache.timeout.entity.poad}")
    private long poadTimeout;
    @Value("${cache.timeout.entity.poat}")
    private long poatTimeout;
    @Value("${cache.timeout.entity.poatac}")
    private long poatacTimeout;

    public P02ServiceConfiguration(
            GenerateConfiguration generateConfiguration,
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            ActivityCrudOperation activityCrudOperation,
            ActivityDao activityDao,
            ActivityCoverInfoDao activityCoverInfoDao,
            ActivityCoverInfoCache activityCoverInfoCache,
            ActivityDataItemCrudOperation activityDataItemCrudOperation,
            ActivityDataItemDao activityDataItemDao,
            ActivityDataNodeCrudOperation activityDataNodeCrudOperation,
            ActivityDataNodeDao activityDataNodeDao,
            ActivityDataRecordDao activityDataRecordDao,
            ActivityDataRecordCache activityDataRecordCache,
            ActivityDataSetCrudOperation activityDataSetCrudOperation,
            ActivityDataSetDao activityDataSetDao,
            ActivityFileInfoDao activityFileInfoDao,
            ActivityFileInfoCache activityFileInfoCache,
            ActivityParticipantDao activityParticipantDao,
            ActivityParticipantCache activityParticipantCache,
            ActivityTemplateCrudOperation activityTemplateCrudOperation,
            ActivityTemplateDao activityTemplateDao,
            ActivityTemplateCoverInfoDao activityTemplateCoverInfoDao,
            ActivityTemplateCoverInfoCache activityTemplateCoverInfoCache,
            ActivityTemplateDataInfoDao activityTemplateDataInfoDao,
            ActivityTemplateDataInfoCache activityTemplateDataInfoCache,
            ActivityTemplateDriverInfoDao activityTemplateDriverInfoDao,
            ActivityTemplateDriverInfoCache activityTemplateDriverInfoCache,
            ActivityTemplateDriverSupportDao activityTemplateDriverSupportDao,
            ActivityTemplateDriverSupportCache activityTemplateDriverSupportCache,
            ActivityTemplateFileInfoDao activityTemplateFileInfoDao,
            ActivityTemplateFileInfoCache activityTemplateFileInfoCache,
            ActivityTemplateParticipantDao activityTemplateParticipantDao,
            ActivityTemplateParticipantCache activityTemplateParticipantCache,
            ActivityTypeIndicatorDao activityTypeIndicatorDao,
            ActivityTypeIndicatorCache activityTypeIndicatorCache,
            PoacDao poacDao,
            PoacCache poacCache,
            PoadDao poadDao,
            PoadCache poadCache,
            PoatDao poatDao,
            PoatCache poatCache,
            PoatacDao poatacDao,
            PoatacCache poatacCache
    ) {
        this.generateConfiguration = generateConfiguration;
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.activityCrudOperation = activityCrudOperation;
        this.activityDao = activityDao;
        this.activityCoverInfoDao = activityCoverInfoDao;
        this.activityCoverInfoCache = activityCoverInfoCache;
        this.activityDataItemCrudOperation = activityDataItemCrudOperation;
        this.activityDataItemDao = activityDataItemDao;
        this.activityDataNodeCrudOperation = activityDataNodeCrudOperation;
        this.activityDataNodeDao = activityDataNodeDao;
        this.activityDataRecordDao = activityDataRecordDao;
        this.activityDataRecordCache = activityDataRecordCache;
        this.activityDataSetCrudOperation = activityDataSetCrudOperation;
        this.activityDataSetDao = activityDataSetDao;
        this.activityFileInfoDao = activityFileInfoDao;
        this.activityFileInfoCache = activityFileInfoCache;
        this.activityParticipantDao = activityParticipantDao;
        this.activityParticipantCache = activityParticipantCache;
        this.activityTemplateCrudOperation = activityTemplateCrudOperation;
        this.activityTemplateDao = activityTemplateDao;
        this.activityTemplateCoverInfoDao = activityTemplateCoverInfoDao;
        this.activityTemplateCoverInfoCache = activityTemplateCoverInfoCache;
        this.activityTemplateDataInfoDao = activityTemplateDataInfoDao;
        this.activityTemplateDataInfoCache = activityTemplateDataInfoCache;
        this.activityTemplateDriverInfoDao = activityTemplateDriverInfoDao;
        this.activityTemplateDriverInfoCache = activityTemplateDriverInfoCache;
        this.activityTemplateDriverSupportDao = activityTemplateDriverSupportDao;
        this.activityTemplateDriverSupportCache = activityTemplateDriverSupportCache;
        this.activityTemplateFileInfoDao = activityTemplateFileInfoDao;
        this.activityTemplateFileInfoCache = activityTemplateFileInfoCache;
        this.activityTemplateParticipantDao = activityTemplateParticipantDao;
        this.activityTemplateParticipantCache = activityTemplateParticipantCache;
        this.activityTypeIndicatorDao = activityTypeIndicatorDao;
        this.activityTypeIndicatorCache = activityTypeIndicatorCache;
        this.poacDao = poacDao;
        this.poacCache = poacCache;
        this.poadDao = poadDao;
        this.poadCache = poadCache;
        this.poatDao = poatDao;
        this.poatCache = poatCache;
        this.poatacDao = poatacDao;
        this.poatacCache = poatacCache;
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, Activity> activityBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Activity> activityDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Activity> activityDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDao
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityCoverInfo> activityCoverInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityCoverInfoDao,
                activityCoverInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                activityCoverInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityCoverInfo> activityCoverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityCoverInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityCoverInfo> activityCoverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityCoverInfoDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityDataItem> activityDataItemBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataItemCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataItem> activityDataItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataItemDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataItem> activityDataItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataItemDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityDataNode> activityDataNodeBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataNodeCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataNode> activityDataNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataNodeDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataNode> activityDataNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataNodeDao
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityDataRecord> activityDataRecordBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataRecordDao,
                activityDataRecordCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                activityDataRecordTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataRecord> activityDataRecordDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataRecordDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataRecord> activityDataRecordDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataRecordDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityDataSet> activityDataSetBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataSetCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataSet> activityDataSetDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataSetDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataSet> activityDataSetDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataSetDao
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityFileInfo> activityFileInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityFileInfoDao,
                activityFileInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                activityFileInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityFileInfo> activityFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityFileInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityFileInfo> activityFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityFileInfoDao
        );
    }

    @Bean
    public GeneralBatchCrudService<ActivityParticipantKey, ActivityParticipant>
    activityParticipantBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityParticipantDao,
                activityParticipantCache,
                new ExceptionKeyGenerator<>(),
                activityParticipantTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityParticipant> activityParticipantDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityParticipantDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityParticipant> activityParticipantDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityParticipantDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityTemplate> activityTemplateBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplate> activityTemplateDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplate> activityTemplateDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDao
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateCoverInfo>
    activityTemplateCoverInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateCoverInfoDao,
                activityTemplateCoverInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                activityTemplateCoverInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateCoverInfo> activityTemplateCoverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateCoverInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateCoverInfo> activityTemplateCoverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateCoverInfoDao
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateDataInfo>
    activityTemplateDataInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDataInfoDao,
                activityTemplateDataInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                activityTemplateDataInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateDataInfo> activityTemplateDataInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDataInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateDataInfo> activityTemplateDataInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDataInfoDao
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateDriverInfo>
    activityTemplateDriverInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverInfoDao,
                activityTemplateDriverInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                activityTemplateDriverInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateDriverInfo>
    activityTemplateDriverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateDriverInfo>
    activityTemplateDriverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverInfoDao
        );
    }

    @Bean
    public GeneralBatchCrudService<StringIdKey, ActivityTemplateDriverSupport>
    activityTemplateDriverSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverSupportDao,
                activityTemplateDriverSupportCache,
                new ExceptionKeyGenerator<>(),
                activityTemplateDriverSupportTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateDriverSupport>
    activityTemplateDriverSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverSupportDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateDriverSupport>
    activityTemplateDriverSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverSupportDao
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateFileInfo>
    activityTemplateFileInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateFileInfoDao,
                activityTemplateFileInfoCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                activityTemplateFileInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateFileInfo>
    activityTemplateFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateFileInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateFileInfo>
    activityTemplateFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateFileInfoDao
        );
    }

    @Bean
    public GeneralBatchCrudService<ActivityTemplateParticipantKey, ActivityTemplateParticipant>
    activityTemplateParticipantBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateParticipantDao,
                activityTemplateParticipantCache,
                new ExceptionKeyGenerator<>(),
                activityTemplateParticipantTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateParticipant>
    activityTemplateParticipantDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateParticipantDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateParticipant>
    activityTemplateParticipantDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateParticipantDao
        );
    }

    @Bean
    public GeneralBatchCrudService<StringIdKey, ActivityTypeIndicator> activityTypeIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTypeIndicatorDao,
                activityTypeIndicatorCache,
                new ExceptionKeyGenerator<>(),
                activityTypeIndicatorTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTypeIndicator> activityTypeIndicatorDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTypeIndicatorDao
        );
    }

    @Bean
    public GeneralBatchCrudService<PoacKey, Poac> poacBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poacDao,
                poacCache,
                new ExceptionKeyGenerator<>(),
                poacTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poac> poacDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poacDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poac> poacDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poacDao
        );
    }

    @Bean
    public GeneralBatchCrudService<PoadKey, Poad> poadBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poadDao,
                poadCache,
                new ExceptionKeyGenerator<>(),
                poadTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poad> poadDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poadDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poad> poadDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poadDao
        );
    }

    @Bean
    public GeneralBatchCrudService<PoatKey, Poat> poatBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatDao,
                poatCache,
                new ExceptionKeyGenerator<>(),
                poatTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poat> poatDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poat> poatDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatDao
        );
    }

    @Bean
    public GeneralBatchCrudService<PoatacKey, Poatac> poatacBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatacDao,
                poatacCache,
                new ExceptionKeyGenerator<>(),
                poatacTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poatac> poatacDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatacDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poatac> poatacDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatacDao
        );
    }
}
