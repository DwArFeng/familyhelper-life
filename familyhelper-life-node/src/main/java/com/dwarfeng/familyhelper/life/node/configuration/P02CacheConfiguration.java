package com.dwarfeng.familyhelper.life.node.configuration;

import com.dwarfeng.familyhelper.life.sdk.bean.P02FastJsonMapper;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.life.sdk.bean.key.formatter.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.cache.RedisBatchBaseCache;
import com.dwarfeng.subgrade.sdk.redis.formatter.LongIdStringKeyFormatter;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringIdStringKeyFormatter;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class P02CacheConfiguration {

    private final RedisTemplate<String, ?> template;

    @Value("${cache.prefix.entity.activity}")
    private String activityPrefix;
    @Value("${cache.prefix.entity.activity_activity_data_record_relation}")
    private String activityActivityDataRecordRelationPrefix;
    @Value("${cache.prefix.entity.activity_cover_info}")
    private String activityCoverInfoPrefix;
    @Value("${cache.prefix.entity.activity_data_item}")
    private String activityDataItemPrefix;
    @Value("${cache.prefix.entity.activity_data_node}")
    private String activityDataNodePrefix;
    @Value("${cache.prefix.entity.activity_data_record}")
    private String activityDataRecordPrefix;
    @Value("${cache.prefix.entity.activity_data_set}")
    private String activityDataSetPrefix;
    @Value("${cache.prefix.entity.activity_file_info}")
    private String activityFileInfoPrefix;
    @Value("${cache.prefix.entity.activity_participant}")
    private String activityParticipantPrefix;
    @Value("${cache.prefix.entity.activity_template}")
    private String activityTemplatePrefix;
    @Value("${cache.prefix.entity.activity_template_activity_data_item_relation}")
    private String activityTemplateActivityDataItemRelationPrefix;
    @Value("${cache.prefix.entity.activity_template_cover_info}")
    private String activityTemplateCoverInfoPrefix;
    @Value("${cache.prefix.entity.activity_template_driver_info}")
    private String activityTemplateDriverInfoPrefix;
    @Value("${cache.prefix.entity.activity_template_driver_support}")
    private String activityTemplateDriverSupportPrefix;
    @Value("${cache.prefix.entity.activity_template_file_info}")
    private String activityTemplateFileInfoPrefix;
    @Value("${cache.prefix.entity.activity_template_participant}")
    private String activityTemplateParticipantPrefix;
    @Value("${cache.prefix.entity.activity_type_indicator}")
    private String activityTypeIndicatorPrefix;
    @Value("${cache.prefix.entity.poac}")
    private String poacPrefix;
    @Value("${cache.prefix.entity.poad}")
    private String poadPrefix;
    @Value("${cache.prefix.entity.poat}")
    private String poatPrefix;
    @Value("${cache.prefix.entity.poatac}")
    private String poatacPrefix;

    public P02CacheConfiguration(RedisTemplate<String, ?> template) {
        this.template = template;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, Activity, FastJsonActivity> activityRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivity>) template,
                new LongIdStringKeyFormatter(activityPrefix),
                new MapStructBeanTransformer<>(Activity.class, FastJsonActivity.class, P02FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongLongRelationKey, ActivityActivityDataRecordRelation,
            FastJsonActivityActivityDataRecordRelation> activityActivityDataRecordRelationRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityActivityDataRecordRelation>) template,
                new LongLongRelationStringKeyFormatter(activityActivityDataRecordRelationPrefix),
                new MapStructBeanTransformer<>(
                        ActivityActivityDataRecordRelation.class, FastJsonActivityActivityDataRecordRelation.class,
                        P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityCoverInfo, FastJsonActivityCoverInfo>
    activityCoverInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityCoverInfo>) template,
                new LongIdStringKeyFormatter(activityCoverInfoPrefix),
                new MapStructBeanTransformer<>(
                        ActivityCoverInfo.class, FastJsonActivityCoverInfo.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityDataItem, FastJsonActivityDataItem>
    activityDataItemRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityDataItem>) template,
                new LongIdStringKeyFormatter(activityDataItemPrefix),
                new MapStructBeanTransformer<>(
                        ActivityDataItem.class, FastJsonActivityDataItem.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityDataNode, FastJsonActivityDataNode>
    activityDataNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityDataNode>) template,
                new LongIdStringKeyFormatter(activityDataNodePrefix),
                new MapStructBeanTransformer<>(
                        ActivityDataNode.class, FastJsonActivityDataNode.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityDataRecord, FastJsonActivityDataRecord>
    activityDataRecordRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityDataRecord>) template,
                new LongIdStringKeyFormatter(activityDataRecordPrefix),
                new MapStructBeanTransformer<>(
                        ActivityDataRecord.class, FastJsonActivityDataRecord.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityDataSet, FastJsonActivityDataSet>
    activityDataSetRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityDataSet>) template,
                new LongIdStringKeyFormatter(activityDataSetPrefix),
                new MapStructBeanTransformer<>(
                        ActivityDataSet.class, FastJsonActivityDataSet.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityFileInfo, FastJsonActivityFileInfo>
    activityFileInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityFileInfo>) template,
                new LongIdStringKeyFormatter(activityFileInfoPrefix),
                new MapStructBeanTransformer<>(
                        ActivityFileInfo.class, FastJsonActivityFileInfo.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<ActivityParticipantKey, ActivityParticipant, FastJsonActivityParticipant>
    activityParticipantRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityParticipant>) template,
                new ActivityParticipantStringKeyFormatter(activityParticipantPrefix),
                new MapStructBeanTransformer<>(
                        ActivityParticipant.class, FastJsonActivityParticipant.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityTemplate, FastJsonActivityTemplate>
    activityTemplateRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTemplate>) template,
                new LongIdStringKeyFormatter(activityTemplatePrefix),
                new MapStructBeanTransformer<>(
                        ActivityTemplate.class, FastJsonActivityTemplate.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongLongRelationKey, ActivityTemplateActivityDataItemRelation,
            FastJsonActivityTemplateActivityDataItemRelation>
    activityTemplateActivityDataItemRelationRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTemplateActivityDataItemRelation>) template,
                new LongLongRelationStringKeyFormatter(activityTemplateActivityDataItemRelationPrefix),
                new MapStructBeanTransformer<>(
                        ActivityTemplateActivityDataItemRelation.class,
                        FastJsonActivityTemplateActivityDataItemRelation.class,
                        P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityTemplateCoverInfo, FastJsonActivityTemplateCoverInfo>
    activityTemplateCoverInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTemplateCoverInfo>) template,
                new LongIdStringKeyFormatter(activityTemplateCoverInfoPrefix),
                new MapStructBeanTransformer<>(
                        ActivityTemplateCoverInfo.class, FastJsonActivityTemplateCoverInfo.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityTemplateDriverInfo, FastJsonActivityTemplateDriverInfo>
    activityTemplateDriverInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTemplateDriverInfo>) template,
                new LongIdStringKeyFormatter(activityTemplateDriverInfoPrefix),
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverInfo.class, FastJsonActivityTemplateDriverInfo.class,
                        P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, ActivityTemplateDriverSupport, FastJsonActivityTemplateDriverSupport>
    activityTemplateDriverSupportRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTemplateDriverSupport>) template,
                new StringIdStringKeyFormatter(activityTemplateDriverSupportPrefix),
                new MapStructBeanTransformer<>(
                        ActivityTemplateDriverSupport.class, FastJsonActivityTemplateDriverSupport.class,
                        P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, ActivityTemplateFileInfo, FastJsonActivityTemplateFileInfo>
    activityTemplateFileInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTemplateFileInfo>) template,
                new LongIdStringKeyFormatter(activityTemplateFileInfoPrefix),
                new MapStructBeanTransformer<>(
                        ActivityTemplateFileInfo.class, FastJsonActivityTemplateFileInfo.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<ActivityTemplateParticipantKey, ActivityTemplateParticipant,
            FastJsonActivityTemplateParticipant> activityTemplateParticipantRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTemplateParticipant>) template,
                new ActivityTemplateParticipantStringKeyFormatter(activityTemplateParticipantPrefix),
                new MapStructBeanTransformer<>(
                        ActivityTemplateParticipant.class, FastJsonActivityTemplateParticipant.class,
                        P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, ActivityTypeIndicator, FastJsonActivityTypeIndicator>
    activityTypeIndicatorRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonActivityTypeIndicator>) template,
                new StringIdStringKeyFormatter(activityTypeIndicatorPrefix),
                new MapStructBeanTransformer<>(
                        ActivityTypeIndicator.class, FastJsonActivityTypeIndicator.class, P02FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PoacKey, Poac, FastJsonPoac> poacRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPoac>) template,
                new PoacStringKeyFormatter(poacPrefix),
                new MapStructBeanTransformer<>(Poac.class, FastJsonPoac.class, P02FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PoadKey, Poad, FastJsonPoad> poadRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPoad>) template,
                new PoadStringKeyFormatter(poadPrefix),
                new MapStructBeanTransformer<>(Poad.class, FastJsonPoad.class, P02FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PoatKey, Poat, FastJsonPoat> poatRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPoat>) template,
                new PoatStringKeyFormatter(poatPrefix),
                new MapStructBeanTransformer<>(Poat.class, FastJsonPoat.class, P02FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PoatacKey, Poatac, FastJsonPoatac> poatacRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPoatac>) template,
                new PoatacStringKeyFormatter(poatacPrefix),
                new MapStructBeanTransformer<>(Poatac.class, FastJsonPoatac.class, P02FastJsonMapper.class)
        );
    }
}
