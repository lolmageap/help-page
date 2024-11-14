package com.cherhy.helppage

import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

class HelpPageH2AutoConfiguration(
    private val defaultHelpPageProperties: DefaultHelpPageProperties,
    private val dataSource: DataSource,
    private val jdbcTemplate: JdbcTemplate,
) : HelpPage {
    override val url: String = defaultHelpPageProperties.url
    override val version: String = defaultHelpPageProperties.version
    override val pageDetail: PageDetail = defaultHelpPageProperties.pageDetail

    override fun saveHelpMessage(
        userId: String,
        message: String,
    ) {
        jdbcTemplate.update(
            """
            INSERT INTO help_message (user_id, message)
            VALUES (?, ?)
            """.trimIndent(),
            userId,
            message,
        )
    }

    override fun createTable() {
        val isCreateTableTrue = defaultHelpPageProperties.createTable
        val driverName = dataSource.connection.metaData.driverName

        if (isCreateTableTrue) {
            jdbcTemplate.execute(
                """
                CREATE TABLE IF NOT EXISTS help_message (
                    id SERIAL PRIMARY KEY,
                    user_id VARCHAR(255) NOT NULL,
                    message TEXT NOT NULL
                )
                """.trimIndent()
            )
        }
    }
}