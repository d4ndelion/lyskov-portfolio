plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        nodejs()
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            kotlin.srcDir("src/main/kotlin")
            resources.srcDir("src/main/resources")
            dependencies {
                implementation(libs.kotlinx.html)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlin.css)
            }
        }
    }
}

// ── Output directories ────────────────────────────────────────────────────────

val siteDir: Provider<Directory> = rootProject.layout.buildDirectory.dir("site")
val resourcesDir: Provider<Directory> = layout.buildDirectory.dir("processedResources/js/main")

// Pass output and resources paths to the Node.js process via environment variables.
tasks.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsExec>().configureEach {
    environment("SITE_OUTPUT_DIR", siteDir.get().asFile.absolutePath)
    environment("SITE_RESOURCES_DIR", resourcesDir.get().asFile.absolutePath)
}

// ── Site tasks ────────────────────────────────────────────────────────────────

tasks.register("generateSite") {
    group = "site"
    description = "Runs the static site generator and writes output to build/site."
    dependsOn("jsNodeDevelopmentRun")
    outputs.dir(siteDir)
}

val compiledBinary: Provider<RegularFile> =
    layout.buildDirectory.file("compileSync/js/main/developmentExecutable/kotlin/lyskov-portfolio-app.js")

tasks.register("devServer") {
    group = "site"
    description = "Starts a local dev server on :3000 with live reload. Watches src/ and rebuilds on change."
    dependsOn("generateSite", "kotlinNodeJsSetup")

    doLast {
        val nodeExec = rootProject.extensions
            .getByType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsEnvSpec::class.java)
            .executable.get()

        project.exec {
            executable = nodeExec
            args(compiledBinary.get().asFile.absolutePath)
            environment("SITE_MODE", "serve")
            environment("SITE_OUTPUT_DIR", siteDir.get().asFile.absolutePath)
            environment("SITE_SRC_DIR", layout.projectDirectory.dir("src/main").asFile.absolutePath)
            environment("SITE_GRADLEW_PATH", rootProject.file("gradlew").absolutePath)
            environment("SITE_ROOT_DIR", rootProject.projectDir.absolutePath)
        }
    }
}

tasks.register("verifySite") {
    group = "verification"
    description = "Verifies that all required files are present in build/site."
    dependsOn("generateSite")

    val expectedDomain = providers.gradleProperty("site.domain")

    doLast {
        fun verify(condition: Boolean, message: String) {
            check(condition) { "Site verification FAILED — $message" }
        }

        val siteRoot = siteDir.get().asFile
        val indexText =
            siteRoot.resolve("index.html").also { verify(it.exists(), "index.html not found in build/site") }.readText()
        val sitemapText =
            siteRoot.resolve("sitemap.xml").also { verify(it.exists(), "sitemap.xml not found in build/site") }
                .readText()
        verify(siteRoot.resolve("404.html").exists(), "404.html not found in build/site")
        verify(siteRoot.resolve("robots.txt").exists(), "robots.txt not found in build/site")

        val domain = expectedDomain.get()
        verify(sitemapText.contains(domain), "sitemap.xml does not reference the index page URL")
        verify(indexText.contains("canonical"), "index.html is missing a canonical <link> tag")

        logger.lifecycle("✓ All site verification checks passed.")
    }
}
