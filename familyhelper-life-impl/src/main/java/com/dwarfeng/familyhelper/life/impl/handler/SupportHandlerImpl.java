package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.sdk.handler.ActivityTemplateDriverSupporter;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverSupport;
import com.dwarfeng.familyhelper.life.stack.handler.SupportHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriverSupportMaintainService;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.BehaviorAnalyse;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SupportHandlerImpl implements SupportHandler {

    private final ActivityTemplateDriverSupportMaintainService activityTemplateDriverSupportMaintainService;

    private final List<ActivityTemplateDriverSupporter> activityTemplateDriverSupporters;

    public SupportHandlerImpl(
            ActivityTemplateDriverSupportMaintainService activityTemplateDriverSupportMaintainService,
            List<ActivityTemplateDriverSupporter> activityTemplateDriverSupporters
    ) {
        this.activityTemplateDriverSupportMaintainService = activityTemplateDriverSupportMaintainService;
        this.activityTemplateDriverSupporters = Optional.ofNullable(activityTemplateDriverSupporters)
                .orElse(Collections.emptyList());
    }

    @Override
    @BehaviorAnalyse
    public void resetActivityTemplateDriver() throws HandlerException {
        try {
            doResetActivityTemplateDriver();
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private void doResetActivityTemplateDriver() throws Exception {
        List<StringIdKey> activityTemplateDriverKeys = activityTemplateDriverSupportMaintainService.lookupAsList()
                .stream()
                .map(ActivityTemplateDriverSupport::getKey).collect(Collectors.toList());
        activityTemplateDriverSupportMaintainService.batchDelete(activityTemplateDriverKeys);
        List<ActivityTemplateDriverSupport> activityTemplateDriverSupports = activityTemplateDriverSupporters
                .stream()
                .map(supporter -> new ActivityTemplateDriverSupport(
                        new StringIdKey(supporter.provideType()),
                        supporter.provideLabel(),
                        supporter.provideDescription(),
                        supporter.provideExampleParam()
                )).collect(Collectors.toList());
        activityTemplateDriverSupportMaintainService.batchInsert(activityTemplateDriverSupports);
    }
}
