package com.dwarfeng.familyhelper.life.impl.dao.preset;

import com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateFileInfoMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class ActivityTemplateFileInfoPresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria detachedCriteria, String s, Object[] objects) {
        switch (s) {
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE:
                childForActivityTemplate(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_ORIGIN_NAME_ASC:
                childForActivityTemplateOriginNameAsc(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_ORIGIN_NAME_DESC:
                childForActivityTemplateOriginNameDesc(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_CREATED_DATE_ASC:
                childForActivityTemplateCreatedDateAsc(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_CREATED_DATE_DESC:
                childForActivityTemplateCreatedDateDesc(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_MODIFIED_DATE_ASC:
                childForActivityTemplateModifiedDateAsc(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_MODIFIED_DATE_DESC:
                childForActivityTemplateModifiedDateDesc(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_INSPECTED_DATE_ASC:
                childForActivityTemplateInspectedDateAsc(detachedCriteria, objects);
                break;
            case ActivityTemplateFileInfoMaintainService.CHILD_FOR_ACTIVITY_TEMPLATE_INSPECTED_DATE_DESC:
                childForActivityTemplateInspectedDateDesc(detachedCriteria, objects);
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

    private void childForActivityTemplateOriginNameAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("originName"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityTemplateOriginNameDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("originName"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityTemplateCreatedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("createdDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityTemplateCreatedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("createdDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityTemplateModifiedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("modifiedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityTemplateModifiedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("modifiedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityTemplateInspectedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("inspectedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityTemplateInspectedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityTemplateLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityTemplateLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("inspectedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }
}
