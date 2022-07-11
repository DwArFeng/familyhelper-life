package com.dwarfeng.familyhelper.life.impl.configuration;

import com.alibaba.fastjson.parser.ParserConfig;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastJsonConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastJsonConfiguration.class);

    public FastJsonConfiguration() {
        LOGGER.info("正在配置 FastJson autotype 白名单");
        //实体对象。
        ParserConfig.getGlobalInstance().addAccept(FastJsonUser.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPopb.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPbSet.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPbNode.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPbItem.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPbRecord.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPbFileInfo.class.getCanonicalName());
        LOGGER.debug("FastJson autotype 白名单配置完毕");
    }
}
