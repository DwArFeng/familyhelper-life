package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateCoverInfo;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateCoverInfoMaintainService;
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
public class ActivityTemplateCoverInfoMaintainServiceImplTest {

    @Autowired
    private ActivityTemplateCoverInfoMaintainService activityTemplateCoverInfoMaintainService;
    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;

    private List<ActivityTemplateCoverInfo> activityTemplateCoverInfos;
    private ActivityTemplate activityTemplate;

    @Before
    public void setUp() {
        activityTemplateCoverInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityTemplateCoverInfo activityTemplateCoverInfo = new ActivityTemplateCoverInfo(
                    null, null, "origin_name", 12450L, new Date(), new Date(), "remark", 12450
            );
            activityTemplateCoverInfos.add(activityTemplateCoverInfo);
        }
        activityTemplate = new ActivityTemplate(
                null, "activityType", "name", "remark", "activityNameTemplate", "activityRemarkTemplate",
                "activityStartDateTemplate", "activityEndDateTemplate", new Date(), new Date(), new Date(), new Date(),
                12450
        );
    }

    @After
    public void tearDown() {
        activityTemplateCoverInfos.clear();
        activityTemplate = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityTemplateCoverInfo activityTemplateCoverInfo : activityTemplateCoverInfos) {
                activityTemplateCoverInfo.setKey(
                        activityTemplateCoverInfoMaintainService.insert(activityTemplateCoverInfo)
                );

                ActivityTemplateCoverInfo testActivityTemplateCoverInfo = activityTemplateCoverInfoMaintainService.get(
                        activityTemplateCoverInfo.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateCoverInfo),
                        BeanUtils.describe(testActivityTemplateCoverInfo)
                );
                activityTemplateCoverInfoMaintainService.update(activityTemplateCoverInfo);
                testActivityTemplateCoverInfo = activityTemplateCoverInfoMaintainService.get(
                        activityTemplateCoverInfo.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateCoverInfo),
                        BeanUtils.describe(testActivityTemplateCoverInfo)
                );
            }
        } finally {
            for (ActivityTemplateCoverInfo activityTemplateCoverInfo : activityTemplateCoverInfos) {
                activityTemplateCoverInfoMaintainService.deleteIfExists(activityTemplateCoverInfo.getKey());
            }
        }
    }

    @Test
    public void testForActivityTemplateCascade() throws Exception {
        try {
            activityTemplate.setKey(activityTemplateMaintainService.insertOrUpdate(activityTemplate));
            for (ActivityTemplateCoverInfo activityTemplateCoverInfo : activityTemplateCoverInfos) {
                activityTemplateCoverInfo.setActivityTemplateKey(activityTemplate.getKey());
                activityTemplateCoverInfo.setKey(
                        activityTemplateCoverInfoMaintainService.insert(activityTemplateCoverInfo)
                );
            }

            assertEquals(activityTemplateCoverInfos.size(), activityTemplateCoverInfoMaintainService.lookup(
                    ActivityTemplateCoverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());

            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());

            assertEquals(0, activityTemplateCoverInfoMaintainService.lookup(
                    ActivityTemplateCoverInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            for (ActivityTemplateCoverInfo activityTemplateCoverInfo : activityTemplateCoverInfos) {
                activityTemplateCoverInfoMaintainService.deleteIfExists(activityTemplateCoverInfo.getKey());
            }
        }
    }
}
