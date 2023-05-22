package com.dwarfeng.familyhelper.life.impl.dao.preset;

import com.dwarfeng.familyhelper.life.stack.service.PoatMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class PoatPresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria detachedCriteria, String s, Object[] objects) {
        switch (s) {
            case PoatMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE:
                childForActivityTemplate(detachedCriteria, objects);
                break;
            case PoatMaintainService.CHILD_FOR_USER:
                childForUser(detachedCriteria, objects);
                break;
            case PoatMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_PERMISSION_LEVEL_EQUALS:
                childForActivityTemplatePermissionLevelEquals(detachedCriteria, objects);
                break;
            case PoatMaintainService.CHILD_FOR_USER_PERMISSION_LEVEL_EQUALS:
                childForUserPermissionLevelEquals(detachedCriteria, objects);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + s);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForActivityTemplate(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForUser(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("userStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("userStringId", stringIdKey.getStringId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForActivityTemplatePermissionLevelEquals(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            int permissionLevel = (int) objects[1];
            detachedCriteria.add(Restrictions.eq("permissionLevel", permissionLevel));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForUserPermissionLevelEquals(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("userStringId"));
            } else {
                StringIdKey stringIdKey = (StringIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("userStringId", stringIdKey.getStringId())
                );
            }
            int permissionLevel = (int) objects[1];
            detachedCriteria.add(Restrictions.eq("permissionLevel", permissionLevel));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }
}
