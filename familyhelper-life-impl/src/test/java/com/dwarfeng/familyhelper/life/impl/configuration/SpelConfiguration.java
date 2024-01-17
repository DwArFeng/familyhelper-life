package com.dwarfeng.familyhelper.life.impl.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
public class SpelConfiguration {

    @Bean
    public SpelExpressionParser spelExpressionParser() {
        return new SpelExpressionParser();
    }

    @Bean
    public TemplateParserContext templateParserContext() {
        return new TemplateParserContext();
    }
}
