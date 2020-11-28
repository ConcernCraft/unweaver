package com.leocth.unweaver.v0.api;

import net.minecraft.util.Identifier;

/**
 * Helper class for creating {@link Identifier}s.
 */
public final class Ids {

    public static String MODID = "unweaver-api";

    public static Identifier vanilla(String path) { return new Identifier(path); }
    public static Identifier unweaver(String path) { return new Identifier(MODID, path); }

}
