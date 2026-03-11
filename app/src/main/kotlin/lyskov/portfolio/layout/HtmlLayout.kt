package lyskov.portfolio.layout

import kotlinx.html.FlowContent
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.lang
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.meta
import kotlinx.html.stream.appendHTML
import kotlinx.html.title
import lyskov.portfolio.model.Page
import lyskov.portfolio.seo.SeoConfig

/**
 * Wraps page content in the full HTML document shell.
 *
 * Returns a complete HTML5 document string including DOCTYPE.
 *
 * @param page     Metadata for the page being rendered.
 * @param content  Lambda that populates the `<main>` element.
 */
fun renderPage(page: Page, content: FlowContent.() -> Unit): String {
    val canonicalUrl = "${SeoConfig.DOMAIN}${page.urlPath}"

    return buildString {
        append("<!DOCTYPE html>\n")
        appendHTML(prettyPrint = true).html {
            lang = "en"

            head {
                meta(charset = "UTF-8")
                meta(name = "viewport", content = "width=device-width, initial-scale=1.0")

                title(page.title)
                meta(name = "description", content = page.description)

                // ── Canonical ────────────────────────────────────────────────────
                link(rel = "canonical", href = canonicalUrl)

                // ── Open Graph ───────────────────────────────────────────────────
                ogMeta("og:type",        "website")
                ogMeta("og:site_name",   SeoConfig.SITE_NAME)
                ogMeta("og:title",       page.title)
                ogMeta("og:description", page.description)
                ogMeta("og:url",         canonicalUrl)

                // ── Twitter card ─────────────────────────────────────────────────
                meta(name = "twitter:card",        content = "summary")
                meta(name = "twitter:site",        content = SeoConfig.TWITTER_HANDLE)
                meta(name = "twitter:title",       content = page.title)
                meta(name = "twitter:description", content = page.description)

                // ── Favicon ──────────────────────────────────────────────────────
                link(rel = "icon", type = "image/x-icon", href = "/favicon.ico")
                link(rel = "icon", type = "image/svg+xml", href = "/favicon.svg")
                link(rel = "apple-touch-icon",    href = "/apple-touch-icon.png")

                // ── Fonts ────────────────────────────────────────────────────────
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(rel = "preconnect", href = "https://fonts.gstatic.com") {
                    attributes["crossorigin"] = ""
                }
                link(
                    rel  = "stylesheet",
                    href = "https://fonts.googleapis.com/css2?family=Onest:wght@400;500&display=swap",
                )

                // ── Stylesheet ───────────────────────────────────────────────────
                link(rel = "stylesheet", href = "/styles.css")
            }

            body {
                siteHeader(page.urlPath)

                main(classes = "site-main") {
                    attributes["id"] = "main-content"
                    attributes["tabindex"] = "-1"
                    content()
                }

                siteFooter()
            }
        }
    }
}

/** Emits a `<meta property="…" content="…">` tag for Open Graph. */
private fun kotlinx.html.HEAD.ogMeta(property: String, content: String) {
    meta(content = content) {
        attributes["property"] = property
    }
}
