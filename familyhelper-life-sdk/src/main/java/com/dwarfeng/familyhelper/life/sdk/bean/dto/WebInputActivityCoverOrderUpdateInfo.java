package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityCoverOrderUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * WebInput 活动封面顺序更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityCoverOrderUpdateInfo implements Dto {

    private static final long serialVersionUID = -9179415158942423519L;

    public static ActivityCoverOrderUpdateInfo toStackBean(
            WebInputActivityCoverOrderUpdateInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityCoverOrderUpdateInfo(
                    webInput.getActivityCoverKeys().stream().map(WebInputLongIdKey::toStackBean)
                            .collect(Collectors.toList())
            );
        }
    }

    @JSONField(name = "activity_cover_keys")
    @Valid
    @NotEmpty
    private List<WebInputLongIdKey> activityCoverKeys;

    public WebInputActivityCoverOrderUpdateInfo() {
    }

    public List<WebInputLongIdKey> getActivityCoverKeys() {
        return activityCoverKeys;
    }

    public void setActivityCoverKeys(List<WebInputLongIdKey> activityCoverKeys) {
        this.activityCoverKeys = activityCoverKeys;
    }

    @Override
    public String toString() {
        return "WebInputActivityCoverOrderUpdateInfo{" +
                "activityCoverKeys=" + activityCoverKeys +
                '}';
    }
}
