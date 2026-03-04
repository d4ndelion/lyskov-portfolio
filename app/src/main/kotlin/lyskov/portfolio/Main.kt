package lyskov.portfolio

import lyskov.portfolio.generator.SiteGenerator
import java.io.File

/**
 * Entry point for the static site generator.
 *
 * Usage:
 *   ./gradlew generateSite          → outputs to <root>/build/site
 *   java -jar app.jar <output-dir>  → outputs to the specified directory
 */
fun main(args: Array<String>) {
    val outputDir = if (args.isNotEmpty()) File(args[0]) else File("build/site")
    SiteGenerator.generate(outputDir)
}
