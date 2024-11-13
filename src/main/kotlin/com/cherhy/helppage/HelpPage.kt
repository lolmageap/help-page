package com.cherhy.helppage

interface HelpPage {
    val version: String
    val url: String
    val pageDetail: PageDetail
    fun saveHelpMessage(
        userId: String,
        message: String,
    )
    fun createTable()
}