plugins {
    id("org.asciidoctor.convert") version "1.6.1"
}

repositories {
    mavenCentral()
    maven(url = "https://repo.gradle.org/gradle/libs-releases")
}

val asciidoctorExternalExtensions by configurations.creating

dependencies {
    asciidoctorExternalExtensions("org.gradle:docs-asciidoctor-extensions:0.7.0")
    asciidoctorExternalExtensions(files("src/main/resources"))
}

configurations.asciidoctor {
    extendsFrom(asciidoctorExternalExtensions)
}

tasks.asciidoctor {
    outputDir = layout.buildDirectory.dir("docs/asciidoc").get().asFile
    separateOutputDirs = false
    attributes(mutableMapOf("nofooter" to true))
}
