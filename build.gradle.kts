plugins {
    kotlin("jvm") version "1.4.21"
}

group = "io.github.koperagen"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.github.koperagen:prelude-jvm:1.4.10-SNAPSHOT")
    implementation("io.ktor:ktor-client-apache:1.4.1")
    implementation("io.ktor:ktor-client-logging-jvm:1.4.1")
}

kotlin {
    sourceSets["main"].kotlin.srcDir("build/generated/source/kapt/")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.freeCompilerArgs += listOf("/путь/к/локальному/файлу/плагин.jar")
}