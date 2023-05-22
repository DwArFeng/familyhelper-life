package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 活动模板参与者主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class FastJsonActivityTemplateParticipantKey implements Key {

    private static final long serialVersionUID = -9013725744254228014L;

    public static FastJsonActivityTemplateParticipantKey of(ActivityTemplateParticipantKey stackBean) {
        if (Objects.isNull(stackBean)) {
            return null;
        } else {
            return new FastJsonActivityTemplateParticipantKey(
                    stackBean.getActivityTemplateLongId(), stackBean.getUserStringId()
            );
        }
    }

    @JSONField(name = "activity_template_long_id", ordinal = 1)
    private Long activityTemplateLongId;

    @JSONField(name = "user_string_id", ordinal = 2)
    private String userStringId;

    public FastJsonActivityTemplateParticipantKey() {
    }

    public FastJsonActivityTemplateParticipantKey(Long activityTemplateLongId, String userStringId) {
        this.activityTemplateLongId = activityTemplateLongId;
        this.userStringId = userStringId;
    }

    public Long getActivityTemplateLongId() {
        return activityTemplateLongId;
    }

    public void setActivityTemplateLongId(Long activityTemplateLongId) {
        this.activityTemplateLongId = activityTemplateLongId;
    }

    public String getUserStringId() {
        return userStringId;
    }

    public void setUserStringId(String userStringId) {
        this.userStringId = userStringId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FastJsonActivityTemplateParticipantKey that = (FastJsonActivityTemplateParticipantKey) o;

        if (!Objects.equals(activityTemplateLongId, that.activityTemplateLongId))
            return false;
        return Objects.equals(userStringId, that.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityTemplateLongId != null ? activityTemplateLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FastJsonActivityTemplateParticipantKey{" +
                "activityTemplateLongId=" + activityTemplateLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
