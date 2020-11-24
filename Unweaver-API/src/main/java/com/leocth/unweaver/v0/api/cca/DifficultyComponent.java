package com.leocth.unweaver.v0.api.cca;

import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.impl.cca.Components;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import org.jetbrains.annotations.Nullable;

public interface DifficultyComponent extends AutoSyncedComponent {
    @Nullable Difficulty getDifficulty();
    void setDifficulty(@Nullable Difficulty difficulty);

    static <T> DifficultyComponent get(T provider) {
        return Components.DIFFICULTY.get(provider);
    }
}
