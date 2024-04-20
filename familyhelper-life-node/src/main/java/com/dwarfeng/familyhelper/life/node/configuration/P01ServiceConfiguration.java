package com.dwarfeng.familyhelper.life.node.configuration;

import com.dwarfeng.familyhelper.life.impl.service.operation.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.familyhelper.life.stack.cache.PopbCache;
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
public class P01ServiceConfiguration {

    private final GenerateConfiguration generateConfiguration;
    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;

    private final UserCrudOperation userCrudOperation;
    private final PopbDao popbDao;
    private final PopbCache popbCache;
    private final PbSetCrudOperation pbSetCrudOperation;
    private final PbSetDao pbSetDao;
    private final PbNodeCrudOperation pbNodeCrudOperation;
    private final PbNodeDao pbNodeDao;
    private final PbItemCrudOperation pbItemCrudOperation;
    private final PbItemDao pbItemDao;
    private final PbRecordCrudOperation pbRecordCrudOperation;
    private final PbRecordDao pbRecordDao;
    private final PbFileInfoCrudOperation pbFileInfoCrudOperation;
    private final PbFileInfoDao pbFileInfoDao;

    @Value("${cache.timeout.entity.popb}")
    private long popbTimeout;

    public P01ServiceConfiguration(
            GenerateConfiguration generateConfiguration,
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            UserCrudOperation userCrudOperation,
            PopbDao popbDao,
            PopbCache popbCache,
            PbSetCrudOperation pbSetCrudOperation,
            PbSetDao pbSetDao,
            PbNodeCrudOperation pbNodeCrudOperation,
            PbNodeDao pbNodeDao,
            PbItemCrudOperation pbItemCrudOperation,
            PbItemDao pbItemDao,
            PbRecordCrudOperation pbRecordCrudOperation,
            PbRecordDao pbRecordDao,
            PbFileInfoCrudOperation pbFileInfoCrudOperation,
            PbFileInfoDao pbFileInfoDao
    ) {
        this.generateConfiguration = generateConfiguration;
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.userCrudOperation = userCrudOperation;
        this.popbDao = popbDao;
        this.popbCache = popbCache;
        this.pbSetCrudOperation = pbSetCrudOperation;
        this.pbSetDao = pbSetDao;
        this.pbNodeCrudOperation = pbNodeCrudOperation;
        this.pbNodeDao = pbNodeDao;
        this.pbItemCrudOperation = pbItemCrudOperation;
        this.pbItemDao = pbItemDao;
        this.pbRecordCrudOperation = pbRecordCrudOperation;
        this.pbRecordDao = pbRecordDao;
        this.pbFileInfoCrudOperation = pbFileInfoCrudOperation;
        this.pbFileInfoDao = pbFileInfoDao;
    }

    @Bean
    public CustomBatchCrudService<StringIdKey, User> userBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                userCrudOperation,
                new ExceptionKeyGenerator<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<PopbKey, Popb> popbGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                popbDao,
                popbCache,
                new ExceptionKeyGenerator<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                popbTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Popb> popbDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                popbDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Popb> popbDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                popbDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbSet> pbSetBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                pbSetCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbSet> pbSetDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                pbSetDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbSet> pbSetDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                pbSetDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbNode> pbNodeBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                pbNodeCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbNode> pbNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                pbNodeDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbNode> pbNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                pbNodeDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbItem> pbItemBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                pbItemCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbItem> pbItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                pbItemDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbItem> pbItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                pbItemDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbRecord> pbRecordBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                pbRecordCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbRecord> pbRecordDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                pbRecordDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbRecord> pbRecordDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                pbRecordDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbFileInfo> pbFileInfoBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                pbFileInfoCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbFileInfo> pbFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                pbFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbFileInfo> pbFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                pbFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }
}
