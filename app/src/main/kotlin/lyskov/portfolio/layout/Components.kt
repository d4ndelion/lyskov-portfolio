package lyskov.portfolio.layout

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.header
import kotlinx.html.img
import kotlinx.html.span

// ─── Header ───────────────────────────────────────────────────────────────────

fun FlowContent.siteHeader(@Suppress("UNUSED_PARAMETER") currentUrlPath: String) {
    header(classes = "site-header") {
        a(href = "#main-content", classes = "skip-link") { +"Перейти к содержимому" }

        div(classes = "site-header__body") {

            // ── Left: logo + location ─────────────────────────────────────────
            div(classes = "site-header__left") {
                img(src = "/vector/il-logo.svg", alt = "IL", classes = "site-header__logo")

                div(classes = "site-header__location") {
                    div(classes = "site-header__divider") {
                        img(src = "/vector/star-divider.svg", alt = "")
                    }
                    span(classes = "site-header__city") { +"Москва" }
                }
            }

            // ── Right: icons + email/cv ───────────────────────────────────────
            div(classes = "site-header__right") {
                div(classes = "site-header__icon-group") {
                    a(href = "https://t.me/ansuzdesign", classes = "site-header__icon-btn", target = "_blank") {
                        attributes["aria-label"] = "Telegram"
                        attributes["rel"] = "noopener"
                        img(src = "/vector/telegram-icon.svg", alt = "")
                    }
                    a(href = "https://www.linkedin.com/in/ilya-lyskov/", classes = "site-header__icon-btn", target = "_blank") {
                        attributes["aria-label"] = "LinkedIn"
                        attributes["rel"] = "noopener"
                        img(src = "/vector/linkedin-icon.svg", alt = "")
                    }
                    a(href = "https://max.ru/ansuzdesign", classes = "site-header__icon-btn site-header__icon-btn--max", target = "_blank") {
                        attributes["aria-label"] = "MAX"
                        attributes["rel"] = "noopener"
                        img(src = "/vector/max-icon.svg", alt = "")
                    }
                }

                span(classes = "site-header__sep") { +"/" }

                div(classes = "site-header__links") {
                    a(href = "mailto:mr.ansuz@gmail.com", classes = "site-header__link") { +"Email" }
                    div(classes = "site-header__divider") {
                        img(src = "/vector/star-divider.svg", alt = "")
                    }
                    a(href = "/cv.pdf", classes = "site-header__link") { +"CV" }
                }
            }
        }
    }
}

// ─── Footer ───────────────────────────────────────────────────────────────────

fun FlowContent.siteFooter() {
    footer(classes = "site-footer") {
        div(classes = "site-footer__body") {
            span(classes = "site-footer__copy") { +"© ilya lyskov, ${java.time.Year.now().value}" }
        }
    }
}
