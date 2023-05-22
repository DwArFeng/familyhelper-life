package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataNode;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataNodeMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataSetMaintainService;
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
public class ActivityDataItemMaintainServiceImplTest {

    @Autowired
    private ActivityDataItemMaintainService activityDataItemMaintainService;
    @Autowired
    private ActivityDataNodeMaintainService activityDataNodeMaintainService;
    @Autowired
    private ActivityDataSetMaintainService activityDataSetMaintainService;

    private List<ActivityDataItem> activityDataItems;
    private ActivityDataNode activityDataNode;
    private ActivityDataSet activityDataSet;

    @Before
    public void setUp() {
        activityDataItems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityDataItem activityDataItem = new ActivityDataItem(
                    null, null, null, "name", "remark", 12450, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE,
                    BigDecimal.ONE, new Date(), new Date(), 12450
            );
            activityDataItems.add(activityDataItem);
        }
        activityDataNode = new ActivityDataNode(null, null, null, "name", "remark");
        activityDataSet = new ActivityDataSet(null, "name", "remark", 12450, new Date());
    }

    @After
    public void tearDown() {
        activityDataItems.clear();
        activityDataNode = null;
        activityDataSet = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityDataItem activityDataItem : activityDataItems) {
                activityDataItem.setKey(activityDataItemMaintainService.insert(activityDataItem));

                ActivityDataItem testActivityDataItem = activityDataItemMaintainService.get(activityDataItem.getKey());
                assertEquals(BeanUtils.describe(activityDataItem), BeanUtils.describe(testActivityDataItem));
                activityDataItemMaintainService.update(activityDataItem);
                testActivityDataItem = activityDataItemMaintainService.get(activityDataItem.getKey());
                assertEquals(BeanUtils.describe(activityDataItem), BeanUtils.describe(testActivityDataItem));
            }
        } finally {
            for (ActivityDataItem activityDataItem : activityDataItems) {
                activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            }
        }
    }

    @Test
    public void testForActivityDataNodeCascade() throws Exception {
        try {
            activityDataNode.setKey(activityDataNodeMaintainService.insertOrUpdate(activityDataNode));
            for (ActivityDataItem activityDataItem : activityDataItems) {
                activityDataItem.setNodeKey(activityDataNode.getKey());
                activityDataItem.setKey(activityDataItemMaintainService.insert(activityDataItem));
            }

            assertEquals(activityDataItems.size(), activityDataItemMaintainService.lookup(
                    ActivityDataItemMaintainService.CHILD_FOR_NODE, new Object[]{activityDataNode.getKey()}
            ).getCount());

            activityDataNodeMaintainService.deleteIfExists(activityDataNode.getKey());

            assertEquals(0, activityDataItemMaintainService.lookup(
                    ActivityDataItemMaintainService.CHILD_FOR_NODE, new Object[]{activityDataNode.getKey()}
            ).getCount());
        } finally {
            activityDataNodeMaintainService.deleteIfExists(activityDataNode.getKey());
            for (ActivityDataItem activityDataItem : activityDataItems) {
                activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            }
        }
    }

    @Test
    public void testForActivityDataSetCascade() throws Exception {
        try {
            activityDataSet.setKey(activityDataSetMaintainService.insertOrUpdate(activityDataSet));
            for (ActivityDataItem activityDataItem : activityDataItems) {
                activityDataItem.setSetKey(activityDataSet.getKey());
                activityDataItem.setKey(activityDataItemMaintainService.insert(activityDataItem));
            }

            assertEquals(activityDataItems.size(), activityDataItemMaintainService.lookup(
                    ActivityDataItemMaintainService.CHILD_FOR_SET, new Object[]{activityDataSet.getKey()}
            ).getCount());

            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());

            assertEquals(0, activityDataItemMaintainService.lookup(
                    ActivityDataItemMaintainService.CHILD_FOR_SET, new Object[]{activityDataSet.getKey()}
            ).getCount());
        } finally {
            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());
            for (ActivityDataItem activityDataItem : activityDataItems) {
                activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            }
        }
    }
}
