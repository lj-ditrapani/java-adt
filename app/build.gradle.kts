plugins {
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}

tasks.compileJava {
    options.release.set(16)
    sourceCompatibility = "16"
    targetCompatibility = "16"
}

repositories {
    // Use JCenter for resolving dependencies.
    jcenter()
}

dependencies {
    // Use JUnit test framework.
    testImplementation("junit:junit:4.13")
}

application {
    // Define the main class for the application.
    mainClass.set("info.ditrapani.adt.App")
}
