package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode;
import com.dwarfeng.familyhelper.life.stack.service.PbItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbNodeMaintainService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class PbItemMaintainServiceImplTest {

    @Autowired
    private PbItemMaintainService pbItemMaintainService;
    @Autowired
    private PbNodeMaintainService pbNodeMaintainService;

    private List<PbItem> pbItems;
    private PbNode pbNode;

    @Before
    public void setUp() {
        pbItems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PbItem pbItem = new PbItem(null, null, "name", "unit", 1, "remark");
            pbItems.add(pbItem);
        }
        pbNode = new PbNode(null, null, null, "name", "remark");
    }

    @After
    public void tearDown() {
        pbItems.clear();
        pbNode = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (PbItem pbItem : pbItems) {
                pbItem.setKey(pbItemMaintainService.insert(pbItem));

                PbItem testPbItem = pbItemMaintainService.get(pbItem.getKey());
                assertEquals(BeanUtils.describe(pbItem), BeanUtils.describe(testPbItem));
                pbItemMaintainService.update(pbItem);
                testPbItem = pbItemMaintainService.get(pbItem.getKey());
                assertEquals(BeanUtils.describe(pbItem), BeanUtils.describe(testPbItem));
            }
        } finally {
            for (PbItem pbItem : pbItems) {
                pbItemMaintainService.deleteIfExists(pbItem.getKey());
            }
        }
    }

    @Test
    public void testForPbNodeCascade() throws Exception {
        try {
            pbNode.setKey(pbNodeMaintainService.insertOrUpdate(pbNode));
            for (PbItem pbItem : pbItems) {
                pbItem.setNodeKey(pbNode.getKey());
                pbItem.setKey(pbItemMaintainService.insert(pbItem));
            }

            assertEquals(pbItems.size(), pbItemMaintainService.lookup(
                    PbItemMaintainService.CHILD_FOR_NODE, new Object[]{pbNode.getKey()}
            ).getCount());

            pbNodeMaintainService.deleteIfExists(pbNode.getKey());

            assertEquals(0, pbItemMaintainService.lookup(
                    PbItemMaintainService.CHILD_FOR_NODE, new Object[]{pbNode.getKey()}
            ).getCount());
        } finally {
            pbNodeMaintainService.deleteIfExists(pbNode.getKey());
            for (PbItem pbItem : pbItems) {
                pbItemMaintainService.deleteIfExists(pbItem.getKey());
            }
        }
    }
}
