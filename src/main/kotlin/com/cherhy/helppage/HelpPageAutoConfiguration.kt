package com.cherhy.helppage

import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

class HelpPageAutoConfiguration(
    private val defaultHelpPageProperties: DefaultHelpPageProperties,
    private val dataSource: DataSource,
    private val jdbcTemplate: JdbcTemplate,
) : HelpPage {
    override val version = defaultHelpPageProperties.version
    override val url = defaultHelpPageProperties.url
    override val pageDetail = defaultHelpPageProperties.pageDetail

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
            when {
                driverName.isH2 or driverName.isPostgres or driverName.isHSQL
                -> {
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

                driverName.isMySQL or driverName.isMariaDB
                -> {
                    jdbcTemplate.execute(
                        """
                        CREATE TABLE IF NOT EXISTS help_message (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            user_id VARCHAR(255) NOT NULL,
                            message TEXT NOT NULL
                        )
                        """.trimIndent()
                    )
                }

                driverName.isOracle
                -> {
                    jdbcTemplate.execute(
                        """
                        CREATE SEQUENCE help_message_seq START WITH 1 INCREMENT BY 1;
                        
                        CREATE TABLE help_message (
                            id NUMBER PRIMARY KEY,
                            user_id VARCHAR2(255) NOT NULL,
                            message CLOB NOT NULL
                        );
                        
                        CREATE OR REPLACE TRIGGER help_message_trigger
                        BEFORE INSERT ON help_message
                        FOR EACH ROW
                        WHEN (NEW.id IS NULL)
                        BEGIN
                            SELECT help_message_seq.NEXTVAL INTO :NEW.id FROM dual;
                        END;
                        """.trimIndent()
                    )
                }

                driverName.isSQLServer
                -> {
                    jdbcTemplate.execute(
                        """
                        CREATE TABLE help_message (
                            id INT PRIMARY KEY IDENTITY(1,1),
                            user_id NVARCHAR(255) NOT NULL,
                            message NVARCHAR(MAX) NOT NULL
                        )
                        """.trimIndent()
                    )
                }

                driverName.isDB2 or driverName.isDerby
                -> {
                    jdbcTemplate.execute(
                        """
                        CREATE TABLE help_message (
                            id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                            user_id VARCHAR(255) NOT NULL,
                            message CLOB NOT NULL
                        )
                        """.trimIndent()
                    )
                }

                driverName.isSQLite
                -> {
                    jdbcTemplate.execute(
                        """
                        CREATE TABLE help_message (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            user_id TEXT NOT NULL,
                            message TEXT NOT NULL
                        )
                        """.trimIndent()
                    )
                }

                else -> {
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