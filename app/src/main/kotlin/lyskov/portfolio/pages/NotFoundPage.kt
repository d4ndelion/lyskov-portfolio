package lyskov.portfolio.pages

import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p
import lyskov.portfolio.layout.renderPage
import lyskov.portfolio.model.Page

/**
 * 404 Not Found page.
 *
 * Not registered in [lyskov.portfolio.registry.PageRegistry] because it must
 * not appear in the sitemap, but it follows the same layout contract.
 */
object NotFoundPage {

    private val page = Page(
        title       = "Page Not Found — Lyskov",
        description = "The page you are looking for does not exist.",
        fileName    = "404.html",
        urlPath     = "/404",
    )

    fun render(): String = renderPage(page) {
        div(classes = "error-page") {
            p(classes = "error-page__code") { +"404" }
            h1(classes = "error-page__title") { +"Page not found" }
            p { +"The page you are looking for doesn't exist or has been moved." }
            a(href = "/") { +"← Back to portfolio" }
        }
    }
}
