package lyskov.portfolio.layout

import kotlinx.html.FlowContent
import kotlinx.html.footer
import kotlinx.html.header
import kotlinx.html.li
import kotlinx.html.nav
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.span
import kotlinx.html.ul
import lyskov.portfolio.model.Page
import lyskov.portfolio.registry.PageRegistry
import lyskov.portfolio.seo.SeoConfig

// ─── Header ───────────────────────────────────────────────────────────────────

/**
 * Renders the accessible site header with skip-link and primary navigation.
 *
 * @param currentUrlPath  URL path of the page being rendered (used to mark active link).
 */
fun FlowContent.siteHeader(currentUrlPath: String) {
    header(classes = "site-header") {
        a(href = "#main-content", classes = "skip-link") { +"Skip to content" }

        div(classes = "site-header__inner") {
            a(href = "/", classes = "site-header__logo") {
                +SeoConfig.SITE_NAME
            }

            siteNav(currentUrlPath)
        }
    }
}

// ─── Navigation ───────────────────────────────────────────────────────────────

private fun FlowContent.siteNav(currentUrlPath: String) {
    nav(classes = "site-nav") {
        attributes["aria-label"] = "Primary navigation"

        ul(classes = "site-nav__list") {
            PageRegistry.all.forEach { page ->
                val isCurrent = page.urlPath == currentUrlPath
                li(classes = "site-nav__item") {
                    a(
                        href    = page.urlPath,
                        classes = "site-nav__link" + if (isCurrent) " site-nav__link--current" else "",
                    ) {
                        if (isCurrent) attributes["aria-current"] = "page"
                        +navLabel(page)
                    }
                }
            }
        }
    }
}

/** Returns a short human-readable label for the nav link. */
private fun navLabel(page: Page): String = when (page.urlPath) {
    "/" -> "Portfolio"
    else -> page.title.substringBefore("—").substringBefore("-").trim()
}

// ─── Footer ───────────────────────────────────────────────────────────────────

fun FlowContent.siteFooter() {
    footer(classes = "site-footer") {
        span { +"© ${java.time.Year.now().value} ${SeoConfig.SITE_NAME}" }
    }
}
