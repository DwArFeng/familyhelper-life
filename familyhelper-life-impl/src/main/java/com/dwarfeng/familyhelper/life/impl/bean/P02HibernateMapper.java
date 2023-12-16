package com.dwarfeng.familyhelper.life.impl.bean;

import com.dwarfeng.familyhelper.life.impl.bean.entity.*;
import com.dwarfeng.familyhelper.life.impl.bean.key.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Hibernate Bean 映射器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
@Mapper
public interface P02HibernateMapper {

    HibernateLongIdKey longIdKeyToHibernate(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromHibernate(HibernateLongIdKey hibernateLongIdKey);

    HibernateStringIdKey stringIdKeyToHibernate(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromHibernate(HibernateStringIdKey hibernateStringIdKey);

    HibernateActivityParticipantKey activityParticipantKeyToHibernate(ActivityParticipantKey activityParticipantKey);

    @InheritInverseConfiguration
    ActivityParticipantKey activityParticipantKeyFromHibernate(
            HibernateActivityParticipantKey hibernateActivityParticipantKey
    );

    HibernateActivityTemplateParticipantKey activityTemplateParticipantKeyToHibernate(
            ActivityTemplateParticipantKey activityTemplateParticipantKey
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipantKey activityTemplateParticipantKeyFromHibernate(
            HibernateActivityTemplateParticipantKey hibernateActivityTemplateParticipantKey
    );

    HibernatePoacKey poacKeyToHibernate(PoacKey poacKey);

    @InheritInverseConfiguration
    PoacKey poacKeyFromHibernate(HibernatePoacKey hibernatePoacKey);

    HibernatePoadKey poadKeyToHibernate(PoadKey poadKey);

    @InheritInverseConfiguration
    PoadKey poadKeyFromHibernate(HibernatePoadKey hibernatePoadKey);

    HibernatePoatacKey poatacKeyToHibernate(PoatacKey poatacKey);

    @InheritInverseConfiguration
    PoatacKey poatacKeyFromHibernate(HibernatePoatacKey hibernatePoatacKey);

    HibernatePoatKey poatKeyToHibernate(PoatKey poatKey);

    @InheritInverseConfiguration
    PoatKey poatKeyFromHibernate(HibernatePoatKey hibernatePoatKey);

    @Mapping(target = "poacs", ignore = true)
    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityParticipants", ignore = true)
    @Mapping(target = "activityFileInfos", ignore = true)
    @Mapping(target = "activityDataRecords", ignore = true)
    @Mapping(target = "activityCoverInfos", ignore = true)
    HibernateActivity activityToHibernate(Activity activity);

    @InheritInverseConfiguration
    Activity activityFromHibernate(HibernateActivity hibernateActivity);

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityLongId", ignore = true)
    @Mapping(target = "activity", ignore = true)
    HibernateActivityCoverInfo activityCoverInfoToHibernate(ActivityCoverInfo activityCoverInfo);

    @InheritInverseConfiguration
    ActivityCoverInfo activityCoverInfoFromHibernate(HibernateActivityCoverInfo hibernateActivityCoverInfo);

    @Mapping(target = "setLongId", ignore = true)
    @Mapping(target = "records", ignore = true)
    @Mapping(target = "nodeLongId", ignore = true)
    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityTemplateDataInfos", ignore = true)
    @Mapping(target = "activityDataSet", ignore = true)
    @Mapping(target = "activityDataNode", ignore = true)
    HibernateActivityDataItem activityDataItemToHibernate(ActivityDataItem activityDataItem);

    @InheritInverseConfiguration
    ActivityDataItem activityDataItemFromHibernate(HibernateActivityDataItem hibernateActivityDataItem);

    @Mapping(target = "setLongId", ignore = true)
    @Mapping(target = "parentLongId", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityDataSet", ignore = true)
    @Mapping(target = "activityDataItems", ignore = true)
    HibernateActivityDataNode activityDataNodeToHibernate(ActivityDataNode activityDataNode);

    @InheritInverseConfiguration
    ActivityDataNode activityDataNodeFromHibernate(HibernateActivityDataNode hibernateActivityDataNode);

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "itemLongId", ignore = true)
    @Mapping(target = "activityLongId", ignore = true)
    @Mapping(target = "activityDataItem", ignore = true)
    @Mapping(target = "activity", ignore = true)
    HibernateActivityDataRecord activityDataRecordToHibernate(ActivityDataRecord activityDataRecord);

    @InheritInverseConfiguration
    ActivityDataRecord activityDataRecordFromHibernate(HibernateActivityDataRecord hibernateActivityDataRecord);

    @Mapping(target = "popbs", ignore = true)
    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityDataNodes", ignore = true)
    @Mapping(target = "activityDataItems", ignore = true)
    HibernateActivityDataSet activityDataSetToHibernate(ActivityDataSet activityDataSet);

    @InheritInverseConfiguration
    ActivityDataSet activityDataSetFromHibernate(HibernateActivityDataSet hibernateActivityDataSet);

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityLongId", ignore = true)
    @Mapping(target = "activity", ignore = true)
    HibernateActivityFileInfo activityFileInfoToHibernate(ActivityFileInfo activityFileInfo);

    @InheritInverseConfiguration
    ActivityFileInfo activityFileInfoFromHibernate(HibernateActivityFileInfo hibernateActivityFileInfo);

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "activityLongId", ignore = true)
    @Mapping(target = "activity", ignore = true)
    HibernateActivityParticipant activityParticipantToHibernate(ActivityParticipant activityParticipant);

    @InheritInverseConfiguration
    ActivityParticipant activityParticipantFromHibernate(HibernateActivityParticipant hibernateActivityParticipant);

    @Mapping(target = "poats", ignore = true)
    @Mapping(target = "poatacs", ignore = true)
    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityTemplateParticipants", ignore = true)
    @Mapping(target = "activityTemplateFileInfos", ignore = true)
    @Mapping(target = "activityTemplateDriverInfos", ignore = true)
    @Mapping(target = "activityTemplateDataInfos", ignore = true)
    @Mapping(target = "activityTemplateCoverInfos", ignore = true)
    HibernateActivityTemplate activityTemplateToHibernate(ActivityTemplate activityTemplate);

    @InheritInverseConfiguration
    ActivityTemplate activityTemplateFromHibernate(HibernateActivityTemplate hibernateActivityTemplate);

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityTemplateLongId", ignore = true)
    @Mapping(target = "activityTemplate", ignore = true)
    HibernateActivityTemplateCoverInfo activityTemplateCoverInfoToHibernate(
            ActivityTemplateCoverInfo activityTemplateCoverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateCoverInfo activityTemplateCoverInfoFromHibernate(
            HibernateActivityTemplateCoverInfo hibernateActivityTemplateCoverInfo
    );

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityTemplateLongId", ignore = true)
    @Mapping(target = "activityTemplate", ignore = true)
    @Mapping(target = "activityDataItemLongId", ignore = true)
    @Mapping(target = "activityDataItem", ignore = true)
    HibernateActivityTemplateDataInfo activityTemplateDataInfoToHibernate(
            ActivityTemplateDataInfo activityTemplateDataInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDataInfo activityTemplateDataInfoFromHibernate(
            HibernateActivityTemplateDataInfo hibernateActivityTemplateDataInfo
    );

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityTemplateLongId", ignore = true)
    @Mapping(target = "activityTemplate", ignore = true)
    HibernateActivityTemplateDriverInfo activityTemplateDriverInfoToHibernate(
            ActivityTemplateDriverInfo activityTemplateDriverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDriverInfo activityTemplateDriverInfoFromHibernate(
            HibernateActivityTemplateDriverInfo hibernateActivityTemplateDriverInfo
    );

    @Mapping(target = "stringId", ignore = true)
    HibernateActivityTemplateDriverSupport activityTemplateDriverSupportToHibernate(
            ActivityTemplateDriverSupport activityTemplateDriverSupport
    );

    @InheritInverseConfiguration
    ActivityTemplateDriverSupport activityTemplateDriverSupportFromHibernate(
            HibernateActivityTemplateDriverSupport hibernateActivityTemplateDriverSupport
    );

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "activityTemplateLongId", ignore = true)
    @Mapping(target = "activityTemplate", ignore = true)
    HibernateActivityTemplateFileInfo activityTemplateFileInfoToHibernate(
            ActivityTemplateFileInfo activityTemplateFileInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateFileInfo activityTemplateFileInfoFromHibernate(
            HibernateActivityTemplateFileInfo hibernateActivityTemplateFileInfo
    );

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "activityTemplateLongId", ignore = true)
    @Mapping(target = "activityTemplate", ignore = true)
    HibernateActivityTemplateParticipant activityTemplateParticipantToHibernate(
            ActivityTemplateParticipant activityTemplateParticipant
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipant activityTemplateParticipantFromHibernate(
            HibernateActivityTemplateParticipant hibernateActivityTemplateParticipant
    );

    @Mapping(target = "stringId", ignore = true)
    HibernateActivityTypeIndicator activityTypeIndicatorToHibernate(ActivityTypeIndicator activityTypeIndicator);

    @InheritInverseConfiguration
    ActivityTypeIndicator activityTypeIndicatorFromHibernate(
            HibernateActivityTypeIndicator hibernateActivityTypeIndicator
    );

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "activityLongId", ignore = true)
    @Mapping(target = "activity", ignore = true)
    HibernatePoac poacToHibernate(Poac poac);

    @InheritInverseConfiguration
    Poac poacFromHibernate(HibernatePoac hibernatePoac);

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "activityDataSetLongId", ignore = true)
    @Mapping(target = "activityDataSet", ignore = true)
    HibernatePoad poadToHibernate(Poad poad);

    @InheritInverseConfiguration
    Poad poadFromHibernate(HibernatePoad hibernatePoad);

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "activityTemplateLongId", ignore = true)
    @Mapping(target = "activityTemplate", ignore = true)
    HibernatePoat poatToHibernate(Poat poat);

    @InheritInverseConfiguration
    Poat poatFromHibernate(HibernatePoat hibernatePoat);

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "activityTemplateLongId", ignore = true)
    @Mapping(target = "activityTemplate", ignore = true)
    HibernatePoatac poatacToHibernate(Poatac poatac);

    @InheritInverseConfiguration
    Poatac poatacFromHibernate(HibernatePoatac hibernatePoatac);
}
