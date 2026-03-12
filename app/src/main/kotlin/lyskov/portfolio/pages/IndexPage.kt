package lyskov.portfolio.pages

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.section
import kotlinx.html.span
import lyskov.portfolio.layout.renderPage
import lyskov.portfolio.model.About
import lyskov.portfolio.model.Case
import lyskov.portfolio.model.ExtraCase
import lyskov.portfolio.model.Goodbye
import lyskov.portfolio.model.Section
import lyskov.portfolio.model.VideoButton
import lyskov.portfolio.registry.ContentLoader
import lyskov.portfolio.registry.PageRegistry

object IndexPage {

    private val page = PageRegistry.all.first { it.urlPath == "/" }

    private object Icons {
        const val CASE_ARROW = "https://www.figma.com/api/mcp/asset/206172de-a724-4f23-b697-33abbdc8884e"
        const val WRITE = "https://www.figma.com/api/mcp/asset/280a39aa-8b87-4759-9fd3-5839785e004d"
        const val COPY_EMAIL = "https://www.figma.com/api/mcp/asset/6222a00e-3c71-46c5-b8bb-a19c4a222f14"
        const val VIDEO_PLAY = "https://www.figma.com/api/mcp/asset/bfdb6c95-d75c-47f4-91a7-174ae97c8c2c"
        const val MAX = "https://www.figma.com/api/mcp/asset/1dc8b057-64be-4b1f-ab3d-65b9546aafcb"
        const val LINKEDIN = "https://www.figma.com/api/mcp/asset/e03cc8ec-fcf9-4d54-b83a-eeda3b5fc9f5"
    }

    fun render(): String = renderPage(page) {
        val content = ContentLoader.content
        content.sections.forEach { section ->
            when (section) {
                is Section.Hero -> renderHero(
                    avatar = section.avatar,
                    name = section.name,
                    role = section.role,
                    experience = section.experience,
                    bio = section.bio,
                    videoButton = section.videoButton,
                )

                is Section.CaseList -> section.items.forEach { renderCase(it) }
                is Section.Divider -> renderDivider(section.subBadge, section.heading)
                is Section.ExtraCaseList -> renderExtraCases(section.items)
                is Section.Outro -> {
                    renderAbout(section.about)
                    renderGoodbye(section.goodbye)
                }
            }
        }
    }

    // ── Hero ──────────────────────────────────────────────────────────────────

    private fun FlowContent.renderHero(
        avatar: String,
        name: String,
        role: String,
        experience: String,
        bio: String,
        videoButton: VideoButton,
    ) {
        section(classes = "pg-section") {
            div(classes = "pg-section__body") {
                div(classes = "hero__body") {
                    div(classes = "hero__avatar") {
                        img(src = avatar, alt = name)
                    }
                    div(classes = "hero__about") {
                        div(classes = "hero__name-role") {
                            p(classes = "hero__name") { +name }
                            div(classes = "hero__role") {
                                span { +"$role," }
                                span(classes = "hero__exp-badge") { +experience }
                            }
                        }
                        p(classes = "hero__bio") { +bio }
                    }
                    if (videoButton.href.isNotEmpty()) {
                        a(href = videoButton.href, classes = "hero__video-btn") {
                            attributes["aria-label"] = "Видео: ${videoButton.label}, ${videoButton.duration}"
                            div(classes = "hero__video-preview") {
                                img(src = Icons.VIDEO_PLAY, alt = "")
                            }
                            div(classes = "hero__video-info") {
                                span(classes = "hero__video-title") { +videoButton.label }
                                span(classes = "hero__video-duration") { +videoButton.duration }
                            }
                        }
                    }
                }
            }
        }
    }

    // ── Case ──────────────────────────────────────────────────────────────────

    private fun FlowContent.renderCase(case: Case) {
        section(classes = "pg-section") {
            div(classes = "pg-section__body") {

                div(classes = "case-card") {

                    // body (gradient)
                    div(classes = "case-card__body") {
                        attributes["style"] =
                            "background: linear-gradient(180deg, ${case.color} 0%, ${case.colorEnd} 100%);"
                    }

                    // shoulder
                    div(classes = "case-card__back") {
                        attributes["style"] = "background: ${case.color};"
                    }

                    // tab
                    div(classes = "case-card__tab") {
                        attributes["style"] = "background: ${case.color};"
                    }

                    if (case.cover.isNotEmpty()) {
                        img(
                            src = case.cover,
                            alt = "",
                            classes = "case-card__cover"
                        )
                    }

                    div(classes = "case-card__info") {

                        div(classes = "case-card__title-desc") {

                            p(classes = "case-card__title") {
                                attributes["style"] = "color: ${case.textColor};"
                                +case.title
                            }

                            p(classes = "case-card__desc") {
                                attributes["style"] = "color: ${case.textColor};"
                                +case.description
                            }
                        }

                        div(classes = "case-card__bottom") {

                            div(classes = "case-card__btn-slot") {
                                if (case.href.isNotEmpty()) {
                                    a(href = case.href, classes = "btn-case") {
                                        img(src = Icons.CASE_ARROW, alt = "")
                                        span { +"Смотреть кейс" }
                                    }
                                }
                            }

                            div(classes = "case-card__tags") {
                                case.tags.forEachIndexed { i, label ->
                                    span(
                                        classes =
                                            if (i == 0) "tag"
                                            else "tag tag--muted"
                                    ) { +label }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // ── Divider ───────────────────────────────────────────────────────────────

    private fun FlowContent.renderDivider(subBadge: String, heading: String) {
        section(classes = "pg-section") {
            div(classes = "pg-section__body") {
                div(classes = "extra-header") {
                    span(classes = "sub-badge") { +subBadge }
                    p(classes = "section-heading") { +heading }
                }
            }
        }
    }

    // ── Extra cases ───────────────────────────────────────────────────────────

    private fun FlowContent.renderExtraCases(items: List<ExtraCase>) {
        section(classes = "pg-section") {
            div(classes = "pg-section__body") {
                div(classes = "extra-grid") {
                    items.forEach { ec ->
                        div(classes = "mini-card") {
                            div(classes = "mini-card__content") {
                                if (ec.image.isNotEmpty()) {
                                    img(src = ec.image, alt = ec.title, classes = "mini-card__img")
                                }
                            }
                            div(classes = "mini-card__bottom") {
                                div(classes = "mini-card__text") {
                                    p(classes = "mini-card__title") { +ec.title }
                                    p(classes = "mini-card__desc") { +ec.description }
                                }
                                div(classes = "mini-card__footer") {
                                    if (ec.href.isNotEmpty()) {
                                        a(href = ec.href, classes = "btn-case") {
                                            img(src = Icons.CASE_ARROW, alt = "")
                                            span { +"Подробнее" }
                                        }
                                    }
                                    span(classes = "tag") { +ec.year }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // ── About ─────────────────────────────────────────────────────────────────

    private fun FlowContent.renderAbout(about: About) {
        section(classes = "pg-section pg-section--about") {
            div(classes = "pg-section__body") {
                div(classes = "about-body") {
                    span(classes = "sub-badge") { +about.subBadge }
                    // Photo row — paths filled in by user via main.json
                    div(classes = "about-photos") {
                        about.aboutPhotos.forEachIndexed { index, photoLink ->
                            div(classes = "about-photo${if (index == 2) " about-photo--sq" else ""}") {
                                img(src = photoLink)
                            }
                        }
                    }
                    div(classes = "about-description") {
                        div(classes = "about-nick") {
                            p(classes = "about-nick__name") { +about.nick }
                            p(classes = "about-nick__sub") { +about.nickSub }
                        }
                        about.paragraphs.forEach { para ->
                            p(classes = "about-text") { +para }
                        }
                        p(classes = "about-text--small") { +about.footnote }
                    }
                }
            }
        }
    }

    // ── Goodbye ───────────────────────────────────────────────────────────────

    private fun FlowContent.renderGoodbye(goodbye: Goodbye) {
        val header = ContentLoader.content.header
        section(classes = "pg-section pg-section--goodbye") {
            div(classes = "goodbye-body") {
                // Funny gif — path to be filled by user
                div(classes = "goodbye-gif")
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
                                img(src = Icons.WRITE, alt = "")
                                span { +"Написать" }
                            }
                        }
                        val maxLink = header.socialMediaLinks.max.link
                        if (maxLink.isNotEmpty()) {
                            a(href = maxLink, classes = "icon-btn", target = "_blank") {
                                attributes["aria-label"] = "MAX"
                                attributes["rel"] = "noopener"
                                img(src = Icons.MAX, alt = "MAX")
                            }
                        }
                        val liLink = header.socialMediaLinks.linkedin.link
                        if (liLink.isNotEmpty()) {
                            a(href = liLink, classes = "icon-btn icon-btn--linkedin", target = "_blank") {
                                attributes["aria-label"] = "LinkedIn"
                                attributes["rel"] = "noopener"
                                img(src = Icons.LINKEDIN, alt = "LinkedIn")
                            }
                        }
                    }
                    a(href = "mailto:${goodbye.email}", classes = "goodbye-email") {
                        span { +goodbye.email }
                        img(src = Icons.COPY_EMAIL, alt = "")
                    }
                }
            }
        }
    }
}
