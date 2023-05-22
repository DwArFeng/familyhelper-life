package com.dwarfeng.familyhelper.life.impl.configuration;

import com.dwarfeng.familyhelper.life.sdk.bean.P01FastJsonMapper;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.life.sdk.bean.key.formatter.PopbStringKeyFormatter;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
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
public class P01CacheConfiguration {

    private final RedisTemplate<String, ?> template;

    @Value("${cache.prefix.entity.user}")
    private String userPrefix;
    @Value("${cache.prefix.entity.popb}")
    private String popbPrefix;
    @Value("${cache.prefix.entity.pb_set}")
    private String pbSetPrefix;
    @Value("${cache.prefix.entity.pb_node}")
    private String pbNodePrefix;
    @Value("${cache.prefix.entity.pb_item}")
    private String pbItemPrefix;
    @Value("${cache.prefix.entity.pb_record}")
    private String pbRecordPrefix;
    @Value("${cache.prefix.entity.pb_file_info}")
    private String pbFileInfoPrefix;

    public P01CacheConfiguration(RedisTemplate<String, ?> template) {
        this.template = template;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, User, FastJsonUser> userRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonUser>) template,
                new StringIdStringKeyFormatter(userPrefix),
                new MapStructBeanTransformer<>(User.class, FastJsonUser.class, P01FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PopbKey, Popb, FastJsonPopb> popbRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPopb>) template,
                new PopbStringKeyFormatter(popbPrefix),
                new MapStructBeanTransformer<>(Popb.class, FastJsonPopb.class, P01FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, PbSet, FastJsonPbSet> pbSetRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPbSet>) template,
                new LongIdStringKeyFormatter(pbSetPrefix),
                new MapStructBeanTransformer<>(PbSet.class, FastJsonPbSet.class, P01FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, PbNode, FastJsonPbNode> pbNodeRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPbNode>) template,
                new LongIdStringKeyFormatter(pbNodePrefix),
                new MapStructBeanTransformer<>(PbNode.class, FastJsonPbNode.class, P01FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, PbItem, FastJsonPbItem> pbItemRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPbItem>) template,
                new LongIdStringKeyFormatter(pbItemPrefix),
                new MapStructBeanTransformer<>(PbItem.class, FastJsonPbItem.class, P01FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, PbRecord, FastJsonPbRecord> pbRecordRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPbRecord>) template,
                new LongIdStringKeyFormatter(pbRecordPrefix),
                new MapStructBeanTransformer<>(PbRecord.class, FastJsonPbRecord.class, P01FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, PbFileInfo, FastJsonPbFileInfo> pbFileInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPbFileInfo>) template,
                new LongIdStringKeyFormatter(pbFileInfoPrefix),
                new MapStructBeanTransformer<>(PbFileInfo.class, FastJsonPbFileInfo.class, P01FastJsonMapper.class)
        );
    }
}
