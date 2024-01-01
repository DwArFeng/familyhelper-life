package com.dwarfeng.familyhelper.life.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.List;

/**
 * 活动封面顺序更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityCoverOrderUpdateInfo implements Dto {

    private static final long serialVersionUID = -9119439564319465483L;

    private List<LongIdKey> activityCoverKeys;

    public ActivityCoverOrderUpdateInfo() {
    }

    public ActivityCoverOrderUpdateInfo(List<LongIdKey> activityCoverKeys) {
        this.activityCoverKeys = activityCoverKeys;
    }

    public List<LongIdKey> getActivityCoverKeys() {
        return activityCoverKeys;
    }

    public void setActivityCoverKeys(List<LongIdKey> activityCoverKeys) {
        this.activityCoverKeys = activityCoverKeys;
    }

    @Override
    public String toString() {
        return "ActivityCoverOrderUpdateInfo{" +
                "activityCoverKeys=" + activityCoverKeys +
                '}';
    }
}
