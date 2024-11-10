package com.cherhy.helppage

class HelpPageAutoConfiguration(
    private val defaultHelpPageProperties: DefaultHelpPageProperties,
): HelpPage {
    override fun getVersion() = defaultHelpPageProperties.version
    override fun getUrl() = defaultHelpPageProperties.url
    override fun getContact() = defaultHelpPageProperties.contact
    override fun getPageDetail() = defaultHelpPageProperties.pageDetail
}