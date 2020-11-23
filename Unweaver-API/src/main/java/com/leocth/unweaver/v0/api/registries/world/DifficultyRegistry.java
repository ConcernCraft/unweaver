package com.leocth.unweaver.v0.api.registries.world;

import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.impl.registries.world.DifficultyRegistryImpl;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Optional;

public interface DifficultyRegistry {

    DifficultyRegistry INSTANCE = new DifficultyRegistryImpl();

    void register(Difficulty difficulty);

    Optional<Difficulty> get(Identifier id);

    List<Difficulty> values();

}
