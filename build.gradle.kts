import konnekt.gradle.Konnekt

plugins {
    kotlin("jvm") version "1.4.10"
//    id("io.github.koperagen.greeting") version "1.4.10-SNAPSHOT"
    id("io.github.koperagen.konnekt") version "1.4.10-SNAPSHOT"
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
    implementation("io.ktor:ktor-client-apache:${Konnekt.ktorVersion}")
    implementation("io.ktor:ktor-client-logging-jvm:${Konnekt.ktorVersion}")
}