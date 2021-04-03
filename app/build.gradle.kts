plugins {
    application
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
    applicationDefaultJvmArgs = listOf("--enable-preview")
}

tasks.withType<JavaCompile> {
	val compilerArgs = options.compilerArgs
	compilerArgs.add("--enable-preview")
}

tasks.withType<Test>().all {
    jvmArgs("--enable-preview")
}
