package com.dwarfeng.familyhelper.life.impl.dao.preset;

import com.dwarfeng.familyhelper.life.stack.service.PbRecordMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class PbRecordPresetCriteriaMaker implements PresetCriteriaMaker {

    @Override
    public void makeCriteria(DetachedCriteria detachedCriteria, String s, Object[] objects) {
        switch (s) {
            case PbRecordMaintainService.CHILD_FOR_ITEM:
                childForItem(detachedCriteria, objects);
                break;
            case PbRecordMaintainService.CHILD_FOR_ITEM_RECORDED_DATE_ASC:
                childForItemRecordedDateAsc(detachedCriteria, objects);
                break;
            case PbRecordMaintainService.CHILD_FOR_ITEM_RECORDED_DATE_DESC:
                childForItemRecordedDateDesc(detachedCriteria, objects);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + s);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForItem(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("itemLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("itemLongId", longIdKey.getLongId())
                );
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForItemRecordedDateAsc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("itemLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("itemLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.asc("recordedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void childForItemRecordedDateDesc(DetachedCriteria detachedCriteria, Object[] objects) {
        try {
            if (Objects.isNull(objects[0])) {
                detachedCriteria.add(Restrictions.isNull("itemLongId"));
            } else {
                LongIdKey longIdKey = (LongIdKey) objects[0];
                detachedCriteria.add(
                        Restrictions.eqOrIsNull("itemLongId", longIdKey.getLongId())
                );
            }
            detachedCriteria.addOrder(Order.desc("recordedDate"));
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objects));
        }
    }
}
