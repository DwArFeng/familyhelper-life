package com.dwarfeng.familyhelper.life.impl.configuration;

import com.dwarfeng.familyhelper.life.sdk.util.ServiceExceptionCodes;
import com.dwarfeng.familyhelper.life.stack.exception.InvalidPermissionLevelException;
import com.dwarfeng.familyhelper.life.stack.exception.PbSetNotExistsException;
import com.dwarfeng.familyhelper.life.stack.exception.UserNotExistsException;
import com.dwarfeng.familyhelper.life.stack.exception.UserNotPermittedForPbSetException;
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
        return new MapServiceExceptionMapper(destination, com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes.UNDEFINE);
    }
}
