plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.kotlin.serialization)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinx.html)
    implementation(libs.kotlinx.serialization.json)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("lyskov.portfolio.MainKt")
}

val siteDir: DirectoryProperty = rootProject.layout.buildDirectory.dir("site")
    .let { rootProject.objects.directoryProperty().also { p -> p.set(it) } }

tasks.register<JavaExec>("generateSite") {
    group = "site"
    description = "Runs the static site generator and writes output to build/site."
    dependsOn("classes")
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("lyskov.portfolio.MainKt")
    args(siteDir.get().toString())
    outputs.dir(siteDir)
}

tasks.register("verifySite") {
    group = "verification"
    description = "Verifies that all required files are present and well-formed in build/site."
    dependsOn("generateSite")

    val indexContent    = providers.fileContents(siteDir.file("index.html")).asText
    val notFoundContent = providers.fileContents(siteDir.file("404.html")).asText
    val sitemapContent  = providers.fileContents(siteDir.file("sitemap.xml")).asText
    val robotsContent   = providers.fileContents(siteDir.file("robots.txt")).asText
    val expectedDomain  = providers.gradleProperty("site.domain")

    doLast {
        fun verify(condition: Boolean, message: String) {
            check(condition) { "Site verification FAILED — $message" }
        }

        verify(indexContent.isPresent,    "index.html not found in build/site")
        verify(notFoundContent.isPresent, "404.html not found in build/site")
        verify(sitemapContent.isPresent,  "sitemap.xml not found in build/site")
        verify(robotsContent.isPresent,   "robots.txt not found in build/site")

        val domain = expectedDomain.get()
        verify(
            sitemapContent.get().contains(domain),
            "sitemap.xml does not reference the index page URL"
        )
        verify(
            indexContent.get().contains("canonical"),
            "index.html is missing a canonical <link> tag"
        )

        logger.lifecycle("✓ All site verification checks passed.")
    }
}

@Suppress("UnstableApiUsage")
testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.1.20")
        }
    }
}
