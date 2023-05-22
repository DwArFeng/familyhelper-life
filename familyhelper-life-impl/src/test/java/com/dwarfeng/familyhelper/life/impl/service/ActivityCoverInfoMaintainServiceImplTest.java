package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityCoverInfo;
import com.dwarfeng.familyhelper.life.stack.service.ActivityCoverInfoMaintainService;
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
public class ActivityCoverInfoMaintainServiceImplTest {

    @Autowired
    private ActivityCoverInfoMaintainService activityCoverInfoMaintainService;
    @Autowired
    private ActivityMaintainService activityMaintainService;

    private List<ActivityCoverInfo> activityCoverInfos;
    private Activity activity;

    @Before
    public void setUp() {
        activityCoverInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityCoverInfo activityCoverInfo = new ActivityCoverInfo(
                    null, null, "origin_name", 12450L, new Date(), new Date(), "remark", 12450
            );
            activityCoverInfos.add(activityCoverInfo);
        }
        activity = new Activity(
                null, "activityType", "name", 12450, "remark", true, new Date(), new Date(), new Date(), new Date(),
                new Date(), new Date()
        );
    }

    @After
    public void tearDown() {
        activityCoverInfos.clear();
        activity = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityCoverInfo activityCoverInfo : activityCoverInfos) {
                activityCoverInfo.setKey(activityCoverInfoMaintainService.insert(activityCoverInfo));

                ActivityCoverInfo testActivityCoverInfo = activityCoverInfoMaintainService.get(
                        activityCoverInfo.getKey()
                );
                assertEquals(BeanUtils.describe(activityCoverInfo), BeanUtils.describe(testActivityCoverInfo));
                activityCoverInfoMaintainService.update(activityCoverInfo);
                testActivityCoverInfo = activityCoverInfoMaintainService.get(activityCoverInfo.getKey());
                assertEquals(BeanUtils.describe(activityCoverInfo), BeanUtils.describe(testActivityCoverInfo));
            }
        } finally {
            for (ActivityCoverInfo activityCoverInfo : activityCoverInfos) {
                activityCoverInfoMaintainService.deleteIfExists(activityCoverInfo.getKey());
            }
        }
    }

    @Test
    public void testForActivityCascade() throws Exception {
        try {
            activity.setKey(activityMaintainService.insertOrUpdate(activity));
            for (ActivityCoverInfo activityCoverInfo : activityCoverInfos) {
                activityCoverInfo.setActivityKey(activity.getKey());
                activityCoverInfo.setKey(activityCoverInfoMaintainService.insert(activityCoverInfo));
            }

            assertEquals(activityCoverInfos.size(), activityCoverInfoMaintainService.lookup(
                    ActivityCoverInfoMaintainService.CHILD_FOR_ACTIVITY, new Object[]{activity.getKey()}
            ).getCount());

            activityMaintainService.deleteIfExists(activity.getKey());

            assertEquals(0, activityCoverInfoMaintainService.lookup(
                    ActivityCoverInfoMaintainService.CHILD_FOR_ACTIVITY, new Object[]{activity.getKey()}
            ).getCount());
        } finally {
            activityMaintainService.deleteIfExists(activity.getKey());
            for (ActivityCoverInfo activityCoverInfo : activityCoverInfos) {
                activityCoverInfoMaintainService.deleteIfExists(activityCoverInfo.getKey());
            }
        }
    }
}
