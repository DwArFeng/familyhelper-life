package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityTemplateCoverOrderUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * WebInput 活动模板封面顺序更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityTemplateCoverOrderUpdateInfo implements Dto {

    private static final long serialVersionUID = 7661054337784104392L;

    public static ActivityTemplateCoverOrderUpdateInfo toStackBean(
            WebInputActivityTemplateCoverOrderUpdateInfo webInput
    ) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityTemplateCoverOrderUpdateInfo(
                    webInput.getActivityTemplateCoverKeys().stream().map(WebInputLongIdKey::toStackBean)
                            .collect(Collectors.toList())
            );
        }
    }

    @JSONField(name = "activity_template_cover_keys")
    @Valid
    @NotEmpty
    private List<WebInputLongIdKey> activityTemplateCoverKeys;

    public WebInputActivityTemplateCoverOrderUpdateInfo() {
    }

    public List<WebInputLongIdKey> getActivityTemplateCoverKeys() {
        return activityTemplateCoverKeys;
    }

    public void setActivityTemplateCoverKeys(List<WebInputLongIdKey> activityTemplateCoverKeys) {
        this.activityTemplateCoverKeys = activityTemplateCoverKeys;
    }

    @Override
    public String toString() {
        return "WebInputActivityTemplateCoverOrderUpdateInfo{" +
                "activityTemplateCoverKeys=" + activityTemplateCoverKeys +
                '}';
    }
}
