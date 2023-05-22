package com.dwarfeng.familyhelper.life.sdk.bean;

import com.dwarfeng.familyhelper.life.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.life.sdk.bean.key.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * FastJson Bean 映射器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
@Mapper
public interface P02FastJsonMapper {

    FastJsonLongIdKey longIdKeyToFastJson(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromFastJson(FastJsonLongIdKey fastJsonLongIdKey);

    FastJsonStringIdKey stringIdKeyToFastJson(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromFastJson(FastJsonStringIdKey fastJsonStringIdKey);

    FastJsonActivityParticipantKey activityParticipantKeyToFastJson(ActivityParticipantKey activityParticipantKey);

    @InheritInverseConfiguration
    ActivityParticipantKey activityParticipantKeyFromFastJson(
            FastJsonActivityParticipantKey fastJsonActivityParticipantKey
    );

    FastJsonActivityTemplateParticipantKey activityTemplateParticipantKeyToFastJson(
            ActivityTemplateParticipantKey activityTemplateParticipantKey
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipantKey activityTemplateParticipantKeyFromFastJson(
            FastJsonActivityTemplateParticipantKey fastJsonActivityTemplateParticipantKey
    );

    FastJsonLongLongRelationKey longLongRelationKeyToFastJson(LongLongRelationKey longLongRelationKey);

    @InheritInverseConfiguration
    LongLongRelationKey longLongRelationKeyFromFastJson(FastJsonLongLongRelationKey fastJsonLongLongRelationKey);

    FastJsonPoacKey poacKeyToFastJson(PoacKey poacKey);

    @InheritInverseConfiguration
    PoacKey poacKeyFromFastJson(FastJsonPoacKey fastJsonPoacKey);

    FastJsonPoadKey poadKeyToFastJson(PoadKey poadKey);

    @InheritInverseConfiguration
    PoadKey poadKeyFromFastJson(FastJsonPoadKey fastJsonPoadKey);

    FastJsonPoatacKey poatacKeyToFastJson(PoatacKey poatacKey);

    @InheritInverseConfiguration
    PoatacKey poatacKeyFromFastJson(FastJsonPoatacKey fastJsonPoatacKey);

    FastJsonPoatKey poatKeyToFastJson(PoatKey poatKey);

    @InheritInverseConfiguration
    PoatKey poatKeyFromFastJson(FastJsonPoatKey fastJsonPoatKey);

    FastJsonActivity activityToFastJson(Activity activity);

    @InheritInverseConfiguration
    Activity activityFromFastJson(FastJsonActivity fastJsonActivity);

    FastJsonActivityActivityDataRecordRelation activityActivityDataRecordRelationToFastJson(
            ActivityActivityDataRecordRelation activityActivityDataRecordRelation
    );

    @InheritInverseConfiguration
    ActivityActivityDataRecordRelation activityActivityDataRecordRelationFromFastJson(
            FastJsonActivityActivityDataRecordRelation fastJsonActivityActivityDataRecordRelation
    );

    FastJsonActivityCoverInfo activityCoverInfoToFastJson(ActivityCoverInfo activityCoverInfo);

    @InheritInverseConfiguration
    ActivityCoverInfo activityCoverInfoFromFastJson(FastJsonActivityCoverInfo fastJsonActivityCoverInfo);

    FastJsonActivityDataItem activityDataItemToFastJson(ActivityDataItem activityDataItem);

    @InheritInverseConfiguration
    ActivityDataItem activityDataItemFromFastJson(FastJsonActivityDataItem fastJsonActivityDataItem);

    FastJsonActivityDataNode activityDataNodeToFastJson(ActivityDataNode activityDataNode);

    @InheritInverseConfiguration
    ActivityDataNode activityDataNodeFromFastJson(FastJsonActivityDataNode fastJsonActivityDataNode);

    FastJsonActivityDataRecord activityDataRecordToFastJson(ActivityDataRecord activityDataRecord);

    @InheritInverseConfiguration
    ActivityDataRecord activityDataRecordFromFastJson(FastJsonActivityDataRecord fastJsonActivityDataRecord);

    FastJsonActivityDataSet activityDataSetToFastJson(ActivityDataSet activityDataSet);

    @InheritInverseConfiguration
    ActivityDataSet activityDataSetFromFastJson(FastJsonActivityDataSet fastJsonActivityDataSet);

    FastJsonActivityFileInfo activityFileInfoToFastJson(ActivityFileInfo activityFileInfo);

    @InheritInverseConfiguration
    ActivityFileInfo activityFileInfoFromFastJson(FastJsonActivityFileInfo fastJsonActivityFileInfo);

    FastJsonActivityParticipant activityParticipantToFastJson(ActivityParticipant activityParticipant);

    @InheritInverseConfiguration
    ActivityParticipant activityParticipantFromFastJson(FastJsonActivityParticipant fastJsonActivityParticipant);

    FastJsonActivityTemplate activityTemplateToFastJson(ActivityTemplate activityTemplate);

    @InheritInverseConfiguration
    ActivityTemplate activityTemplateFromFastJson(FastJsonActivityTemplate fastJsonActivityTemplate);

    FastJsonActivityTemplateActivityDataItemRelation activityTemplateActivityDataItemRelationToFastJson(
            ActivityTemplateActivityDataItemRelation activityTemplateActivityDataItemRelation
    );

    @InheritInverseConfiguration
    ActivityTemplateActivityDataItemRelation activityTemplateActivityDataItemRelationFromFastJson(
            FastJsonActivityTemplateActivityDataItemRelation fastJsonActivityTemplateActivityDataItemRelation
    );

    FastJsonActivityTemplateCoverInfo activityTemplateCoverInfoToFastJson(
            ActivityTemplateCoverInfo activityTemplateCoverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateCoverInfo activityTemplateCoverInfoFromFastJson(
            FastJsonActivityTemplateCoverInfo fastJsonActivityTemplateCoverInfo
    );

    FastJsonActivityTemplateDriverInfo activityTemplateDriverInfoToFastJson(
            ActivityTemplateDriverInfo activityTemplateDriverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDriverInfo activityTemplateDriverInfoFromFastJson(
            FastJsonActivityTemplateDriverInfo fastJsonActivityTemplateDriverInfo
    );

    FastJsonActivityTemplateDriverSupport activityTemplateDriverSupportToFastJson(
            ActivityTemplateDriverSupport activityTemplateDriverSupport
    );

    @InheritInverseConfiguration
    ActivityTemplateDriverSupport activityTemplateDriverSupportFromFastJson(
            FastJsonActivityTemplateDriverSupport fastJsonActivityTemplateDriverSupport
    );

    FastJsonActivityTemplateFileInfo activityTemplateFileInfoToFastJson(
            ActivityTemplateFileInfo activityTemplateFileInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateFileInfo activityTemplateFileInfoFromFastJson(
            FastJsonActivityTemplateFileInfo fastJsonActivityTemplateFileInfo
    );

    FastJsonActivityTemplateParticipant activityTemplateParticipantToFastJson(
            ActivityTemplateParticipant activityTemplateParticipant
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipant activityTemplateParticipantFromFastJson(
            FastJsonActivityTemplateParticipant fastJsonActivityTemplateParticipant
    );

    FastJsonActivityTypeIndicator activityTypeIndicatorToFastJson(ActivityTypeIndicator activityTypeIndicator);

    @InheritInverseConfiguration
    ActivityTypeIndicator activityTypeIndicatorFromFastJson(
            FastJsonActivityTypeIndicator fastJsonActivityTypeIndicator
    );

    FastJsonPoac poacToFastJson(Poac poac);

    @InheritInverseConfiguration
    Poac poacFromFastJson(FastJsonPoac fastJsonPoac);

    FastJsonPoad poadToFastJson(Poad poad);

    @InheritInverseConfiguration
    Poad poadFromFastJson(FastJsonPoad fastJsonPoad);

    FastJsonPoat poatToFastJson(Poat poat);

    @InheritInverseConfiguration
    Poat poatFromFastJson(FastJsonPoat fastJsonPoat);

    FastJsonPoatac poatacToFastJson(Poatac poatac);

    @InheritInverseConfiguration
    Poatac poatacFromFastJson(FastJsonPoatac fastJsonPoatac);
}
