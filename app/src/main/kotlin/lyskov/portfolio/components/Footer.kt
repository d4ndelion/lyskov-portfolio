package lyskov.portfolio.components

import kotlinx.html.FlowContent
import kotlinx.html.footer
import kotlinx.html.div
import kotlinx.html.span

fun FlowContent.siteFooter() {
    footer(classes = "site-footer") {
        div(classes = "site-footer__body") {
            val year = js("new Date().getFullYear()") as Int
            span(classes = "site-footer__copy") { +"© ilya lyskov, $year" }
        }
    }
}
