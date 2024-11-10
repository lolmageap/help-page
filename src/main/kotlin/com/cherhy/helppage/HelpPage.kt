package com.cherhy.helppage

interface HelpPage {
    fun getVersion(): String
    fun getUrl(): String
    fun getContact(): Contact
    fun getPageDetail(): PageDetail
}