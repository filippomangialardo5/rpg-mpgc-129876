plugins {
    id("java")
    application
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

application {
    mainClass.set("it.unicam.cs.mpgc.rpg129876.Main")
}