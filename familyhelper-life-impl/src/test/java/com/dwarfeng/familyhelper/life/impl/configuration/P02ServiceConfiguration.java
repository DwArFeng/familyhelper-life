package com.dwarfeng.familyhelper.life.impl.configuration;

import com.dwarfeng.familyhelper.life.impl.service.operation.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.familyhelper.life.stack.cache.*;
import com.dwarfeng.familyhelper.life.stack.dao.*;
import com.dwarfeng.subgrade.impl.bean.key.ExceptionKeyFetcher;
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

    private final KeyFetcherConfiguration keyFetcherConfiguration;
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
            KeyFetcherConfiguration keyFetcherConfiguration,
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
        this.keyFetcherConfiguration = keyFetcherConfiguration;
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.activityCrudOperation = activityCrudOperation;
        this.activityDao = activityDao;
        this.activityCoverInfoDao = activityCoverInfoDao;
        this.activityCoverInfoCache = activityCoverInfoCache;
        this.activityDataItemCrudOperation = activityDataItemCrudOperation;
        this.activityDataItemDao = activityDataItemDao;
        this.activityDataNodeCrudOperation = activityDataNodeCrudOperation;
        this.activityDataNodeDao = activityDataNodeDao;
        this.activityDataRecordCache = activityDataRecordCache;
        this.activityDataRecordDao = activityDataRecordDao;
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
                activityCrudOperation,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Activity> activityDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Activity> activityDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityCoverInfo> activityCoverInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityCoverInfoDao,
                activityCoverInfoCache,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityCoverInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityCoverInfo> activityCoverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityCoverInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityCoverInfo> activityCoverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityCoverInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityDataItem> activityDataItemBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                activityDataItemCrudOperation,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataItem> activityDataItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityDataItemDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataItem> activityDataItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityDataItemDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityDataNode> activityDataNodeBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                activityDataNodeCrudOperation,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataNode> activityDataNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityDataNodeDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataNode> activityDataNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityDataNodeDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityDataRecord> activityDataRecordBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityDataRecordDao,
                activityDataRecordCache,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityDataRecordTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataRecord> activityDataRecordDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityDataRecordDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataRecord> activityDataRecordDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityDataRecordDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityDataSet> activityDataSetBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                activityDataSetCrudOperation,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityDataSet> activityDataSetDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityDataSetDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityDataSet> activityDataSetDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityDataSetDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityFileInfo> activityFileInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityFileInfoDao,
                activityFileInfoCache,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityFileInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityFileInfo> activityFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityFileInfo> activityFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<ActivityParticipantKey, ActivityParticipant>
    activityParticipantBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityParticipantDao,
                activityParticipantCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityParticipantTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityParticipant> activityParticipantDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityParticipantDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityParticipant> activityParticipantDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityParticipantDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, ActivityTemplate> activityTemplateBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                activityTemplateCrudOperation,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplate> activityTemplateDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTemplateDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplate> activityTemplateDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityTemplateDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateCoverInfo>
    activityTemplateCoverInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityTemplateCoverInfoDao,
                activityTemplateCoverInfoCache,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateCoverInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateCoverInfo> activityTemplateCoverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTemplateCoverInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateCoverInfo> activityTemplateCoverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityTemplateCoverInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateDataInfo>
    activityTemplateDataInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityTemplateDataInfoDao,
                activityTemplateDataInfoCache,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDataInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateDataInfo> activityTemplateDataInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTemplateDataInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateDataInfo> activityTemplateDataInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityTemplateDataInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateDriverInfo>
    activityTemplateDriverInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityTemplateDriverInfoDao,
                activityTemplateDriverInfoCache,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateDriverInfo>
    activityTemplateDriverInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTemplateDriverInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateDriverInfo>
    activityTemplateDriverInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityTemplateDriverInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<StringIdKey, ActivityTemplateDriverSupport>
    activityTemplateDriverSupportGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                activityTemplateDriverSupportDao,
                activityTemplateDriverSupportCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateDriverSupportTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateDriverSupport>
    activityTemplateDriverSupportDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTemplateDriverSupportDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateDriverSupport>
    activityTemplateDriverSupportDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityTemplateDriverSupportDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, ActivityTemplateFileInfo>
    activityTemplateFileInfoBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityTemplateFileInfoDao,
                activityTemplateFileInfoCache,
                keyFetcherConfiguration.longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateFileInfoTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateFileInfo>
    activityTemplateFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTemplateFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateFileInfo>
    activityTemplateFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityTemplateFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<ActivityTemplateParticipantKey, ActivityTemplateParticipant>
    activityTemplateParticipantBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                activityTemplateParticipantDao,
                activityTemplateParticipantCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTemplateParticipantTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTemplateParticipant>
    activityTemplateParticipantDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTemplateParticipantDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ActivityTemplateParticipant>
    activityTemplateParticipantDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                activityTemplateParticipantDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<StringIdKey, ActivityTypeIndicator> activityTypeIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                activityTypeIndicatorDao,
                activityTypeIndicatorCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                activityTypeIndicatorTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<ActivityTypeIndicator> activityTypeIndicatorDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                activityTypeIndicatorDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<PoacKey, Poac> poacBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                poacDao,
                poacCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poacTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poac> poacDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                poacDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poac> poacDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                poacDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<PoadKey, Poad> poadBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                poadDao,
                poadCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poadTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poad> poadDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                poadDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poad> poadDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                poadDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<PoatKey, Poat> poatBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                poatDao,
                poatCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poat> poatDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                poatDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poat> poatDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                poatDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<PoatacKey, Poatac> poatacBatchGeneralCrudService() {
        return new GeneralBatchCrudService<>(
                poatacDao,
                poatacCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poatacTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poatac> poatacDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                poatacDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poatac> poatacDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                poatacDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }
}
