package lyskov.portfolio.pages.index

import kotlinx.css.Color
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.section
import kotlinx.html.span
import lyskov.portfolio.components.goodbyeSection
import lyskov.portfolio.components.imageBlock
import lyskov.portfolio.components.tagRow
import lyskov.portfolio.layout.renderPage
import lyskov.portfolio.model.About
import lyskov.portfolio.model.Case
import lyskov.portfolio.model.CaseSection
import lyskov.portfolio.model.ExtraCase
import lyskov.portfolio.model.Section
import lyskov.portfolio.model.VideoButton
import lyskov.portfolio.registry.ContentLoader
import lyskov.portfolio.registry.PageRegistry

object IndexPage {

    private val page = PageRegistry.all.first { it.urlPath == "/" }

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
                    goodbyeSection(section.goodbye)
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
                                img(src = "/vector/video-play.svg", alt = "")
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
                imageBlock(case)
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
                                a(href = case.href, classes = "btn-pill") {
                                    span(classes = "btn-pill__icon") {}
                                    span { +"Смотреть кейс" }
                                }
                            }
                        }
                        tagRow(case.tags, "case-card__tags", Color("#EBEDEF").withAlpha(.4))
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
                            if (ec.image.isNotEmpty()) {
                                img(src = ec.image, alt = ec.title, classes = "mini-card__img")
                            }
                            div(classes = "mini-card__content") {
                                div(classes = "mini-card__bottom") {
                                    div(classes = "mini-card__text") {
                                        p(classes = "mini-card__title") { +ec.title }
                                        p(classes = "mini-card__desc") { +ec.description }
                                    }
                                    if (ec.href.isNotEmpty()) {
                                        div(classes = "mini-card__footer") {
                                            a(href = ec.href, classes = "btn-pill") {
                                                span(classes = "btn-pill__icon") {}
                                                span { +"Подробнее" }
                                            }
                                        }
                                    }
                                }
                                tagRow(tags = listOf(ec.year), color = Color.white.withAlpha(.6))
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
}
