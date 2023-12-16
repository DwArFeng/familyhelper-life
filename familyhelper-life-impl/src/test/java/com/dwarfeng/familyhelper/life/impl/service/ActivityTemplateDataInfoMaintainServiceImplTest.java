package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDataInfo;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDataInfoMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
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
public class ActivityTemplateDataInfoMaintainServiceImplTest {

    @Autowired
    private ActivityTemplateDataInfoMaintainService activityTemplateDataInfoMaintainService;
    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;
    @Autowired
    private ActivityDataItemMaintainService activityDataItemMaintainService;

    private List<ActivityTemplateDataInfo> activityTemplateDataInfos;
    private ActivityTemplate activityTemplate;
    private ActivityDataItem activityDataItem;

    @Before
    public void setUp() {
        activityTemplateDataInfos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActivityTemplateDataInfo activityTemplateDataInfo = new ActivityTemplateDataInfo(
                    null, null, null, "remark", new BigDecimal(12450)
            );
            activityTemplateDataInfos.add(activityTemplateDataInfo);
        }
        activityTemplate = new ActivityTemplate(
                null, "activityType", "name", "remark", "activityNameTemplate", "activityRemarkTemplate",
                "activityStartDateTemplate", "activityEndDateTemplate", new Date(), new Date(), new Date(), new Date(),
                12450
        );
        activityDataItem = new ActivityDataItem(
                null, null, null, "name", "remark", 12450, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE,
                BigDecimal.ONE, new Date(), new Date(), 12450
        );
    }

    @After
    public void tearDown() {
        activityTemplateDataInfos.clear();
        activityTemplate = null;
        activityDataItem = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (ActivityTemplateDataInfo activityTemplateDataInfo : activityTemplateDataInfos) {
                activityTemplateDataInfo.setKey(
                        activityTemplateDataInfoMaintainService.insert(activityTemplateDataInfo)
                );

                ActivityTemplateDataInfo testActivityTemplateDataInfo = activityTemplateDataInfoMaintainService.get(
                        activityTemplateDataInfo.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateDataInfo),
                        BeanUtils.describe(testActivityTemplateDataInfo)
                );
                activityTemplateDataInfoMaintainService.update(activityTemplateDataInfo);
                testActivityTemplateDataInfo = activityTemplateDataInfoMaintainService.get(
                        activityTemplateDataInfo.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateDataInfo),
                        BeanUtils.describe(testActivityTemplateDataInfo)
                );
            }
        } finally {
            for (ActivityTemplateDataInfo activityTemplateDataInfo : activityTemplateDataInfos) {
                activityTemplateDataInfoMaintainService.deleteIfExists(activityTemplateDataInfo.getKey());
            }
        }
    }

    @Test
    public void testForActivityTemplateCascade() throws Exception {
        try {
            activityTemplate.setKey(activityTemplateMaintainService.insertOrUpdate(activityTemplate));
            for (ActivityTemplateDataInfo activityTemplateDataInfo : activityTemplateDataInfos) {
                activityTemplateDataInfo.setActivityTemplateKey(activityTemplate.getKey());
                activityTemplateDataInfo.setKey(
                        activityTemplateDataInfoMaintainService.insert(activityTemplateDataInfo)
                );
            }

            assertEquals(activityTemplateDataInfos.size(), activityTemplateDataInfoMaintainService.lookup(
                    ActivityTemplateDataInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());

            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());

            assertEquals(0, activityTemplateDataInfoMaintainService.lookup(
                    ActivityTemplateDataInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE,
                    new Object[]{activityTemplate.getKey()}
            ).getCount());
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            for (ActivityTemplateDataInfo activityTemplateDataInfo : activityTemplateDataInfos) {
                activityTemplateDataInfoMaintainService.deleteIfExists(activityTemplateDataInfo.getKey());
            }
        }
    }

    @Test
    public void testForActivityDataItemCascade() throws Exception {
        try {
            activityDataItem.setKey(activityDataItemMaintainService.insertOrUpdate(activityDataItem));
            for (ActivityTemplateDataInfo activityTemplateDataInfo : activityTemplateDataInfos) {
                activityTemplateDataInfo.setActivityDataItemKey(activityDataItem.getKey());
                activityTemplateDataInfo.setKey(
                        activityTemplateDataInfoMaintainService.insert(activityTemplateDataInfo)
                );
            }

            assertEquals(activityTemplateDataInfos.size(), activityTemplateDataInfoMaintainService.lookup(
                    ActivityTemplateDataInfoMaintainService.CHILD_FOR_ACTIVITY_DATA_ITEM,
                    new Object[]{activityDataItem.getKey()}
            ).getCount());

            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());

            assertEquals(0, activityTemplateDataInfoMaintainService.lookup(
                    ActivityTemplateDataInfoMaintainService.CHILD_FOR_ACTIVITY_DATA_ITEM,
                    new Object[]{activityDataItem.getKey()}
            ).getCount());
        } finally {
            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            for (ActivityTemplateDataInfo activityTemplateDataInfo : activityTemplateDataInfos) {
                activityTemplateDataInfoMaintainService.deleteIfExists(activityTemplateDataInfo.getKey());
            }
        }
    }
}
