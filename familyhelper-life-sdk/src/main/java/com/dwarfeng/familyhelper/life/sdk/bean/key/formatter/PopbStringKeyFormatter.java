package com.dwarfeng.familyhelper.life.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * PopbKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PopbStringKeyFormatter implements StringKeyFormatter<PopbKey> {

    private String prefix;

    public PopbStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(PopbKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getPbLongId() + "_" + key.getUserStringId();
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
        return "PopbStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
