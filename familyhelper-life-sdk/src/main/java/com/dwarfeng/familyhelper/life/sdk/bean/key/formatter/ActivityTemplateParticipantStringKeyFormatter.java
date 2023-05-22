package com.dwarfeng.familyhelper.life.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.life.stack.bean.key.ActivityTemplateParticipantKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * ActivityTemplateParticipantKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class ActivityTemplateParticipantStringKeyFormatter implements
        StringKeyFormatter<ActivityTemplateParticipantKey> {

    private String prefix;

    public ActivityTemplateParticipantStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(ActivityTemplateParticipantKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getActivityTemplateLongId() + "_" + key.getUserStringId();
    }

    @Override
    public String generalFormat() {
        return prefix + Constants.REDIS_KEY_WILDCARD_CHARACTER;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "ActivityTemplateParticipantStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
