plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    neoFormVersion = providers.gradleProperty("neoform")
}

val resourcelibrary = providers.gradleProperty("resourcelibrary")
dependencies {
    implementation("net.morthen:resourcelibrary-common:${ resourcelibrary.get() }")
}