package com.cherhy.helppage

class HelpPageAutoConfiguration(
    private val defaultHelpPageProperties: DefaultHelpPageProperties,
): HelpPage {
    override val version = defaultHelpPageProperties.version
    override val url = defaultHelpPageProperties.url
    override val contact = defaultHelpPageProperties.contact
    override val pageDetail = defaultHelpPageProperties.pageDetail
}