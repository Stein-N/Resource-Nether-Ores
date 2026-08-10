plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    loader = "forge"

    forgeVersion = providers.gradleProperty("forge")
    forgeMixins = listOf(
        "${ modId.get() }.mixins.json",
        "${ modId.get() }.forge.mixins.json"
    )

    withModPublish()

    applyMetadataReplacements(listOf("pack.mcmeta", "META-INF/mods.toml"), mapOf(
        "forge_version" to forgeVersion.get(),
        "issues_url" to providers.gradleProperty("issues_url")
    ))
}

val resourcelibrary = providers.gradleProperty("resourcelibrary")
dependencies {
    implementation("net.morthen:resourcelibrary-forge:${resourcelibrary.get()}")
}