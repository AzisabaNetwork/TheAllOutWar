import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

plugins {
    kotlin("jvm") version "1.6.21"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

group = "net.testusuke"
version = "0.1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    testImplementation("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    testImplementation(kotlin("test"))
}

bukkit {
    name = project.name
    version = project.version.toString()
    main = "$group.thealloutwar.Main"
    author = "testusuke"
    apiVersion = "1.17"
    commands {
        register("war") {
            description = "General command"
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}