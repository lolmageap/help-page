package com.cherhy.helppage

import com.cherhy.helppage.Randomizer.UUID
import com.cherhy.helppage.Randomizer.uuid
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
            addAttribute(VERSION, helpPage.version)
            addAttribute(URL, helpPage.url)
            addAttribute(CONTACT, helpPage.contact)
            addAttribute(PAGE_DETAIL, helpPage.pageDetail)
            addAttribute(UUID, uuid)
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