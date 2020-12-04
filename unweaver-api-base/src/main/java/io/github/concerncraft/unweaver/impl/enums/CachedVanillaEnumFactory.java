package io.github.concerncraft.unweaver.impl.enums;

import io.github.concerncraft.unweaver.api.enums.ExtendedEnum;
import io.github.concerncraft.unweaver.api.enums.VanillaEnumFactory;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceArrayMap;

import java.util.Map;
import java.util.function.Function;

public class CachedVanillaEnumFactory<Vanilla extends Enum<Vanilla>, Custom extends ExtendedEnum<Vanilla>>
        implements VanillaEnumFactory<Vanilla, Custom>
{
    private final Map<Vanilla, Custom> vanillaCache = createVanillaCache();
    private final Function<Vanilla, Custom> factory;

    public CachedVanillaEnumFactory(Function<Vanilla, Custom> factory) {
        this.factory = factory;
    }

    @Override
    public Custom get(Vanilla vanilla) {
        return vanillaCache.computeIfAbsent(vanilla, factory);
    }

    protected Map<Vanilla, Custom> createVanillaCache() {
        return new Reference2ReferenceArrayMap<>();
    }
}