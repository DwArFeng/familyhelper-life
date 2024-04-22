package com.dwarfeng.familyhelper.life.impl.handler;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriveLocalCacheHandler;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriver;
import com.dwarfeng.familyhelper.life.stack.handler.ActivityTemplateDriverHandler;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriverInfoMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
import com.dwarfeng.familyhelper.life.stack.struct.ActivityTemplateDriveInfo;
import com.dwarfeng.subgrade.impl.handler.Fetcher;
import com.dwarfeng.subgrade.impl.handler.GeneralLocalCacheHandler;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.BehaviorAnalyse;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ActivityTemplateDriveLocalCacheHandlerImpl implements ActivityTemplateDriveLocalCacheHandler {

    private final GeneralLocalCacheHandler<LongIdKey, ActivityTemplateDriveInfo> handler;

    public ActivityTemplateDriveLocalCacheHandlerImpl(
            ActivityTemplateDriveInfoFetcher activityTemplateDriveInfoFetcher
    ) {
        handler = new GeneralLocalCacheHandler<>(activityTemplateDriveInfoFetcher);
    }

    @BehaviorAnalyse
    @Override
    public boolean exists(LongIdKey key) throws HandlerException {
        return handler.exists(key);
    }

    @BehaviorAnalyse
    @Override
    public ActivityTemplateDriveInfo get(LongIdKey key) throws HandlerException {
        return handler.get(key);
    }

    @BehaviorAnalyse
    @Override
    public boolean remove(LongIdKey key) {
        return handler.remove(key);
    }

    @BehaviorAnalyse
    @Override
    public void clear() throws HandlerException {
        handler.clear();
    }

    @Component
    public static class ActivityTemplateDriveInfoFetcher implements Fetcher<LongIdKey, ActivityTemplateDriveInfo> {

        private final ActivityTemplateMaintainService activityTemplateMaintainService;
        private final ActivityTemplateDriverInfoMaintainService activityTemplateDriverInfoMaintainService;

        private final ActivityTemplateDriverHandler activityTemplateDriverHandler;

        public ActivityTemplateDriveInfoFetcher(
                ActivityTemplateMaintainService activityTemplateMaintainService,
                ActivityTemplateDriverInfoMaintainService activityTemplateDriverInfoMaintainService,
                ActivityTemplateDriverHandler activityTemplateDriverHandler
        ) {
            this.activityTemplateMaintainService = activityTemplateMaintainService;
            this.activityTemplateDriverInfoMaintainService = activityTemplateDriverInfoMaintainService;
            this.activityTemplateDriverHandler = activityTemplateDriverHandler;
        }

        @Override
        @BehaviorAnalyse
        @Transactional(
                transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class
        )
        public boolean exists(LongIdKey key) throws Exception {
            return activityTemplateMaintainService.exists(key);
        }

        @Override
        @BehaviorAnalyse
        @Transactional(
                transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class
        )
        public ActivityTemplateDriveInfo fetch(LongIdKey key) throws Exception {
            ActivityTemplate activityTemplate = activityTemplateMaintainService.get(key);
            List<ActivityTemplateDriverInfo> driverInfos = activityTemplateDriverInfoMaintainService.lookupAsList(
                    ActivityTemplateDriverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_ENABLED, new Object[]{key}
            );

            Map<ActivityTemplateDriverInfo, ActivityTemplateDriver> activityTemplateDriverMap = new HashMap<>();

            for (ActivityTemplateDriverInfo activityTemplateDriverInfo : driverInfos) {
                activityTemplateDriverMap.put(activityTemplateDriverInfo, activityTemplateDriverHandler.find(
                        activityTemplateDriverInfo.getType())
                );
            }

            return new ActivityTemplateDriveInfo(activityTemplate, activityTemplateDriverMap);
        }
    }
}
