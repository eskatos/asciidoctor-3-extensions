plugins {
    id("org.asciidoctor.jvm.convert") version "2.4.0"
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

tasks.asciidoctor {
    attributes(mutableMapOf("nofooter" to true))
    configurations(asciidoctorExternalExtensions.name)
}
