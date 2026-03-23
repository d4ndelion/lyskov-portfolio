package lyskov.portfolio.generator

import lyskov.portfolio.js.mkdirSync
import lyskov.portfolio.js.readdirSync
import lyskov.portfolio.js.readFileSync
import lyskov.portfolio.js.statSync
import lyskov.portfolio.js.writeFileSync
import lyskov.portfolio.layout.Css
import lyskov.portfolio.pages.NotFoundPage
import lyskov.portfolio.pages.case.CasePage
import lyskov.portfolio.pages.index.IndexPage
import lyskov.portfolio.registry.CaseLoader
import lyskov.portfolio.registry.ContentLoader
import lyskov.portfolio.registry.PageRegistry
import lyskov.portfolio.seo.SeoConfig

/**
 * Orchestrates the full static site build.
 *
 * To add a new page:
 *   1. Add a [lyskov.portfolio.model.Page] to [lyskov.portfolio.registry.PageRegistry].
 *   2. Create its renderer (e.g. `AboutPage.kt`).
 *   3. Add one line to [generatePages] calling that renderer.
 */
object SiteGenerator {

    fun generate(outputDir: String, resourcesDir: String) {
        ContentLoader.init(resourcesDir)
        mkdirSync(outputDir, js("({ recursive: true })"))
        generatePages(outputDir, resourcesDir)
        write(outputDir, "styles.css",      Css.MAIN_STYLESHEET)
        write(outputDir, "case-styles.css", Css.CASE_STYLESHEET)
        write(outputDir, "robots.txt",  buildRobotsTxt())
        write(outputDir, "sitemap.xml", buildSitemap())
        write(outputDir, "CNAME",       SeoConfig.CNAME_DOMAIN)
        copyStaticAssets(resourcesDir, outputDir)
        println("Site written to: $outputDir")
    }

    // ─── Pages ────────────────────────────────────────────────────────────────

    private fun generatePages(outputDir: String, resourcesDir: String) {
        write(outputDir, "index.html", IndexPage.render())
        write(outputDir, "404.html",   NotFoundPage.render())

        val mtsCasePage = PageRegistry.all.first { it.urlPath == "/cases/mts/" }
        val mtsCaseContent = CaseLoader.load(resourcesDir, "mts")
        write(outputDir, mtsCasePage.fileName, CasePage.render(mtsCaseContent, mtsCasePage))

        val bflCasePage = PageRegistry.all.first { it.urlPath == "/cases/bfl/" }
        val bflCaseContent = CaseLoader.load(resourcesDir, "bfl")
        write(outputDir, bflCasePage.fileName, CasePage.render(bflCaseContent, bflCasePage))

        val amongOwnCasePage = PageRegistry.all.first { it.urlPath == "/cases/among-own/" }
        val amongOwnCaseContent = CaseLoader.load(resourcesDir, "amongOwn")
        write(outputDir, amongOwnCasePage.fileName, CasePage.render(amongOwnCaseContent, amongOwnCasePage))
    }

    // ─── robots.txt ───────────────────────────────────────────────────────────

    private fun buildRobotsTxt(): String = buildString {
        appendLine("User-agent: *")
        appendLine("Allow: /")
        appendLine()
        appendLine("Sitemap: ${SeoConfig.SITEMAP_URL}")
    }

    // ─── sitemap.xml ──────────────────────────────────────────────────────────

    private fun buildSitemap(): String {
        val today = js("new Date().toISOString().split('T')[0]") as String
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
     * Copies every subdirectory from [resourcesDir] into [outputDir],
     * preserving folder structure. Binary files are copied as raw buffers.
     */
    private fun copyStaticAssets(resourcesDir: String, outputDir: String) {
        val entries = readdirSync(resourcesDir)
        for (entry in entries) {
            val srcPath = "$resourcesDir/$entry"
            if (statSync(srcPath).isDirectory() as Boolean) {
                copyDirRecursive(srcPath, "$outputDir/$entry")
            }
        }
    }

    private fun copyDirRecursive(src: String, dest: String) {
        mkdirSync(dest, js("({ recursive: true })"))
        val entries = readdirSync(src)
        for (entry in entries) {
            val srcPath  = "$src/$entry"
            val destPath = "$dest/$entry"
            if (statSync(srcPath).isDirectory() as Boolean) {
                copyDirRecursive(srcPath, destPath)
            } else {
                writeFileSync(destPath, readFileSync(srcPath)) // Buffer copy
            }
        }
    }

    // ─── Utility ──────────────────────────────────────────────────────────────

    private fun write(outputDir: String, relativePath: String, content: String) {
        val fullPath = "$outputDir/$relativePath"
        // Ensure parent directory exists
        val lastSlash = fullPath.lastIndexOf('/')
        if (lastSlash > 0) {
            mkdirSync(fullPath.substring(0, lastSlash), js("({ recursive: true })"))
        }
        writeFileSync(fullPath, content)
    }
}
