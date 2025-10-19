package com.dwarfeng.familyhelper.life.impl.configuration;

import com.dwarfeng.familyhelper.life.impl.bean.BeanMapper;
import com.dwarfeng.familyhelper.life.impl.bean.entity.*;
import com.dwarfeng.familyhelper.life.impl.bean.key.*;
import com.dwarfeng.familyhelper.life.impl.dao.preset.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class P02DaoConfiguration {

    private final HibernateTemplate template;

    private final ActivityPresetCriteriaMaker activityPresetCriteriaMaker;
    private final ActivityCoverInfoPresetCriteriaMaker activityCoverInfoPresetCriteriaMaker;
    private final ActivityDataItemPresetCriteriaMaker activityDataItemPresetCriteriaMaker;
    private final ActivityDataNodePresetCriteriaMaker activityDataNodePresetCriteriaMaker;
    private final ActivityDataRecordPresetCriteriaMaker activityDataRecordPresetCriteriaMaker;
    private final ActivityDataSetPresetCriteriaMaker activityDataSetPresetCriteriaMaker;
    private final ActivityFileInfoPresetCriteriaMaker activityFileInfoPresetCriteriaMaker;
    private final ActivityParticipantPresetCriteriaMaker activityParticipantPresetCriteriaMaker;
    private final ActivityTemplatePresetCriteriaMaker activityTemplatePresetCriteriaMaker;
    private final ActivityTemplateCoverInfoPresetCriteriaMaker activityTemplateCoverInfoPresetCriteriaMaker;
    private final ActivityTemplateDataInfoPresetCriteriaMaker activityTemplateDataInfoPresetCriteriaMaker;
    private final ActivityTemplateDriverInfoPresetCriteriaMaker activityTemplateDriverInfoPresetCriteriaMaker;
    private final ActivityTemplateDriverSupportPresetCriteriaMaker activityTemplateDriverSupportPresetCriteriaMaker;
    private final ActivityTemplateFileInfoPresetCriteriaMaker activityTemplateFileInfoPresetCriteriaMaker;
    private final ActivityTemplateParticipantPresetCriteriaMaker activityTemplateParticipantPresetCriteriaMaker;
    private final PoacPresetCriteriaMaker poacPresetCriteriaMaker;
    private final PoadPresetCriteriaMaker poadPresetCriteriaMaker;
    private final PoatPresetCriteriaMaker poatPresetCriteriaMaker;
    private final PoatacPresetCriteriaMaker poatacPresetCriteriaMaker;

    @Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    public P02DaoConfiguration(
            HibernateTemplate template,
            ActivityPresetCriteriaMaker activityPresetCriteriaMaker,
            ActivityCoverInfoPresetCriteriaMaker activityCoverInfoPresetCriteriaMaker,
            ActivityDataItemPresetCriteriaMaker activityDataItemPresetCriteriaMaker,
            ActivityDataNodePresetCriteriaMaker activityDataNodePresetCriteriaMaker,
            ActivityDataRecordPresetCriteriaMaker activityDataRecordPresetCriteriaMaker,
            ActivityDataSetPresetCriteriaMaker activityDataSetPresetCriteriaMaker,
            ActivityFileInfoPresetCriteriaMaker activityFileInfoPresetCriteriaMaker,
            ActivityParticipantPresetCriteriaMaker activityParticipantPresetCriteriaMaker,
            ActivityTemplatePresetCriteriaMaker activityTemplatePresetCriteriaMaker,
            ActivityTemplateCoverInfoPresetCriteriaMaker activityTemplateCoverInfoPresetCriteriaMaker,
            ActivityTemplateDataInfoPresetCriteriaMaker activityTemplateDataInfoPresetCriteriaMaker,
            ActivityTemplateDriverInfoPresetCriteriaMaker activityTemplateDriverInfoPresetCriteriaMaker,
            ActivityTemplateDriverSupportPresetCriteriaMaker activityTemplateDriverSupportPresetCriteriaMaker,
            ActivityTemplateFileInfoPresetCriteriaMaker activityTemplateFileInfoPresetCriteriaMaker,
            ActivityTemplateParticipantPresetCriteriaMaker activityTemplateParticipantPresetCriteriaMaker,
            PoacPresetCriteriaMaker poacPresetCriteriaMaker,
            PoadPresetCriteriaMaker poadPresetCriteriaMaker,
            PoatPresetCriteriaMaker poatPresetCriteriaMaker,
            PoatacPresetCriteriaMaker poatacPresetCriteriaMaker
    ) {
        this.template = template;
        this.activityPresetCriteriaMaker = activityPresetCriteriaMaker;
        this.activityTemplateDataInfoPresetCriteriaMaker = activityTemplateDataInfoPresetCriteriaMaker;
        this.activityCoverInfoPresetCriteriaMaker = activityCoverInfoPresetCriteriaMaker;
        this.activityDataItemPresetCriteriaMaker = activityDataItemPresetCriteriaMaker;
        this.activityDataNodePresetCriteriaMaker = activityDataNodePresetCriteriaMaker;
        this.activityDataRecordPresetCriteriaMaker = activityDataRecordPresetCriteriaMaker;
        this.activityDataSetPresetCriteriaMaker = activityDataSetPresetCriteriaMaker;
        this.activityFileInfoPresetCriteriaMaker = activityFileInfoPresetCriteriaMaker;
        this.activityParticipantPresetCriteriaMaker = activityParticipantPresetCriteriaMaker;
        this.activityTemplatePresetCriteriaMaker = activityTemplatePresetCriteriaMaker;
        this.activityTemplateCoverInfoPresetCriteriaMaker = activityTemplateCoverInfoPresetCriteriaMaker;
        this.activityTemplateDriverInfoPresetCriteriaMaker = activityTemplateDriverInfoPresetCriteriaMaker;
        this.activityTemplateDriverSupportPresetCriteriaMaker = activityTemplateDriverSupportPresetCriteriaMaker;
        this.activityTemplateFileInfoPresetCriteriaMaker = activityTemplateFileInfoPresetCriteriaMaker;
        this.activityTemplateParticipantPresetCriteriaMaker = activityTemplateParticipantPresetCriteriaMaker;
        this.poacPresetCriteriaMaker = poacPresetCriteriaMaker;
        this.poadPresetCriteriaMaker = poadPresetCriteriaMaker;
        this.poatPresetCriteriaMaker = poatPresetCriteriaMaker;
        this.poatacPresetCriteriaMaker = poatacPresetCriteriaMaker;
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Activity, HibernateActivity>
    activityHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Activity.class, HibernateActivity.class, BeanMapper.class),
                HibernateActivity.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Activity, HibernateActivity> activityHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Activity.class, HibernateActivity.class, BeanMapper.class),
                HibernateActivity.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Activity, HibernateActivity> activityHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Activity.class, HibernateActivity.class, BeanMapper.class),
                HibernateActivity.class,
                activityPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityCoverInfo, HibernateActivityCoverInfo>
    activityCoverInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityCoverInfo.class, HibernateActivityCoverInfo.class, BeanMapper.class
                ),
                HibernateActivityCoverInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityCoverInfo, HibernateActivityCoverInfo>
    activityCoverInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityCoverInfo.class, HibernateActivityCoverInfo.class, BeanMapper.class
                ),
                HibernateActivityCoverInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityCoverInfo, HibernateActivityCoverInfo>
    activityCoverInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityCoverInfo.class, HibernateActivityCoverInfo.class, BeanMapper.class
                ),
                HibernateActivityCoverInfo.class,
                activityCoverInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityDataItem, HibernateActivityDataItem>
    activityDataItemHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataItem.class, HibernateActivityDataItem.class, BeanMapper.class
                ),
                HibernateActivityDataItem.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityDataItem, HibernateActivityDataItem>
    activityDataItemHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataItem.class, HibernateActivityDataItem.class, BeanMapper.class
                ),
                HibernateActivityDataItem.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityDataItem, HibernateActivityDataItem>
    activityDataItemHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataItem.class, HibernateActivityDataItem.class, BeanMapper.class
                ),
                HibernateActivityDataItem.class,
                activityDataItemPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityDataNode, HibernateActivityDataNode>
    activityDataNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataNode.class, HibernateActivityDataNode.class, BeanMapper.class
                ),
                HibernateActivityDataNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityDataNode, HibernateActivityDataNode>
    activityDataNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataNode.class, HibernateActivityDataNode.class, BeanMapper.class
                ),
                HibernateActivityDataNode.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityDataNode, HibernateActivityDataNode>
    activityDataNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataNode.class, HibernateActivityDataNode.class, BeanMapper.class
                ),
                HibernateActivityDataNode.class,
                activityDataNodePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityDataRecord, HibernateActivityDataRecord>
    activityDataRecordHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataRecord.class, HibernateActivityDataRecord.class, BeanMapper.class
                ),
                HibernateActivityDataRecord.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityDataRecord, HibernateActivityDataRecord>
    activityDataRecordHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataRecord.class, HibernateActivityDataRecord.class, BeanMapper.class
                ),
                HibernateActivityDataRecord.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityDataRecord, HibernateActivityDataRecord>
    activityDataRecordHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataRecord.class, HibernateActivityDataRecord.class, BeanMapper.class
                ),
                HibernateActivityDataRecord.class,
                activityDataRecordPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityDataSet, HibernateActivityDataSet>
    activityDataSetHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataSet.class, HibernateActivityDataSet.class, BeanMapper.class
                ),
                HibernateActivityDataSet.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityDataSet, HibernateActivityDataSet>
    activityDataSetHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataSet.class, HibernateActivityDataSet.class, BeanMapper.class
                ),
                HibernateActivityDataSet.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityDataSet, HibernateActivityDataSet>
    activityDataSetHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityDataSet.class, HibernateActivityDataSet.class, BeanMapper.class
                ),
                HibernateActivityDataSet.class,
                activityDataSetPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityFileInfo, HibernateActivityFileInfo>
    activityFileInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityFileInfo.class, HibernateActivityFileInfo.class, BeanMapper.class
                ),
                HibernateActivityFileInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityFileInfo, HibernateActivityFileInfo>
    activityFileInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityFileInfo.class, HibernateActivityFileInfo.class, BeanMapper.class
                ),
                HibernateActivityFileInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityFileInfo, HibernateActivityFileInfo>
    activityFileInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityFileInfo.class, HibernateActivityFileInfo.class, BeanMapper.class
                ),
                HibernateActivityFileInfo.class,
                activityFileInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<ActivityParticipantKey, HibernateActivityParticipantKey, ActivityParticipant,
            HibernateActivityParticipant> activityParticipantHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityParticipantKey.class, HibernateActivityParticipantKey.class, BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ActivityParticipant.class, HibernateActivityParticipant.class, BeanMapper.class
                ),
                HibernateActivityParticipant.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityParticipant, HibernateActivityParticipant>
    activityParticipantHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityParticipant.class, HibernateActivityParticipant.class, BeanMapper.class
                ),
                HibernateActivityParticipant.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityParticipant, HibernateActivityParticipant>
    activityParticipantHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityParticipant.class, HibernateActivityParticipant.class, BeanMapper.class
                ),
                HibernateActivityParticipant.class,
                activityParticipantPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityTemplate, HibernateActivityTemplate>
    activityTemplateHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplate.class, HibernateActivityTemplate.class, BeanMapper.class
                ),
                HibernateActivityTemplate.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplate, HibernateActivityTemplate>
    activityTemplateHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplate.class, HibernateActivityTemplate.class, BeanMapper.class
                ),
                HibernateActivityTemplate.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplate, HibernateActivityTemplate>
    activityTemplateHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplate.class, HibernateActivityTemplate.class, BeanMapper.class
                ),
                HibernateActivityTemplate.class,
                activityTemplatePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityTemplateCoverInfo,
            HibernateActivityTemplateCoverInfo> activityTemplateCoverInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateCoverInfo.class, HibernateActivityTemplateCoverInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateCoverInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplateCoverInfo, HibernateActivityTemplateCoverInfo>
    activityTemplateCoverInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateCoverInfo.class, HibernateActivityTemplateCoverInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateCoverInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplateCoverInfo, HibernateActivityTemplateCoverInfo>
    activityTemplateCoverInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateCoverInfo.class, HibernateActivityTemplateCoverInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateCoverInfo.class,
                activityTemplateCoverInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityTemplateDataInfo,
            HibernateActivityTemplateDataInfo> activityTemplateDataInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateDataInfo.class, HibernateActivityTemplateDataInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDataInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplateDataInfo, HibernateActivityTemplateDataInfo>
    activityTemplateDataInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateDataInfo.class, HibernateActivityTemplateDataInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDataInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplateDataInfo, HibernateActivityTemplateDataInfo>
    activityTemplateDataInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateDataInfo.class, HibernateActivityTemplateDataInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDataInfo.class,
                activityTemplateDataInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityTemplateDriverInfo,
            HibernateActivityTemplateDriverInfo> activityTemplateDriverInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverInfo.class, HibernateActivityTemplateDriverInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDriverInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplateDriverInfo, HibernateActivityTemplateDriverInfo>
    activityTemplateDriverInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverInfo.class, HibernateActivityTemplateDriverInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDriverInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplateDriverInfo, HibernateActivityTemplateDriverInfo>
    activityTemplateDriverInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverInfo.class, HibernateActivityTemplateDriverInfo.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDriverInfo.class,
                activityTemplateDriverInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, ActivityTemplateDriverSupport,
            HibernateActivityTemplateDriverSupport> activityTemplateDriverSupportHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverSupport.class, HibernateActivityTemplateDriverSupport.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDriverSupport.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplateDriverSupport, HibernateActivityTemplateDriverSupport>
    activityTemplateDriverSupportHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverSupport.class, HibernateActivityTemplateDriverSupport.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDriverSupport.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplateDriverSupport, HibernateActivityTemplateDriverSupport>
    activityTemplateDriverSupportHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverSupport.class, HibernateActivityTemplateDriverSupport.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateDriverSupport.class,
                activityTemplateDriverSupportPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityTemplateFileInfo,
            HibernateActivityTemplateFileInfo> activityTemplateFileInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateFileInfo.class, HibernateActivityTemplateFileInfo.class, BeanMapper.class
                ),
                HibernateActivityTemplateFileInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplateFileInfo, HibernateActivityTemplateFileInfo>
    activityTemplateFileInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateFileInfo.class, HibernateActivityTemplateFileInfo.class, BeanMapper.class
                ),
                HibernateActivityTemplateFileInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplateFileInfo, HibernateActivityTemplateFileInfo>
    activityTemplateFileInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateFileInfo.class, HibernateActivityTemplateFileInfo.class, BeanMapper.class
                ),
                HibernateActivityTemplateFileInfo.class,
                activityTemplateFileInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<ActivityTemplateParticipantKey, HibernateActivityTemplateParticipantKey,
            ActivityTemplateParticipant, HibernateActivityTemplateParticipant>
    activityTemplateParticipantHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateParticipantKey.class, HibernateActivityTemplateParticipantKey.class,
                        BeanMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ActivityTemplateParticipant.class, HibernateActivityTemplateParticipant.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateParticipant.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplateParticipant, HibernateActivityTemplateParticipant>
    activityTemplateParticipantHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateParticipant.class, HibernateActivityTemplateParticipant.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateParticipant.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplateParticipant, HibernateActivityTemplateParticipant>
    activityTemplateParticipantHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateParticipant.class, HibernateActivityTemplateParticipant.class,
                        BeanMapper.class
                ),
                HibernateActivityTemplateParticipant.class,
                activityTemplateParticipantPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, ActivityTypeIndicator,
            HibernateActivityTypeIndicator> activityTypeIndicatorHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTypeIndicator.class, HibernateActivityTypeIndicator.class, BeanMapper.class
                ),
                HibernateActivityTypeIndicator.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTypeIndicator, HibernateActivityTypeIndicator>
    activityTypeIndicatorHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTypeIndicator.class, HibernateActivityTypeIndicator.class, BeanMapper.class
                ),
                HibernateActivityTypeIndicator.class
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoacKey, HibernatePoacKey, Poac, HibernatePoac> poacHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoacKey.class, HibernatePoacKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Poac.class, HibernatePoac.class, BeanMapper.class),
                HibernatePoac.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poac, HibernatePoac> poacHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poac.class, HibernatePoac.class, BeanMapper.class),
                HibernatePoac.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poac, HibernatePoac> poacHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poac.class, HibernatePoac.class, BeanMapper.class),
                HibernatePoac.class,
                poacPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoadKey, HibernatePoadKey, Poad, HibernatePoad> poadHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoadKey.class, HibernatePoadKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Poad.class, HibernatePoad.class, BeanMapper.class),
                HibernatePoad.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poad, HibernatePoad> poadHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poad.class, HibernatePoad.class, BeanMapper.class),
                HibernatePoad.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poad, HibernatePoad> poadHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poad.class, HibernatePoad.class, BeanMapper.class),
                HibernatePoad.class,
                poadPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoatKey, HibernatePoatKey, Poat, HibernatePoat> poatHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoatKey.class, HibernatePoatKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Poat.class, HibernatePoat.class, BeanMapper.class),
                HibernatePoat.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poat, HibernatePoat> poatHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poat.class, HibernatePoat.class, BeanMapper.class),
                HibernatePoat.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poat, HibernatePoat> poatHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poat.class, HibernatePoat.class, BeanMapper.class),
                HibernatePoat.class,
                poatPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoatacKey, HibernatePoatacKey, Poatac, HibernatePoatac> poatacHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoatacKey.class, HibernatePoatacKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Poatac.class, HibernatePoatac.class, BeanMapper.class),
                HibernatePoatac.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poatac, HibernatePoatac> poatacHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poatac.class, HibernatePoatac.class, BeanMapper.class),
                HibernatePoatac.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poatac, HibernatePoatac> poatacHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poatac.class, HibernatePoatac.class, BeanMapper.class),
                HibernatePoatac.class,
                poatacPresetCriteriaMaker
        );
    }
}
