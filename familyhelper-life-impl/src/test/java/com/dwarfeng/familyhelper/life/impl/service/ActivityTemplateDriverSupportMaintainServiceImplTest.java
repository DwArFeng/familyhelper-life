package com.dwarfeng.familyhelper.life.impl.service;

import com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverSupport;
import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriverSupportMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
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
public class ActivityTemplateDriverSupportMaintainServiceImplTest {

    @Autowired
    private ActivityTemplateDriverSupportMaintainService service;

    private final List<ActivityTemplateDriverSupport> activityTemplateDriverSupports = new ArrayList<>();

    @Before
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            ActivityTemplateDriverSupport activityTemplateDriverSupport = new ActivityTemplateDriverSupport(
                    new StringIdKey("remindDriver-support-" + (i + 1)), "label", "description", "exampleParam"
            );
            activityTemplateDriverSupports.add(activityTemplateDriverSupport);
        }
    }

    @After
    public void tearDown() {
        activityTemplateDriverSupports.clear();
    }

    @Test
    public void test() throws Exception {
        try {
            for (ActivityTemplateDriverSupport activityTemplateDriverSupport : activityTemplateDriverSupports) {
                activityTemplateDriverSupport.setKey(service.insert(activityTemplateDriverSupport));
                service.update(activityTemplateDriverSupport);
                ActivityTemplateDriverSupport testActivityTemplateDriverSupport = service.get(
                        activityTemplateDriverSupport.getKey()
                );
                assertEquals(
                        BeanUtils.describe(activityTemplateDriverSupport),
                        BeanUtils.describe(testActivityTemplateDriverSupport)
                );
            }
        } finally {
            for (ActivityTemplateDriverSupport activityTemplateDriverSupport : activityTemplateDriverSupports) {
                service.delete(activityTemplateDriverSupport.getKey());
            }
        }
    }
}
