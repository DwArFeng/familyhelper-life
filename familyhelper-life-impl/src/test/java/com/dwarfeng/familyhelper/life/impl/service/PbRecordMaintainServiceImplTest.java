package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.familyhelper.life.stack.service.PbItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.PbRecordMaintainService;
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
public class PbRecordMaintainServiceImplTest {

    @Autowired
    private PbRecordMaintainService pbRecordMaintainService;
    @Autowired
    private PbItemMaintainService pbItemMaintainService;

    private List<PbRecord> pbRecords;
    private PbItem pbItem;

    @Before
    public void setUp() {
        pbRecords = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PbRecord pbRecord = new PbRecord(null, null, 12.45, new Date(), "remark");
            pbRecords.add(pbRecord);
        }
        pbItem = new PbItem(null, null, "name", "unit", 1, "remark");
    }

    @After
    public void tearDown() {
        pbRecords.clear();
        pbItem = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (PbRecord pbRecord : pbRecords) {
                pbRecord.setKey(pbRecordMaintainService.insert(pbRecord));

                PbRecord testPbRecord = pbRecordMaintainService.get(pbRecord.getKey());
                assertEquals(BeanUtils.describe(pbRecord), BeanUtils.describe(testPbRecord));
                pbRecordMaintainService.update(pbRecord);
                testPbRecord = pbRecordMaintainService.get(pbRecord.getKey());
                assertEquals(BeanUtils.describe(pbRecord), BeanUtils.describe(testPbRecord));
            }
        } finally {
            for (PbRecord pbRecord : pbRecords) {
                pbRecordMaintainService.deleteIfExists(pbRecord.getKey());
            }
        }
    }

    @Test
    public void testForPbItemCascade() throws Exception {
        try {
            pbItem.setKey(pbItemMaintainService.insertOrUpdate(pbItem));
            for (PbRecord pbRecord : pbRecords) {
                pbRecord.setItemKey(pbItem.getKey());
                pbRecord.setKey(pbRecordMaintainService.insert(pbRecord));
            }

            assertEquals(pbRecords.size(), pbRecordMaintainService.lookup(
                    PbRecordMaintainService.CHILD_FOR_ITEM, new Object[]{pbItem.getKey()}
            ).getCount());

            pbItemMaintainService.deleteIfExists(pbItem.getKey());

            assertEquals(0, pbRecordMaintainService.lookup(
                    PbRecordMaintainService.CHILD_FOR_ITEM, new Object[]{pbItem.getKey()}
            ).getCount());
        } finally {
            pbItemMaintainService.deleteIfExists(pbItem.getKey());
            for (PbRecord pbRecord : pbRecords) {
                pbRecordMaintainService.deleteIfExists(pbRecord.getKey());
            }
        }
    }
}
