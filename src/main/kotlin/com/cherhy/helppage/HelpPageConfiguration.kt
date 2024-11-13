package com.cherhy.helppage

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
class HelpPageConfiguration(
    private val defaultHelpPageProperties: DefaultHelpPageProperties,
    private val dataSource: DataSource,
    private val jdbcTemplate: JdbcTemplate,
) {
    @Bean
    @ConditionalOnMissingBean(HelpPage::class)
    fun helpPage(): HelpPage {
        return HelpPageAutoConfiguration(
            defaultHelpPageProperties,
            dataSource,
            jdbcTemplate,
        )
    }
}