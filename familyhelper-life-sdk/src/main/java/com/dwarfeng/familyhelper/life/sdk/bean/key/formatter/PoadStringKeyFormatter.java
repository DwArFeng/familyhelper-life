package com.dwarfeng.familyhelper.life.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.life.stack.bean.key.PoadKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * PoadKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class PoadStringKeyFormatter implements StringKeyFormatter<PoadKey> {

    private String prefix;

    public PoadStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(PoadKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getActivityDataSetLongId() + "_" + key.getUserStringId();
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
        return "PoadStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
