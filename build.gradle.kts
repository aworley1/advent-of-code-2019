import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version = "1.3.61"
val spek_version = "2.0.8"

plugins {
    kotlin("jvm") version "1.3.61"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.guava:guava:28.1-jre")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek_version")
    testRuntimeOnly ("org.spekframework.spek2:spek-runner-junit5:$spek_version")
    testRuntimeOnly ("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.20")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("io.mockk:mockk:1.9.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}