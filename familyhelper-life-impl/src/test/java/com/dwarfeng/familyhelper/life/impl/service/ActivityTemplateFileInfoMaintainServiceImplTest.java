package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateFileInfo;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateFileInfoMaintainService;
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
public class ActivityTemplateFileInfoMaintainServiceImplTest {

    @Autowired
    private ActivityTemplateFileInfoMaintainService activityTemplateFileInfoMaintainService;
    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;

    private List<ActivityTemplateFileInfo> activityTemplateFileInfos;
    private ActivityTemplate activityTemplate;

    @Before
    public void setUp() {
        activityTemplateFileInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityTemplateFileInfo activityTemplateFileInfo = new ActivityTemplateFileInfo(
                    null, null, "origin_name", 12450L, new Date(), new Date(), new Date(), "remark"
            );
            activityTemplateFileInfos.add(activityTemplateFileInfo);
        }
        activityTemplate = new ActivityTemplate(
                null, "activityType", "name", "remark", "activityNameTemplate", "activityRemarkTemplate",
                "activityStartDateTemplate", "activityEndDateTemplate", new Date(), new Date(), new Date(), new Date(),
                12450
        );
    }

    @After
    public void tearDown() {
        activityTemplateFileInfos.clear();
        activityTemplate = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityTemplateFileInfo activityTemplateFileInfo : activityTemplateFileInfos) {
                activityTemplateFileInfo.setKey(activityTemplateFileInfoMaintainService.insert(
                        activityTemplateFileInfo)
                );

                ActivityTemplateFileInfo testActivityTemplateFileInfo = activityTemplateFileInfoMaintainService.get(
                        activityTemplateFileInfo.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateFileInfo), BeanUtils.describe(testActivityTemplateFileInfo)
                );
                activityTemplateFileInfoMaintainService.update(activityTemplateFileInfo);
                testActivityTemplateFileInfo = activityTemplateFileInfoMaintainService.get(
                        activityTemplateFileInfo.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateFileInfo), BeanUtils.describe(testActivityTemplateFileInfo)
                );
            }
        } finally {
            for (ActivityTemplateFileInfo activityTemplateFileInfo : activityTemplateFileInfos) {
                activityTemplateFileInfoMaintainService.deleteIfExists(activityTemplateFileInfo.getKey());
            }
        }
    }

    @Test
    public void testForActivityTemplateCascade() throws Exception {
        try {
            activityTemplate.setKey(activityTemplateMaintainService.insertOrUpdate(activityTemplate));
            for (ActivityTemplateFileInfo activityTemplateFileInfo : activityTemplateFileInfos) {
                activityTemplateFileInfo.setActivityTemplateKey(activityTemplate.getKey());
                activityTemplateFileInfo.setKey(
                        activityTemplateFileInfoMaintainService.insert(activityTemplateFileInfo)
                );
            }

            assertEquals(activityTemplateFileInfos.size(), activityTemplateFileInfoMaintainService.lookup(
                    ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());

            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());

            assertEquals(0, activityTemplateFileInfoMaintainService.lookup(
                    ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            for (ActivityTemplateFileInfo activityTemplateFileInfo : activityTemplateFileInfos) {
                activityTemplateFileInfoMaintainService.deleteIfExists(activityTemplateFileInfo.getKey());
            }
        }
    }
}
