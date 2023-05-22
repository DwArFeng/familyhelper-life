package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet;
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
public class ActivityDataSetMaintainServiceImplTest {

    @Autowired
    private ActivityDataSetMaintainService activityDataSetMaintainService;

    private List<ActivityDataSet> activityDataSets;

    @Before
    public void setUp() {
        activityDataSets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityDataSet activityDataSet = new ActivityDataSet(null, "name", "remark", 12450, new Date());
            activityDataSets.add(activityDataSet);
        }
    }

    @After
    public void tearDown() {
        activityDataSets.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityDataSet activityDataSet : activityDataSets) {
                activityDataSet.setKey(activityDataSetMaintainService.insert(activityDataSet));

                ActivityDataSet testActivityDataSet = activityDataSetMaintainService.get(activityDataSet.getKey());
                assertEquals(BeanUtils.describe(activityDataSet), BeanUtils.describe(testActivityDataSet));
                activityDataSetMaintainService.update(activityDataSet);
                testActivityDataSet = activityDataSetMaintainService.get(activityDataSet.getKey());
                assertEquals(BeanUtils.describe(activityDataSet), BeanUtils.describe(testActivityDataSet));
            }
        } finally {
            for (ActivityDataSet activityDataSet : activityDataSets) {
                activityDataSetMaintainService.deleteIfExists(activityDataSet.getKey());
            }
        }
    }
}
