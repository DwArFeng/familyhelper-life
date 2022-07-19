package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.familyhelper.life.stack.bean.entity.Popb;
import com.dwarfeng.familyhelper.life.stack.bean.entity.User;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.familyhelper.life.stack.service.PbSetMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PopbMaintainService;
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
public class PopbMaintainServiceImplTest {

    private static final long ASSET_CATALOG_ID = 12450;
    private static final String USER_ID = "test_user";

    @Autowired
    private PbSetMaintainService pbSetMaintainService;
    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private PopbMaintainService popbMaintainService;

    private PbSet pbSet;
    private User user;
    private Popb popb;

    @Before
    public void setUp() {
        pbSet = new PbSet(new LongIdKey(ASSET_CATALOG_ID), "name", "remark", new Date(), 0, new Date());
        user = new User(new StringIdKey(USER_ID), "remark");
        popb = new Popb(new PopbKey(ASSET_CATALOG_ID, USER_ID), 233, "remark");
    }

    @After
    public void tearDown() {
        pbSet = null;
        user = null;
        popb = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            pbSetMaintainService.insertOrUpdate(pbSet);
            userMaintainService.insertOrUpdate(user);
            popbMaintainService.insert(popb);
            popbMaintainService.update(popb);

            Popb testPopb = popbMaintainService.get(popb.getKey());
            assertEquals(BeanUtils.describe(popb), BeanUtils.describe(testPopb));
            testPopb = popbMaintainService.get(popb.getKey());
            assertEquals(BeanUtils.describe(popb), BeanUtils.describe(testPopb));
        } finally {
            pbSetMaintainService.deleteIfExists(pbSet.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            popbMaintainService.deleteIfExists(popb.getKey());
        }
    }

    @Test
    public void testForPbSetCascade() throws Exception {
        try {
            pbSetMaintainService.insertOrUpdate(pbSet);
            userMaintainService.insertOrUpdate(user);
            popbMaintainService.insert(popb);

            pbSetMaintainService.deleteIfExists(pbSet.getKey());
            assertFalse(popbMaintainService.exists(popb.getKey()));
        } finally {
            pbSetMaintainService.deleteIfExists(pbSet.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            popbMaintainService.deleteIfExists(popb.getKey());
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            pbSetMaintainService.insertOrUpdate(pbSet);
            userMaintainService.insertOrUpdate(user);
            popbMaintainService.insert(popb);

            userMaintainService.deleteIfExists(user.getKey());
            assertFalse(popbMaintainService.exists(popb.getKey()));
        } finally {
            pbSetMaintainService.deleteIfExists(pbSet.getKey());
            userMaintainService.deleteIfExists(user.getKey());
            popbMaintainService.deleteIfExists(popb.getKey());
        }
    }
}
