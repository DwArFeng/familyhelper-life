package com.dwarfeng.familyhelper.life.impl.dao.preset;

import com.dwarfeng.familyhelper.life.stack.service.ActivityFileInfoMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class ActivityFileInfoPresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria detachedCriteria, String s, Object[] objects) {
        switch (s) {
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY:
                childForActivity(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_ORIGIN_NAME_ASC:
                childForActivityOriginNameAsc(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_ORIGIN_NAME_DESC:
                childForActivityOriginNameDesc(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_CREATED_DATE_ASC:
                childForActivityCreatedDateAsc(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_CREATED_DATE_DESC:
                childForActivityCreatedDateDesc(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_MODIFIED_DATE_ASC:
                childForActivityModifiedDateAsc(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_MODIFIED_DATE_DESC:
                childForActivityModifiedDateDesc(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_INSPECTED_DATE_ASC:
                childForActivityInspectedDateAsc(detachedCriteria, objects);
                break;
            case ActivityFileInfoMaintainService.CHILD_FOR_ACTIVITY_INSPECTED_DATE_DESC:
                childForActivityInspectedDateDesc(detachedCriteria, objects);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + s);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForActivity(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityOriginNameAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("originName"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityOriginNameDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("originName"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityCreatedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("createdDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityCreatedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("createdDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityModifiedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("modifiedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityModifiedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("modifiedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityInspectedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("inspectedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    private void childForActivityInspectedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("activityLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("activityLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("inspectedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }
}
