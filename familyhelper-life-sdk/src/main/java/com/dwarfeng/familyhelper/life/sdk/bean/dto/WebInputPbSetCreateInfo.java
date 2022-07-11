package com.dwarfeng.familyhelper.life.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.dto.PbSetCreateInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人最佳创建信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPbSetCreateInfo implements Dto {

    private static final long serialVersionUID = 36387868481465979L;

    public static PbSetCreateInfo toStackBean(WebInputPbSetCreateInfo webInputPbSetCreateInfo) {
        if (Objects.isNull(webInputPbSetCreateInfo)) {
            return null;
        } else {
            return new PbSetCreateInfo(
                    webInputPbSetCreateInfo.getName(),
                    webInputPbSetCreateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @JSONField(name = "remark")
    private String remark;

    public WebInputPbSetCreateInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WebInputPbSetCreateInfo{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
