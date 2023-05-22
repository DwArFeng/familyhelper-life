package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateParticipant;
import com.dwarfeng.familyhelper.life.stack.bean.entity.User;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateParticipantMaintainService;
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
public class ActivityTemplateParticipantMaintainServiceImplTest {

    private static final long ACTIVITY_TEMPLATE_ID = 12450;
    private static final String USER_ID = "test_user";

    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private ActivityTemplateParticipantMaintainService activityTemplateParticipantMaintainService;

    private ActivityTemplate activityTemplate;
    private User user;
    private ActivityTemplateParticipant activityTemplateParticipant;

    @Before
    public void setUp() {
        activityTemplate = new ActivityTemplate(
                new LongIdKey(ACTIVITY_TEMPLATE_ID), "activityType", "name", "remark", "activityNameTemplate",
                "activityRemarkTemplate", "activityStartDateTemplate", "activityEndDateTemplate", new Date(),
                new Date(), new Date(), new Date(), 12450
        );
        user = new User(new StringIdKey(USER_ID), "remark");
        activityTemplateParticipant = new ActivityTemplateParticipant(
                new ActivityTemplateParticipantKey(ACTIVITY_TEMPLATE_ID, USER_ID), "remark"
        );
    }

    @After
    public void tearDown() {
        activityTemplate = null;
        user = null;
        activityTemplateParticipant = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            userMaintainService.insertOrUpdate(user);
            activityTemplateParticipantMaintainService.insert(activityTemplateParticipant);
            activityTemplateParticipantMaintainService.update(activityTemplateParticipant);

            ActivityTemplateParticipant testActivityTemplateParticipant =
                    activityTemplateParticipantMaintainService.get(activityTemplateParticipant.getKey());
            assertEquals(
                    BeanUtils.describe(activityTemplateParticipant),
                    BeanUtils.describe(testActivityTemplateParticipant)
            );
            testActivityTemplateParticipant = activityTemplateParticipantMaintainService.get(
                    activityTemplateParticipant.getKey()
            );
            assertEquals(
                    BeanUtils.describe(activityTemplateParticipant),
                    BeanUtils.describe(testActivityTemplateParticipant)
            );
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            activityTemplateParticipantMaintainService.deleteIfExists(activityTemplateParticipant.getKey());
        }
    }

    @Test
    public void testForActivityTemplateCascade() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            userMaintainService.insertOrUpdate(user);
            activityTemplateParticipantMaintainService.insert(activityTemplateParticipant);

            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            assertFalse(activityTemplateParticipantMaintainService.exists(activityTemplateParticipant.getKey()));
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            activityTemplateParticipantMaintainService.deleteIfExists(activityTemplateParticipant.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            userMaintainService.insertOrUpdate(user);
            activityTemplateParticipantMaintainService.insert(activityTemplateParticipant);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(activityTemplateParticipantMaintainService.exists(activityTemplateParticipant.getKey()));
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            activityTemplateParticipantMaintainService.deleteIfExists(activityTemplateParticipant.getKey());
        }
    }
}
