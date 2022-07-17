plugins {
    application
    id("com.github.ben-manes.versions") version "0.39.0"
}

repositories {
    // Use JCenter for resolving dependencies.
    jcenter()
}

dependencies {
    // Use JUnit test framework.
    testImplementation("junit:junit:4.13.2")
}

application {
    // Define the main class for the application.
    mainClass.set("info.ditrapani.adt.App")
    applicationDefaultJvmArgs = listOf("--enable-preview")
}

tasks.withType<JavaCompile> {
	val compilerArgs = options.compilerArgs
	compilerArgs.add("--enable-preview")
}

tasks.withType<Test>().all {
    jvmArgs("--enable-preview")
}
