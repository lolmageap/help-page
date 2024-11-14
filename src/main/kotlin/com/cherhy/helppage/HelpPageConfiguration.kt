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
        val driver = dataSource.connection.metaData.driverName
        return when {
            driver.isH2 ->
                HelpPageH2AutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isPostgres ->
                HelpPagePostgresAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isMySQL ->
                HelpPageMySQLAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isMariaDB ->
                HelpPageMariaDBAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isOracle ->
                HelpPageOracleAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isSQLServer ->
                HelpPageSQLServerAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isDB2 ->
                HelpPageDB2AutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isDerby ->
                HelpPageDerbyAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isHSQL ->
                HelpPageHSQLAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            driver.isSQLite ->
                HelpPageSQLiteAutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)

            else ->
                HelpPageH2AutoConfiguration(defaultHelpPageProperties, dataSource, jdbcTemplate)
        }
    }


    private val String.isH2: Boolean
        get() = this.lowercase().contains("h2")

    private val String.isPostgres: Boolean
        get() = this.lowercase().contains("postgresql")

    private val String.isMySQL: Boolean
        get() = this.lowercase().contains("mysql")

    private val String.isMariaDB: Boolean
        get() = this.lowercase().contains("mariadb")

    private val String.isOracle: Boolean
        get() = this.lowercase().contains("oracle")

    private val String.isSQLServer: Boolean
        get() = this.lowercase().contains("sqlserver")

    private val String.isDB2: Boolean
        get() = this.lowercase().contains("db2")

    private val String.isDerby: Boolean
        get() = this.lowercase().contains("derby")

    private val String.isHSQL: Boolean
        get() = this.lowercase().contains("hsql")

    private val String.isSQLite: Boolean
        get() = this.lowercase().contains("sqlite")
}