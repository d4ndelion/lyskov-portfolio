package lyskov.portfolio.components

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.section
import kotlinx.html.span
import lyskov.portfolio.model.Goodbye
import lyskov.portfolio.registry.ContentLoader

fun FlowContent.goodbyeSection(goodbye: Goodbye) {
    val header = ContentLoader.content.header
    section(classes = "pg-section pg-section--goodbye") {
        div(classes = "goodbye-body") {
            div(classes = "goodbye-gif") {
                img(src = goodbye.goodbyeGif, alt = "")
            }
            div(classes = "goodbye-text") {
                p(classes = "goodbye-text__heading") { +goodbye.heading }
                p(classes = "goodbye-text__sub") { +goodbye.sub }
            }
            div(classes = "goodbye-contacts") {
                div(classes = "goodbye-btn-row") {
                    val tgLink = header.socialMediaLinks.telegram.link
                    if (tgLink.isNotEmpty()) {
                        a(href = tgLink, classes = "btn-write", target = "_blank") {
                            attributes["rel"] = "noopener"
                            img(src = "/vector/telegram-icon-white.svg", alt = "")
                            span { +"Написать" }
                        }
                    }
                    val maxLink = header.socialMediaLinks.max.link
                    if (maxLink.isNotEmpty()) {
                        a(href = maxLink, classes = "icon-btn", target = "_blank") {
                            attributes["aria-label"] = "MAX"
                            attributes["rel"] = "noopener"
                            img(src = header.socialMediaLinks.max.icon, alt = "MAX")
                        }
                    }
                    val liLink = header.socialMediaLinks.linkedin.link
                    if (liLink.isNotEmpty()) {
                        a(href = liLink, classes = "icon-btn icon-btn--linkedin", target = "_blank") {
                            attributes["aria-label"] = "LinkedIn"
                            attributes["rel"] = "noopener"
                            img(src = header.socialMediaLinks.linkedin.icon, alt = "LinkedIn")
                        }
                    }
                }
                a(href = "mailto:${goodbye.email}", classes = "goodbye-email") {
                    span { +goodbye.email }
                    span(classes = "goodbye-email__icon") {}
                }
            }
        }
    }
}
