package net.xstopho.resource_nether_ores.client;

import net.minecraft.client.Minecraft;
import net.xstopho.resource_nether_ores.OreConstants;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcePackHelper {
    public static void extractPack(String name) {
        Path resourcepackPath = Minecraft.getInstance().getResourcePackDirectory();

        if (!resourcepackPath.toFile().exists()) {
            try {
                Files.createDirectories(resourcepackPath);
            } catch (IOException e) {
                OreConstants.LOG.error("Could not create Directory '{}'", resourcepackPath);
            }
        }

        InputStream pack = ResourcePackHelper.class.getResourceAsStream("/shipped/" + name + ".zip");

        try {
            Files.copy(pack, Paths.get("resourcepacks/" + name + ".zip"));
            pack.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
