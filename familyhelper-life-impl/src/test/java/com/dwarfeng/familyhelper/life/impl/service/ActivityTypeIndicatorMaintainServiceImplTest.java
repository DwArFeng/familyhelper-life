package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTypeIndicator;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTypeIndicatorMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ActivityTypeIndicatorMaintainServiceImplTest {

    @Autowired
    private ActivityTypeIndicatorMaintainService activityTypeIndicatorMaintainService;

    private List<ActivityTypeIndicator> activityTypeIndicators;

    @Before
    public void setUp() {
        activityTypeIndicators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityTypeIndicator activityTypeIndicator = new ActivityTypeIndicator(
                    new StringIdKey("test.activity_type_indicator." + (i + 1)),
                    "label",
                    "remark"
            );
            activityTypeIndicators.add(activityTypeIndicator);
        }
    }

    @After
    public void tearDown() {
        activityTypeIndicators.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityTypeIndicator activityTypeIndicator : activityTypeIndicators) {
                activityTypeIndicator.setKey(activityTypeIndicatorMaintainService.insert(activityTypeIndicator));

                ActivityTypeIndicator testActivityTypeIndicator = activityTypeIndicatorMaintainService.get(
                        activityTypeIndicator.getKey());
                assertEquals(BeanUtils.describe(activityTypeIndicator), BeanUtils.describe(testActivityTypeIndicator));
                activityTypeIndicatorMaintainService.update(activityTypeIndicator);
                testActivityTypeIndicator = activityTypeIndicatorMaintainService.get(activityTypeIndicator.getKey());
                assertEquals(BeanUtils.describe(activityTypeIndicator), BeanUtils.describe(testActivityTypeIndicator));
            }
        } finally {
            for (ActivityTypeIndicator activityTypeIndicator : activityTypeIndicators) {
                activityTypeIndicatorMaintainService.deleteIfExists(activityTypeIndicator.getKey());
            }
        }
    }
}
