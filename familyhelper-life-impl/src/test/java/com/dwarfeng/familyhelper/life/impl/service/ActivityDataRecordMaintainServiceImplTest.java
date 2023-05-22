package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataRecordMaintainService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ActivityDataRecordMaintainServiceImplTest {

    @Autowired
    private ActivityDataRecordMaintainService activityDataRecordMaintainService;
    @Autowired
    private ActivityDataItemMaintainService activityDataItemMaintainService;

    private List<ActivityDataRecord> activityDataRecords;
    private ActivityDataItem activityDataItem;

    @Before
    public void setUp() {
        activityDataRecords = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityDataRecord activityDataRecord = new ActivityDataRecord(
                    null, null, BigDecimal.ONE, new Date(), "remark"
            );
            activityDataRecords.add(activityDataRecord);
        }
        activityDataItem = new ActivityDataItem(
                null, null, null, "name", "remark", 12450, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE,
                BigDecimal.ONE, new Date(), new Date(), 12450
        );
    }

    @After
    public void tearDown() {
        activityDataRecords.clear();
        activityDataItem = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityDataRecord activityDataRecord : activityDataRecords) {
                activityDataRecord.setKey(activityDataRecordMaintainService.insert(activityDataRecord));

                ActivityDataRecord testActivityDataRecord = activityDataRecordMaintainService.get(
                        activityDataRecord.getKey()
                );
                assertEquals(BeanUtils.describe(activityDataRecord), BeanUtils.describe(testActivityDataRecord));
                activityDataRecordMaintainService.update(activityDataRecord);
                testActivityDataRecord = activityDataRecordMaintainService.get(activityDataRecord.getKey());
                assertEquals(BeanUtils.describe(activityDataRecord), BeanUtils.describe(testActivityDataRecord));
            }
        } finally {
            for (ActivityDataRecord activityDataRecord : activityDataRecords) {
                activityDataRecordMaintainService.deleteIfExists(activityDataRecord.getKey());
            }
        }
    }

    @Test
    public void testForActivityDataItemCascade() throws Exception {
        try {
            activityDataItem.setKey(activityDataItemMaintainService.insertOrUpdate(activityDataItem));
            for (ActivityDataRecord activityDataRecord : activityDataRecords) {
                activityDataRecord.setItemKey(activityDataItem.getKey());
                activityDataRecord.setKey(activityDataRecordMaintainService.insert(activityDataRecord));
            }

            assertEquals(activityDataRecords.size(), activityDataRecordMaintainService.lookup(
                    ActivityDataRecordMaintainService.CHILD_FOR_ITEM, new Object[]{activityDataItem.getKey()}
            ).getCount());

            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());

            assertEquals(0, activityDataRecordMaintainService.lookup(
                    ActivityDataRecordMaintainService.CHILD_FOR_ITEM, new Object[]{activityDataItem.getKey()}
            ).getCount());
        } finally {
            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            for (ActivityDataRecord activityDataRecord : activityDataRecords) {
                activityDataRecordMaintainService.deleteIfExists(activityDataRecord.getKey());
            }
        }
    }
}
