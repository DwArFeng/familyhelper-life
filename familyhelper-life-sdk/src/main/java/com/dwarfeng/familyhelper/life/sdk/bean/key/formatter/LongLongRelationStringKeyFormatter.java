package com.dwarfeng.familyhelper.life.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.life.stack.bean.key.LongLongRelationKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * LongLongRelationKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class LongLongRelationStringKeyFormatter implements StringKeyFormatter<LongLongRelationKey> {

    private String prefix;

    public LongLongRelationStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(LongLongRelationKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getLeftLongId() + "_" + key.getRightLongId();
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
        return "LongLongRelationStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
