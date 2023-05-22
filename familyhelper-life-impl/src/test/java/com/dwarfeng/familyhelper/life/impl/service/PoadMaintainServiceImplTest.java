package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Poad;
import com.dwarfeng.familyhelper.life.stack.bean.entity.User;
import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataSetMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PoadMaintainService;
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
public class PoadMaintainServiceImplTest {

    private static final long ACTIVITY_DATA_SET_ID = 12450;
    private static final String USER_ID = "test_user";

    @Autowired
    private ActivityDataSetMaintainService activityDataSetMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private PoadMaintainService poadMaintainService;

    private ActivityDataSet activityDataSet;
    private User user;
    private Poad poad;

    @Before
    public void setUp() {
        activityDataSet = new ActivityDataSet(new LongIdKey(ACTIVITY_DATA_SET_ID), "name", "remark", 12450, new Date());
        user = new User(new StringIdKey(USER_ID), "remark");
        poad = new Poad(new PoadKey(ACTIVITY_DATA_SET_ID, USER_ID), 233, "remark");
    }

    @After
    public void tearDown() {
        activityDataSet = null;
        user = null;
        poad = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            activityDataSetMaintainService.insertOrUpdate(activityDataSet);
            userMaintainService.insertOrUpdate(user);
            poadMaintainService.insert(poad);
            poadMaintainService.update(poad);

            Poad testPoad = poadMaintainService.get(poad.getKey());
            assertEquals(BeanUtils.describe(poad), BeanUtils.describe(testPoad));
            testPoad = poadMaintainService.get(poad.getKey());
            assertEquals(BeanUtils.describe(poad), BeanUtils.describe(testPoad));
        } finally {
            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poadMaintainService.deleteIfExists(poad.getKey());
        }
    }

    @Test
    public void testForActivityDataSetCascade() throws Exception {
        try {
            activityDataSetMaintainService.insertOrUpdate(activityDataSet);
            userMaintainService.insertOrUpdate(user);
            poadMaintainService.insert(poad);

            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());
            assertFalse(poadMaintainService.exists(poad.getKey()));
        } finally {
            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poadMaintainService.deleteIfExists(poad.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            activityDataSetMaintainService.insertOrUpdate(activityDataSet);
            userMaintainService.insertOrUpdate(user);
            poadMaintainService.insert(poad);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(poadMaintainService.exists(poad.getKey()));
        } finally {
            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            poadMaintainService.deleteIfExists(poad.getKey());
        }
    }
}
