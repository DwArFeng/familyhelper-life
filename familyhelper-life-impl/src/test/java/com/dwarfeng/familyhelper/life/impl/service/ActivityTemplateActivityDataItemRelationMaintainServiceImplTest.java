package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate;
import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateActivityDataItemRelation;
import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateActivityDataItemRelationMaintainService;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ActivityTemplateActivityDataItemRelationMaintainServiceImplTest {

    private static final long ACTIVITY_TEMPLATE_ID = 12450;
    private static final long ACTIVITY_DATA_ITEM_ID = 12450;

    @Autowired
    private ActivityTemplateMaintainService activityTemplateMaintainService;
    @Autowired
    private ActivityDataItemMaintainService activityDataItemMaintainService;
    @Autowired
    private ActivityTemplateActivityDataItemRelationMaintainService
            activityTemplateActivityDataItemRelationMaintainService;

    private ActivityTemplate activityTemplate;
    private ActivityDataItem activityDataItem;
    private ActivityTemplateActivityDataItemRelation activityTemplateActivityDataItemRelation;

    @Before
    public void setUp() {
        activityTemplate = new ActivityTemplate(
                new LongIdKey(ACTIVITY_TEMPLATE_ID), "activityType", "name", "remark", "activityNameTemplate",
                "activityRemarkTemplate", "activityStartDateTemplate", "activityEndDateTemplate", new Date(),
                new Date(), new Date(), new Date(), 12450
        );
        activityDataItem = new ActivityDataItem(
                new LongIdKey(ACTIVITY_DATA_ITEM_ID), null, null, "name", "remark", 12450, BigDecimal.ONE,
                BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, new Date(), new Date(), 12450
        );
        activityTemplateActivityDataItemRelation = new ActivityTemplateActivityDataItemRelation(
                new LongLongRelationKey(ACTIVITY_TEMPLATE_ID, ACTIVITY_DATA_ITEM_ID), "remark", BigDecimal.ONE
        );
    }

    @After
    public void tearDown() {
        activityTemplate = null;
        activityDataItem = null;
        activityTemplateActivityDataItemRelation = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            activityDataItemMaintainService.insertOrUpdate(activityDataItem);
            activityTemplateActivityDataItemRelationMaintainService.insert(activityTemplateActivityDataItemRelation);
            activityTemplateActivityDataItemRelationMaintainService.update(activityTemplateActivityDataItemRelation);

            ActivityTemplateActivityDataItemRelation testActivityTemplateActivityDataItemRelation =
                    activityTemplateActivityDataItemRelationMaintainService.get(
                            activityTemplateActivityDataItemRelation.getKey()
                    );
            assertEquals(
                    BeanUtils.describe(activityTemplateActivityDataItemRelation),
                    BeanUtils.describe(testActivityTemplateActivityDataItemRelation)
            );
            testActivityTemplateActivityDataItemRelation =
                    activityTemplateActivityDataItemRelationMaintainService.get(
                            activityTemplateActivityDataItemRelation.getKey()
                    );
            assertEquals(
                    BeanUtils.describe(activityTemplateActivityDataItemRelation),
                    BeanUtils.describe(testActivityTemplateActivityDataItemRelation)
            );
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            activityTemplateActivityDataItemRelationMaintainService.deleteIfExists(
                    activityTemplateActivityDataItemRelation.getKey()
            );
        }
    }

    @Test
    public void testForActivityTemplateCascade() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            activityDataItemMaintainService.insertOrUpdate(activityDataItem);
            activityTemplateActivityDataItemRelationMaintainService.insert(activityTemplateActivityDataItemRelation);

            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            assertFalse(activityTemplateActivityDataItemRelationMaintainService.exists(
                    activityTemplateActivityDataItemRelation.getKey()
            ));
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            activityTemplateActivityDataItemRelationMaintainService.deleteIfExists(
                    activityTemplateActivityDataItemRelation.getKey()
            );
        }
    }

    @Test
    public void testForActivityDataItemCascade() throws Exception {
        try {
            activityTemplateMaintainService.insertOrUpdate(activityTemplate);
            activityDataItemMaintainService.insertOrUpdate(activityDataItem);
            activityTemplateActivityDataItemRelationMaintainService.insert(activityTemplateActivityDataItemRelation);

            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            assertFalse(activityTemplateActivityDataItemRelationMaintainService.exists(
                    activityTemplateActivityDataItemRelation.getKey()
            ));
        } finally {
            activityTemplateMaintainService.deleteIfExists(activityTemplate.getKey());
            activityDataItemMaintainService.deleteIfExists(activityDataItem.getKey());
            activityTemplateActivityDataItemRelationMaintainService.deleteIfExists(
                    activityTemplateActivityDataItemRelation.getKey()
            );
        }
    }
}
