package com.dwarfeng.familyhelper.life.node.configuration;

import com.dwarfeng.familyhelper.life.impl.bean.P02HibernateMapper;
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
    private final ActivityActivityDataRecordRelationPresetCriteriaMaker activityActivityDataRecordRelationPresetCriteriaMaker;
    private final ActivityCoverInfoPresetCriteriaMaker activityCoverInfoPresetCriteriaMaker;
    private final ActivityDataItemPresetCriteriaMaker activityDataItemPresetCriteriaMaker;
    private final ActivityDataNodePresetCriteriaMaker activityDataNodePresetCriteriaMaker;
    private final ActivityDataRecordPresetCriteriaMaker activityDataRecordPresetCriteriaMaker;
    private final ActivityDataSetPresetCriteriaMaker activityDataSetPresetCriteriaMaker;
    private final ActivityFileInfoPresetCriteriaMaker activityFileInfoPresetCriteriaMaker;
    private final ActivityParticipantPresetCriteriaMaker activityParticipantPresetCriteriaMaker;
    private final ActivityTemplatePresetCriteriaMaker activityTemplatePresetCriteriaMaker;
    private final ActivityTemplateActivityDataItemRelationPresetCriteriaMaker activityTemplateActivityDataItemRelationPresetCriteriaMaker;
    private final ActivityTemplateCoverInfoPresetCriteriaMaker activityTemplateCoverInfoPresetCriteriaMaker;
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
            ActivityActivityDataRecordRelationPresetCriteriaMaker activityActivityDataRecordRelationPresetCriteriaMaker,
            ActivityCoverInfoPresetCriteriaMaker activityCoverInfoPresetCriteriaMaker,
            ActivityDataItemPresetCriteriaMaker activityDataItemPresetCriteriaMaker,
            ActivityDataNodePresetCriteriaMaker activityDataNodePresetCriteriaMaker,
            ActivityDataRecordPresetCriteriaMaker activityDataRecordPresetCriteriaMaker,
            ActivityDataSetPresetCriteriaMaker activityDataSetPresetCriteriaMaker,
            ActivityFileInfoPresetCriteriaMaker activityFileInfoPresetCriteriaMaker,
            ActivityParticipantPresetCriteriaMaker activityParticipantPresetCriteriaMaker,
            ActivityTemplatePresetCriteriaMaker activityTemplatePresetCriteriaMaker,
            ActivityTemplateActivityDataItemRelationPresetCriteriaMaker
                    activityTemplateActivityDataItemRelationPresetCriteriaMaker,
            ActivityTemplateCoverInfoPresetCriteriaMaker activityTemplateCoverInfoPresetCriteriaMaker,
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
        this.activityActivityDataRecordRelationPresetCriteriaMaker =
                activityActivityDataRecordRelationPresetCriteriaMaker;
        this.activityCoverInfoPresetCriteriaMaker = activityCoverInfoPresetCriteriaMaker;
        this.activityDataItemPresetCriteriaMaker = activityDataItemPresetCriteriaMaker;
        this.activityDataNodePresetCriteriaMaker = activityDataNodePresetCriteriaMaker;
        this.activityDataRecordPresetCriteriaMaker = activityDataRecordPresetCriteriaMaker;
        this.activityDataSetPresetCriteriaMaker = activityDataSetPresetCriteriaMaker;
        this.activityFileInfoPresetCriteriaMaker = activityFileInfoPresetCriteriaMaker;
        this.activityParticipantPresetCriteriaMaker = activityParticipantPresetCriteriaMaker;
        this.activityTemplatePresetCriteriaMaker = activityTemplatePresetCriteriaMaker;
        this.activityTemplateActivityDataItemRelationPresetCriteriaMaker =
                activityTemplateActivityDataItemRelationPresetCriteriaMaker;
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(Activity.class, HibernateActivity.class, P02HibernateMapper.class),
                HibernateActivity.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Activity, HibernateActivity> activityHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Activity.class, HibernateActivity.class, P02HibernateMapper.class),
                HibernateActivity.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Activity, HibernateActivity> activityHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Activity.class, HibernateActivity.class, P02HibernateMapper.class),
                HibernateActivity.class,
                activityPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongLongRelationKey, HibernateLongLongRelationKey, ActivityActivityDataRecordRelation,
            HibernateActivityActivityDataRecordRelation> activityActivityDataRecordRelationHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        LongLongRelationKey.class, HibernateLongLongRelationKey.class, P02HibernateMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ActivityActivityDataRecordRelation.class, HibernateActivityActivityDataRecordRelation.class,
                        P02HibernateMapper.class
                ),
                HibernateActivityActivityDataRecordRelation.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityActivityDataRecordRelation, HibernateActivityActivityDataRecordRelation>
    activityActivityDataRecordRelationHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityActivityDataRecordRelation.class, HibernateActivityActivityDataRecordRelation.class,
                        P02HibernateMapper.class
                ),
                HibernateActivityActivityDataRecordRelation.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityActivityDataRecordRelation, HibernateActivityActivityDataRecordRelation>
    activityActivityDataRecordRelationHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityActivityDataRecordRelation.class, HibernateActivityActivityDataRecordRelation.class,
                        P02HibernateMapper.class
                ),
                HibernateActivityActivityDataRecordRelation.class,
                activityActivityDataRecordRelationPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityCoverInfo, HibernateActivityCoverInfo>
    activityCoverInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityCoverInfo.class, HibernateActivityCoverInfo.class, P02HibernateMapper.class
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
                        ActivityCoverInfo.class, HibernateActivityCoverInfo.class, P02HibernateMapper.class
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
                        ActivityCoverInfo.class, HibernateActivityCoverInfo.class, P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataItem.class, HibernateActivityDataItem.class, P02HibernateMapper.class
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
                        ActivityDataItem.class, HibernateActivityDataItem.class, P02HibernateMapper.class
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
                        ActivityDataItem.class, HibernateActivityDataItem.class, P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataNode.class, HibernateActivityDataNode.class, P02HibernateMapper.class
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
                        ActivityDataNode.class, HibernateActivityDataNode.class, P02HibernateMapper.class
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
                        ActivityDataNode.class, HibernateActivityDataNode.class, P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataRecord.class, HibernateActivityDataRecord.class, P02HibernateMapper.class
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
                        ActivityDataRecord.class, HibernateActivityDataRecord.class, P02HibernateMapper.class
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
                        ActivityDataRecord.class, HibernateActivityDataRecord.class, P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityDataSet.class, HibernateActivityDataSet.class, P02HibernateMapper.class
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
                        ActivityDataSet.class, HibernateActivityDataSet.class, P02HibernateMapper.class
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
                        ActivityDataSet.class, HibernateActivityDataSet.class, P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityFileInfo.class, HibernateActivityFileInfo.class, P02HibernateMapper.class
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
                        ActivityFileInfo.class, HibernateActivityFileInfo.class, P02HibernateMapper.class
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
                        ActivityFileInfo.class, HibernateActivityFileInfo.class, P02HibernateMapper.class
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
                        ActivityParticipantKey.class, HibernateActivityParticipantKey.class, P02HibernateMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ActivityParticipant.class, HibernateActivityParticipant.class, P02HibernateMapper.class
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
                        ActivityParticipant.class, HibernateActivityParticipant.class, P02HibernateMapper.class
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
                        ActivityParticipant.class, HibernateActivityParticipant.class, P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplate.class, HibernateActivityTemplate.class, P02HibernateMapper.class
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
                        ActivityTemplate.class, HibernateActivityTemplate.class, P02HibernateMapper.class
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
                        ActivityTemplate.class, HibernateActivityTemplate.class, P02HibernateMapper.class
                ),
                HibernateActivityTemplate.class,
                activityTemplatePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongLongRelationKey, HibernateLongLongRelationKey,
            ActivityTemplateActivityDataItemRelation, HibernateActivityTemplateActivityDataItemRelation>
    activityTemplateActivityDataItemRelationHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(
                        LongLongRelationKey.class, HibernateLongLongRelationKey.class, P02HibernateMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ActivityTemplateActivityDataItemRelation.class,
                        HibernateActivityTemplateActivityDataItemRelation.class, P02HibernateMapper.class
                ),
                HibernateActivityTemplateActivityDataItemRelation.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<ActivityTemplateActivityDataItemRelation,
            HibernateActivityTemplateActivityDataItemRelation>
    activityTemplateActivityDataItemRelationHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateActivityDataItemRelation.class,
                        HibernateActivityTemplateActivityDataItemRelation.class, P02HibernateMapper.class
                ),
                HibernateActivityTemplateActivityDataItemRelation.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<ActivityTemplateActivityDataItemRelation,
            HibernateActivityTemplateActivityDataItemRelation>
    activityTemplateActivityDataItemRelationHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        ActivityTemplateActivityDataItemRelation.class,
                        HibernateActivityTemplateActivityDataItemRelation.class, P02HibernateMapper.class
                ),
                HibernateActivityTemplateActivityDataItemRelation.class,
                activityTemplateActivityDataItemRelationPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityTemplateCoverInfo,
            HibernateActivityTemplateCoverInfo> activityTemplateCoverInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateCoverInfo.class, HibernateActivityTemplateCoverInfo.class,
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
                ),
                HibernateActivityTemplateCoverInfo.class,
                activityTemplateCoverInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, ActivityTemplateDriverInfo,
            HibernateActivityTemplateDriverInfo> activityTemplateDriverInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverInfo.class, HibernateActivityTemplateDriverInfo.class,
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverSupport.class, HibernateActivityTemplateDriverSupport.class,
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTemplateFileInfo.class, HibernateActivityTemplateFileInfo.class, P02HibernateMapper.class
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
                        ActivityTemplateFileInfo.class, HibernateActivityTemplateFileInfo.class, P02HibernateMapper.class
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
                        ActivityTemplateFileInfo.class, HibernateActivityTemplateFileInfo.class, P02HibernateMapper.class
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
                        P02HibernateMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ActivityTemplateParticipant.class, HibernateActivityTemplateParticipant.class,
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
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
                        P02HibernateMapper.class
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
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        ActivityTypeIndicator.class, HibernateActivityTypeIndicator.class, P02HibernateMapper.class
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
                        ActivityTypeIndicator.class, HibernateActivityTypeIndicator.class, P02HibernateMapper.class
                ),
                HibernateActivityTypeIndicator.class
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoacKey, HibernatePoacKey, Poac, HibernatePoac> poacHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoacKey.class, HibernatePoacKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(Poac.class, HibernatePoac.class, P02HibernateMapper.class),
                HibernatePoac.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poac, HibernatePoac> poacHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poac.class, HibernatePoac.class, P02HibernateMapper.class),
                HibernatePoac.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poac, HibernatePoac> poacHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poac.class, HibernatePoac.class, P02HibernateMapper.class),
                HibernatePoac.class,
                poacPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoadKey, HibernatePoadKey, Poad, HibernatePoad> poadHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoadKey.class, HibernatePoadKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(Poad.class, HibernatePoad.class, P02HibernateMapper.class),
                HibernatePoad.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poad, HibernatePoad> poadHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poad.class, HibernatePoad.class, P02HibernateMapper.class),
                HibernatePoad.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poad, HibernatePoad> poadHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poad.class, HibernatePoad.class, P02HibernateMapper.class),
                HibernatePoad.class,
                poadPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoatKey, HibernatePoatKey, Poat, HibernatePoat> poatHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoatKey.class, HibernatePoatKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(Poat.class, HibernatePoat.class, P02HibernateMapper.class),
                HibernatePoat.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poat, HibernatePoat> poatHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poat.class, HibernatePoat.class, P02HibernateMapper.class),
                HibernatePoat.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poat, HibernatePoat> poatHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poat.class, HibernatePoat.class, P02HibernateMapper.class),
                HibernatePoat.class,
                poatPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoatacKey, HibernatePoatacKey, Poatac, HibernatePoatac> poatacHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoatacKey.class, HibernatePoatacKey.class, P02HibernateMapper.class),
                new MapStructBeanTransformer<>(Poatac.class, HibernatePoatac.class, P02HibernateMapper.class),
                HibernatePoatac.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poatac, HibernatePoatac> poatacHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poatac.class, HibernatePoatac.class, P02HibernateMapper.class),
                HibernatePoatac.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poatac, HibernatePoatac> poatacHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poatac.class, HibernatePoatac.class, P02HibernateMapper.class),
                HibernatePoatac.class,
                poatacPresetCriteriaMaker
        );
    }
}
