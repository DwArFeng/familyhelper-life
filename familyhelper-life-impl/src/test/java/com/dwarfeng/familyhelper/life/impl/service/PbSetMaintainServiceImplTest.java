package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet;
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
public class PbSetMaintainServiceImplTest {

    @Autowired
    private PbSetMaintainService pbSetMaintainService;

    private List<PbSet> pbSets;

    @Before
    public void setUp() {
        pbSets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PbSet pbSet = new PbSet(null, "name", "remark", new Date());
            pbSets.add(pbSet);
        }
    }

    @After
    public void tearDown() {
        pbSets.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (PbSet pbSet : pbSets) {
                pbSet.setKey(pbSetMaintainService.insert(pbSet));

                PbSet testPbSet = pbSetMaintainService.get(pbSet.getKey());
                assertEquals(BeanUtils.describe(pbSet), BeanUtils.describe(testPbSet));
                pbSetMaintainService.update(pbSet);
                testPbSet = pbSetMaintainService.get(pbSet.getKey());
                assertEquals(BeanUtils.describe(pbSet), BeanUtils.describe(testPbSet));
            }
        } finally {
            for (PbSet pbSet : pbSets) {
                pbSetMaintainService.deleteIfExists(pbSet.getKey());
            }
        }
    }
}
