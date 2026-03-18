package lyskov.portfolio.components

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.header
import kotlinx.html.img
import kotlinx.html.span
import lyskov.portfolio.registry.ContentLoader

// ─── Home header ──────────────────────────────────────────────────────────────

fun FlowContent.siteHeader() {
    val h = ContentLoader.content.header
    header(classes = "site-header") {
        div(classes = "site-header__body") {

            div(classes = "site-header__left") {
                a(href = "/") {
                    img(src = h.logo, alt = "IL", classes = "site-header__logo")
                }
                div(classes = "site-header__location") {
                    img(src = h.dividerIcon, alt = "", classes = "site-header__divider-icon")
                    span(classes = "site-header__city") { +h.locationString }
                }
            }

            renderRightSection(h.socialMediaLinks.telegram.link, h.socialMediaLinks.linkedin.link,
                h.socialMediaLinks.max.link, h.socialMediaLinks.max.icon,
                h.emailLink, h.cvLink)
        }
    }
}

// ─── Case header (with breadcrumb) ────────────────────────────────────────────

fun FlowContent.caseHeader(breadcrumb: String) {
    val h = ContentLoader.content.header
    header(classes = "site-header") {
        div(classes = "site-header__body") {

            div(classes = "site-header__left") {
                if (h.avatar.isNotEmpty()) {
                    a(href = "/") {
                        img(src = h.avatar, alt = "Avatar", classes = "site-header__avatar")
                    }
                }
                a(href = "/") {
                    img(src = h.logo, alt = "IL", classes = "site-header__logo")
                }
                div(classes = "site-header__breadcrumb") {
                    img(src = "/vector/chevron-right.svg", alt = "", classes = "site-header__chevron")
                    span(classes = "site-header__breadcrumb-text") { +breadcrumb }
                }
            }

            renderRightSection(h.socialMediaLinks.telegram.link, h.socialMediaLinks.linkedin.link,
                h.socialMediaLinks.max.link, h.socialMediaLinks.max.icon,
                h.emailLink, h.cvLink)
        }
    }
}

// ─── Shared right section ─────────────────────────────────────────────────────

private fun FlowContent.renderRightSection(
    tgLink: String,
    liLink: String,
    maxLink: String,
    maxIcon: String,
    emailLink: String,
    cvLink: String,
) {
    div(classes = "site-header__right") {
        div(classes = "site-header__icon-group") {
            if (tgLink.isNotEmpty()) {
                a(href = tgLink, classes = "site-header__icon-btn", target = "_blank") {
                    attributes["aria-label"] = "Telegram"
                    attributes["rel"] = "noopener"
                    img(src = "/vector/telegram-icon.svg", alt = "")
                }
            }
            if (liLink.isNotEmpty()) {
                a(href = liLink, classes = "site-header__icon-btn", target = "_blank") {
                    attributes["aria-label"] = "LinkedIn"
                    attributes["rel"] = "noopener"
                    img(src = "/vector/linkedin-icon.svg", alt = "")
                }
            }
            if (maxLink.isNotEmpty()) {
                a(href = maxLink, classes = "site-header__icon-btn site-header__icon-btn--max", target = "_blank") {
                    attributes["aria-label"] = "MAX"
                    attributes["rel"] = "noopener"
                    img(src = maxIcon, alt = "MAX")
                }
            }
        }
        span(classes = "site-header__sep") { +"/" }
        div(classes = "site-header__links") {
            if (emailLink.isNotEmpty()) {
                a(href = emailLink, classes = "site-header__link") { +"Email" }
            }
            img(src = "/vector/star-divider.svg", alt = "", classes = "site-header__divider-icon")
            if (cvLink.isNotEmpty()) {
                a(href = cvLink, classes = "site-header__link") { +"CV" }
            } else {
                span(classes = "site-header__link site-header__link--muted") { +"CV" }
            }
        }
    }
}
