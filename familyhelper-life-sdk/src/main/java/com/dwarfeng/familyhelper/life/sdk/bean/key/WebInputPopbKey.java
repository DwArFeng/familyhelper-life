package com.dwarfeng.familyhelper.life.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人最佳权限主键。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputPopbKey implements Key {

    private static final long serialVersionUID = -8702835685988025764L;

    public static PopbKey toStackBean(WebInputPopbKey webInputPopbKey) {
        if (Objects.isNull(webInputPopbKey)) {
            return null;
        } else {
            return new PopbKey(webInputPopbKey.getPbLongId(), webInputPopbKey.getUserStringId());
        }
    }

    @JSONField(name = "pb_long_id")
    @NotNull
    private Long pbLongId;

    @JSONField(name = "user_string_id")
    @NotNull
    @NotEmpty
    private String userStringId;

    public WebInputPopbKey() {
    }

    public Long getPbLongId() {
        return pbLongId;
    }

    public void setPbLongId(Long pbLongId) {
        this.pbLongId = pbLongId;
    }

    public String getUserStringId() {
        return userStringId;
    }

    public void setUserStringId(String userStringId) {
        this.userStringId = userStringId;
    }

    @Override
    public String toString() {
        return "WebInputPopbKey{" +
                "pbLongId=" + pbLongId +
                ", userStringId='" + userStringId + '\'' +
                '}';
    }
}
