package lyskov.portfolio

import lyskov.portfolio.devserver.DevServer
import lyskov.portfolio.generator.SiteGenerator

fun main() {
    val outputDir    = js("process.env['SITE_OUTPUT_DIR']")    as? String ?: "build/site"
    val resourcesDir = js("process.env['SITE_RESOURCES_DIR']") as? String ?: "build/processedResources/js/main"
    val mode         = js("process.env['SITE_MODE']")          as? String ?: "generate"

    when (mode) {
        "serve" -> {
            val srcDir      = js("process.env['SITE_SRC_DIR']")      as? String ?: "src/main"
            val gradlewPath = js("process.env['SITE_GRADLEW_PATH']") as? String ?: "./gradlew"
            val rootDir     = js("process.env['SITE_ROOT_DIR']")     as? String ?: "."
            val binaryPath  = js("process.env['SITE_BINARY_PATH']")  as? String
            DevServer.start(outputDir, resourcesDir, srcDir, gradlewPath, rootDir, binaryPath)
        }
        else -> SiteGenerator.generate(outputDir, resourcesDir)
    }
}
