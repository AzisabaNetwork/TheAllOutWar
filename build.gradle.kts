import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

plugins {
    kotlin("jvm") version "1.6.20"
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
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
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    testImplementation(kotlin("test"))
}

bukkit {
    name = project.name
    version = project.version.toString()
    main = "$group.${project.name.toLowerCaseAsciiOnly()}.Main"
    author = "testusuke"
    apiVersion = "1.17"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}