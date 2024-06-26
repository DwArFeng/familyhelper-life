package com.dwarfeng.familyhelper.life.node.configuration;

import com.dwarfeng.familyhelper.life.sdk.util.ServiceExceptionCodes;
import com.dwarfeng.familyhelper.life.stack.exception.*;
import com.dwarfeng.subgrade.impl.exception.MapServiceExceptionMapper;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ServiceExceptionMapperConfiguration {

    @Bean
    public MapServiceExceptionMapper mapServiceExceptionMapper() {
        Map<Class<? extends Exception>, ServiceException.Code> destination = ServiceExceptionHelper.putDefaultDestination(null);
        destination = com.dwarfeng.ftp.util.ServiceExceptionHelper.putDefaultDestination(destination);
        destination.put(UserNotExistsException.class, ServiceExceptionCodes.USER_NOT_EXISTS);
        destination.put(UserNotPermittedForPbSetException.class, ServiceExceptionCodes.USER_NOT_PERMITTED_FOR_PB_SET);
        destination.put(PbSetNotExistsException.class, ServiceExceptionCodes.PB_SET_NOT_EXISTS);
        destination.put(InvalidPermissionLevelException.class, ServiceExceptionCodes.INVALID_PERMISSION_LEVEL);
        destination.put(PbNodeNotExistsException.class, ServiceExceptionCodes.PB_NODE_NOT_EXISTS);
        destination.put(IllegalPbNodeStateException.class, ServiceExceptionCodes.ILLEGAL_PB_NODE_STATE);
        destination.put(PbSetNotIdenticalException.class, ServiceExceptionCodes.PB_SET_NOT_IDENTICAL);
        destination.put(PbItemNotExistsException.class, ServiceExceptionCodes.PB_ITEM_NOT_EXISTS);
        destination.put(IllegalPbItemStateException.class, ServiceExceptionCodes.ILLEGAL_PB_ITEM_STATE);
        destination.put(PbRecordNotExistsException.class, ServiceExceptionCodes.PB_RECORD_NOT_EXISTS);
        destination.put(IllegalPbRecordStateException.class, ServiceExceptionCodes.ILLEGAL_PB_RECORD_STATE);
        destination.put(PbFileNotExistsException.class, ServiceExceptionCodes.PB_FILE_NOT_EXISTS);
        destination.put(UserNotPermittedForActivityDataSetException.class, ServiceExceptionCodes.USER_NOT_PERMITTED_FOR_ACTIVITY_DATA_SET);
        destination.put(ActivityDataSetNotExistsException.class, ServiceExceptionCodes.ACTIVITY_DATA_SET_NOT_EXISTS);
        destination.put(ActivityDataNodeNotExistsException.class, ServiceExceptionCodes.ACTIVITY_DATA_NODE_NOT_EXISTS);
        destination.put(IllegalActivityDataNodeStateException.class, ServiceExceptionCodes.ILLEGAL_ACTIVITY_DATA_NODE_STATE);
        destination.put(ActivityDataSetNotIdenticalException.class, ServiceExceptionCodes.ACTIVITY_DATA_SET_NOT_IDENTICAL);
        destination.put(ActivityDataItemNotExistsException.class, ServiceExceptionCodes.ACTIVITY_DATA_ITEM_NOT_EXISTS);
        destination.put(IllegalActivityDataItemStateException.class, ServiceExceptionCodes.ILLEGAL_ACTIVITY_DATA_ITEM_STATE);
        destination.put(ActivityTemplateNotExistsException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_NOT_EXISTS);
        destination.put(UserNotPermittedForActivityTemplateException.class, ServiceExceptionCodes.USER_NOT_PERMITTED_FOR_ACTIVITY_TEMPLATE);
        destination.put(ActivityTemplateCoverNotExistsException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_COVER_NOT_EXISTS);
        destination.put(IllegalActivityTemplateCoverStateException.class, ServiceExceptionCodes.ILLEGAL_ACTIVITY_TEMPLATE_COVER_STATE);
        destination.put(ActivityTemplateParticipantExistsException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_PARTICIPANT_EXISTS);
        destination.put(ActivityTemplateParticipantNotExistsException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_PARTICIPANT_NOT_EXISTS);
        destination.put(ActivityTemplateDataInfoNotExistsException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_DATA_INFO_NOT_EXISTS);
        destination.put(ActivityNotExistsException.class, ServiceExceptionCodes.ACTIVITY_NOT_EXISTS);
        destination.put(UserNotPermittedForActivityException.class, ServiceExceptionCodes.USER_NOT_PERMITTED_FOR_ACTIVITY);
        destination.put(ActivityLockedException.class, ServiceExceptionCodes.ACTIVITY_LOCKED);
        destination.put(ActivityCoverNotExistsException.class, ServiceExceptionCodes.ACTIVITY_COVER_NOT_EXISTS);
        destination.put(IllegalActivityCoverStateException.class, ServiceExceptionCodes.ILLEGAL_ACTIVITY_COVER_STATE);
        destination.put(ActivityFileNotExistsException.class, ServiceExceptionCodes.ACTIVITY_FILE_NOT_EXISTS);
        destination.put(IllegalActivityFileStateException.class, ServiceExceptionCodes.ILLEGAL_ACTIVITY_FILE_STATE);
        destination.put(ActivityParticipantExistsException.class, ServiceExceptionCodes.ACTIVITY_PARTICIPANT_EXISTS);
        destination.put(ActivityParticipantNotExistsException.class, ServiceExceptionCodes.ACTIVITY_PARTICIPANT_NOT_EXISTS);
        destination.put(ActivityDataRecordNotExistsException.class, ServiceExceptionCodes.ACTIVITY_DATA_RECORD_NOT_EXISTS);
        destination.put(ActivityTemplateDriverException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_DRIVER_FAILED);
        destination.put(UnsupportedActivityTemplateDriverTypeException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_DRIVER_TYPE_UNSUPPORTED);
        destination.put(ActivityTemplateDriverInfoNotExistsException.class, ServiceExceptionCodes.ACTIVITY_TEMPLATE_DRIVER_INFO_NOT_EXISTS);
        return new MapServiceExceptionMapper(destination, com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes.UNDEFINED);
    }
}
