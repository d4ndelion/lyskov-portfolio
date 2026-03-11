package lyskov.portfolio.registry

import kotlinx.serialization.json.Json
import lyskov.portfolio.model.PageContent

/**
 * Loads and deserializes [PageContent] from `main.json` on the classpath.
 * Result is cached in a lazy property — parsed once per JVM run.
 */
object ContentLoader {

    private val json = Json { ignoreUnknownKeys = true }

    val content: PageContent by lazy {
        val text = ContentLoader::class.java.classLoader
            .getResourceAsStream("main.json")
            ?.bufferedReader()
            ?.readText()
            ?: error("main.json not found on classpath")

        json.decodeFromString(text)
    }
}
