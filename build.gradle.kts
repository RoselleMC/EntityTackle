plugins {
    `java-library`
    `maven-publish`
    id("io.izzel.taboolib") version "1.56"
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
}

taboolib {
    install("common",
        "common-5",
        "module-chat",
        "module-configuration",
        "module-database",
        "module-effect",
        "module-kether",
        "module-lang",
        "module-metrics",
        "module-nms",
        "module-nms-util",
        "module-ui",
        "platform-bukkit",
        "expansion-command-helper",
    )
    classifier = null
    version = "6.0.11-24"
    relocate("fr.skytasul", "${project.name}.libs.fr.skytasul")
}

repositories {
    mavenCentral()
}

dependencies {
    taboo("ink.ptms:um:1.0.0-beta-18")
//    compileOnly("ink.ptms.core:v12001:12001:universal")
    taboo("io.github.skytasul:guardianbeam:2.3.3")
    compileOnly("ink.ptms.core:v12001:12001:mapped")
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    repositories {
        maven {
            url = uri("https://repo.tabooproject.org/repository/releases")
            credentials {
                username = project.findProperty("taboolibUsername").toString()
                password = project.findProperty("taboolibPassword").toString()
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
            groupId = project.group.toString()
        }
    }
}