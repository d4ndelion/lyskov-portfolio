package lyskov.portfolio.model

/**
 * Represents a single page in the site.
 *
 * @param title       Full <title> text (also used for OG / Twitter).
 * @param description Meta description (also used for OG / Twitter).
 * @param fileName    Output file name, e.g. "index.html".
 * @param urlPath     Canonical URL path, e.g. "/" or "/about/".
 */
data class Page(
    val title: String,
    val description: String,
    val fileName: String,
    val urlPath: String,
)
