package lyskov.portfolio.pages

import kotlinx.html.h1
import kotlinx.html.p
import lyskov.portfolio.layout.renderPage
import lyskov.portfolio.registry.PageRegistry

/**
 * Portfolio landing page (index.html).
 *
 * Content is intentionally minimal pending Figma design delivery.
 * Replace the placeholder sections with final copy and components.
 */
object IndexPage {

    private val page = PageRegistry.all.first { it.urlPath == "/" }

    fun render(): String = renderPage(page) {
        h1(classes = "portfolio__heading") {
            +"Portfolio"
        }
        p(classes = "portfolio__lead") {
            +"Я Илья. Здарова."
        }
    }
}
