package com.dwarfeng.familyhelper.life.impl.configuration;

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
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean
    public GeneralBatchCrudService<PopbKey, Popb> popbGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                popbDao,
                popbCache,
                new ExceptionKeyGenerator<>(),
                popbTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Popb> popbDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                popbDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Popb> popbDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                popbDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbSet> pbSetBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbSetCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbSet> pbSetDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbSetDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbSet> pbSetDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbSetDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbNode> pbNodeBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbNodeCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbNode> pbNodeDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbNodeDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbNode> pbNodeDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbNodeDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbItem> pbItemBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbItemCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbItem> pbItemDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbItemDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbItem> pbItemDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbItemDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbRecord> pbRecordBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbRecordCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbRecord> pbRecordDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbRecordDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbRecord> pbRecordDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbRecordDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, PbFileInfo> pbFileInfoBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbFileInfoCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<PbFileInfo> pbFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbFileInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<PbFileInfo> pbFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                pbFileInfoDao
        );
    }
}
