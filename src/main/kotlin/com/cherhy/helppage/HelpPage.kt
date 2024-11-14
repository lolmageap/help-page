package com.cherhy.helppage

interface HelpPage: HelpPageProperties {
    fun saveHelpMessage(
        userId: String,
        message: String,
    )
    fun createTable()
}

interface HelpPageProperties {
    val version: String
    val url: String
    val pageDetail: PageDetail
}