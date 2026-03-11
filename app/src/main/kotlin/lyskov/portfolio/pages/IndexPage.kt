package lyskov.portfolio.pages

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.section
import kotlinx.html.span
import lyskov.portfolio.layout.renderPage
import lyskov.portfolio.registry.PageRegistry

object IndexPage {

    private val page = PageRegistry.all.first { it.urlPath == "/" }

    /**
     * Figma CDN image URLs — valid approximately 7 days after design export.
     * TODO: download and replace with local paths under src/main/resources/img/
     */
    private object A {
        const val AVATAR           = "https://www.figma.com/api/mcp/asset/52724317-ba7d-444a-b4e8-1ca5bbc4451e"
        const val VIDEO_PREVIEW    = "https://www.figma.com/api/mcp/asset/17cab353-14dc-41ea-9d41-314574da194e"
        const val VIDEO_PLAY_ICON  = "https://www.figma.com/api/mcp/asset/bfdb6c95-d75c-47f4-91a7-174ae97c8c2c"
        const val CASE_BTN_ICON    = "https://www.figma.com/api/mcp/asset/206172de-a724-4f23-b697-33abbdc8884e"
        const val WRITE_ICON       = "https://www.figma.com/api/mcp/asset/280a39aa-8b87-4759-9fd3-5839785e004d"
        const val COPY_ICON        = "https://www.figma.com/api/mcp/asset/6222a00e-3c71-46c5-b8bb-a19c4a222f14"
        const val CASE1_COVER      = "https://www.figma.com/api/mcp/asset/5ca5186c-d247-4287-a122-fa9970be1eb2"
        const val CASE2_COVER      = "https://www.figma.com/api/mcp/asset/cb2650ba-f2ea-4741-b822-7ead7bf3d142"
        const val CASE3_COVER      = "https://www.figma.com/api/mcp/asset/081e39ae-7fb0-4831-a8e3-545de3a21924"
        const val CASE4_COVER      = "https://www.figma.com/api/mcp/asset/652ded42-c87f-4fcd-b671-1ebaef1ad268"
        const val CASE4_SCREEN     = "https://www.figma.com/api/mcp/asset/9eec5bf9-d009-45fb-ac36-e997cfa1adee"
        const val MONOPOLY_IMG     = "https://www.figma.com/api/mcp/asset/77e14916-8747-48db-8d75-21f78b848c91"
        const val HACKATHON_IMG    = "https://www.figma.com/api/mcp/asset/6da2799d-9f8c-45eb-8be4-6f8a78208726"
        const val FUNNY_GIF        = "https://www.figma.com/api/mcp/asset/95935e79-5a6f-460d-9380-0317caebd3d9"
        const val PHOTO1           = "https://www.figma.com/api/mcp/asset/4d98691c-9ba9-4acb-8005-73c1065e877a"
        const val PHOTO2           = "https://www.figma.com/api/mcp/asset/0ef30b06-dcb4-4498-b703-3548d6a14fb6"
        const val PHOTO3           = "https://www.figma.com/api/mcp/asset/f489ec88-b57a-437f-827c-e71be3619dfc"
        const val PHOTO4           = "https://www.figma.com/api/mcp/asset/e0c3c82c-1cd7-407a-8539-edfb4f9dd74b"
        const val ICON_MAX         = "https://www.figma.com/api/mcp/asset/1dc8b057-64be-4b1f-ab3d-65b9546aafcb"
        const val ICON_LINKEDIN    = "https://www.figma.com/api/mcp/asset/e03cc8ec-fcf9-4d54-b83a-eeda3b5fc9f5"
    }

    fun render(): String = renderPage(page) {
        heroSection()
        caseSection(
            cover = A.CASE1_COVER,
            title = "SAAS-система для ведения процессов банкротства BFL",
            desc  = "С нуля погрузился в сложный домен и спроектировал B2B-систему для ведения банкротства физических лиц. Получил крутой фидбек от пользователей и уложился в короткие сроки",
            tags  = listOf("2025", "LegalTech", "Web"),
            href  = "#",
        )
        caseSection(
            cover = A.CASE2_COVER,
            title = "Спроектировал MVP приложения для бизнес-нетворкинга",
            desc  = "Разработал концепцию, исследовал пользователей и спроектировал полноценный MVP мобильного приложения для деловых знакомств",
            tags  = listOf("2026", "—", "Mobile"),
            href  = "#",
        )
        caseSection(
            cover = A.CASE3_COVER,
            title = "Дизайн система для Dispex Web",
            desc  = "Построил масштабируемую дизайн-систему для B2B веб-продукта в PropTech — от токенов до готовых компонентов",
            tags  = listOf("2026", "PropTech", "Web"),
            href  = "#",
        )
        caseSection(
            cover = A.CASE4_COVER,
            title = "Успешное тестовое в МТС Web Services",
            desc  = "Проектировал интерфейс приглашения пользователей в проект для бигтеха. Получил положительные отзывы от пользователей и команды найма",
            tags  = listOf("2025", "Telecom", "Web"),
            href  = "#",
        )
        extraCasesSection()
        aboutSection()
        goodbyeSection()
    }

    // ── Hero ──────────────────────────────────────────────────────────────────

    private fun FlowContent.heroSection() {
        section(classes = "pg-section") {
            div(classes = "pg-section__body") {
                div(classes = "hero__body") {
                    div(classes = "hero__avatar") {
                        img(src = A.AVATAR, alt = "Илья Лысков")
                    }
                    div(classes = "hero__about") {
                        div(classes = "hero__name-role") {
                            p(classes = "hero__name") { +"Илья Лысков" }
                            div(classes = "hero__role") {
                                span { +"Продуктовый дизайнер," }
                                span(classes = "hero__exp-badge") { +"5 лет опыта" }
                            }
                        }
                        p(classes = "hero__bio") {
                            +"Проектирую интерфейсы с заботой о пользователе, выгодой для бизнеса, и понятной разработке"
                        }
                    }
                    a(href = "#", classes = "hero__video-btn") {
                        attributes["aria-label"] = "Видео: рассказ о себе, 0:40"
                        div(classes = "hero__video-preview") {
                            img(src = A.VIDEO_PREVIEW, alt = "")
                        }
                        div(classes = "hero__video-info") {
                            span(classes = "hero__video-title") { +"Рассказ о себе" }
                            span(classes = "hero__video-duration") { +"0:40" }
                        }
                    }
                }
            }
        }
    }

    // ── Case section (reusable) ───────────────────────────────────────────────

    private fun FlowContent.caseSection(
        cover: String,
        title: String,
        desc: String,
        tags: List<String>,
        href: String,
    ) {
        section(classes = "pg-section") {
            div(classes = "pg-section__body") {
                div(classes = "case-body") {
                    div(classes = "case-card") {
                        img(src = cover, alt = "", classes = "case-card__cover")

                        div(classes = "case-card__info") {
                            div(classes = "case-card__title-desc") {
                                p(classes = "case-card__title") { +title }
                                p(classes = "case-card__desc") { +desc }
                            }
                            div(classes = "case-card__bottom") {
                                div(classes = "case-card__btn-slot") {
                                    a(href = href, classes = "btn-case") {
                                        img(src = A.CASE_BTN_ICON, alt = "")
                                        span { +"Смотреть кейс" }
                                    }
                                }
                                div(classes = "case-card__tags") {
                                    tags.forEachIndexed { i, label ->
                                        span(classes = if (i == 0) "tag" else "tag tag--muted") { +label }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // ── Extra cases ───────────────────────────────────────────────────────────

    private fun FlowContent.extraCasesSection() {
        section(classes = "pg-section") {
            div(classes = "pg-section__body") {
                div(classes = "extra-body") {
                    div(classes = "extra-header") {
                        span(classes = "sub-badge") { +"а еще..." }
                        p(classes = "section-heading") {
                            +"использую и проверяю свои навыки вне работы"
                        }
                    }
                    div(classes = "extra-grid") {
                        // Monopoly card
                        div(classes = "mini-card") {
                            div(classes = "mini-card__content") {
                                img(src = A.MONOPOLY_IMG, alt = "Доска игры «Монополия»", classes = "mini-card__img")
                            }
                            div(classes = "mini-card__bottom") {
                                div(classes = "mini-card__text") {
                                    p(classes = "mini-card__title") { +"Моя сбалансированная версия «Монополии»" }
                                    p(classes = "mini-card__desc") {
                                        +"Переработал экономику и баланс игры, добавил новые механики и встроил в неё множество наших с друзьями локальных мемов"
                                    }
                                }
                                div(classes = "mini-card__footer") {
                                    a(href = "#", classes = "btn-case") {
                                        img(src = A.CASE_BTN_ICON, alt = "")
                                        span { +"Подробнее" }
                                    }
                                    span(classes = "tag") { +"2026" }
                                }
                            }
                        }
                        // Hackathon card
                        div(classes = "mini-card") {
                            div(classes = "mini-card__content") {
                                img(src = A.HACKATHON_IMG, alt = "Сертификат победителя хакатона", classes = "mini-card__img")
                            }
                            div(classes = "mini-card__bottom") {
                                div(classes = "mini-card__text") {
                                    p(classes = "mini-card__title") { +"Выиграл в Хакатоне по разработке приложения" }
                                    p(classes = "mini-card__desc") {
                                        +"Выступал в команде главным дизайнером: разработал запоминающийся визуал и грамотно презентовал концепт, благодаря чему проект запомнился жюри :)"
                                    }
                                }
                                div(classes = "mini-card__footer") {
                                    span(classes = "tag") { +"2022" }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // ── About ─────────────────────────────────────────────────────────────────

    private fun FlowContent.aboutSection() {
        section(classes = "pg-section pg-section--about") {
            div(classes = "pg-section__body") {
                div(classes = "about-body") {
                    span(classes = "sub-badge") { +"ну а вообще..." }
                    div(classes = "about-photos") {
                        div(classes = "about-photo") {
                            img(src = A.PHOTO1, alt = "Фото 1")
                        }
                        div(classes = "about-photo") {
                            img(src = A.PHOTO2, alt = "Фото 2")
                        }
                        div(classes = "about-photo about-photo--sq") {
                            img(src = A.PHOTO3, alt = "Фото 3")
                        }
                        div(classes = "about-photo") {
                            img(src = A.PHOTO4, alt = "Фото 4")
                        }
                    }
                    div(classes = "about-description") {
                        div(classes = "about-nick") {
                            p(classes = "about-nick__name") { +"я Илья, здарова!" }
                            p(classes = "about-nick__sub") { +"(такой ник можно встретить во всех моих соцсетях)" }
                        }
                        p(classes = "about-text") {
                            +"Выписываю свои наблюдения в tg-посты, снимался в кулинарных видео на yt, очень люблю фоткаться"
                        }
                        p(classes = "about-text") { +"Завайбкодил бота" }
                        p(classes = "about-text--small") {
                            +"На форуме сервера по GTA San Andreas Multiplayer был дизайнером графики всего сервера (ну, это типо было круто!)"
                        }
                    }
                }
            }
        }
    }

    // ── Goodbye ───────────────────────────────────────────────────────────────

    private fun FlowContent.goodbyeSection() {
        section(classes = "pg-section pg-section--goodbye") {
            div(classes = "goodbye-body") {
                div(classes = "goodbye-gif") {
                    img(src = A.FUNNY_GIF, alt = "")
                }
                div(classes = "goodbye-text") {
                    p(classes = "goodbye-text__heading") { +"cпасибо за уделенное время!" }
                    p(classes = "goodbye-text__sub") { +"буду рад посотрудничать с вами" }
                }
                div(classes = "goodbye-contacts") {
                    div(classes = "goodbye-btn-row") {
                        a(href = "https://t.me/ansuzdesign", classes = "btn-write", target = "_blank") {
                            attributes["rel"] = "noopener"
                            img(src = A.WRITE_ICON, alt = "")
                            span { +"Написать" }
                        }
                        a(href = "https://max.ru/ansuzdesign", classes = "icon-btn", target = "_blank") {
                            attributes["aria-label"] = "MAX"
                            attributes["rel"] = "noopener"
                            img(src = A.ICON_MAX, alt = "MAX")
                        }
                        a(href = "https://www.linkedin.com/in/ilya-lyskov/", classes = "icon-btn icon-btn--linkedin", target = "_blank") {
                            attributes["aria-label"] = "LinkedIn"
                            attributes["rel"] = "noopener"
                            img(src = A.ICON_LINKEDIN, alt = "LinkedIn")
                        }
                    }
                    a(href = "mailto:mr.ansuz@gmail.com", classes = "goodbye-email") {
                        span { +"mr.ansuz@gmail.com" }
                        img(src = A.COPY_ICON, alt = "")
                    }
                }
            }
        }
    }
}
