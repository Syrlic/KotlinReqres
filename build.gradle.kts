import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("io.qameta.allure") version "2.10.0"
    id("io.qameta.allure-report") version "2.10.0"
    application
}

group = "me.oklon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spring.io/release")
    }
    maven {
        url = uri("https://jcenter.bintray.com/")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("khttp:khttp:1.0.0")
    runtimeOnly("khttp:khttp:1.0.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}