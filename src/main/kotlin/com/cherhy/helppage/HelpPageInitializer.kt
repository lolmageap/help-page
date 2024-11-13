package com.cherhy.helppage

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
class HelpPageInitializer(
    private val helpPage: HelpPage,
) {
    @PostConstruct
    fun initialize() {
        helpPage.createTable()
    }
}