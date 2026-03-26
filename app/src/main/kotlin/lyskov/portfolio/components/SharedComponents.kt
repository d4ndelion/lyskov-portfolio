package lyskov.portfolio.components

import kotlinx.css.Color
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
fun FlowContent.tagRow(
    tags: List<String>,
    classes: String = "tag-row",
    color: Color? = null,
    allMuted: Boolean = true,
) {
    div(classes = classes) {
        tags.forEachIndexed { i, label ->
            span(classes = if (i == 0 && !allMuted) "tag" else "tag tag--muted") {
                if (color != null) {
                    attributes["style"] = "background: ${color.value};"
                }
                +label
            }
        }
    }
}

// ─── Story card ───────────────────────────────────────────────────────────────

fun FlowContent.storyCard(card: StoryCard) {
    div(classes = "story-card") {
        attributes["style"] = "background: ${card.color};"
        p(classes = "story-card__text") { +card.text }
        if (card.author.isNotEmpty()) {
            p(classes = "story-card__author") { +card.author }
        }
        if (card.ordinal != null) {
            span(classes = "story-card__ordinal") { +card.ordinal.toString() }
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
                else -> "/vector/link-icon.svg"
            }
            img(src = iconSrc, alt = "", classes = "case-ext-link__icon")
            span(classes = "case-ext-link__label") { +link.label }
        }
        img(src = "/vector/case-arrow.svg", alt = "", classes = "case-ext-link__arrow")
    }
}
