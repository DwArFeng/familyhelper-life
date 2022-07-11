package com.dwarfeng.familyhelper.life.impl.configuration;

import com.dwarfeng.familyhelper.life.impl.bean.entity.*;
import com.dwarfeng.familyhelper.life.impl.bean.key.HibernatePopbKey;
import com.dwarfeng.familyhelper.life.impl.dao.preset.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.impl.bean.DozerBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class DaoConfiguration {

    private final HibernateTemplate template;
    private final Mapper mapper;

    private final PopbPresetCriteriaMaker popbPresetCriteriaMaker;
    private final PbSetPresetCriteriaMaker pbSetPresetCriteriaMaker;
    private final PbNodePresetCriteriaMaker pbNodePresetCriteriaMaker;
    private final PbItemPresetCriteriaMaker pbItemPresetCriteriaMaker;
    private final PbRecordPresetCriteriaMaker pbRecordPresetCriteriaMaker;
    private final PbFileInfoPresetCriteriaMaker pbFileInfoPresetCriteriaMaker;

    @Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    public DaoConfiguration(
            HibernateTemplate template, Mapper mapper,
            PopbPresetCriteriaMaker popbPresetCriteriaMaker,
            PbSetPresetCriteriaMaker pbSetPresetCriteriaMaker,
            PbNodePresetCriteriaMaker pbNodePresetCriteriaMaker,
            PbItemPresetCriteriaMaker pbItemPresetCriteriaMaker,
            PbRecordPresetCriteriaMaker pbRecordPresetCriteriaMaker,
            PbFileInfoPresetCriteriaMaker pbFileInfoPresetCriteriaMaker
    ) {
        this.template = template;
        this.mapper = mapper;
        this.popbPresetCriteriaMaker = popbPresetCriteriaMaker;
        this.pbSetPresetCriteriaMaker = pbSetPresetCriteriaMaker;
        this.pbNodePresetCriteriaMaker = pbNodePresetCriteriaMaker;
        this.pbItemPresetCriteriaMaker = pbItemPresetCriteriaMaker;
        this.pbRecordPresetCriteriaMaker = pbRecordPresetCriteriaMaker;
        this.pbFileInfoPresetCriteriaMaker = pbFileInfoPresetCriteriaMaker;
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, User, HibernateUser> userHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, mapper),
                new DozerBeanTransformer<>(User.class, HibernateUser.class, mapper),
                HibernateUser.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateBatchBaseDao<PopbKey, HibernatePopbKey, Popb, HibernatePopb> popbHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(PopbKey.class, HibernatePopbKey.class, mapper),
                new DozerBeanTransformer<>(Popb.class, HibernatePopb.class, mapper),
                HibernatePopb.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Popb, HibernatePopb> popbHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(Popb.class, HibernatePopb.class, mapper),
                HibernatePopb.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Popb, HibernatePopb> popbHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(Popb.class, HibernatePopb.class, mapper),
                HibernatePopb.class,
                popbPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbSet, HibernatePbSet>
    pbSetHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(PbSet.class, HibernatePbSet.class, mapper),
                HibernatePbSet.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbSet, HibernatePbSet> pbSetHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbSet.class, HibernatePbSet.class, mapper),
                HibernatePbSet.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbSet, HibernatePbSet> pbSetHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbSet.class, HibernatePbSet.class, mapper),
                HibernatePbSet.class,
                pbSetPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbNode, HibernatePbNode>
    pbNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(PbNode.class, HibernatePbNode.class, mapper),
                HibernatePbNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbNode, HibernatePbNode> pbNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbNode.class, HibernatePbNode.class, mapper),
                HibernatePbNode.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbNode, HibernatePbNode> pbNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbNode.class, HibernatePbNode.class, mapper),
                HibernatePbNode.class,
                pbNodePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbItem, HibernatePbItem>
    pbItemHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(PbItem.class, HibernatePbItem.class, mapper),
                HibernatePbItem.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbItem, HibernatePbItem> pbItemHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbItem.class, HibernatePbItem.class, mapper),
                HibernatePbItem.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbItem, HibernatePbItem> pbItemHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbItem.class, HibernatePbItem.class, mapper),
                HibernatePbItem.class,
                pbItemPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbRecord, HibernatePbRecord>
    pbRecordHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(PbRecord.class, HibernatePbRecord.class, mapper),
                HibernatePbRecord.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbRecord, HibernatePbRecord> pbRecordHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbRecord.class, HibernatePbRecord.class, mapper),
                HibernatePbRecord.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbRecord, HibernatePbRecord> pbRecordHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbRecord.class, HibernatePbRecord.class, mapper),
                HibernatePbRecord.class,
                pbRecordPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbFileInfo, HibernatePbFileInfo>
    pbFileInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(PbFileInfo.class, HibernatePbFileInfo.class, mapper),
                HibernatePbFileInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbFileInfo, HibernatePbFileInfo> pbFileInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbFileInfo.class, HibernatePbFileInfo.class, mapper),
                HibernatePbFileInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbFileInfo, HibernatePbFileInfo> pbFileInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(PbFileInfo.class, HibernatePbFileInfo.class, mapper),
                HibernatePbFileInfo.class,
                pbFileInfoPresetCriteriaMaker
        );
    }
}
