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
            description = "Designer portfolio showcasing projects, skills, and experience.",
            fileName    = "index.html",
            urlPath     = "/",
        ),

        Page(
            title       = "Кейс: МТС Web Services",
            description = "Проектировал интерфейс приглашения пользователей в проект для бигтеха. Получил положительные отзывы от пользователей и команды найма.",
            fileName    = "cases/mts/index.html",
            urlPath     = "/cases/mts/",
        ),

        Page(
            title       = "Кейс: BFL",
            description = "С нуля погрузился в сложный домен и спроектировал B2B-систему для ведения банкротства физических лиц. Получил крутой фидбек от пользователей и уложился в короткие сроки.",
            fileName    = "cases/bfl/index.html",
            urlPath     = "/cases/bfl/",
        ),

        Page(
            title       = "Кейс: Свой Среди Своих",
            description = "Разработал концепцию, исследовал пользователей и спроектировал полноценный MVP мобильного приложения для деловых знакомств.",
            fileName    = "cases/among-own/index.html",
            urlPath     = "/cases/among-own/",
        ),

    )
}
