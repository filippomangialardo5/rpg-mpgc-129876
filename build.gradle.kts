plugins {
    id("java")
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "it.unicam.cs.mpgc"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

javafx {
    version = "25"
    modules = listOf("javafx.controls")
}

application {
    mainClass.set("it.unicam.cs.mpgc.rpg129876.Main")
}