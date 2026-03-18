package lyskov.portfolio.components

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.span
import lyskov.portfolio.model.ExternalLink
import lyskov.portfolio.model.StoryCard

// ─── Tags ─────────────────────────────────────────────────────────────────────

/** Renders a row of tags. First tag is accented, rest are muted. */
fun FlowContent.tagRow(tags: List<String>, classes: String = "tag-row") {
    div(classes = classes) {
        tags.forEachIndexed { i, label ->
            span(classes = if (i == 0) "tag" else "tag tag--muted") { +label }
        }
    }
}

// ─── Story card ───────────────────────────────────────────────────────────────

/**
 * Sticky-note style card used in discovery / UX-research sections.
 * [card.color] is any CSS color value, e.g. "#BBEA80" (green) or "#FFE27A" (yellow).
 */
fun FlowContent.storyCard(card: StoryCard) {
    div(classes = "story-card") {
        attributes["style"] = "background: ${card.color};"
        p(classes = "story-card__text") { +card.text }
        if (card.author.isNotEmpty()) {
            p(classes = "story-card__author") { +card.author }
        }
    }
}

// ─── External link card ───────────────────────────────────────────────────────

fun FlowContent.externalLinkCard(link: ExternalLink) {
    a(href = link.href, classes = "case-ext-link", target = "_blank") {
        attributes["rel"] = "noopener"
        div(classes = "case-ext-link__info") {
            val iconSrc = when (link.icon) {
                "figma" -> "/vector/figma-icon.svg"
                else    -> "/vector/link-icon.svg"
            }
            img(src = iconSrc, alt = "", classes = "case-ext-link__icon")
            span(classes = "case-ext-link__label") { +link.label }
        }
        img(src = "/vector/case-arrow.svg", alt = "", classes = "case-ext-link__arrow")
    }
}
