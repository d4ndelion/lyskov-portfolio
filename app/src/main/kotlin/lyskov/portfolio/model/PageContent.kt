package lyskov.portfolio.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// ─── Root ─────────────────────────────────────────────────────────────────────

@Serializable
data class PageContent(
    val header: Header,
    val sections: List<Section>,
)

// ─── Header ───────────────────────────────────────────────────────────────────

@Serializable
data class Header(
    val logo: String,
    val dividerIcon: String,
    val locationString: String,
    val socialMediaLinks: SocialMediaLinks,
    val emailLink: String,
    val cvLink: String,
)

@Serializable
data class SocialMediaLinks(
    val telegram: SocialMediaLink,
    val linkedin: SocialMediaLink,
    val max: SocialMediaLink,
)

@Serializable
data class SocialMediaLink(
    val icon: String,
    val link: String,
)

// ─── Sections (discriminated union on "type") ─────────────────────────────────

@Serializable
sealed class Section {

    @Serializable
    @SerialName("hero")
    data class Hero(
        val avatar: String,
        val name: String,
        val role: String,
        val experience: String,
        val bio: String,
        val videoButton: VideoButton,
    ) : Section()

    @Serializable
    @SerialName("caseList")
    data class CaseList(
        val items: List<Case>,
    ) : Section()

    @Serializable
    @SerialName("divider")
    data class Divider(
        val subBadge: String,
        val heading: String,
    ) : Section()

    @Serializable
    @SerialName("extraCaseList")
    data class ExtraCaseList(
        val items: List<ExtraCase>,
    ) : Section()

    @Serializable
    @SerialName("outro")
    data class Outro(
        val about: About,
        val goodbye: Goodbye,
    ) : Section()
}

// ─── Nested models ────────────────────────────────────────────────────────────

@Serializable
data class VideoButton(
    val label: String,
    val duration: String,
    val href: String,
)

@Serializable
data class Case(
    val title: String,
    val description: String,
    val tags: List<String>,
    val href: String,
    val cover: String = "",
    val color: String = "#e8ebed",
    /** Gradient end color (bottom of card). Defaults to neutral light gray. */
    val colorEnd: String = "#ebedef",
    /** Text color for title and description. Use "#ffffff" for dark backgrounds. */
    val textColor: String = "#071b31",
)

@Serializable
data class ExtraCase(
    val title: String,
    val description: String,
    val year: String,
    val href: String = "",
    val image: String = "",
)

@Serializable
data class About(
    val subBadge: String,
    val aboutPhotos: List<String>,
    val nick: String,
    val nickSub: String,
    val paragraphs: List<String>,
    val footnote: String,
)

@Serializable
data class Goodbye(
    val heading: String,
    val sub: String,
    val email: String,
)
