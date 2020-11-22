package com.leocth.unweaver.v0.impl.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Map;

public abstract class AbstractVanillaFactory<Vanilla extends Enum<Vanilla>, Custom extends ExtendedEnum<Vanilla>> {
    private final Map<Vanilla, Custom> vanillaCache = createVanillaCache();

    protected abstract Custom createCustom(Vanilla vanilla);

    public Custom get(Vanilla vanilla) {
        if (vanillaCache.containsKey(vanilla))
            return vanillaCache.get(vanilla);
        Custom custom = createCustom(vanilla);
        vanillaCache.put(vanilla, custom);
        return custom;
    }

    protected Map<Vanilla, Custom> createVanillaCache() {
        return new Object2ObjectOpenHashMap<>();
    }
}