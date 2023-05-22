package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriverInfoMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ActivityTemplateDriverInfoMaintainServiceImplTest {

    @Autowired
    private ActivityTemplateDriverInfoMaintainService activityTemplateDriverInfoMaintainService;
    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;

    private List<ActivityTemplateDriverInfo> activityTemplateDriverInfos;
    private ActivityTemplate activityTemplate;

    @Before
    public void setUp() {
        activityTemplateDriverInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityTemplateDriverInfo activityTemplateDriverInfo = new ActivityTemplateDriverInfo(
                    null, null, true, "type", "param", true, true, "remark"
            );
            activityTemplateDriverInfos.add(activityTemplateDriverInfo);
        }
        activityTemplate = new ActivityTemplate(
                null, "activityType", "name", "remark", "activityNameTemplate", "activityRemarkTemplate",
                "activityStartDateTemplate", "activityEndDateTemplate", new Date(), new Date(), new Date(), new Date(),
                12450
        );
    }

    @After
    public void tearDown() {
        activityTemplateDriverInfos.clear();
        activityTemplate = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityTemplateDriverInfo activityTemplateDriverInfo : activityTemplateDriverInfos) {
                activityTemplateDriverInfo.setKey(
                        activityTemplateDriverInfoMaintainService.insert(activityTemplateDriverInfo)
                );

                ActivityTemplateDriverInfo testActivityTemplateDriverInfo =
                        activityTemplateDriverInfoMaintainService.get(activityTemplateDriverInfo.getKey());
                assertEquals(
                        BeanUtils.describe(activityTemplateDriverInfo),
                        BeanUtils.describe(testActivityTemplateDriverInfo)
                );
                activityTemplateDriverInfoMaintainService.update(activityTemplateDriverInfo);
                testActivityTemplateDriverInfo = activityTemplateDriverInfoMaintainService.get(
                        activityTemplateDriverInfo.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateDriverInfo),
                        BeanUtils.describe(testActivityTemplateDriverInfo)
                );
            }
        } finally {
            for (ActivityTemplateDriverInfo activityTemplateDriverInfo : activityTemplateDriverInfos) {
                activityTemplateDriverInfoMaintainService.deleteIfExists(activityTemplateDriverInfo.getKey());
            }
        }
    }

    @Test
    public void testForActivityTemplateCascade() throws Exception {
        try {
            activityTemplate.setKey(activityTemplateMaintainService.insertOrUpdate(activityTemplate));
            for (ActivityTemplateDriverInfo activityTemplateDriverInfo : activityTemplateDriverInfos) {
                activityTemplateDriverInfo.setActivityTemplateKey(activityTemplate.getKey());
                activityTemplateDriverInfo.setKey(
                        activityTemplateDriverInfoMaintainService.insert(activityTemplateDriverInfo)
                );
            }

            assertEquals(activityTemplateDriverInfos.size(), activityTemplateDriverInfoMaintainService.lookup(
                    ActivityTemplateDriverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());

            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());

            assertEquals(0, activityTemplateDriverInfoMaintainService.lookup(
                    ActivityTemplateDriverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            for (ActivityTemplateDriverInfo activityTemplateDriverInfo : activityTemplateDriverInfos) {
                activityTemplateDriverInfoMaintainService.deleteIfExists(activityTemplateDriverInfo.getKey());
            }
        }
    }
}
