package lyskov.portfolio.pages.case

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.li
import kotlinx.html.ol
import kotlinx.html.p
import kotlinx.html.span
import kotlinx.html.ul
import lyskov.portfolio.components.externalLinkCard
import lyskov.portfolio.components.goodbyeSection
import lyskov.portfolio.components.storyCard
import lyskov.portfolio.components.tagRow
import lyskov.portfolio.layout.renderPage
import lyskov.portfolio.model.CaseContent
import lyskov.portfolio.model.CaseSection
import lyskov.portfolio.model.ExternalLink
import lyskov.portfolio.model.Page

object CasePage {

    fun render(content: CaseContent, page: Page): String =
        renderPage(page, breadcrumb = content.breadcrumb) {
            div(classes = "case-page") {
                div(classes = "case-page__body") {

                    renderHeadInfo(
                        content.headInfo.tags, content.headInfo.title,
                        content.headInfo.description, content.headInfo.links, content.headInfo.warning,
                    )

                    content.sections.forEach { renderSection(it) }

                    // Back to main link
                    a(href = "/", classes = "case-ext-link case-back-link") {
                        div(classes = "case-ext-link__info") {
                            img(src = "/vector/back-arrow.svg", alt = "", classes = "case-ext-link__icon")
                            p(classes = "case-ext-link__label") { +"Вернуться на Главную" }
                        }
                    }
                }
                goodbyeSection(content.goodbye)
            }
        }

    // ── Head info ─────────────────────────────────────────────────────────────

    private fun FlowContent.renderHeadInfo(
        tags: List<String>,
        title: String,
        description: String,
        links: List<ExternalLink>,
        warning: String?,
    ) {
        div(classes = "case-head-info") {
            tagRow(tags, classes = "case-tags")
            p(classes = "case-title") { +title }
            p(classes = "case-desc") { +description }
            if (links.isNotEmpty()) {
                div(classes = "case-links-row") {
                    links.forEach { externalLinkCard(it) }
                }
            }
            if (!warning.isNullOrEmpty()) {
                p(classes = "case-warning") {
                    img(src = "/vector/warning.svg", classes = "case-heading-icon") {
                        attributes["style"] = "margin-left:0; margin-right:12px; width:20px; height:20px"
                    }
                    +warning
                }
            }
        }
    }

    // ── Sections ──────────────────────────────────────────────────────────────

    private fun FlowContent.renderSection(section: CaseSection) {
        when (section) {
            is CaseSection.ImageBlock -> renderImageBlock(section)
            is CaseSection.TextSection -> renderTextSection(section)
            is CaseSection.StepList -> renderStepList(section)
            is CaseSection.CardGrid -> renderCardGrid(section)
        }
    }

    private fun FlowContent.renderImageBlock(block: CaseSection.ImageBlock) {
        val bgStyle = if (block.accent.isNotEmpty())
            "background: linear-gradient(180deg, var(--c-card) 0%, ${block.accent}1F 100%);"
        else
            "background: var(--c-card);"

        if (block.placeholders.isNotEmpty()) {
            div(classes = "case-img-block case-img-block--placeholder") {
                attributes["style"] = bgStyle
                block.placeholders.forEach { w ->
                    div(classes = "case-img-block__ph-row") {
                        attributes["style"] = "width: $w;"
                    }
                }
            }
        } else {
            div {
                div(classes = "case-img-block") {
                    attributes["style"] = bgStyle
                    if (block.image.isNotEmpty()) {
                        img(src = block.image, alt = "", classes = "case-img-block__img")
                    }
                }
                if (!block.description.isNullOrEmpty()) {
                    p(classes = "case-img-description") {
                        +block.description
                    }
                }
            }
        }
    }

    private fun FlowContent.renderTextSection(section: CaseSection.TextSection) {
        div(classes = "case-text-section") {
            if (section.heading.isNotEmpty()) {
                p(classes = "case-section-heading") {
                    if (section.sectionId.isNotEmpty()) attributes["id"] = section.sectionId
                    renderHeadingText(section.heading)
                }
            }
            section.paragraphs.forEach { para ->
                renderParagraph(para.text, para.muted)
            }
            if (section.listHeader.isNotEmpty()) {
                p(classes = "case-para case-para--muted") { +section.listHeader }
            }
            if (section.listItems.isNotEmpty()) {
                ol(classes = "case-list") {
                    section.listItems.forEach { item ->
                        li(classes = "case-list__item") { +item }
                    }
                }
            }
            if (section.links.isNotEmpty()) {
                div(classes = "case-links-row") {
                    section.links.forEach { externalLinkCard(it) }
                }
            }
            section.postParagraphs.forEach { para ->
                renderParagraph(para.text, para.muted)
            }
        }
    }

    private fun FlowContent.renderCardGrid(section: CaseSection.CardGrid) {
        val rows = section.cards.groupBy { it.color }
        div(classes = "card-grid-wrap") {
            rows.values.forEach { rowCards ->
                div(classes = "card-grid") {
                    rowCards.forEach { storyCard(it) }
                }
            }
        }
    }

    private fun FlowContent.renderStepList(section: CaseSection.StepList) {
        div(classes = "case-text-section") {
            p(classes = "case-section-heading") { renderHeadingText(section.heading) }
            if (section.intro.isNotEmpty()) {
                p(classes = "case-para case-para--muted") { +section.intro }
            }
            div(classes = "case-steps") {
                section.steps.forEachIndexed { i, step ->
                    val anchorId = section.anchorIds.getOrNull(i)
                    if (anchorId != null) {
                        a(href = "#$anchorId", classes = "case-step") {
                            p(classes = "case-step__label") { +"${i + 1}. $step" }
                            img(src = "/vector/case-arrow.svg", alt = "", classes = "case-step__arrow")
                        }
                    } else {
                        div(classes = "case-step") {
                            p(classes = "case-step__label") { +"${i + 1}. $step" }
                            img(src = "/vector/case-arrow.svg", alt = "", classes = "case-step__arrow")
                        }
                    }
                }
            }
        }
    }

    // ── Heading text with inline images ────────────────────────────────────
    //
    // Syntax: <img src="/vector/star-divider.svg">  (only src is extracted)
    //
    private val headingImgRegex = Regex("""<img\s+src="([^"]+)"[^>]*>""")

    private fun FlowContent.renderHeadingText(text: String) {
        var last = 0
        for (match in headingImgRegex.findAll(text)) {
            if (match.range.first > last) +text.substring(last, match.range.first)
            img(src = match.groupValues[1], alt = "", classes = "case-heading-icon")
            last = match.range.last + 1
        }
        if (last < text.length) +text.substring(last)
    }

    // ── Paragraph with optional embedded <ol>/<ul> lists ──────────────────
    //
    // Allows mixing text and block lists inside a single JSON paragraph:
    //   "text": "Intro:\n<ol><li>One</li><li>Two</li></ol>\nOutro"
    //
    private val listBlockRegex = Regex("""<(ol|ul)>([\s\S]*?)</(ol|ul)>""")
    private val listItemRegex  = Regex("""<li>([\s\S]*?)</li>""")

    private fun FlowContent.renderParagraph(text: String, muted: Boolean) {
        val paraClass = if (muted) "case-para case-para--muted" else "case-para"
        val matches = listBlockRegex.findAll(text).toList()
        if (matches.isEmpty()) {
            p(classes = paraClass) { renderInlineText(text) }
            return
        }
        var last = 0
        for (match in matches) {
            val before = text.substring(last, match.range.first).trim()
            if (before.isNotEmpty()) p(classes = paraClass) { renderInlineText(before) }
            val items = listItemRegex.findAll(match.groupValues[2]).map { it.groupValues[1] }.toList()
            if (match.groupValues[1] == "ul") {
                ul(classes = "case-list case-list--ul") {
                    items.forEach { item -> li(classes = "case-list__item") { renderInlineText(item) } }
                }
            } else {
                ol(classes = "case-list") {
                    items.forEach { item -> li(classes = "case-list__item") { renderInlineText(item) } }
                }
            }
            last = match.range.last + 1
        }
        val after = text.substring(last).trim()
        if (after.isNotEmpty()) p(classes = paraClass) { renderInlineText(after) }
    }

    // ── Inline text with highlights ────────────────────────────────────────
    //
    // Syntax: <<текст|цвет>>  e.g. <<User Stories|#FFE27A>>
    //
    private val highlightRegex = Regex("<<([^|>]+)\\|([^>]+)>>")

    private fun FlowContent.renderInlineText(text: String) {
        var last = 0
        for (match in highlightRegex.findAll(text)) {
            if (match.range.first > last) +text.substring(last, match.range.first)
            span(classes = "text-highlight") {
                attributes["style"] = "background: ${match.groupValues[2]};"
                +match.groupValues[1]
            }
            last = match.range.last + 1
        }
        if (last < text.length) +text.substring(last)
    }
}
