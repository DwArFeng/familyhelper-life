package com.dwarfeng.familyhelper.life.impl.configuration;

import com.alibaba.fastjson.parser.ParserConfig;
import com.dwarfeng.familyhelper.life.sdk.bean.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class P02FastJsonConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(P02FastJsonConfiguration.class);

    public P02FastJsonConfiguration() {
        LOGGER.info("正在配置 FastJson autotype 白名单");
        //实体对象。
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivity.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityActivityDataRecordRelation.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityCoverInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityDataItem.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityDataNode.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityDataRecord.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityDataSet.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityFileInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityParticipant.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityTemplate.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(
                FastJsonActivityTemplateActivityDataItemRelation.class.getCanonicalName()
        );
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityTemplateCoverInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityTemplateDriverInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityTemplateDriverSupport.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityTemplateFileInfo.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityTemplateParticipant.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonActivityTypeIndicator.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPoac.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPoad.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPoat.class.getCanonicalName());
        ParserConfig.getGlobalInstance().addAccept(FastJsonPoatac.class.getCanonicalName());
        LOGGER.debug("FastJson autotype 白名单配置完毕");
    }
}
