package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
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
public class ActivityTemplateMaintainServiceImplTest {

    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;

    private List<ActivityTemplate> activityTemplates;

    @Before
    public void setUp() {
        activityTemplates = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityTemplate activityTemplate = new ActivityTemplate(
                    null, "activityType", "name", "remark", "activityNameTemplate", "activityRemarkTemplate",
                    "activityStartDateTemplate", "activityEndDateTemplate", new Date(), new Date(), new Date(),
                    new Date(), 12450
            );
            activityTemplates.add(activityTemplate);
        }
    }

    @After
    public void tearDown() {
        activityTemplates.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityTemplate activityTemplate : activityTemplates) {
                activityTemplate.setKey(activityTemplateMaintainService.insert(activityTemplate));

                ActivityTemplate testActivityTemplate = activityTemplateMaintainService.get(activityTemplate.getKey());
                assertEquals(BeanUtils.describe(activityTemplate), BeanUtils.describe(testActivityTemplate));
                activityTemplateMaintainService.update(activityTemplate);
                testActivityTemplate = activityTemplateMaintainService.get(activityTemplate.getKey());
                assertEquals(BeanUtils.describe(activityTemplate), BeanUtils.describe(testActivityTemplate));
            }
        } finally {
            for (ActivityTemplate activityTemplate : activityTemplates) {
                activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            }
        }
    }
}
