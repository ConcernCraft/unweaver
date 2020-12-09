package io.github.concerncraft.unweaver.util;

import net.minecraft.util.Identifier;

public final class Ids {
    public static final String MODID = "unweaver";

    public static Identifier vanilla(String path) { return new Identifier(path); }
    public static Identifier unweaver(String path) { return new Identifier(MODID, path); }
    public static Identifier module(String module, String path) { return new Identifier(MODID, module + "/" + path); }
}
