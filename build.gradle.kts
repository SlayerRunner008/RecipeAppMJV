plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false

    kotlin("plugin.serialization") version "2.0.21" apply false

    id("com.google.devtools.ksp") version "2.2.20-2.0.4" apply false
    id("de.jensklingenberg.ktorfit") version "2.6.4" apply false
}