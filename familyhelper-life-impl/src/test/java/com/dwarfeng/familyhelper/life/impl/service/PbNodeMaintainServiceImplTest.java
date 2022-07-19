package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
import com.dwarfeng.familyhelper.life.stack.service.PbNodeMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbSetMaintainService;
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
public class PbNodeMaintainServiceImplTest {

    @Autowired
    private PbNodeMaintainService pbNodeMaintainService;
    @Autowired
    private PbSetMaintainService pbSetMaintainService;

    private List<PbNode> pbNodes;
    private PbNode parent;
    private PbSet pbSet;

    @Before
    public void setUp() {
        pbNodes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PbNode pbNode = new PbNode(null, null, null, "name", "remark");
            pbNodes.add(pbNode);
        }
        parent = new PbNode(null, null, null, "name", "remark");
        pbSet = new PbSet(null, "name", "remark", new Date(), 0, new Date());
    }

    @After
    public void tearDown() {
        pbNodes.clear();
        parent = null;
        pbSet = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (PbNode pbNode : pbNodes) {
                pbNode.setKey(pbNodeMaintainService.insert(pbNode));

                PbNode testPbNode = pbNodeMaintainService.get(pbNode.getKey());
                assertEquals(BeanUtils.describe(pbNode), BeanUtils.describe(testPbNode));
                pbNodeMaintainService.update(pbNode);
                testPbNode = pbNodeMaintainService.get(pbNode.getKey());
                assertEquals(BeanUtils.describe(pbNode), BeanUtils.describe(testPbNode));
            }
        } finally {
            for (PbNode pbNode : pbNodes) {
                pbNodeMaintainService.deleteIfExists(pbNode.getKey());
            }
        }
    }

    @Test
    public void testForParentCascade() throws Exception {
        try {
            parent.setKey(pbNodeMaintainService.insertOrUpdate(parent));
            for (PbNode pbNode : pbNodes) {
                pbNode.setParentKey(parent.getKey());
                pbNode.setKey(pbNodeMaintainService.insert(pbNode));
            }

            assertEquals(pbNodes.size(), pbNodeMaintainService.lookup(
                    PbNodeMaintainService.CHILD_FOR_PARENT, new Object[]{parent.getKey()}
            ).getCount());

            pbNodeMaintainService.deleteIfExists(parent.getKey());

            assertEquals(0, pbNodeMaintainService.lookup(
                    PbNodeMaintainService.CHILD_FOR_PARENT, new Object[]{parent.getKey()}
            ).getCount());
        } finally {
            pbNodeMaintainService.deleteIfExists(parent.getKey());
            for (PbNode pbNode : pbNodes) {
                pbNodeMaintainService.deleteIfExists(pbNode.getKey());
            }
        }
    }

    @Test
    public void testForPbSetCascade() throws Exception {
        try {
            pbSet.setKey(pbSetMaintainService.insertOrUpdate(pbSet));
            for (PbNode pbNode : pbNodes) {
                pbNode.setSetKey(pbSet.getKey());
                pbNode.setKey(pbNodeMaintainService.insert(pbNode));
            }

            assertEquals(pbNodes.size(), pbNodeMaintainService.lookup(
                    PbNodeMaintainService.CHILD_FOR_SET, new Object[]{pbSet.getKey()}
            ).getCount());

            pbSetMaintainService.deleteIfExists(pbSet.getKey());

            assertEquals(0, pbNodeMaintainService.lookup(
                    PbNodeMaintainService.CHILD_FOR_SET, new Object[]{pbSet.getKey()}
            ).getCount());
        } finally {
            pbSetMaintainService.deleteIfExists(pbSet.getKey());
            for (PbNode pbNode : pbNodes) {
                pbNodeMaintainService.deleteIfExists(pbNode.getKey());
            }
        }
    }
}
