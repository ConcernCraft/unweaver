package io.github.concerncraft.unweaver.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Some utilities for determining which *physical* environment Minecraft is currently running in.
 *
 * @author leocth
 * @since 0.3.0
 */
public class SidedUtils {

    public static EnvType getEnvType() {
        return FabricLoader.getInstance().getEnvironmentType();
    }

    public static boolean isClient() { return getEnvType() == EnvType.CLIENT; }
    public static boolean isServer() { return getEnvType() == EnvType.SERVER; }
}
