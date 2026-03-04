package lyskov.portfolio

import lyskov.portfolio.registry.PageRegistry
import lyskov.portfolio.seo.SeoConfig
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class SiteRegistryTest {

    @Test
    fun `registry contains at least the index page`() {
        val index = PageRegistry.all.firstOrNull { it.urlPath == "/" }
        assertNotNull(index, "PageRegistry must contain an entry for '/'")
    }

    @Test
    fun `every page has a non-blank title and description`() {
        PageRegistry.all.forEach { page ->
            assertTrue(page.title.isNotBlank(), "Page ${page.urlPath} has blank title")
            assertTrue(page.description.isNotBlank(), "Page ${page.urlPath} has blank description")
        }
    }

    @Test
    fun `every page filename ends with html`() {
        PageRegistry.all.forEach { page ->
            assertTrue(page.fileName.endsWith(".html"), "${page.fileName} must end with .html")
        }
    }

    @Test
    fun `SeoConfig domain has scheme and no trailing slash`() {
        assertTrue(SeoConfig.DOMAIN.startsWith("https://"), "DOMAIN must start with https://")
        assertTrue(!SeoConfig.DOMAIN.endsWith("/"), "DOMAIN must not end with /")
    }

    @Test
    fun `CNAME domain matches domain host`() {
        val host = SeoConfig.DOMAIN.removePrefix("https://").removePrefix("http://")
        assertEquals(host, SeoConfig.CNAME_DOMAIN, "CNAME_DOMAIN must match DOMAIN host")
    }
}
