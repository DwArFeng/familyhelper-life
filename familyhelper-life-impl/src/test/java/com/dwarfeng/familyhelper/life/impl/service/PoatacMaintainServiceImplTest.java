package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poatac;
import com.dwarfeng.familyhelper.life.stack.bean.entity.User;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoatacKey;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoatacMaintainService;
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
public class PoatacMaintainServiceImplTest {

    private static final long ACTIVITY_TEMPLATE_ID = 12450;
    private static final String USER_ID = "test_user";

    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private PoatacMaintainService poatacMaintainService;

    private ActivityTemplate activityTemplate;
    private User user;
    private Poatac poatac;

    @Before
    public void setUp() {
        activityTemplate = new ActivityTemplate(
                new LongIdKey(ACTIVITY_TEMPLATE_ID), "activityType", "name", "remark", "activityNameTemplate",
                "activityRemarkTemplate", "activityStartDateTemplate", "activityEndDateTemplate", new Date(),
                new Date(), new Date(), new Date(), 12450
        );
        user = new User(new StringIdKey(USER_ID), "remark");
        poatac = new Poatac(new PoatacKey(ACTIVITY_TEMPLATE_ID, USER_ID), 233, "remark");
    }

    @After
    public void tearDown() {
        activityTemplate = null;
        user = null;
        poatac = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            userMaintainService.insertOrUpdate(user);
            poatacMaintainService.insert(poatac);
            poatacMaintainService.update(poatac);

            Poatac testPoatac = poatacMaintainService.get(poatac.getKey());
            assertEquals(BeanUtils.describe(poatac), BeanUtils.describe(testPoatac));
            testPoatac = poatacMaintainService.get(poatac.getKey());
            assertEquals(BeanUtils.describe(poatac), BeanUtils.describe(testPoatac));
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poatacMaintainService.deleteIfExists(poatac.getKey());
        }
    }

    @Test
    public void testForActivityTemplateCascade() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            userMaintainService.insertOrUpdate(user);
            poatacMaintainService.insert(poatac);

            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            assertFalse(poatacMaintainService.exists(poatac.getKey()));
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poatacMaintainService.deleteIfExists(poatac.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            userMaintainService.insertOrUpdate(user);
            poatacMaintainService.insert(poatac);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(poatacMaintainService.exists(poatac.getKey()));
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poatacMaintainService.deleteIfExists(poatac.getKey());
        }
    }
}
