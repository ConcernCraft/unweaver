package com.leocth.unweaver.v0.impl.enums;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Map;
import java.util.function.Function;

public class CachedVanillaFactory<Vanilla extends Enum<Vanilla>, Custom extends ExtendedEnum<Vanilla>>
        implements VanillaFactory<Vanilla, Custom>
{
    private final Map<Vanilla, Custom> vanillaCache = createVanillaCache();
    private final Function<Vanilla, Custom> factory;

    public CachedVanillaFactory(Function<Vanilla, Custom> factory) {
        this.factory = factory;
    }

    @Override
    public Custom get(Vanilla vanilla) {
        if (vanillaCache.containsKey(vanilla))
            return vanillaCache.get(vanilla);
        Custom custom = factory.apply(vanilla);
        vanillaCache.put(vanilla, custom);
        return custom;
    }

    protected Map<Vanilla, Custom> createVanillaCache() {
        return new Object2ObjectOpenHashMap<>();
    }
}