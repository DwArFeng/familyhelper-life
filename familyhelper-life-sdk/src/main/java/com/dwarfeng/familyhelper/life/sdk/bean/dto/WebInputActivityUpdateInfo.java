package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.sdk.util.Constraints;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

/**
 * WebInput 活动更新信息。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class WebInputActivityUpdateInfo implements Dto {

    private static final long serialVersionUID = 7707614255671082606L;

    public static ActivityUpdateInfo toStackBean(WebInputActivityUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ActivityUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getActivityKey()),
                    webInput.getActivityType(),
                    webInput.getName(),
                    webInput.getScore(),
                    webInput.getRemark(),
                    webInput.getStartDate(),
                    webInput.getEndDate()
            );
        }
    }

    @JSONField(name = "activity_key")
    @NotNull
    @Valid
    private WebInputLongIdKey activityKey;

    @JSONField(name = "activity_type")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_TYPE)
    private String activityType;

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_NAME)
    private String name;

    @JSONField(name = "score")
    private int score;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    @JSONField(name = "start_date")
    private Date startDate;

    @JSONField(name = "end_date")
    private Date endDate;

    public WebInputActivityUpdateInfo() {
    }

    public WebInputLongIdKey getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(WebInputLongIdKey activityKey) {
        this.activityKey = activityKey;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "WebInputActivityUpdateInfo{" +
                "activityKey=" + activityKey +
                ", activityType='" + activityType + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", remark='" + remark + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
