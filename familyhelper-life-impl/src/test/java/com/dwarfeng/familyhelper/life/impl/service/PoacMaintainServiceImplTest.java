package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poac;
import com.dwarfeng.familyhelper.life.stack.bean.entity.User;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoacKey;
import com.dwarfeng.familyhelper.life.stack.service.ActivityMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoacMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class PoacMaintainServiceImplTest {

    private static final long ACTIVITY_ID = 12450;
    private static final String USER_ID = "test_user";

    @Autowired
    private ActivityMaintainService activityMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private PoacMaintainService poacMaintainService;

    private Activity activity;
    private User user;
    private Poac poac;

    @Before
    public void setUp() {
        activity = new Activity(
                new LongIdKey(ACTIVITY_ID), "activityType", "name", 12450, "remark", true, new Date(), new Date(),
                new Date(), new Date(), new Date(), new Date()
        );
        user = new User(new StringIdKey(USER_ID), "remark");
        poac = new Poac(new PoacKey(ACTIVITY_ID, USER_ID), 233, "remark");
    }

    @After
    public void tearDown() {
        activity = null;
        user = null;
        poac = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            activityMaintainService.insertOrUpdate(activity);
            userMaintainService.insertOrUpdate(user);
            poacMaintainService.insert(poac);
            poacMaintainService.update(poac);

            Poac testPoac = poacMaintainService.get(poac.getKey());
            assertEquals(BeanUtils.describe(poac), BeanUtils.describe(testPoac));
            testPoac = poacMaintainService.get(poac.getKey());
            assertEquals(BeanUtils.describe(poac), BeanUtils.describe(testPoac));
        } finally {
            activityMaintainService.deleteIfExists(activity.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poacMaintainService.deleteIfExists(poac.getKey());
        }
    }

    @Test
    public void testForActivityCascade() throws Exception {
        try {
            activityMaintainService.insertOrUpdate(activity);
            userMaintainService.insertOrUpdate(user);
            poacMaintainService.insert(poac);

            activityMaintainService.deleteIfExists(activity.getKey());
            assertFalse(poacMaintainService.exists(poac.getKey()));
        } finally {
            activityMaintainService.deleteIfExists(activity.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poacMaintainService.deleteIfExists(poac.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            activityMaintainService.insertOrUpdate(activity);
            userMaintainService.insertOrUpdate(user);
            poacMaintainService.insert(poac);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(poacMaintainService.exists(poac.getKey()));
        } finally {
            activityMaintainService.deleteIfExists(activity.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poacMaintainService.deleteIfExists(poac.getKey());
        }
    }
}
