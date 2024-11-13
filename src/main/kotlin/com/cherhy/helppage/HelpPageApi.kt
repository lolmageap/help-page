package com.cherhy.helppage

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelpPageApi(
    private val helpPage: HelpPage,
) {
    @PostMapping("/help")
    fun helpPage(
        @RequestBody request: HelpMessage,
    ) {
        helpPage.saveHelpMessage(
            userId = request.userId,
            message = request.message,
        )
    }
}