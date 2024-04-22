package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.exception.UnsupportedActivityTemplateDriverTypeException;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriverHandler;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ActivityTemplateDriverHandlerImpl implements ActivityTemplateDriverHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityTemplateDriverHandlerImpl.class);

    private final List<ActivityTemplateDriverProvider> activityTemplateDriverProviders;

    private final InternalActivityTemplateDriverContext activityTemplateDriverContext;

    public ActivityTemplateDriverHandlerImpl(
            List<ActivityTemplateDriverProvider> activityTemplateDriverProviders,
            InternalActivityTemplateDriverContext activityTemplateDriverContext
    ) {
        this.activityTemplateDriverProviders = Optional.ofNullable(activityTemplateDriverProviders)
                .orElse(Collections.emptyList());
        this.activityTemplateDriverContext = activityTemplateDriverContext;
    }

    @PostConstruct
    public void init() {
        LOGGER.info("初始化活动模板驱动器...");
        activityTemplateDriverProviders.stream().map(ActivityTemplateDriverProvider::provide)
                .forEach(activityTemplateDriver -> activityTemplateDriver.init(activityTemplateDriverContext));
    }

    @Override
    public ActivityTemplateDriver find(String type) throws HandlerException {
        return activityTemplateDriverProviders.stream().filter(dp -> dp.supportType(type))
                .map(ActivityTemplateDriverProvider::provide)
                .findAny()
                .orElseThrow(() -> new UnsupportedActivityTemplateDriverTypeException(type));
    }
}
