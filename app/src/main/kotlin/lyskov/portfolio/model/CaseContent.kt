package lyskov.portfolio.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CaseContent(
    val meta: CaseMeta,
    val breadcrumb: String,
    val headInfo: CaseHeadInfo,
    val sections: List<CaseSection>,
    val goodbye: Goodbye,
)

@Serializable
data class CaseMeta(
    val title: String,
    val description: String,
)

@Serializable
data class CaseHeadInfo(
    val tags: List<String>,
    val title: String,
    val description: String,
    val links: List<ExternalLink>,
    val warning: String? = null,
)

@Serializable
data class ExternalLink(
    val icon: String,
    val label: String,
    val href: String,
)

@Serializable
data class TextParagraph(
    val text: String,
    val muted: Boolean = false,
)

@Serializable
sealed class CaseSection {

    @Serializable
    @SerialName("imageBlock")
    data class ImageBlock(
        val image: String = "",
        val accent: String = "",
        /** If non-empty, renders placeholder rows instead of an image (widths as CSS values, e.g. "100%", "59%"). */
        val placeholders: List<String> = emptyList(),
        val description: String? = null,
    ) : CaseSection()

    @Serializable
    @SerialName("textSection")
    data class TextSection(
        val heading: String = "",
        /** HTML id for this section — used as scroll target from the step list. */
        val sectionId: String = "",
        val paragraphs: List<TextParagraph> = emptyList(),
        val listHeader: String = "",
        val listItems: List<String> = emptyList(),
        val links: List<ExternalLink> = emptyList(),
        /** Paragraphs rendered after the links row. */
        val postParagraphs: List<TextParagraph> = emptyList(),
    ) : CaseSection()

    @Serializable
    @SerialName("stepList")
    data class StepList(
        val heading: String,
        val intro: String = "",
        val steps: List<String>,
        /** Anchor ids corresponding to each step (links to that section on click). */
        val anchorIds: List<String> = emptyList(),
    ) : CaseSection()

    @Serializable
    @SerialName("cardGrid")
    data class CardGrid(
        val heading: String = "",
        val cards: List<StoryCard>,
    ) : CaseSection()
}

@Serializable
data class StoryCard(
    val text: String,
    val author: String = "",
    /** CSS color value for the card background, e.g. "#BBEA80" or "var(--c-card-green)". */
    val color: String = "#BBEA80",
    val ordinal: Int? = null,
)
