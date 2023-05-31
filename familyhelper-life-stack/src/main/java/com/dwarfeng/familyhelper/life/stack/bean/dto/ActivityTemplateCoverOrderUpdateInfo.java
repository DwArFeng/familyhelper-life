package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.List;

/**
 * 活动模板封面顺序更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateCoverOrderUpdateInfo implements Dto {

    private static final long serialVersionUID = -1761026335156667089L;
    
    private List<LongIdKey> activityTemplateCoverKeys;

    public ActivityTemplateCoverOrderUpdateInfo() {
    }

    public ActivityTemplateCoverOrderUpdateInfo(List<LongIdKey> activityTemplateCoverKeys) {
        this.activityTemplateCoverKeys = activityTemplateCoverKeys;
    }

    public List<LongIdKey> getActivityTemplateCoverKeys() {
        return activityTemplateCoverKeys;
    }

    public void setActivityTemplateCoverKeys(List<LongIdKey> activityTemplateCoverKeys) {
        this.activityTemplateCoverKeys = activityTemplateCoverKeys;
    }

    @Override
    public String toString() {
        return "ActivityTemplateCoverOrderUpdateInfo{" +
                "activityTemplateCoverKeys=" + activityTemplateCoverKeys +
                '}';
    }
}
