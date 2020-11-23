package com.leocth.unweaver.v0.impl.registries.world;

import com.google.common.collect.ImmutableList;
import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.api.factories.InstrumentFactory;
import com.leocth.unweaver.v0.api.registries.world.DifficultyRegistry;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Optional;

public class DifficultyRegistryImpl implements DifficultyRegistry {

    private final Object2ObjectArrayMap<Identifier, Difficulty> factories
            = new Object2ObjectArrayMap<>();

    @Override
    public void register(Difficulty difficulty) {
        factories.put(difficulty.getId(), difficulty);
    }

    @Override
    public Optional<Difficulty> get(Identifier id) {
        return Optional.ofNullable(factories.get(id));
    }

    @Override
    public List<Difficulty> values() {
        return ImmutableList.copyOf(factories.values());
    }

}
