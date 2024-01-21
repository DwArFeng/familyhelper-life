package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityParticipantKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 活动参与者主键。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityParticipantKey implements Key {

    private static final long serialVersionUID = -1754245175584744873L;

    public static ActivityParticipantKey toStackBean(WebInputActivityParticipantKey webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityParticipantKey(
                    webInput.getActivityLongId(),
                    webInput.getUserStringId()
            );
        }
    }

    @JSONField(name = "activity_long_id")
    @NotNull
    private Long activityLongId;

    @JSONField(name = "user_string_id")
    @NotNull
    private String userStringId;

    public WebInputActivityParticipantKey() {
    }

    public Long getActivityLongId() {
        return activityLongId;
    }

    public void setActivityLongId(Long activityLongId) {
        this.activityLongId = activityLongId;
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

        WebInputActivityParticipantKey that = (WebInputActivityParticipantKey) o;

        if (!Objects.equals(activityLongId, that.activityLongId))
            return false;
        return Objects.equals(userStringId, that.userStringId);
    }

    @Override
    public int hashCode() {
        int result = activityLongId != null ? activityLongId.hashCode() : 0;
        result = 31 * result + (userStringId != null ? userStringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WebInputActivityParticipantKey{" +
                "activityLongId=" + activityLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
