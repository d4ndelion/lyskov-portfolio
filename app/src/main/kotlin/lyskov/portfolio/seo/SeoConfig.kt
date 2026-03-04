package lyskov.portfolio.seo

/**
 * Central SEO and site identity configuration.
 * Replace placeholder values before deploying.
 */
object SeoConfig {
    /** Scheme + host, no trailing slash. */
    const val DOMAIN = "https://ilyskov.site/"

    /** Human-readable site name used in OG tags. */
    const val SITE_NAME = "Lyskov Portfolio"

    /** Twitter / X handle including the @ symbol. */
    const val TWITTER_HANDLE = "@lyskov"

    /** Value written to the CNAME file for GitHub Pages. */
    const val CNAME_DOMAIN = "ilyskov.site"

    /** Absolute URL of the sitemap, referenced by robots.txt. */
    val SITEMAP_URL = "$DOMAIN/sitemap.xml"
}
