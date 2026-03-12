package lyskov.portfolio.generator

import lyskov.portfolio.layout.Css
import lyskov.portfolio.pages.IndexPage
import lyskov.portfolio.pages.NotFoundPage
import lyskov.portfolio.registry.PageRegistry
import lyskov.portfolio.seo.SeoConfig
import java.io.File
import java.time.LocalDate

/**
 * Orchestrates the full static site build.
 *
 * To add a new page:
 *   1. Add a [lyskov.portfolio.model.Page] to [lyskov.portfolio.registry.PageRegistry].
 *   2. Create its renderer (e.g. `AboutPage.kt`).
 *   3. Add one line to [generatePages] calling that renderer.
 *
 * Everything else (sitemap, robots.txt) is derived automatically from
 * [PageRegistry.all].
 */
object SiteGenerator {

    fun generate(outputDir: File) {
        outputDir.mkdirs()
        generatePages(outputDir)
        write(outputDir, "styles.css",  Css.STYLESHEET)
        write(outputDir, "robots.txt",  buildRobotsTxt())
        write(outputDir, "sitemap.xml", buildSitemap())
        write(outputDir, "CNAME",       SeoConfig.CNAME_DOMAIN)
        copyStaticAssets(outputDir)
        println("Site written to: ${outputDir.absolutePath}")
    }

    // ─── Pages ────────────────────────────────────────────────────────────────

    private fun generatePages(outputDir: File) {
        write(outputDir, "index.html", IndexPage.render())
        write(outputDir, "404.html",   NotFoundPage.render())
        // Add new pages here, e.g.:
        // write(outputDir, "about/index.html", AboutPage.render())
    }

    // ─── robots.txt ───────────────────────────────────────────────────────────

    private fun buildRobotsTxt(): String = buildString {
        appendLine("User-agent: *")
        appendLine("Allow: /")
        appendLine()
        appendLine("Sitemap: ${SeoConfig.SITEMAP_URL}")
    }

    // ─── sitemap.xml ──────────────────────────────────────────────────────────

    /**
     * Generates sitemap.xml dynamically from [PageRegistry.all].
     * Adding a page to the registry automatically includes it here.
     */
    private fun buildSitemap(): String {
        val today = LocalDate.now()
        return buildString {
            appendLine("""<?xml version="1.0" encoding="UTF-8"?>""")
            appendLine("""<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">""")
            PageRegistry.all.forEach { page ->
                val loc = "${SeoConfig.DOMAIN}${page.urlPath}"
                appendLine("  <url>")
                appendLine("    <loc>$loc</loc>")
                appendLine("    <lastmod>$today</lastmod>")
                appendLine("    <changefreq>monthly</changefreq>")
                val priority = if (page.urlPath == "/") "1.0" else "0.8"
                appendLine("    <priority>$priority</priority>")
                appendLine("  </url>")
            }
            append("</urlset>")
        }
    }

    // ─── Static assets ────────────────────────────────────────────────────────

    /**
     * Copies static asset directories (vector/, image/, etc.) from the
     * classpath resources root into [outputDir], preserving folder structure.
     *
     * Any directory sitting next to main.json in resources is treated as a
     * static asset folder and copied verbatim.
     */
    private fun copyStaticAssets(outputDir: File) {
        val resourcesRoot = SiteGenerator::class.java.classLoader
            .getResource("main.json")
            ?.toURI()
            ?.let { File(it).parentFile }
            ?: return

        resourcesRoot.listFiles { f -> f.isDirectory }?.forEach { dir ->
            dir.copyRecursively(target = outputDir.resolve(dir.name), overwrite = true)
        }
    }

    // ─── Utility ──────────────────────────────────────────────────────────────

    private fun write(outputDir: File, relativePath: String, content: String) {
        val target = outputDir.resolve(relativePath)
        target.parentFile?.mkdirs()
        target.writeText(content, Charsets.UTF_8)
    }
}
