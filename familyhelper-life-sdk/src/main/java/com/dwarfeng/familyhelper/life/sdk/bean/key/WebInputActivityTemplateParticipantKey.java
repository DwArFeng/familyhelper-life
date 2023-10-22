package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动模板参与者主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateParticipantKey implements Key {

    private static final long serialVersionUID = -758672722476784366L;

    public static ActivityTemplateParticipantKey toStackBean(WebInputActivityTemplateParticipantKey webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateParticipantKey(
                    webInput.getActivityTemplateLongId(),
                    webInput.getUserStringId()
            );
        }
    }

    @JSONField(name = "activity_template_long_id")
    @NotNull
    private Long activityTemplateLongId;

    @JSONField(name = "user_string_id")
    @NotNull
    private String userStringId;

    public WebInputActivityTemplateParticipantKey() {
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

        WebInputActivityTemplateParticipantKey that = (WebInputActivityTemplateParticipantKey) o;

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
        return "WebInputActivityTemplateParticipantKey{" +
                "activityTemplateLongId=" + activityTemplateLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
