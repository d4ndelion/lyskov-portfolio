package lyskov.portfolio.registry

import lyskov.portfolio.model.Page

/**
 * Single source of truth for all pages on the site.
 *
 * To add a new page:
 *   1. Append a [Page] entry here.
 *   2. Create a renderer in `pages/` (e.g. `AboutPage.kt`).
 *   3. Register the renderer call in [lyskov.portfolio.generator.SiteGenerator].
 *
 * The sitemap and robots.txt are generated automatically from this list.
 */
object PageRegistry {

    val all: List<Page> = listOf(

        Page(
            title       = "Portfolio — Lyskov",
            description = "Full-stack developer portfolio showcasing projects, skills, and experience.",
            fileName    = "index.html",
            urlPath     = "/",
        ),

    )
}
