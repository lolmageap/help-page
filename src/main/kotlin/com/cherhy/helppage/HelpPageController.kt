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
        with(model) {
            addAttribute(VERSION, helpPage.getVersion())
            addAttribute(URL, helpPage.getUrl())
            addAttribute(CONTACT, helpPage.getContact())
            addAttribute(PAGE_DETAIL, helpPage.getPageDetail())
        }
        return "help"
    }

    companion object {
        const val VERSION = "version"
        const val URL = "url"
        const val CONTACT = "contact"
        const val PAGE_DETAIL = "pageDetail"
    }
}