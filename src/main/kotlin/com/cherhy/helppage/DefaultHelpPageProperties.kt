package com.cherhy.helppage

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "help")
data class DefaultHelpPageProperties(
    val version: String = "1.0.0",
    val url: String = "/help",
    val contact: Contact,
    val pageDetail: PageDetail = PageDetail(),
)

@ConfigurationProperties(prefix = "help.contact")
data class Contact(
    val email: String,
)

@ConfigurationProperties(prefix = "help.page-detail")
data class PageDetail(
    val title: String = "Help Page",
    val description: String = "This is a help page",
    val backgroundColour: String = "#FF0000",
    val fontColour: String = "#FFFFFF",
    val fontSize: Int = 20,
    val fontFamily: String = "Arial",
)