package com.dwarfeng.familyhelper.life.impl.dao.preset;

import com.dwarfeng.familyhelper.life.stack.service.ActivityActivityDataRecordRelationMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class ActivityActivityDataRecordRelationPresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria detachedCriteria, String preset, Object[] objects) {
        switch (preset) {
            case ActivityActivityDataRecordRelationMaintainService.CHILD_FOR_ACTIVITY:
                childForActivity(detachedCriteria, objects);
                break;
            case ActivityActivityDataRecordRelationMaintainService.CHILD_FOR_ACTIVITY_DATA_RECORD:
                childForActivityDataRecord(detachedCriteria, objects);
                break;
            case ActivityActivityDataRecordRelationMaintainService.CHILD_FOR_ACTIVITY_DATA_RECORD_RECORDED_DATE_ASC:
                childForActivityDataRecordRecordedDateAsc(detachedCriteria, objects);
                break;
            case ActivityActivityDataRecordRelationMaintainService.CHILD_FOR_ACTIVITY_DATA_RECORD_RECORDED_DATE_DESC:
                childForActivityDataRecordRecordedDateDesc(detachedCriteria, objects);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + preset);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForActivity(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("leftLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("leftLongId", longIdKey.getLongId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForActivityDataRecord(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("rightLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("rightLongId", longIdKey.getLongId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForActivityDataRecordRecordedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            detachedCriteria.createAlias("activityDataRecord", "r");
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("leftLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("leftLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("r.recordedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForActivityDataRecordRecordedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            detachedCriteria.createAlias("activityDataRecord", "r");
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("leftLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("leftLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("r.recordedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }
}
