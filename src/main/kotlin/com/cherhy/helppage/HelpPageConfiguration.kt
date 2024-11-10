package com.cherhy.helppage

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelpPageConfiguration(
    private val defaultHelpPageProperties: DefaultHelpPageProperties,
) {
    @Bean
    @ConditionalOnMissingBean(HelpPage::class)
    fun helpPage(): HelpPage {
        return HelpPageAutoConfiguration(defaultHelpPageProperties)
    }
}