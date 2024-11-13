package com.cherhy.helppage

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelpPageController(
    private val helpPage: HelpPage,
) {
    @GetMapping("\${help.url}")
    fun helpPage(
        model: Model,
    ): String {
        model.addAttribute(PAGE_DETAIL, helpPage.pageDetail)
        return "help"
    }

    companion object {
        const val PAGE_DETAIL = "pageDetail"
    }
}