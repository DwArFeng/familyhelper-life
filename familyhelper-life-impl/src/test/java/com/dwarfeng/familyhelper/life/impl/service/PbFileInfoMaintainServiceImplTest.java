package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord;
import com.dwarfeng.familyhelper.life.stack.service.PbFileInfoMaintainService;
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
public class PbFileInfoMaintainServiceImplTest {

    @Autowired
    private PbFileInfoMaintainService pbFileInfoMaintainService;
    @Autowired
    private PbRecordMaintainService pbRecordMaintainService;

    private List<PbFileInfo> pbFileInfos;
    private PbRecord pbRecord;

    @Before
    public void setUp() {
        pbFileInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PbFileInfo pbFileInfo = new PbFileInfo(null, null, "origin_name", 12450L, new Date(), new Date(), "remark");
            pbFileInfos.add(pbFileInfo);
        }
        pbRecord = new PbRecord(null, null, 12.45, new Date(), "remark");
    }

    @After
    public void tearDown() {
        pbFileInfos.clear();
        pbRecord = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (PbFileInfo pbFileInfo : pbFileInfos) {
                pbFileInfo.setKey(pbFileInfoMaintainService.insert(pbFileInfo));

                PbFileInfo testPbFileInfo = pbFileInfoMaintainService.get(pbFileInfo.getKey());
                assertEquals(BeanUtils.describe(pbFileInfo), BeanUtils.describe(testPbFileInfo));
                pbFileInfoMaintainService.update(pbFileInfo);
                testPbFileInfo = pbFileInfoMaintainService.get(pbFileInfo.getKey());
                assertEquals(BeanUtils.describe(pbFileInfo), BeanUtils.describe(testPbFileInfo));
            }
        } finally {
            for (PbFileInfo pbFileInfo : pbFileInfos) {
                pbFileInfoMaintainService.deleteIfExists(pbFileInfo.getKey());
            }
        }
    }

    @Test
    public void testForPbRecordCascade() throws Exception {
        try {
            pbRecord.setKey(pbRecordMaintainService.insertOrUpdate(pbRecord));
            for (PbFileInfo pbFileInfo : pbFileInfos) {
                pbFileInfo.setRecordKey(pbRecord.getKey());
                pbFileInfo.setKey(pbFileInfoMaintainService.insert(pbFileInfo));
            }

            assertEquals(pbFileInfos.size(), pbFileInfoMaintainService.lookup(
                    PbFileInfoMaintainService.CHILD_FOR_RECORD, new Object[]{pbRecord.getKey()}
            ).getCount());

            pbRecordMaintainService.deleteIfExists(pbRecord.getKey());

            assertEquals(0, pbFileInfoMaintainService.lookup(
                    PbFileInfoMaintainService.CHILD_FOR_RECORD, new Object[]{pbRecord.getKey()}
            ).getCount());
        } finally {
            pbRecordMaintainService.deleteIfExists(pbRecord.getKey());
            for (PbFileInfo pbFileInfo : pbFileInfos) {
                pbFileInfoMaintainService.deleteIfExists(pbFileInfo.getKey());
            }
        }
    }
}
