package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.familyhelper.life.stack.service.ActivityMaintainService;
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
public class ActivityMaintainServiceImplTest {

    @Autowired
    private ActivityMaintainService activityMaintainService;

    private List<Activity> activities;

    @Before
    public void setUp() {
        activities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Activity activity = new Activity(
                    null, "activityType", "name", 12450, "remark", true, new Date(), new Date(), new Date(), new Date(),
                    new Date(), new Date()
            );
            activities.add(activity);
        }
    }

    @After
    public void tearDown() {
        activities.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (Activity activity : activities) {
                activity.setKey(activityMaintainService.insert(activity));

                Activity testActivity = activityMaintainService.get(activity.getKey());
                assertEquals(BeanUtils.describe(activity), BeanUtils.describe(testActivity));
                activityMaintainService.update(activity);
                testActivity = activityMaintainService.get(activity.getKey());
                assertEquals(BeanUtils.describe(activity), BeanUtils.describe(testActivity));
            }
        } finally {
            for (Activity activity : activities) {
                activityMaintainService.deleteIfExists(activity.getKey());
            }
        }
    }
}
