package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.Activity;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.familyhelper.life.stack.service.ActivityActivityDataRecordRelationMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataRecordMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ActivityActivityDataRecordRelationMaintainServiceImplTest {

    private static final long ACTIVITY_ID = 12450;
    private static final long ACTIVITY_DATA_RECORD_ID = 12450;

    @Autowired
    private ActivityMaintainService activityMaintainService;
    @Autowired
    private ActivityDataRecordMaintainService activityDataRecordMaintainService;
    @Autowired
    private ActivityActivityDataRecordRelationMaintainService activityActivityDataRecordRelationMaintainService;

    private Activity activity;
    private ActivityDataRecord activityDataRecord;
    private ActivityActivityDataRecordRelation activityActivityDataRecordRelation;

    @Before
    public void setUp() {
        activity = new Activity(
                new LongIdKey(ACTIVITY_ID), "activityType", "name", 12450, "remark", true, new Date(), new Date(),
                new Date(), new Date(), new Date(), new Date()
        );
        activityDataRecord = new ActivityDataRecord(
                new LongIdKey(ACTIVITY_DATA_RECORD_ID), null, BigDecimal.ONE, new Date(), "remark"
        );
        activityActivityDataRecordRelation = new ActivityActivityDataRecordRelation(
                new LongLongRelationKey(ACTIVITY_ID, ACTIVITY_DATA_RECORD_ID), "remark"
        );
    }

    @After
    public void tearDown() {
        activity = null;
        activityDataRecord = null;
        activityActivityDataRecordRelation = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            activityMaintainService.insertOrUpdate(activity);
            activityDataRecordMaintainService.insertOrUpdate(activityDataRecord);
            activityActivityDataRecordRelationMaintainService.insert(activityActivityDataRecordRelation);
            activityActivityDataRecordRelationMaintainService.update(activityActivityDataRecordRelation);

            ActivityActivityDataRecordRelation testActivityActivityDataRecordRelation =
                    activityActivityDataRecordRelationMaintainService.get(activityActivityDataRecordRelation.getKey());
            assertEquals(
                    BeanUtils.describe(activityActivityDataRecordRelation),
                    BeanUtils.describe(testActivityActivityDataRecordRelation)
            );
            testActivityActivityDataRecordRelation =
                    activityActivityDataRecordRelationMaintainService.get(activityActivityDataRecordRelation.getKey());
            assertEquals(
                    BeanUtils.describe(activityActivityDataRecordRelation),
                    BeanUtils.describe(testActivityActivityDataRecordRelation)
            );
        } finally {
            activityMaintainService.deleteIfExists(activity.getKey());
            activityDataRecordMaintainService.deleteIfExists(activityDataRecord.getKey());
            activityActivityDataRecordRelationMaintainService.deleteIfExists(
                    activityActivityDataRecordRelation.getKey()
            );
        }
    }

    @Test
    public void testForActivityCascade() throws Exception {
        try {
            activityMaintainService.insertOrUpdate(activity);
            activityDataRecordMaintainService.insertOrUpdate(activityDataRecord);
            activityActivityDataRecordRelationMaintainService.insert(activityActivityDataRecordRelation);

            activityMaintainService.deleteIfExists(activity.getKey());
            assertFalse(activityActivityDataRecordRelationMaintainService.exists(
                    activityActivityDataRecordRelation.getKey()
            ));
        } finally {
            activityMaintainService.deleteIfExists(activity.getKey());
            activityDataRecordMaintainService.deleteIfExists(activityDataRecord.getKey());
            activityActivityDataRecordRelationMaintainService.deleteIfExists(
                    activityActivityDataRecordRelation.getKey()
            );
        }
    }

    @Test
    public void testForActivityDataRecordCascade() throws Exception {
        try {
            activityMaintainService.insertOrUpdate(activity);
            activityDataRecordMaintainService.insertOrUpdate(activityDataRecord);
            activityActivityDataRecordRelationMaintainService.insert(activityActivityDataRecordRelation);

            activityDataRecordMaintainService.deleteIfExists(activityDataRecord.getKey());
            assertFalse(activityActivityDataRecordRelationMaintainService.exists(
                    activityActivityDataRecordRelation.getKey()
            ));
        } finally {
            activityMaintainService.deleteIfExists(activity.getKey());
            activityDataRecordMaintainService.deleteIfExists(activityDataRecord.getKey());
            activityActivityDataRecordRelationMaintainService.deleteIfExists(
                    activityActivityDataRecordRelation.getKey()
            );
        }
    }
}
