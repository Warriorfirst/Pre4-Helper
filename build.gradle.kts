import dev.architectury.pack200.java.Pack200Adapter
import java.util.regex.Pattern.compile

plugins {
    id("gg.essential.loom")
    id("io.github.juuxel.loom-quiltflower")
    id("dev.architectury.architectury-pack200")
    id("com.github.johnrengelman.shadow")
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
}

group = "dev.dumatech"
version = "1.0.0"

loom {
    runConfigs {
        named("client") {
            ideConfigGenerated(true)

        }
    }

    launchConfigs {
        getByName("client") {
            arg("--tweakClass", "gg.essential.loader.stage0.EssentialSetupTweaker")
        }
    }

    forge {
        pack200Provider.set(Pack200Adapter())
    }
}

val embed: Configuration by configurations.creating
configurations.implementation.get().extendsFrom(embed)

dependencies {
    minecraft("com.mojang:minecraft:1.8.9")
    mappings("de.oceanlabs.mcp:mcp_stable:22-1.8.9")
    forge("net.minecraftforge:forge:1.8.9-11.15.1.2318-1.8.9")
    compileOnly("gg.essential:essential-1.8.9-forge:15490+g7b549fcfbd")
    embed("gg.essential:loader-launchwrapper:1.1.3")
    kotlin("stdlib-jdk8")
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
    compileOnly("org.spongepowered:mixin:0.8.5")
}

repositories {
    maven("https://repo.essential.gg/repository/maven-public")
    maven ("https://repo.spongepowered.org/repository/maven-public/")
}

tasks {
    jar {
        from(embed.files.map { zipTree(it) })

        manifest.attributes(
            mapOf(
                "ModSide" to "CLIENT",
                "TweakClass" to "gg.essential.loader.stage0.EssentialSetupTweaker",
            )
        )
    }

    processResources {
        inputs.property("version", project.version)
        inputs.property("mcversion", "1.8.9")
        filesMatching("mcmod.info") {
            expand("version" to project.version, "mcversion" to "1.8.9")
        }
    }

    withType<JavaCompile> {
        options.release.set(8)
    }
}