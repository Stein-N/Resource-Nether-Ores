plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    loader = "datagen"
    neoForgeVersion = providers.gradleProperty("neoforge")

    applyMetadataReplacements(listOf("pack.mcmeta", "META-INF/neoforge.mods.toml"))
}

val resourcelibrary = providers.gradleProperty("resourcelibrary")
dependencies {
    implementation("net.morthen:resourcelibrary-neoforge:${ resourcelibrary.get() }")
}
