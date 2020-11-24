package com.leocth.unweaver.v0.impl.cca;

import com.leocth.unweaver.v0.api.Ids;
import com.leocth.unweaver.v0.api.cca.DifficultyComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentInitializer;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;

@SuppressWarnings("UnstableApiUsage")
public class Components implements LevelComponentInitializer {

    public static final ComponentKey<DifficultyComponent> DIFFICULTY =
            ComponentRegistry.getOrCreate(Ids.unweaver("difficulty"), DifficultyComponent.class);

    @Override
    public void registerLevelComponentFactories(LevelComponentFactoryRegistry registry) {
        registry.register(DIFFICULTY, level -> new DifficultyComponentImpl());

    }
}
