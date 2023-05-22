package com.dwarfeng.familyhelper.life.impl.configuration;

import com.dwarfeng.familyhelper.life.impl.bean.P01HibernateMapper;
import com.dwarfeng.familyhelper.life.impl.bean.entity.*;
import com.dwarfeng.familyhelper.life.impl.bean.key.HibernatePopbKey;
import com.dwarfeng.familyhelper.life.impl.dao.preset.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
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
public class P01DaoConfiguration {

    private final HibernateTemplate template;

    private final PopbPresetCriteriaMaker popbPresetCriteriaMaker;
    private final PbSetPresetCriteriaMaker pbSetPresetCriteriaMaker;
    private final PbNodePresetCriteriaMaker pbNodePresetCriteriaMaker;
    private final PbItemPresetCriteriaMaker pbItemPresetCriteriaMaker;
    private final PbRecordPresetCriteriaMaker pbRecordPresetCriteriaMaker;
    private final PbFileInfoPresetCriteriaMaker pbFileInfoPresetCriteriaMaker;

    @Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    public P01DaoConfiguration(
            HibernateTemplate template,
            PopbPresetCriteriaMaker popbPresetCriteriaMaker,
            PbSetPresetCriteriaMaker pbSetPresetCriteriaMaker,
            PbNodePresetCriteriaMaker pbNodePresetCriteriaMaker,
            PbItemPresetCriteriaMaker pbItemPresetCriteriaMaker,
            PbRecordPresetCriteriaMaker pbRecordPresetCriteriaMaker,
            PbFileInfoPresetCriteriaMaker pbFileInfoPresetCriteriaMaker
    ) {
        this.template = template;
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
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, P01HibernateMapper.class),
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, P01HibernateMapper.class),
                HibernateUser.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateBatchBaseDao<PopbKey, HibernatePopbKey, Popb, HibernatePopb> popbHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PopbKey.class, HibernatePopbKey.class, P01HibernateMapper.class),
                new MapStructBeanTransformer<>(Popb.class, HibernatePopb.class, P01HibernateMapper.class),
                HibernatePopb.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Popb, HibernatePopb> popbHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Popb.class, HibernatePopb.class, P01HibernateMapper.class),
                HibernatePopb.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Popb, HibernatePopb> popbHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Popb.class, HibernatePopb.class, P01HibernateMapper.class),
                HibernatePopb.class,
                popbPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbSet, HibernatePbSet>
    pbSetHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P01HibernateMapper.class),
                new MapStructBeanTransformer<>(PbSet.class, HibernatePbSet.class, P01HibernateMapper.class),
                HibernatePbSet.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbSet, HibernatePbSet> pbSetHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbSet.class, HibernatePbSet.class, P01HibernateMapper.class),
                HibernatePbSet.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbSet, HibernatePbSet> pbSetHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbSet.class, HibernatePbSet.class, P01HibernateMapper.class),
                HibernatePbSet.class,
                pbSetPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbNode, HibernatePbNode>
    pbNodeHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P01HibernateMapper.class),
                new MapStructBeanTransformer<>(PbNode.class, HibernatePbNode.class, P01HibernateMapper.class),
                HibernatePbNode.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbNode, HibernatePbNode> pbNodeHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbNode.class, HibernatePbNode.class, P01HibernateMapper.class),
                HibernatePbNode.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbNode, HibernatePbNode> pbNodeHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbNode.class, HibernatePbNode.class, P01HibernateMapper.class),
                HibernatePbNode.class,
                pbNodePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbItem, HibernatePbItem>
    pbItemHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P01HibernateMapper.class),
                new MapStructBeanTransformer<>(PbItem.class, HibernatePbItem.class, P01HibernateMapper.class),
                HibernatePbItem.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbItem, HibernatePbItem> pbItemHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbItem.class, HibernatePbItem.class, P01HibernateMapper.class),
                HibernatePbItem.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbItem, HibernatePbItem> pbItemHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbItem.class, HibernatePbItem.class, P01HibernateMapper.class),
                HibernatePbItem.class,
                pbItemPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbRecord, HibernatePbRecord>
    pbRecordHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P01HibernateMapper.class),
                new MapStructBeanTransformer<>(PbRecord.class, HibernatePbRecord.class, P01HibernateMapper.class),
                HibernatePbRecord.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbRecord, HibernatePbRecord> pbRecordHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbRecord.class, HibernatePbRecord.class, P01HibernateMapper.class),
                HibernatePbRecord.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbRecord, HibernatePbRecord> pbRecordHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbRecord.class, HibernatePbRecord.class, P01HibernateMapper.class),
                HibernatePbRecord.class,
                pbRecordPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, PbFileInfo, HibernatePbFileInfo>
    pbFileInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, P01HibernateMapper.class),
                new MapStructBeanTransformer<>(PbFileInfo.class, HibernatePbFileInfo.class, P01HibernateMapper.class),
                HibernatePbFileInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<PbFileInfo, HibernatePbFileInfo> pbFileInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbFileInfo.class, HibernatePbFileInfo.class, P01HibernateMapper.class),
                HibernatePbFileInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<PbFileInfo, HibernatePbFileInfo> pbFileInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(PbFileInfo.class, HibernatePbFileInfo.class, P01HibernateMapper.class),
                HibernatePbFileInfo.class,
                pbFileInfoPresetCriteriaMaker
        );
    }
}
