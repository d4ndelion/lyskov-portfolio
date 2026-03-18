package lyskov.portfolio.registry

import kotlinx.serialization.json.Json
import lyskov.portfolio.model.CaseContent

object CaseLoader {

    private val json = Json { ignoreUnknownKeys = true }

    fun load(resourcesDir: String, slug: String): CaseContent {
        val text = lyskov.portfolio.js.readFileSync("$resourcesDir/$slug.json", "utf8")
        return json.decodeFromString(text)
    }
}
