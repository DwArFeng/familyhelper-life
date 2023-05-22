package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataNode;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ActivityDataNodeMaintainServiceImplTest {

    @Autowired
    private ActivityDataNodeMaintainService activityDataNodeMaintainService;
    @Autowired
    private ActivityDataSetMaintainService activityDataSetMaintainService;

    private List<ActivityDataNode> activityDataNodes;
    private ActivityDataNode parent;
    private ActivityDataSet activityDataSet;

    @Before
    public void setUp() {
        activityDataNodes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityDataNode activityDataNode = new ActivityDataNode(null, null, null, "name", "remark");
            activityDataNodes.add(activityDataNode);
        }
        parent = new ActivityDataNode(null, null, null, "name", "remark");
        activityDataSet = new ActivityDataSet(null, "name", "remark", 12450, new Date());
    }

    @After
    public void tearDown() {
        activityDataNodes.clear();
        parent = null;
        activityDataSet = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityDataNode activityDataNode : activityDataNodes) {
                activityDataNode.setKey(activityDataNodeMaintainService.insert(activityDataNode));

                ActivityDataNode testActivityDataNode = activityDataNodeMaintainService.get(activityDataNode.getKey());
                assertEquals(BeanUtils.describe(activityDataNode), BeanUtils.describe(testActivityDataNode));
                activityDataNodeMaintainService.update(activityDataNode);
                testActivityDataNode = activityDataNodeMaintainService.get(activityDataNode.getKey());
                assertEquals(BeanUtils.describe(activityDataNode), BeanUtils.describe(testActivityDataNode));
            }
        } finally {
            for (ActivityDataNode activityDataNode : activityDataNodes) {
                activityDataNodeMaintainService.deleteIfExists(activityDataNode.getKey());
            }
        }
    }

    @Test
    public void testForParentCascade() throws Exception {
        try {
            parent.setKey(activityDataNodeMaintainService.insertOrUpdate(parent));
            for (ActivityDataNode activityDataNode : activityDataNodes) {
                activityDataNode.setParentKey(parent.getKey());
                activityDataNode.setKey(activityDataNodeMaintainService.insert(activityDataNode));
            }

            assertEquals(activityDataNodes.size(), activityDataNodeMaintainService.lookup(
                    ActivityDataNodeMaintainService.CHILD_FOR_PARENT, new Object[]{parent.getKey()}
            ).getCount());

            activityDataNodeMaintainService.deleteIfExists(parent.getKey());

            assertEquals(0, activityDataNodeMaintainService.lookup(
                    ActivityDataNodeMaintainService.CHILD_FOR_PARENT, new Object[]{parent.getKey()}
            ).getCount());
        } finally {
            activityDataNodeMaintainService.deleteIfExists(parent.getKey());
            for (ActivityDataNode activityDataNode : activityDataNodes) {
                activityDataNodeMaintainService.deleteIfExists(activityDataNode.getKey());
            }
        }
    }

    @Test
    public void testForActivityDataSetCascade() throws Exception {
        try {
            activityDataSet.setKey(activityDataSetMaintainService.insertOrUpdate(activityDataSet));
            for (ActivityDataNode activityDataNode : activityDataNodes) {
                activityDataNode.setSetKey(activityDataSet.getKey());
                activityDataNode.setKey(activityDataNodeMaintainService.insert(activityDataNode));
            }

            assertEquals(activityDataNodes.size(), activityDataNodeMaintainService.lookup(
                    ActivityDataNodeMaintainService.CHILD_FOR_SET, new Object[]{activityDataSet.getKey()}
            ).getCount());

            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());

            assertEquals(0, activityDataNodeMaintainService.lookup(
                    ActivityDataNodeMaintainService.CHILD_FOR_SET, new Object[]{activityDataSet.getKey()}
            ).getCount());
        } finally {
            activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());
            for (ActivityDataNode activityDataNode : activityDataNodes) {
                activityDataNodeMaintainService.deleteIfExists(activityDataNode.getKey());
            }
        }
    }
}
