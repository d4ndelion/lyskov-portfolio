package lyskov.portfolio.registry

import kotlinx.serialization.json.Json
import lyskov.portfolio.model.PageContent

/**
 * Loads and deserializes [PageContent] from `main.json`.
 * Must be initialized once via [init] before [content] is accessed.
 */
object ContentLoader {

    private val json = Json { ignoreUnknownKeys = true }

    private lateinit var _content: PageContent

    val content: PageContent
        get() = _content

    fun init(resourcesDir: String) {
        val text = lyskov.portfolio.js.readFileSync("$resourcesDir/main.json", "utf8")
        _content = json.decodeFromString(text)
    }
}
