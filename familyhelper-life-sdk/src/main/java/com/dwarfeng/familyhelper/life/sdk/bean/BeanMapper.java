package com.dwarfeng.familyhelper.life.sdk.bean;

import com.dwarfeng.familyhelper.life.sdk.bean.dto.*;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.life.sdk.bean.key.*;
import com.dwarfeng.familyhelper.life.stack.bean.dto.*;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.*;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * Bean 映射器。
 *
 * <p>
 * 该映射器中包含了 <code>sdk</code> 模块中所有实体与 <code>stack</code> 模块中对应实体的映射方法。
 *
 * @author DwArFeng
 * @since 1.2.0
 */
@Mapper
public interface BeanMapper {

    // -----------------------------------------------------------Subgrade Key-----------------------------------------------------------
    FastJsonLongIdKey longIdKeyToFastJson(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromFastJson(FastJsonLongIdKey fastJsonLongIdKey);

    FastJsonStringIdKey stringIdKeyToFastJson(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromFastJson(FastJsonStringIdKey fastJsonStringIdKey);

    JSFixedFastJsonLongIdKey longIdKeyToJSFixedFastJson(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromJSFixedFastJson(JSFixedFastJsonLongIdKey jSFixedFastJsonLongIdKey);

    WebInputStringIdKey stringIdKeyToWebInput(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromWebInput(WebInputStringIdKey webInputStringIdKey);

    // -----------------------------------------------------------Familyhelper-life Key-----------------------------------------------------------
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

    FastJsonPopbKey popbKeyToFastJson(PopbKey popbKey);

    @InheritInverseConfiguration
    PopbKey popbKeyFromFastJson(FastJsonPopbKey fastJsonPopbKey);

    JSFixedFastJsonActivityParticipantKey activityParticipantKeyToJSFixedFastJson(
            ActivityParticipantKey activityParticipantKey
    );

    @InheritInverseConfiguration
    ActivityParticipantKey activityParticipantKeyFromJSFixedFastJson(
            JSFixedFastJsonActivityParticipantKey jSFixedFastJsonActivityParticipantKey
    );

    JSFixedFastJsonActivityTemplateParticipantKey activityTemplateParticipantKeyToJSFixedFastJson(
            ActivityTemplateParticipantKey activityTemplateParticipantKey
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipantKey activityTemplateParticipantKeyFromJSFixedFastJson(
            JSFixedFastJsonActivityTemplateParticipantKey jSFixedFastJsonActivityTemplateParticipantKey
    );

    JSFixedFastJsonPoacKey poacKeyToJSFixedFastJson(PoacKey poacKey);

    @InheritInverseConfiguration
    PoacKey poacKeyFromJSFixedFastJson(JSFixedFastJsonPoacKey jSFixedFastJsonPoacKey);

    JSFixedFastJsonPoadKey poadKeyToJSFixedFastJson(PoadKey poadKey);

    @InheritInverseConfiguration
    PoadKey poadKeyFromJSFixedFastJson(JSFixedFastJsonPoadKey jSFixedFastJsonPoadKey);

    JSFixedFastJsonPoatacKey poatacKeyToJSFixedFastJson(PoatacKey poatacKey);

    @InheritInverseConfiguration
    PoatacKey poatacKeyFromJSFixedFastJson(JSFixedFastJsonPoatacKey jSFixedFastJsonPoatacKey);

    JSFixedFastJsonPoatKey poatKeyToJSFixedFastJson(PoatKey poatKey);

    @InheritInverseConfiguration
    PoatKey poatKeyFromJSFixedFastJson(JSFixedFastJsonPoatKey jSFixedFastJsonPoatKey);

    JSFixedFastJsonPopbKey popbKeyToJSFixedFastJson(PopbKey popbKey);

    @InheritInverseConfiguration
    PopbKey popbKeyFromJSFixedFastJson(JSFixedFastJsonPopbKey jSFixedFastJsonPopbKey);

    WebInputActivityParticipantKey activityParticipantKeyToWebInput(ActivityParticipantKey activityParticipantKey);

    @InheritInverseConfiguration
    ActivityParticipantKey activityParticipantKeyFromWebInput(
            WebInputActivityParticipantKey webInputActivityParticipantKey
    );

    WebInputActivityTemplateParticipantKey activityTemplateParticipantKeyToWebInput(
            ActivityTemplateParticipantKey activityTemplateParticipantKey
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipantKey activityTemplateParticipantKeyFromWebInput(
            WebInputActivityTemplateParticipantKey webInputActivityTemplateParticipantKey
    );

    WebInputPopbKey popbKeyToWebInput(PopbKey popbKey);

    @InheritInverseConfiguration
    PopbKey popbKeyFromWebInput(WebInputPopbKey webInputPopbKey);

    // -----------------------------------------------------------Familyhelper-life Entity-----------------------------------------------------------
    FastJsonActivity activityToFastJson(Activity activity);

    @InheritInverseConfiguration
    Activity activityFromFastJson(FastJsonActivity fastJsonActivity);

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

    FastJsonActivityTemplateCoverInfo activityTemplateCoverInfoToFastJson(
            ActivityTemplateCoverInfo activityTemplateCoverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateCoverInfo activityTemplateCoverInfoFromFastJson(
            FastJsonActivityTemplateCoverInfo fastJsonActivityTemplateCoverInfo
    );

    FastJsonActivityTemplateDataInfo activityTemplateDataInfoToFastJson(
            ActivityTemplateDataInfo activityTemplateDataInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDataInfo activityTemplateDataInfoFromFastJson(
            FastJsonActivityTemplateDataInfo fastJsonActivityTemplateDataInfo
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

    FastJsonPbFileInfo pbFileInfoToFastJson(PbFileInfo pbFileInfo);

    @InheritInverseConfiguration
    PbFileInfo pbFileInfoFromFastJson(FastJsonPbFileInfo fastJsonPbFileInfo);

    FastJsonPbItem pbItemToFastJson(PbItem pbItem);

    @InheritInverseConfiguration
    PbItem pbItemFromFastJson(FastJsonPbItem fastJsonPbItem);

    FastJsonPbNode pbNodeToFastJson(PbNode pbNode);

    @InheritInverseConfiguration
    PbNode pbNodeFromFastJson(FastJsonPbNode fastJsonPbNode);

    FastJsonPbRecord pbRecordToFastJson(PbRecord pbRecord);

    @InheritInverseConfiguration
    PbRecord pbRecordFromFastJson(FastJsonPbRecord fastJsonPbRecord);

    FastJsonPbSet pbSetToFastJson(PbSet pbSet);

    @InheritInverseConfiguration
    PbSet pbSetFromFastJson(FastJsonPbSet fastJsonPbSet);

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

    FastJsonPopb popbToFastJson(Popb popb);

    @InheritInverseConfiguration
    Popb popbFromFastJson(FastJsonPopb fastJsonPopb);

    FastJsonUser userToFastJson(User user);

    @InheritInverseConfiguration
    User userFromFastJson(FastJsonUser fastJsonUser);

    JSFixedFastJsonActivity activityToJSFixedFastJson(Activity activity);

    @InheritInverseConfiguration
    Activity activityFromJSFixedFastJson(JSFixedFastJsonActivity jSFixedFastJsonActivity);

    JSFixedFastJsonActivityCoverInfo activityCoverInfoToJSFixedFastJson(ActivityCoverInfo activityCoverInfo);

    @InheritInverseConfiguration
    ActivityCoverInfo activityCoverInfoFromJSFixedFastJson(
            JSFixedFastJsonActivityCoverInfo jSFixedFastJsonActivityCoverInfo
    );

    JSFixedFastJsonActivityDataItem activityDataItemToJSFixedFastJson(ActivityDataItem activityDataItem);

    @InheritInverseConfiguration
    ActivityDataItem activityDataItemFromJSFixedFastJson(
            JSFixedFastJsonActivityDataItem jSFixedFastJsonActivityDataItem
    );

    JSFixedFastJsonActivityDataNode activityDataNodeToJSFixedFastJson(ActivityDataNode activityDataNode);

    @InheritInverseConfiguration
    ActivityDataNode activityDataNodeFromJSFixedFastJson(
            JSFixedFastJsonActivityDataNode jSFixedFastJsonActivityDataNode
    );

    JSFixedFastJsonActivityDataRecord activityDataRecordToJSFixedFastJson(ActivityDataRecord activityDataRecord);

    @InheritInverseConfiguration
    ActivityDataRecord activityDataRecordFromJSFixedFastJson(
            JSFixedFastJsonActivityDataRecord jSFixedFastJsonActivityDataRecord
    );

    JSFixedFastJsonActivityDataSet activityDataSetToJSFixedFastJson(ActivityDataSet activityDataSet);

    @InheritInverseConfiguration
    ActivityDataSet activityDataSetFromJSFixedFastJson(JSFixedFastJsonActivityDataSet jSFixedFastJsonActivityDataSet);

    JSFixedFastJsonActivityFileInfo activityFileInfoToJSFixedFastJson(ActivityFileInfo activityFileInfo);

    @InheritInverseConfiguration
    ActivityFileInfo activityFileInfoFromJSFixedFastJson(
            JSFixedFastJsonActivityFileInfo jSFixedFastJsonActivityFileInfo
    );

    JSFixedFastJsonActivityParticipant activityParticipantToJSFixedFastJson(ActivityParticipant activityParticipant);

    @InheritInverseConfiguration
    ActivityParticipant activityParticipantFromJSFixedFastJson(
            JSFixedFastJsonActivityParticipant jSFixedFastJsonActivityParticipant
    );

    JSFixedFastJsonActivityTemplate activityTemplateToJSFixedFastJson(ActivityTemplate activityTemplate);

    @InheritInverseConfiguration
    ActivityTemplate activityTemplateFromJSFixedFastJson(
            JSFixedFastJsonActivityTemplate jSFixedFastJsonActivityTemplate
    );

    JSFixedFastJsonActivityTemplateCoverInfo activityTemplateCoverInfoToJSFixedFastJson(
            ActivityTemplateCoverInfo activityTemplateCoverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateCoverInfo activityTemplateCoverInfoFromJSFixedFastJson(
            JSFixedFastJsonActivityTemplateCoverInfo jSFixedFastJsonActivityTemplateCoverInfo
    );

    JSFixedFastJsonActivityTemplateDataInfo activityTemplateDataInfoToJSFixedFastJson(
            ActivityTemplateDataInfo activityTemplateDataInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDataInfo activityTemplateDataInfoFromJSFixedFastJson(
            JSFixedFastJsonActivityTemplateDataInfo jSFixedFastJsonActivityTemplateDataInfo
    );

    JSFixedFastJsonActivityTemplateDriverInfo activityTemplateDriverInfoToJSFixedFastJson(
            ActivityTemplateDriverInfo activityTemplateDriverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDriverInfo activityTemplateDriverInfoFromJSFixedFastJson(
            JSFixedFastJsonActivityTemplateDriverInfo jSFixedFastJsonActivityTemplateDriverInfo
    );

    JSFixedFastJsonActivityTemplateFileInfo activityTemplateFileInfoToJSFixedFastJson(
            ActivityTemplateFileInfo activityTemplateFileInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateFileInfo activityTemplateFileInfoFromJSFixedFastJson(
            JSFixedFastJsonActivityTemplateFileInfo jSFixedFastJsonActivityTemplateFileInfo
    );

    JSFixedFastJsonActivityTemplateParticipant activityTemplateParticipantToJSFixedFastJson(
            ActivityTemplateParticipant activityTemplateParticipant
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipant activityTemplateParticipantFromJSFixedFastJson(
            JSFixedFastJsonActivityTemplateParticipant jSFixedFastJsonActivityTemplateParticipant
    );

    JSFixedFastJsonPbFileInfo pbFileInfoToJSFixedFastJson(PbFileInfo pbFileInfo);

    @InheritInverseConfiguration
    PbFileInfo pbFileInfoFromJSFixedFastJson(JSFixedFastJsonPbFileInfo jSFixedFastJsonPbFileInfo);

    JSFixedFastJsonPbItem pbItemToJSFixedFastJson(PbItem pbItem);

    @InheritInverseConfiguration
    PbItem pbItemFromJSFixedFastJson(JSFixedFastJsonPbItem jSFixedFastJsonPbItem);

    JSFixedFastJsonPbNode pbNodeToJSFixedFastJson(PbNode pbNode);

    @InheritInverseConfiguration
    PbNode pbNodeFromJSFixedFastJson(JSFixedFastJsonPbNode jSFixedFastJsonPbNode);

    JSFixedFastJsonPbRecord pbRecordToJSFixedFastJson(PbRecord pbRecord);

    @InheritInverseConfiguration
    PbRecord pbRecordFromJSFixedFastJson(JSFixedFastJsonPbRecord jSFixedFastJsonPbRecord);

    JSFixedFastJsonPbSet pbSetToJSFixedFastJson(PbSet pbSet);

    @InheritInverseConfiguration
    PbSet pbSetFromJSFixedFastJson(JSFixedFastJsonPbSet jSFixedFastJsonPbSet);

    JSFixedFastJsonPoac poacToJSFixedFastJson(Poac poac);

    @InheritInverseConfiguration
    Poac poacFromJSFixedFastJson(JSFixedFastJsonPoac jSFixedFastJsonPoac);

    JSFixedFastJsonPoad poadToJSFixedFastJson(Poad poad);

    @InheritInverseConfiguration
    Poad poadFromJSFixedFastJson(JSFixedFastJsonPoad jSFixedFastJsonPoad);

    JSFixedFastJsonPoat poatToJSFixedFastJson(Poat poat);

    @InheritInverseConfiguration
    Poat poatFromJSFixedFastJson(JSFixedFastJsonPoat jSFixedFastJsonPoat);

    JSFixedFastJsonPoatac poatacToJSFixedFastJson(Poatac poatac);

    @InheritInverseConfiguration
    Poatac poatacFromJSFixedFastJson(JSFixedFastJsonPoatac jSFixedFastJsonPoatac);

    JSFixedFastJsonPopb popbToJSFixedFastJson(Popb popb);

    @InheritInverseConfiguration
    Popb popbFromJSFixedFastJson(JSFixedFastJsonPopb jSFixedFastJsonPopb);

    WebInputActivityTemplateDriverInfo activityTemplateDriverInfoToWebInput(
            ActivityTemplateDriverInfo activityTemplateDriverInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDriverInfo activityTemplateDriverInfoFromWebInput(
            WebInputActivityTemplateDriverInfo webInputActivityTemplateDriverInfo
    );

    WebInputActivityTypeIndicator activityTypeIndicatorToWebInput(ActivityTypeIndicator activityTypeIndicator);

    @InheritInverseConfiguration
    ActivityTypeIndicator activityTypeIndicatorFromWebInput(
            WebInputActivityTypeIndicator webInputActivityTypeIndicator
    );

    WebInputPbItem pbItemToWebInput(PbItem pbItem);

    @InheritInverseConfiguration
    PbItem pbItemFromWebInput(WebInputPbItem webInputPbItem);

    WebInputPbNode pbNodeToWebInput(PbNode pbNode);

    @InheritInverseConfiguration
    PbNode pbNodeFromWebInput(WebInputPbNode webInputPbNode);

    WebInputPbRecord pbRecordToWebInput(PbRecord pbRecord);

    @InheritInverseConfiguration
    PbRecord pbRecordFromWebInput(WebInputPbRecord webInputPbRecord);

    WebInputPbSet pbSetToWebInput(PbSet pbSet);

    @InheritInverseConfiguration
    PbSet pbSetFromWebInput(WebInputPbSet webInputPbSet);

    WebInputPopb popbToWebInput(Popb popb);

    @InheritInverseConfiguration
    Popb popbFromWebInput(WebInputPopb webInputPopb);

    WebInputUser userToWebInput(User user);

    @InheritInverseConfiguration
    User userFromWebInput(WebInputUser webInputUser);

    // -----------------------------------------------------------Familyhelper-life DTO-----------------------------------------------------------
    FastJsonActivityGeneratedByDriverPushInfo activityGeneratedByDriverPushInfoToFastJson(
            ActivityGeneratedByDriverPushInfo activityGeneratedByDriverPushInfo
    );

    @InheritInverseConfiguration
    ActivityGeneratedByDriverPushInfo activityGeneratedByDriverPushInfoFromFastJson(
            FastJsonActivityGeneratedByDriverPushInfo fastJsonActivityGeneratedByDriverPushInfo
    );

    FastJsonActivityRemindedByDriverPushInfo activityRemindedByDriverPushInfoToFastJson(
            ActivityRemindedByDriverPushInfo activityRemindedByDriverPushInfo
    );

    @InheritInverseConfiguration
    ActivityRemindedByDriverPushInfo activityRemindedByDriverPushInfoFromFastJson(
            FastJsonActivityRemindedByDriverPushInfo fastJsonActivityRemindedByDriverPushInfo
    );

    WebInputActivityCoverOrderUpdateInfo activityCoverOrderUpdateInfoToWebInput(
            ActivityCoverOrderUpdateInfo activityCoverOrderUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityCoverOrderUpdateInfo activityCoverOrderUpdateInfoFromWebInput(
            WebInputActivityCoverOrderUpdateInfo webInputActivityCoverOrderUpdateInfo
    );

    WebInputActivityCreateInfo activityCreateInfoToWebInput(ActivityCreateInfo activityCreateInfo);

    @InheritInverseConfiguration
    ActivityCreateInfo activityCreateInfoFromWebInput(WebInputActivityCreateInfo webInputActivityCreateInfo);

    WebInputActivityDataItemCreateInfo activityDataItemCreateInfoToWebInput(
            ActivityDataItemCreateInfo activityDataItemCreateInfo
    );

    @InheritInverseConfiguration
    ActivityDataItemCreateInfo activityDataItemCreateInfoFromWebInput(
            WebInputActivityDataItemCreateInfo webInputActivityDataItemCreateInfo
    );

    WebInputActivityDataItemUpdateInfo activityDataItemUpdateInfoToWebInput(
            ActivityDataItemUpdateInfo activityDataItemUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityDataItemUpdateInfo activityDataItemUpdateInfoFromWebInput(
            WebInputActivityDataItemUpdateInfo webInputActivityDataItemUpdateInfo
    );

    WebInputActivityDataNodeCreateInfo activityDataNodeCreateInfoToWebInput(
            ActivityDataNodeCreateInfo activityDataNodeCreateInfo
    );

    @InheritInverseConfiguration
    ActivityDataNodeCreateInfo activityDataNodeCreateInfoFromWebInput(
            WebInputActivityDataNodeCreateInfo webInputActivityDataNodeCreateInfo
    );

    WebInputActivityDataNodeUpdateInfo activityDataNodeUpdateInfoToWebInput(
            ActivityDataNodeUpdateInfo activityDataNodeUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityDataNodeUpdateInfo activityDataNodeUpdateInfoFromWebInput(
            WebInputActivityDataNodeUpdateInfo webInputActivityDataNodeUpdateInfo
    );

    WebInputActivityDataRecordCreateInfo activityDataRecordCreateInfoToWebInput(
            ActivityDataRecordCreateInfo activityDataRecordCreateInfo
    );

    @InheritInverseConfiguration
    ActivityDataRecordCreateInfo activityDataRecordCreateInfoFromWebInput(
            WebInputActivityDataRecordCreateInfo webInputActivityDataRecordCreateInfo
    );

    WebInputActivityDataRecordUpdateInfo activityDataRecordUpdateInfoToWebInput(
            ActivityDataRecordUpdateInfo activityDataRecordUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityDataRecordUpdateInfo activityDataRecordUpdateInfoFromWebInput(
            WebInputActivityDataRecordUpdateInfo webInputActivityDataRecordUpdateInfo
    );

    WebInputActivityDataSetCreateInfo activityDataSetCreateInfoToWebInput(
            ActivityDataSetCreateInfo activityDataSetCreateInfo
    );

    @InheritInverseConfiguration
    ActivityDataSetCreateInfo activityDataSetCreateInfoFromWebInput(
            WebInputActivityDataSetCreateInfo webInputActivityDataSetCreateInfo
    );

    WebInputActivityDataSetPermissionRemoveInfo activityDataSetPermissionRemoveInfoToWebInput(
            ActivityDataSetPermissionRemoveInfo activityDataSetPermissionRemoveInfo
    );

    @InheritInverseConfiguration
    ActivityDataSetPermissionRemoveInfo activityDataSetPermissionRemoveInfoFromWebInput(
            WebInputActivityDataSetPermissionRemoveInfo webInputActivityDataSetPermissionRemoveInfo
    );

    WebInputActivityDataSetPermissionUpsertInfo activityDataSetPermissionUpsertInfoToWebInput(
            ActivityDataSetPermissionUpsertInfo activityDataSetPermissionUpsertInfo
    );

    @InheritInverseConfiguration
    ActivityDataSetPermissionUpsertInfo activityDataSetPermissionUpsertInfoFromWebInput(
            WebInputActivityDataSetPermissionUpsertInfo webInputActivityDataSetPermissionUpsertInfo
    );

    WebInputActivityDataSetUpdateInfo activityDataSetUpdateInfoToWebInput(
            ActivityDataSetUpdateInfo activityDataSetUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityDataSetUpdateInfo activityDataSetUpdateInfoFromWebInput(
            WebInputActivityDataSetUpdateInfo webInputActivityDataSetUpdateInfo
    );

    WebInputActivityParticipantCreateInfo activityParticipantCreateInfoToWebInput(
            ActivityParticipantCreateInfo activityParticipantCreateInfo
    );

    @InheritInverseConfiguration
    ActivityParticipantCreateInfo activityParticipantCreateInfoFromWebInput(
            WebInputActivityParticipantCreateInfo webInputActivityParticipantCreateInfo
    );

    WebInputActivityParticipantRemoveInfo activityParticipantRemoveInfoToWebInput(
            ActivityParticipantRemoveInfo activityParticipantRemoveInfo
    );

    @InheritInverseConfiguration
    ActivityParticipantRemoveInfo activityParticipantRemoveInfoFromWebInput(
            WebInputActivityParticipantRemoveInfo webInputActivityParticipantRemoveInfo
    );

    WebInputActivityParticipantUpdateInfo activityParticipantUpdateInfoToWebInput(
            ActivityParticipantUpdateInfo activityParticipantUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityParticipantUpdateInfo activityParticipantUpdateInfoFromWebInput(
            WebInputActivityParticipantUpdateInfo webInputActivityParticipantUpdateInfo
    );

    WebInputActivityPermissionRemoveInfo activityPermissionRemoveInfoToWebInput(
            ActivityPermissionRemoveInfo activityPermissionRemoveInfo
    );

    @InheritInverseConfiguration
    ActivityPermissionRemoveInfo activityPermissionRemoveInfoFromWebInput(
            WebInputActivityPermissionRemoveInfo webInputActivityPermissionRemoveInfo
    );

    WebInputActivityPermissionUpsertInfo activityPermissionUpsertInfoToWebInput(
            ActivityPermissionUpsertInfo activityPermissionUpsertInfo
    );

    @InheritInverseConfiguration
    ActivityPermissionUpsertInfo activityPermissionUpsertInfoFromWebInput(
            WebInputActivityPermissionUpsertInfo webInputActivityPermissionUpsertInfo
    );

    WebInputActivityTemplateActivityCreateInfo activityTemplateActivityCreateInfoToWebInput(
            ActivityTemplateActivityCreateInfo activityTemplateActivityCreateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateActivityCreateInfo activityTemplateActivityCreateInfoFromWebInput(
            WebInputActivityTemplateActivityCreateInfo webInputActivityTemplateActivityCreateInfo
    );

    WebInputActivityTemplateActivityPermissionRemoveInfo activityTemplateActivityPermissionRemoveInfoToWebInput(
            ActivityTemplateActivityPermissionRemoveInfo activityTemplateActivityPermissionRemoveInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateActivityPermissionRemoveInfo activityTemplateActivityPermissionRemoveInfoFromWebInput(
            WebInputActivityTemplateActivityPermissionRemoveInfo webInputActivityTemplateActivityPermissionRemoveInfo
    );

    WebInputActivityTemplateActivityPermissionUpsertInfo activityTemplateActivityPermissionUpsertInfoToWebInput(
            ActivityTemplateActivityPermissionUpsertInfo activityTemplateActivityPermissionUpsertInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateActivityPermissionUpsertInfo activityTemplateActivityPermissionUpsertInfoFromWebInput(
            WebInputActivityTemplateActivityPermissionUpsertInfo webInputActivityTemplateActivityPermissionUpsertInfo
    );

    WebInputActivityTemplateCoverOrderUpdateInfo activityTemplateCoverOrderUpdateInfoToWebInput(
            ActivityTemplateCoverOrderUpdateInfo activityTemplateCoverOrderUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateCoverOrderUpdateInfo activityTemplateCoverOrderUpdateInfoFromWebInput(
            WebInputActivityTemplateCoverOrderUpdateInfo webInputActivityTemplateCoverOrderUpdateInfo
    );

    WebInputActivityTemplateCreateInfo activityTemplateCreateInfoToWebInput(
            ActivityTemplateCreateInfo activityTemplateCreateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateCreateInfo activityTemplateCreateInfoFromWebInput(
            WebInputActivityTemplateCreateInfo webInputActivityTemplateCreateInfo
    );

    WebInputActivityTemplateDataInfoCreateInfo activityTemplateDataInfoCreateInfoToWebInput(
            ActivityTemplateDataInfoCreateInfo activityTemplateDataInfoCreateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDataInfoCreateInfo activityTemplateDataInfoCreateInfoFromWebInput(
            WebInputActivityTemplateDataInfoCreateInfo webInputActivityTemplateDataInfoCreateInfo
    );

    WebInputActivityTemplateDataInfoUpdateInfo activityTemplateDataInfoUpdateInfoToWebInput(
            ActivityTemplateDataInfoUpdateInfo activityTemplateDataInfoUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateDataInfoUpdateInfo activityTemplateDataInfoUpdateInfoFromWebInput(
            WebInputActivityTemplateDataInfoUpdateInfo webInputActivityTemplateDataInfoUpdateInfo
    );

    WebInputActivityTemplateParticipantCreateInfo activityTemplateParticipantCreateInfoToWebInput(
            ActivityTemplateParticipantCreateInfo activityTemplateParticipantCreateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipantCreateInfo activityTemplateParticipantCreateInfoFromWebInput(
            WebInputActivityTemplateParticipantCreateInfo webInputActivityTemplateParticipantCreateInfo
    );

    WebInputActivityTemplateParticipantRemoveInfo activityTemplateParticipantRemoveInfoToWebInput(
            ActivityTemplateParticipantRemoveInfo activityTemplateParticipantRemoveInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipantRemoveInfo activityTemplateParticipantRemoveInfoFromWebInput(
            WebInputActivityTemplateParticipantRemoveInfo webInputActivityTemplateParticipantRemoveInfo
    );

    WebInputActivityTemplateParticipantUpdateInfo activityTemplateParticipantUpdateInfoToWebInput(
            ActivityTemplateParticipantUpdateInfo activityTemplateParticipantUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateParticipantUpdateInfo activityTemplateParticipantUpdateInfoFromWebInput(
            WebInputActivityTemplateParticipantUpdateInfo webInputActivityTemplateParticipantUpdateInfo
    );

    WebInputActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfoToWebInput(
            ActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfo
    );

    @InheritInverseConfiguration
    ActivityTemplatePermissionRemoveInfo activityTemplatePermissionRemoveInfoFromWebInput(
            WebInputActivityTemplatePermissionRemoveInfo webInputActivityTemplatePermissionRemoveInfo
    );

    WebInputActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfoToWebInput(
            ActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfo
    );

    @InheritInverseConfiguration
    ActivityTemplatePermissionUpsertInfo activityTemplatePermissionUpsertInfoFromWebInput(
            WebInputActivityTemplatePermissionUpsertInfo webInputActivityTemplatePermissionUpsertInfo
    );

    WebInputActivityTemplateUpdateInfo activityTemplateUpdateInfoToWebInput(
            ActivityTemplateUpdateInfo activityTemplateUpdateInfo
    );

    @InheritInverseConfiguration
    ActivityTemplateUpdateInfo activityTemplateUpdateInfoFromWebInput(
            WebInputActivityTemplateUpdateInfo webInputActivityTemplateUpdateInfo
    );

    WebInputActivityUpdateInfo activityUpdateInfoToWebInput(ActivityUpdateInfo activityUpdateInfo);

    @InheritInverseConfiguration
    ActivityUpdateInfo activityUpdateInfoFromWebInput(WebInputActivityUpdateInfo webInputActivityUpdateInfo);

    WebInputPbItemCreateInfo pbItemCreateInfoToWebInput(PbItemCreateInfo pbItemCreateInfo);

    @InheritInverseConfiguration
    PbItemCreateInfo pbItemCreateInfoFromWebInput(WebInputPbItemCreateInfo webInputPbItemCreateInfo);

    WebInputPbItemUpdateInfo pbItemUpdateInfoToWebInput(PbItemUpdateInfo pbItemUpdateInfo);

    @InheritInverseConfiguration
    PbItemUpdateInfo pbItemUpdateInfoFromWebInput(WebInputPbItemUpdateInfo webInputPbItemUpdateInfo);

    WebInputPbNodeCreateInfo pbNodeCreateInfoToWebInput(PbNodeCreateInfo pbNodeCreateInfo);

    @InheritInverseConfiguration
    PbNodeCreateInfo pbNodeCreateInfoFromWebInput(WebInputPbNodeCreateInfo webInputPbNodeCreateInfo);

    WebInputPbNodeUpdateInfo pbNodeUpdateInfoToWebInput(PbNodeUpdateInfo pbNodeUpdateInfo);

    @InheritInverseConfiguration
    PbNodeUpdateInfo pbNodeUpdateInfoFromWebInput(WebInputPbNodeUpdateInfo webInputPbNodeUpdateInfo);

    WebInputPbRecordCreateInfo pbRecordCreateInfoToWebInput(PbRecordCreateInfo pbRecordCreateInfo);

    @InheritInverseConfiguration
    PbRecordCreateInfo pbRecordCreateInfoFromWebInput(WebInputPbRecordCreateInfo webInputPbRecordCreateInfo);

    WebInputPbRecordUpdateInfo pbRecordUpdateInfoToWebInput(PbRecordUpdateInfo pbRecordUpdateInfo);

    @InheritInverseConfiguration
    PbRecordUpdateInfo pbRecordUpdateInfoFromWebInput(WebInputPbRecordUpdateInfo webInputPbRecordUpdateInfo);

    WebInputPbSetCreateInfo pbSetCreateInfoToWebInput(PbSetCreateInfo pbSetCreateInfo);

    @InheritInverseConfiguration
    PbSetCreateInfo pbSetCreateInfoFromWebInput(WebInputPbSetCreateInfo webInputPbSetCreateInfo);

    WebInputPbSetPermissionRemoveInfo pbSetPermissionRemoveInfoToWebInput(
            PbSetPermissionRemoveInfo pbSetPermissionRemoveInfo
    );

    @InheritInverseConfiguration
    PbSetPermissionRemoveInfo pbSetPermissionRemoveInfoFromWebInput(
            WebInputPbSetPermissionRemoveInfo webInputPbSetPermissionRemoveInfo
    );

    WebInputPbSetPermissionUpsertInfo pbSetPermissionUpsertInfoToWebInput(
            PbSetPermissionUpsertInfo pbSetPermissionUpsertInfo
    );

    @InheritInverseConfiguration
    PbSetPermissionUpsertInfo pbSetPermissionUpsertInfoFromWebInput(
            WebInputPbSetPermissionUpsertInfo webInputPbSetPermissionUpsertInfo
    );

    WebInputPbSetUpdateInfo pbSetUpdateInfoToWebInput(PbSetUpdateInfo pbSetUpdateInfo);

    @InheritInverseConfiguration
    PbSetUpdateInfo pbSetUpdateInfoFromWebInput(WebInputPbSetUpdateInfo webInputPbSetUpdateInfo);
}
